/*
 * Copyright 2018 Gunnar Flötteröd
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * contact: gunnar.flotterod@gmail.com
 *
 */
package org.matsim.contrib.pseudosimulation.searchacceleration;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Singleton;

import org.apache.log4j.Logger;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.LinkEnterEvent;
import org.matsim.api.core.v01.events.VehicleEntersTrafficEvent;
import org.matsim.api.core.v01.events.handler.LinkEnterEventHandler;
import org.matsim.api.core.v01.events.handler.VehicleEntersTrafficEventHandler;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.population.HasPlansAndId;
import org.matsim.api.core.v01.population.Person;
import org.matsim.api.core.v01.population.Plan;
import org.matsim.contrib.pseudosimulation.MobSimSwitcher;
import org.matsim.contrib.pseudosimulation.PSimConfigGroup;
import org.matsim.contrib.pseudosimulation.mobsim.PSim;
import org.matsim.contrib.pseudosimulation.searchacceleration.datastructures.SpaceTimeIndicators;
import org.matsim.contrib.pseudosimulation.searchacceleration.datastructures.Utilities;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.AverageDeltaForUniformReplanning;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.AverageReplanningEfficiency;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.DeltaForUniformReplanning;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.DeltaForUniformReplanningExact;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.DeltaPercentile;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.DriversInPhysicalSim;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.DriversInPseudoSim;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.EffectiveReplanningRate;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.ExpectedDeltaUtilityAccelerated;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.ExpectedDeltaUtilityUniform;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.FinalObjectiveFunctionValue;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.LogDataWrapper;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.MeanReplanningRate;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.RealizedDeltaUtility;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.RealizedGreedyScoreChange;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.RegularizationWeight;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.ReplanningEfficiency;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.ShareNeverReplanned;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.ShareScoreImprovingReplanners;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.TTSum;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.TargetPercentile;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.UniformGreedyScoreChange;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.UniformReplannerShare;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.UniformReplanningObjectiveFunctionValue;
import org.matsim.contrib.pseudosimulation.searchacceleration.logging.WeightedCountDifferences2;
import org.matsim.contrib.pseudosimulation.searchacceleration.utils.RecursiveMovingAverage;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.MatsimServices;
import org.matsim.core.controler.events.IterationEndsEvent;
import org.matsim.core.controler.events.StartupEvent;
import org.matsim.core.controler.listener.IterationEndsListener;
import org.matsim.core.controler.listener.StartupListener;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.replanning.GenericPlanStrategy;
import org.matsim.core.replanning.StrategyManager;
import org.matsim.core.router.util.TravelTime;

import com.google.inject.Inject;

import floetteroed.utilities.statisticslogging.StatisticsWriter;
import floetteroed.utilities.statisticslogging.TimeStampStatistic;

/**
 * 
 * @author Gunnar Flötteröd
 *
 */
@Singleton
public class SearchAccelerator
		implements StartupListener, IterationEndsListener, LinkEnterEventHandler, VehicleEntersTrafficEventHandler {

	// -------------------- CONSTANTS --------------------

	private static final Logger log = Logger.getLogger(Controler.class);

	// -------------------- INJECTED MEMBERS --------------------

	@Inject
	private MatsimServices services;

	/*
	 * We know if we are in a pSim iteration or in a "real" iteration. The
	 * MobsimSwitcher is updated at iterationStarts, i.e. always *before* the mobsim
	 * (or psim) is executed. The SearchAccelerator, on the other hand, is invoked
	 * at iterationEnds, i.e. *after* the corresponding mobsim (or psim) run.
	 * 
	 */
	@Inject
	private MobSimSwitcher mobsimSwitcher;

	@Inject
	private TravelTime linkTravelTimes;

	// -------------------- NON-INJECTED MEMBERS --------------------

	private Set<Id<Person>> replanners = null;

	private final Set<Id<Person>> everReplanners = new LinkedHashSet<>();

	// Delegate for mobsim listening. Created upon startup.
	private LinkUsageListener matsimMobsimUsageListener = null;

	// >>> created upon startup >>>
	private StatisticsWriter<LogDataWrapper> statsWriter = null;
	private RecursiveMovingAverage expectedUtilityImprovementSum;
	private RecursiveMovingAverage realizedUtilityImprovementSum;
	private RecursiveMovingAverage averageDeltaForUniformReplanning;
	private RecursiveMovingAverage averageDeltaForUniformReplanningExact;
	private Utilities utilities;
	// <<< created upon startup <<<

	private PopulationState hypotheticalPopulationState = null;

	private double currentDelta = 0.0;

	// >>> created upon startup >>>
	private RecursiveMovingAverage lastExpectedUtilityChangeSumAccelerated;
	private RecursiveMovingAverage lastExpectedUtilityChangeSumUniform;
	private RecursiveMovingAverage lastRealizedUtilityChangeSum;
	// <<< created upon startup <<<

	private List<Double> lastActualReplanIndicators = null;
	private List<Double> lastUniformReplanIndicators = null;
	private List<Double> lastCriticalDeltas = null;
	private List<Double> lastDeltaScore = null;

	private Double percentile = null;
	private Double targetPercentile = null;

	// private LinearInPercentile deltaRecipe = new LinearInPercentile();

	// -------------------- CONSTRUCTION --------------------

	@Inject
	public SearchAccelerator() {
	}

	// -------------------- HELPERS --------------------

	private AccelerationConfigGroup replanningParameters() {
		return ConfigUtils.addOrGetModule(this.services.getConfig(), AccelerationConfigGroup.class);
	}

	private void setWeightOfHypotheticalReplanning(final double weight) {
		final StrategyManager strategyManager = this.services.getStrategyManager();
		for (GenericPlanStrategy<Plan, Person> strategy : strategyManager.getStrategies(null)) {
			if (strategy instanceof AcceptIntendedReplanningStrategy) {
				strategyManager.changeWeightOfStrategy(strategy, null, weight);
			}
		}
	}

	public Integer getDriversInPhysicalSim() {
		if (this.lastPhysicalLinkUsages != null) {
			return this.lastPhysicalLinkUsages.size();
		} else {
			return null;
		}
	}

	public Double getReplanningEfficiency() {
		if ((this.expectedUtilityImprovementSum.size() == 0) || (this.realizedUtilityImprovementSum.size() == 0)) {
			return null;
		} else {
			final double expected = Math.max(1e-8, this.expectedUtilityImprovementSum.mostRecentValue());
			final double realized = Math.max(1e-8, this.realizedUtilityImprovementSum.mostRecentValue());
			return realized / expected;
		}
	}

	public Double getAverageReplanningEfficiency() {
		if ((this.expectedUtilityImprovementSum.size() == 0) || (this.realizedUtilityImprovementSum.size() == 0)) {
			return null;
		} else {
			final double expected = Math.max(1e-8, this.expectedUtilityImprovementSum.sum());
			final double realized = Math.max(1e-8, this.realizedUtilityImprovementSum.sum());
			return realized / expected;
		}
	}

	public Double getPhysicalTravelTimeSum_h() {
		double ttSum_s = 0;
		for (Link link : this.services.getScenario().getNetwork().getLinks().values()) {
			for (int time_s = 0; time_s < 24 * 3600; time_s += 15 * 60) {
				ttSum_s += this.linkTravelTimes.getLinkTravelTime(link, time_s, null, null);
			}
		}
		return (ttSum_s / 3600.0);
	}

	public Double getEffectiveReplanningRate() {
		if (this.replanners == null) {
			return null;
		} else {
			return ((double) this.replanners.size()) / this.services.getScenario().getPopulation().getPersons().size();
		}
	}

	public Double getShareNeverReplanned() {
		return 1.0 - ((double) this.everReplanners.size())
				/ this.services.getScenario().getPopulation().getPersons().size();
	}

	public Double getDeltaForUniformReplanning() {
		if (this.averageDeltaForUniformReplanning == null || this.averageDeltaForUniformReplanning.size() == 0) {
			return null;
		} else {
			return this.averageDeltaForUniformReplanning.mostRecentValue();
		}
	}

	public Double getDeltaForUniformReplanningExact() {
		if (this.averageDeltaForUniformReplanningExact == null
				|| this.averageDeltaForUniformReplanningExact.size() == 0) {
			return null;
		} else {
			return this.averageDeltaForUniformReplanningExact.mostRecentValue();
		}
	}

	public Double getAverageDeltaForUniformReplanning() {
		if (this.averageDeltaForUniformReplanning == null) {
			return null;
		} else {
			return this.averageDeltaForUniformReplanning.average();
		}
	}

	public Double getRegularizationWeight() {
		return this.currentDelta;
	}

	public Double getPercentile() {
		return this.percentile;
	}

	public Double getLastExpectedUtilityChangeSumAccelerated() {
		return this.lastExpectedUtilityChangeSumAccelerated.average();
	}

	public Double getLastExpectedUtilityChangeSumUniform() {
		return this.lastExpectedUtilityChangeSumUniform.average();
	}

	public Double getLastRealizedUtilityChangeSum() {
		return this.lastRealizedUtilityChangeSum.average();
	}

	public Double getTargetPercentile() {
		return this.targetPercentile;
	}

	// --------------- IMPLEMENTATION OF StartupListener ---------------

	@Override
	public void notifyStartup(final StartupEvent event) {

		this.matsimMobsimUsageListener = new LinkUsageListener(this.replanningParameters().getTimeDiscretization());

		this.expectedUtilityImprovementSum = new RecursiveMovingAverage(
				this.replanningParameters().getAverageIterations());
		this.realizedUtilityImprovementSum = new RecursiveMovingAverage(
				this.replanningParameters().getAverageIterations());
		this.averageDeltaForUniformReplanning = new RecursiveMovingAverage(
				this.replanningParameters().getAverageIterations());
		this.averageDeltaForUniformReplanningExact = new RecursiveMovingAverage(
				this.replanningParameters().getAverageIterations());

		this.lastExpectedUtilityChangeSumAccelerated = new RecursiveMovingAverage(
				this.replanningParameters().getAverageIterations());
		this.lastExpectedUtilityChangeSumUniform = new RecursiveMovingAverage(
				this.replanningParameters().getAverageIterations());
		this.lastRealizedUtilityChangeSum = new RecursiveMovingAverage(
				this.replanningParameters().getAverageIterations());

		this.utilities = new Utilities(this.replanningParameters().getAverageIterations());

		this.statsWriter = new StatisticsWriter<>(
				new File(this.services.getConfig().controler().getOutputDirectory(), "acceleration.log").toString(),
				false);
		this.statsWriter.addSearchStatistic(new TimeStampStatistic<>());
		this.statsWriter.addSearchStatistic(new DriversInPhysicalSim());
		this.statsWriter.addSearchStatistic(new DriversInPseudoSim());
		this.statsWriter.addSearchStatistic(new DeltaPercentile());
		this.statsWriter.addSearchStatistic(new TargetPercentile());
		this.statsWriter.addSearchStatistic(new RegularizationWeight());
		this.statsWriter.addSearchStatistic(new MeanReplanningRate());
		this.statsWriter.addSearchStatistic(new EffectiveReplanningRate());
		this.statsWriter.addSearchStatistic(new RealizedGreedyScoreChange());
		this.statsWriter.addSearchStatistic(new UniformGreedyScoreChange());
		this.statsWriter.addSearchStatistic(new ShareNeverReplanned());
		this.statsWriter.addSearchStatistic(new UniformReplanningObjectiveFunctionValue());
		this.statsWriter.addSearchStatistic(new FinalObjectiveFunctionValue());
		this.statsWriter.addSearchStatistic(new ShareScoreImprovingReplanners());
		this.statsWriter.addSearchStatistic(new WeightedCountDifferences2());
		this.statsWriter.addSearchStatistic(new TTSum());
		this.statsWriter.addSearchStatistic(new ReplanningEfficiency());
		this.statsWriter.addSearchStatistic(new AverageReplanningEfficiency());
		this.statsWriter.addSearchStatistic(new DeltaForUniformReplanning());
		this.statsWriter.addSearchStatistic(new DeltaForUniformReplanningExact());
		this.statsWriter.addSearchStatistic(new AverageDeltaForUniformReplanning());
		this.statsWriter.addSearchStatistic(new UniformReplannerShare());
		// this.statsWriter.addSearchStatistic(new ReplanningSignalAKF());
		this.statsWriter.addSearchStatistic(new RealizedDeltaUtility());
		this.statsWriter.addSearchStatistic(new ExpectedDeltaUtilityUniform());
		this.statsWriter.addSearchStatistic(new ExpectedDeltaUtilityAccelerated());
	}

	// -------------------- IMPLEMENTATION OF EventHandlers --------------------

	@Override
	public void reset(final int iteration) {
		this.matsimMobsimUsageListener.reset(iteration);
	}

	@Override
	public void handleEvent(final VehicleEntersTrafficEvent event) {
		if (this.mobsimSwitcher.isQSimIteration()) {
			this.matsimMobsimUsageListener.handleEvent(event);
		}
	}

	@Override
	public void handleEvent(final LinkEnterEvent event) {
		if (this.mobsimSwitcher.isQSimIteration()) {
			this.matsimMobsimUsageListener.handleEvent(event);
		}
	}

	// --------------- IMPLEMENTATION OF IterationEndsListener ---------------

	private PopulationState lastPhysicalPopulationState = null;
	private Map<Id<Person>, SpaceTimeIndicators<Id<Link>>> lastPhysicalLinkUsages = null;

	private int pseudoSimIterationCnt = 0;

	// A safeguard.
	private boolean nextMobsimIsExpectedToBePhysical = true;

	@Override
	public void notifyIterationEnds(final IterationEndsEvent event) {

		if (this.mobsimSwitcher.isQSimIteration()) {
			log.info("physical mobsim run in iteration " + event.getIteration() + " ends");
			if (!this.nextMobsimIsExpectedToBePhysical) {
				throw new RuntimeException("Did not expect a physical mobsim run!");
			}
			this.lastPhysicalPopulationState = new PopulationState(this.services.getScenario().getPopulation());
			this.lastPhysicalLinkUsages = this.matsimMobsimUsageListener.getAndClearIndicators();
			this.pseudoSimIterationCnt = 0;
		} else {
			log.info("pseudoSim run in iteration " + event.getIteration() + " ends");
			if (this.nextMobsimIsExpectedToBePhysical) {
				throw new RuntimeException("Expected a physical mobsim run!");
			}
			this.pseudoSimIterationCnt++;
		}

		if (this.pseudoSimIterationCnt == (ConfigUtils.addOrGetModule(this.services.getConfig(), PSimConfigGroup.class)
				.getIterationsPerCycle() - 1)) {

			/*
			 * Extract, for each agent, the expected (hypothetical) score change and do some
			 * book-keeping.
			 */

			for (Person person : this.services.getScenario().getPopulation().getPersons().values()) {
				final double realizedUtility = this.lastPhysicalPopulationState.getSelectedPlan(person.getId())
						.getScore();
				final double expectedUtility = person.getSelectedPlan().getScore();
				this.utilities.updateBeforeReplanning(person.getId(), realizedUtility, expectedUtility);
			}

			final Utilities.SummaryStatistics utilityStats = this.utilities
					.newSummaryStatistics(this.replanningParameters().getReplanningEfficiencyThreshold());

			if (utilityStats.previousDataValid) {
				this.expectedUtilityImprovementSum.add(utilityStats.previousExpectedUtilityImprovementSum);
				this.realizedUtilityImprovementSum.add(utilityStats.realizedUtilityImprovementSum);
			}

			/*
			 * Extract hypothetical selected plans.
			 */

			final Collection<Plan> selectedHypotheticalPlans = new ArrayList<>(
					this.services.getScenario().getPopulation().getPersons().size());
			for (Person person : this.services.getScenario().getPopulation().getPersons().values()) {
				selectedHypotheticalPlans.add(person.getSelectedPlan());
			}

			/*
			 * Execute one pSim with the full population.
			 */

			final Map<Id<Person>, SpaceTimeIndicators<Id<Link>>> lastPseudoSimLinkUsages;
			{
				final LinkUsageListener pSimLinkUsageListener = new LinkUsageListener(
						this.replanningParameters().getTimeDiscretization());
				final EventsManager eventsManager = EventsUtils.createEventsManager();
				eventsManager.addHandler(pSimLinkUsageListener);
				final PSim pSim = new PSim(this.services.getScenario(), eventsManager, selectedHypotheticalPlans,
						this.linkTravelTimes);
				pSim.run();
				lastPseudoSimLinkUsages = pSimLinkUsageListener.getAndClearIndicators();
			}

			/*
			 * Memorize the most recent hypothetical population state and re-set the
			 * population to its most recent physical state.
			 */

			this.hypotheticalPopulationState = new PopulationState(this.services.getScenario().getPopulation());
			this.lastPhysicalPopulationState.set(this.services.getScenario().getPopulation());

			/*
			 * DECIDE WHO GETS TO RE-PLAN.
			 * 
			 * At this point, one has (i) the link usage statistics from the last physical
			 * MATSim network loading (lastPhysicalLinkUsages), and (ii) the hypothetical
			 * link usage statistics that would result from a 100% re-planning rate if
			 * network congestion did not change (lastPseudoSimLinkUsages).
			 * 
			 * Now solve an optimization problem that aims at balancing simulation
			 * advancement (changing link usage patterns) and simulation stabilization
			 * (keeping link usage patterns as they are). Most of the code below prepares
			 * the (heuristic) solution of this problem.
			 * 
			 */

			final ReplannerIdentifier replannerIdentifier = new ReplannerIdentifier(this.replanningParameters(),
					event.getIteration(), this.lastPhysicalLinkUsages, lastPseudoSimLinkUsages,
					this.services.getScenario().getPopulation(), utilityStats.personId2currentDeltaUtility,
					utilityStats.currentDeltaUtilitySum, this.currentDelta);
			this.replanners = replannerIdentifier.drawReplanners();
			this.everReplanners.addAll(this.replanners);

			this.averageDeltaForUniformReplanning.add(replannerIdentifier.getDeltaForUniformReplanning(95));
			this.averageDeltaForUniformReplanningExact.add(replannerIdentifier.getDeltaForUniformReplanningExact(95));

			// if (this.getAverageReplanningEfficiency() != null) {
			// this.currentDelta =
			// this.replanningParameters().getAdaptiveRegularizationWeight(
			// this.getAverageReplanningEfficiency(),
			// this.averageDeltaForUniformReplanning.average());
			// }
			// if (utilityStats.previousDataValid) {
			// final int percentile = max(0, min(100, (int) ((1.0 -
			// this.getReplanningEfficiency()) * 100)));
			// this.currentDelta = max(0,
			// replannerIdentifier.getDeltaForUniformReplanning(percentile));
			// }


			final LogDataWrapper data = new LogDataWrapper(this, replannerIdentifier, lastPseudoSimLinkUsages.size());
			this.statsWriter.writeToFile(data);

			if (this.lastRealizedUtilityChangeSum.size() > 0) {

				int percentileIndex = 0;
				while ((this.lastCriticalDeltas.get(percentileIndex) < 0.0)
						&& (percentileIndex + 1 < this.lastCriticalDeltas.size())) {
					percentileIndex++;
				}
				this.percentile = Math.max(0, Math.min(100,
						(percentileIndex * 100.0) / this.services.getScenario().getPopulation().getPersons().size()));

				final double upperBound = Math.max(0, this.getLastRealizedUtilityChangeSum())
						+ this.getLastExpectedUtilityChangeSumUniform();
				double currentVal = this.getLastExpectedUtilityChangeSumAccelerated();
				final int dir = (currentVal > upperBound ? 1 : -1);
				while ((currentVal > upperBound) & (percentileIndex + dir >= 0)
						&& (percentileIndex + dir < this.lastCriticalDeltas.size())) {
					percentileIndex += dir;
					if (this.lastActualReplanIndicators.get(percentileIndex) == 1.0
							&& this.lastUniformReplanIndicators.get(percentileIndex) == 0.0) {
						currentVal -= this.lastDeltaScore.get(percentileIndex) * dir;
					} else if (this.lastActualReplanIndicators.get(percentileIndex) == 0.0
							&& this.lastUniformReplanIndicators.get(percentileIndex) == 1.0) {
						currentVal += this.lastDeltaScore.get(percentileIndex) * dir;
					}
				}
				this.targetPercentile = Math.max(0, Math.min(100,
						(percentileIndex * 100.0) / this.services.getScenario().getPopulation().getPersons().size()));
				this.currentDelta = this.lastCriticalDeltas.get(percentileIndex);
			}
			// this.currentDelta = this.deltaRecipe.getDelta();
			// if (this.getAverageReplanningEfficiency() != null) {
			// final int percentile = Math.max(0,
			// Math.min(100, (int) ((1.0 - this.getAverageReplanningEfficiency()) * 100)));
			// this.currentDelta = Math.max(0,
			// replannerIdentifier.getDeltaForUniformReplanningExact(percentile));
			// }

			// this.lastExpectedUtilityChangeSumAccelerated = 0.0;
			// for (Id<Person> replanner : this.replanners) {
			// final Utilities.Entry utilityEntry = this.utilities.getUtilities(replanner);
			// this.lastExpectedUtilityChangeSumAccelerated +=
			// utilityEntry.getCurrentExpectedUtility()
			// - utilityEntry.getCurrentRealizedUtility();
			// }

			if (utilityStats.previousDataValid) {
				this.lastRealizedUtilityChangeSum
						.add(utilityStats.currentRealizedUtilitySum - utilityStats.previousRealizedUtilitySum);
				this.lastExpectedUtilityChangeSumUniform
						.add(this.replanningParameters().getMeanReplanningRate(event.getIteration())
								* (utilityStats.previousExpectedUtilitySum - utilityStats.previousRealizedUtilitySum));
				double lastExpectedUtilityChangeSumAcceleratedValue = 0.0;
				for (Id<Person> replannerId : this.replanners) {
					lastExpectedUtilityChangeSumAcceleratedValue += this.utilities.getUtilities(replannerId)
							.getPreviousExpectedUtilityChange();
				}
				this.lastExpectedUtilityChangeSumAccelerated.add(lastExpectedUtilityChangeSumAcceleratedValue);
			}

			this.lastActualReplanIndicators = replannerIdentifier.actualReplanIndicator;
			this.lastUniformReplanIndicators = replannerIdentifier.uniformReplanIndicator;
			this.lastCriticalDeltas = replannerIdentifier.allDeltaForUniformReplanningExact;
			this.lastDeltaScore = replannerIdentifier.deltaScore;

			this.nextMobsimIsExpectedToBePhysical = true;
			this.setWeightOfHypotheticalReplanning(1e9);

		} else

		{

			this.nextMobsimIsExpectedToBePhysical = false;
			this.setWeightOfHypotheticalReplanning(0);

		}
	}

	// -------------------- REPLANNING FUNCTIONALITY --------------------

	public void replan(final HasPlansAndId<Plan, Person> person) {
		if ((this.replanners != null) && this.replanners.contains(person.getId())) {
			// This replaces the entire choice set and not just the selected plan. Why not.
			this.hypotheticalPopulationState.set(person);
		}
	}
}
