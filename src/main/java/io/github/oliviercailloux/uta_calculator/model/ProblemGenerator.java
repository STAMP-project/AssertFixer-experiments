package io.github.oliviercailloux.uta_calculator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import io.github.oliviercailloux.uta_calculator.utils.ScaleGenerator;

public class ProblemGenerator {

	// Attributes
	private Random random;
	private List<CriterionWithScale> criteria;
	private List<UTAAlternative> alternatives;

	// Constructors
	public ProblemGenerator(List<CriterionWithScale> criteria, List<UTAAlternative> alternatives) {
		this.criteria = criteria;
		this.alternatives = alternatives;
		random = new Random();
	}

	public ProblemGenerator() {
		this.criteria = new ArrayList<>();
		this.alternatives = new ArrayList<>();
		random = new Random();
	}

	// Getters and Setters
	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public List<CriterionWithScale> getCriteria() {
		return criteria;
	}

	public void setCriteria(List<CriterionWithScale> criteria) {
		this.criteria = criteria;
	}

	public List<UTAAlternative> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(List<UTAAlternative> alternatives) {
		this.alternatives = alternatives;
	}

	// Methods
	public void generateCriteria(int number, double minValue, double maxValue, int cuts) {
		ScaleGenerator scaleGenerator = new ScaleGenerator();
		for (int i = 0; i < number; i++) {
			int id = i + 1;
			CriterionWithScale criterion = new CriterionWithScale(id, "c" + id,
					scaleGenerator.generate(minValue, maxValue, cuts));
			criteria.add(criterion);
		}
	}

	public void generateAlternatives(int number) {
		for (int i = 0; i < number; i++) {
			int id = i + 1;
			Map<CriterionWithScale, Double> evaluations = new HashMap<>();
			for (CriterionWithScale criterion : criteria) {
				double randomValue = criterion.getMinValue()
						+ (criterion.getMaxValue() - criterion.getMinValue()) * random.nextDouble();
				evaluations.put(criterion, randomValue);
			}
			UTAAlternative alternative = new UTAAlternative(id, "a" + id, evaluations);
			alternatives.add(alternative);
		}
	}

	@Override
	public String toString() {
		String result = "";
		result += "Criteria : \n";

		for (int i = 0; i < criteria.size(); i++) {
			result += criteria.get(i).getName() + " --> " + criteria.get(i).getScale() + " \n";
		}

		result += "\nAlternatives : \n";
		for (UTAAlternative alternative : alternatives) {
			result += alternative.getName() + " --> ";
			for (int i = 0; i < criteria.size(); i++) {
				result += alternative.getEvaluations().get(criteria.get(i)) + " ";
			}
			result += "\n";
		}

		return result;
	}

}