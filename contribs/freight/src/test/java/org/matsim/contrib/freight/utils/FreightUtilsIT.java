/* *********************************************************************** *
 * project: org.matsim.*
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2018 by the members listed in the COPYING,        *
 *                   LICENSE and WARRANTY file.                            *
 * email           : info at matsim dot org                                *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *   See also COPYING, LICENSE and WARRANTY file                           *
 *                                                                         *
 * *********************************************************************** */
  
package org.matsim.contrib.freight.utils;

import java.util.Collection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.network.Network;
import org.matsim.contrib.freight.carrier.Carrier;
import org.matsim.contrib.freight.carrier.CarrierCapabilities;
import org.matsim.contrib.freight.carrier.CarrierImpl;
import org.matsim.contrib.freight.carrier.CarrierPlan;
import org.matsim.contrib.freight.carrier.CarrierService;
import org.matsim.contrib.freight.carrier.CarrierShipment;
import org.matsim.contrib.freight.carrier.CarrierVehicle;
import org.matsim.contrib.freight.carrier.CarrierVehicleType;
import org.matsim.contrib.freight.carrier.CarrierVehicleTypeLoader;
import org.matsim.contrib.freight.carrier.CarrierVehicleTypes;
import org.matsim.contrib.freight.carrier.Carriers;
import org.matsim.contrib.freight.carrier.ScheduledTour;
import org.matsim.contrib.freight.carrier.TimeWindow;
import org.matsim.contrib.freight.carrier.Tour.Leg;
import org.matsim.contrib.freight.carrier.Tour.TourElement;
import org.matsim.contrib.freight.carrier.CarrierCapabilities.FleetSize;
import org.matsim.contrib.freight.jsprit.MatsimJspritFactory;
import org.matsim.contrib.freight.jsprit.NetworkBasedTransportCosts;
import org.matsim.contrib.freight.jsprit.NetworkRouter;
import org.matsim.contrib.freight.jsprit.NetworkBasedTransportCosts.Builder;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.network.io.MatsimNetworkReader;
import org.matsim.testcases.MatsimTestUtils;
import org.matsim.vehicles.VehicleType;
import org.matsim.vehicles.EngineInformation;
import org.matsim.vehicles.EngineInformation.FuelType;
import org.matsim.vehicles.EngineInformationImpl;

import com.graphhopper.jsprit.core.algorithm.VehicleRoutingAlgorithm;
import com.graphhopper.jsprit.core.algorithm.box.SchrimpfFactory;
import com.graphhopper.jsprit.core.problem.VehicleRoutingProblem;
import com.graphhopper.jsprit.core.problem.solution.VehicleRoutingProblemSolution;
import com.graphhopper.jsprit.core.util.Solutions;

import org.junit.Assert;

public class FreightUtilsIT {
	
	private static final Id<Carrier> CARRIER_ID = Id.create("Carrier", Carrier.class);
	
	private Carriers carriersWithServicesAndShpiments;
	private Carrier carrierServicesAndShipments1;
	
	private Carriers carriersShipmentsOnly;
	private Carrier carrierShipmentsOnly1;
	
	@Rule
	public MatsimTestUtils testUtils = new MatsimTestUtils();
	
	@Before
	public void setUp() {
		
		//Create carrier with services and shipments
		carriersWithServicesAndShpiments = new Carriers() ;
		carrierServicesAndShipments1 = CarrierImpl.newInstance(CARRIER_ID);
		carrierServicesAndShipments1.getShipments().add(createMatsimShipment("shipment1", "i(1,0)", "i(7,6)R", 1)); 
		carrierServicesAndShipments1.getShipments().add(createMatsimShipment("shipment2", "i(3,0)", "i(3,7)", 2));

		carrierServicesAndShipments1.getServices().add(createMatsimService("Service2", "i(3,9)", 2));
		carrierServicesAndShipments1.getServices().add(createMatsimService("Service3", "i(4,9)", 2));

		//Create vehicle for Carrier
		CarrierVehicleType carrierVehType = CarrierVehicleType.Builder.newInstance(Id.create("gridType", VehicleType.class))
				.setCapacity(3)
				.setMaxVelocity(10)
				.setCostPerDistanceUnit(0.0001)
				.setCostPerTimeUnit(0.001)
				.setFixCost(130)
				.setEngineInformation(new EngineInformationImpl(FuelType.diesel, 0.015))
				.build();
		CarrierVehicleTypes vehicleTypes = new CarrierVehicleTypes() ;
		vehicleTypes.getVehicleTypes().put(carrierVehType.getId(), carrierVehType);
		
		CarrierVehicle carrierVehicle = CarrierVehicle.Builder.newInstance(Id.create("gridVehicle", org.matsim.vehicles.Vehicle.class), Id.createLinkId("i(6,0)")).setEarliestStart(0.0).setLatestEnd(36000.0).setTypeId(carrierVehType.getId()).build();
		CarrierCapabilities.Builder ccBuilder = CarrierCapabilities.Builder.newInstance() 
				.addType(carrierVehType)
				.addVehicle(carrierVehicle)
				.setFleetSize(FleetSize.INFINITE);				
		carrierServicesAndShipments1.setCarrierCapabilities(ccBuilder.build());

		carriersWithServicesAndShpiments.addCarrier(carrierServicesAndShipments1);

		// assign vehicle types to the carriers
		new CarrierVehicleTypeLoader(carriersWithServicesAndShpiments).loadVehicleTypes(vehicleTypes) ;	

		//load Network and build netbasedCosts for jsprit
		Network network = NetworkUtils.createNetwork();
		new MatsimNetworkReader(network).readFile(testUtils.getPackageInputDirectory() + "grid-network.xml"); 
		Builder netBuilder = NetworkBasedTransportCosts.Builder.newInstance( network, vehicleTypes.getVehicleTypes().values() );
		final NetworkBasedTransportCosts netBasedCosts = netBuilder.build() ;
		netBuilder.setTimeSliceWidth(1800) ; // !!!!, otherwise it will not do anything.
		

		//Build jsprit VRP
		VehicleRoutingProblem.Builder vrpBuilder = MatsimJspritFactory.createRoutingProblemBuilder(carrierServicesAndShipments1, network);
		vrpBuilder.setRoutingCost(netBasedCosts) ;
		VehicleRoutingProblem problem = vrpBuilder.build();

		// get the algorithm out-of-the-box, search solution and get the best one.
		VehicleRoutingAlgorithm algorithm = new SchrimpfFactory().createAlgorithm(problem);
		Collection<VehicleRoutingProblemSolution> solutions = algorithm.searchSolutions();
		VehicleRoutingProblemSolution bestSolution = Solutions.bestOf(solutions);

		//Routing bestPlan to Network
		CarrierPlan carrierPlanServicesAndShipments = MatsimJspritFactory.createPlan(carrierServicesAndShipments1, bestSolution) ;
		NetworkRouter.routePlan(carrierPlanServicesAndShipments,netBasedCosts) ;
		carrierServicesAndShipments1.setSelectedPlan(carrierPlanServicesAndShipments) ;

		/*
		 * Now convert it to a only shipment-based VRP and run it again.
		 */

		//Convert to jsprit VRP
		carriersShipmentsOnly = FreightUtils.createShipmentVRPCarrierFromServiceVRPSolution(carriersWithServicesAndShpiments);
		carrierShipmentsOnly1 = carriersShipmentsOnly.getCarriers().get(CARRIER_ID);

		// assign vehicle types to the carriers
		new CarrierVehicleTypeLoader(carriersShipmentsOnly).loadVehicleTypes(vehicleTypes) ;	

		VehicleRoutingProblem.Builder vrpBuilderShipmentsOnly = MatsimJspritFactory.createRoutingProblemBuilder(carrierShipmentsOnly1, network);

		vrpBuilderShipmentsOnly.setRoutingCost(netBasedCosts) ;

		VehicleRoutingProblem problemSchipmentsOnly = vrpBuilderShipmentsOnly.build();

		// get the algorithm out-of-the-box, search solution and get the best one.
		VehicleRoutingAlgorithm algorithmShipmentsOnly = new SchrimpfFactory().createAlgorithm(problemSchipmentsOnly);
		Collection<VehicleRoutingProblemSolution> solutionsShipmentsOnly = algorithmShipmentsOnly.searchSolutions();
		VehicleRoutingProblemSolution bestSolutionShipmentsOnly = Solutions.bestOf(solutionsShipmentsOnly);


		CarrierPlan carrierPlanShipmentsOnly = MatsimJspritFactory.createPlan(carrierShipmentsOnly1, bestSolutionShipmentsOnly) ;
		NetworkRouter.routePlan(carrierPlanShipmentsOnly,netBasedCosts) ;
		carrierShipmentsOnly1.setSelectedPlan(carrierPlanShipmentsOnly) ;
	}
	
	@Test
	public void numberOfServicesAndShipmentsIsCorrect() {
		Assert.assertEquals(2, carrierServicesAndShipments1.getServices().size());
		
		int demandServices = 0;
		for (CarrierService carrierService : carrierServicesAndShipments1.getServices()) {
			demandServices += carrierService.getCapacityDemand();
		}
		Assert.assertEquals(4, demandServices);
		
		Assert.assertEquals(2, carrierServicesAndShipments1.getShipments().size());
		int demandShipments = 0;
		for (CarrierShipment carrierShipment : carrierServicesAndShipments1.getShipments()) {
			demandShipments += carrierShipment.getSize();
		}
		Assert.assertEquals(3, demandShipments);
	}
	
	@Test
	public void numberOfShipmentsInShipmentOnlyIsCorrect() {
		Assert.assertEquals(0, carrierShipmentsOnly1.getServices().size());
		
		Assert.assertEquals(4, carrierShipmentsOnly1.getShipments().size());
		int demandShipments = 0;
		for (CarrierShipment carrierShipment : carrierShipmentsOnly1.getShipments()) {
			demandShipments += carrierShipment.getSize();
		}
		Assert.assertEquals(7, demandShipments);
	}
	
	@Test
	public void fleetAvailableIsCorrect() {
		Assert.assertEquals(FleetSize.INFINITE, carrierShipmentsOnly1.getCarrierCapabilities().getFleetSize());
		Assert.assertEquals(1, carrierShipmentsOnly1.getCarrierCapabilities().getVehicleTypes().size());
		for (CarrierVehicleType carrierVehicleType : carrierShipmentsOnly1.getCarrierCapabilities().getVehicleTypes()){
			Assert.assertEquals(3,carrierVehicleType.getCarrierVehicleCapacity());
			Assert.assertEquals(130, carrierVehicleType.getVehicleCostInformation().fix, 0.0);
			Assert.assertEquals(0.0001, carrierVehicleType.getVehicleCostInformation().perDistanceUnit, 0.0);
			Assert.assertEquals(0.001, carrierVehicleType.getVehicleCostInformation().perTimeUnit, 0.0);
			Assert.assertEquals(10, carrierVehicleType.getMaximumVelocity(), 0.0);
			Assert.assertEquals(EngineInformation.FuelType.diesel, carrierVehicleType.getEngineInformation().getFuelType());
			Assert.assertEquals(0.015, carrierVehicleType.getEngineInformation().getGasConsumption(), 0.0);
		}
	}

	@Test
	public void copiingOfShipmentsIsDoneCorrectly() {
		boolean foundShipment1 = false;
		boolean foundShipment2 = false;
		for (CarrierShipment carrierShipment :  carrierShipmentsOnly1.getShipments()) {
			if (carrierShipment.getId() == Id.create("shipment1", CarrierShipment.class)) {
				foundShipment1 = true;
				Assert.assertEquals(Id.createLinkId("i(1,0)"), carrierShipment.getFrom());
				Assert.assertEquals(Id.createLinkId("i(7,6)R"), carrierShipment.getTo());
				Assert.assertEquals(1, carrierShipment.getSize());
				Assert.assertEquals(30.0, carrierShipment.getDeliveryServiceTime(), 0);
				Assert.assertEquals(3600.0, carrierShipment.getDeliveryTimeWindow().getStart(), 0);
				Assert.assertEquals(36000.0, carrierShipment.getDeliveryTimeWindow().getEnd(), 0);
				Assert.assertEquals(5.0, carrierShipment.getPickupServiceTime(), 0);
				Assert.assertEquals(0.0, carrierShipment.getPickupTimeWindow().getStart(), 0);
				Assert.assertEquals(7200.0, carrierShipment.getPickupTimeWindow().getEnd(), 0);
			} else if (carrierShipment.getId() == Id.create("shipment2", CarrierShipment.class)) {
				foundShipment2 = true;
				Assert.assertEquals(Id.createLinkId("(3,0)"), carrierShipment.getFrom());
				Assert.assertEquals(Id.createLinkId("i(3,7)"), carrierShipment.getTo());
				Assert.assertEquals(2, carrierShipment.getSize());
				Assert.assertEquals(30.0, carrierShipment.getDeliveryServiceTime(), 0);
				Assert.assertEquals(3600.0, carrierShipment.getDeliveryTimeWindow().getStart(), 0);
				Assert.assertEquals(36000.0, carrierShipment.getDeliveryTimeWindow().getEnd(), 0);
				Assert.assertEquals(5.0, carrierShipment.getPickupServiceTime(), 0);
				Assert.assertEquals(0.0, carrierShipment.getPickupTimeWindow().getStart(), 0);
				Assert.assertEquals(7200.0, carrierShipment.getPickupTimeWindow().getEnd(), 0);
			} 
			
			Assert.assertTrue("Not found Shipment1 after copiing", foundShipment1);
			Assert.assertTrue("Not found Shipment2 after copiing", foundShipment2);
		}
	}
	
	
	@Test
	public void convertionOfSericesIsDoneCorrectly() {
		boolean foundSercice2 = false;
		boolean foundService3 = false;
		for (CarrierShipment carrierShipment :  carrierShipmentsOnly1.getShipments()) {
			if (carrierShipment.getId() == Id.create("service2", CarrierShipment.class)) {
				foundSercice2 = true;
				Assert.assertEquals(Id.createLinkId("i(6,0)"), carrierShipment.getFrom());
				Assert.assertEquals(Id.createLinkId("i(3,9)"), carrierShipment.getTo());
				Assert.assertEquals(2, carrierShipment.getSize());
				Assert.assertEquals(31.0, carrierShipment.getDeliveryServiceTime(), 0);
				Assert.assertEquals(3601.0, carrierShipment.getDeliveryTimeWindow().getStart(), 0);
				Assert.assertEquals(36001.0, carrierShipment.getDeliveryTimeWindow().getEnd(), 0);
				Assert.assertEquals(0.0, carrierShipment.getPickupServiceTime(), 0);
				Assert.assertEquals(0.0, carrierShipment.getPickupTimeWindow().getStart(), 0);
				Assert.assertEquals(36001.0, carrierShipment.getPickupTimeWindow().getEnd(), 0);
			} else if (carrierShipment.getId() == Id.create("service3", CarrierShipment.class)) {
				foundService3 = true;
				Assert.assertEquals(Id.createLinkId("i(6,0)"), carrierShipment.getFrom());
				Assert.assertEquals(Id.createLinkId("i(4,9)"), carrierShipment.getTo());
				Assert.assertEquals(2, carrierShipment.getSize());
				Assert.assertEquals(31.0, carrierShipment.getDeliveryServiceTime(), 0);
				Assert.assertEquals(3601.0, carrierShipment.getDeliveryTimeWindow().getStart(), 0);
				Assert.assertEquals(36001.0, carrierShipment.getDeliveryTimeWindow().getEnd(), 0);
				Assert.assertEquals(0.0, carrierShipment.getPickupServiceTime(), 0);
				Assert.assertEquals(0.0, carrierShipment.getPickupTimeWindow().getStart(), 0);
				Assert.assertEquals(36001.0, carrierShipment.getPickupTimeWindow().getEnd(), 0);
			}
			
			Assert.assertTrue("Not found Shipment1 after copiing", foundSercice2);
			Assert.assertTrue("Not found Shipment2 after copiing", foundService3);
		}
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void exceptionIsThrownWhenUsingShipmentsAndServices() {
		//TODO Insert content.
	}
	
	@Test
	public void numberOfToursIsCorrect() {
		Assert.assertEquals(2 , carrierServicesAndShipments1.getSelectedPlan().getScheduledTours().size());
		Assert.assertEquals(1, carrierShipmentsOnly1.getSelectedPlan().getScheduledTours().size());
	}
	
	@Test
	public void toursMixedCarrierAreCorrect() {
		
		Assert.assertEquals(-99, carrierServicesAndShipments1.getSelectedPlan().getScore(), 0);			//TODO: Korrekten WErt ermitteln und eintragen
		
		double tourDurationSum = 0;
		for (ScheduledTour scheduledTour: carrierServicesAndShipments1.getSelectedPlan().getScheduledTours()){
			tourDurationSum += scheduledTour.getTour().getEnd().getExpectedArrival() - scheduledTour.getDeparture();
		}
		Assert.assertEquals(3 , tourDurationSum, 0);													//TODO: Korrekten WErt ermitteln und eintragen
		
		double tourLengthSum = 0;
		for (ScheduledTour scheduledTour: carrierServicesAndShipments1.getSelectedPlan().getScheduledTours()){
			for (TourElement te : scheduledTour.getTour().getTourElements()) {
				if (te instanceof Leg) {
					tourLengthSum += ((Leg) te).getRoute().getDistance();
				}
			}
		}
		Assert.assertEquals(1, tourLengthSum, 0);														//TODO: Korrekten WErt ermitteln und eintragen
	}

	@Test
	public void toursShipmentOnlyCarrierAreCorrect() {
		
		Assert.assertEquals(-99, carrierShipmentsOnly1.getSelectedPlan().getScore(), 0);			//TODO: Korrekten WErt ermitteln und eintragen
		
		double tourDurationSum = 0;
		for (ScheduledTour scheduledTour: carrierShipmentsOnly1.getSelectedPlan().getScheduledTours()){
			tourDurationSum += scheduledTour.getTour().getEnd().getExpectedArrival() - scheduledTour.getDeparture();
		}
		Assert.assertEquals(3 , tourDurationSum, 0);													//TODO: Korrekten WErt ermitteln und eintragen
		
		double tourLengthSum = 0;
		for (ScheduledTour scheduledTour: carrierShipmentsOnly1.getSelectedPlan().getScheduledTours()){
			for (TourElement te : scheduledTour.getTour().getTourElements()) {
				if (te instanceof Leg) {
					tourLengthSum += ((Leg) te).getRoute().getDistance();
				}
			}
		}
		Assert.assertEquals(1, tourLengthSum, 0);														//TODO: Korrekten WErt ermitteln und eintragen
	}
	
	private static CarrierShipment createMatsimShipment(String id, String from, String to, int size) {
		Id<CarrierShipment> shipmentId = Id.create(id, CarrierShipment.class);
		Id<Link> fromLinkId = null; 
		Id<Link> toLinkId= null;

		if(from != null ) {
			fromLinkId = Id.create(from, Link.class);
		} 
		if(to != null ) {
			toLinkId = Id.create(to, Link.class);
		}

		return CarrierShipment.Builder.newInstance(shipmentId, fromLinkId, toLinkId, size)
				.setDeliveryServiceTime(30.0)
				.setDeliveryTimeWindow(TimeWindow.newInstance(3600.0, 36000.0))
				.setPickupServiceTime(5.0)
				.setPickupTimeWindow(TimeWindow.newInstance(0.0, 7200.0))
				.build();
	}

	private static CarrierService createMatsimService(String id, String to, int size) {
		return CarrierService.Builder.newInstance(Id.create(id, CarrierService.class), Id.create(to, Link.class))
				.setCapacityDemand(size)
				.setServiceDuration(31.0)
				.setServiceStartTimeWindow(TimeWindow.newInstance(3601.0, 36001.0))
				.build();
	}

}
