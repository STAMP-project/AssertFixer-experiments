package controller;

import controller.map.CheckConnectivityControllerTest;
import controller.map.ContinentControllerTest;
import controller.map.CountryControllerTest;
import controller.map.GeographicalMapControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({CheckConnectivityControllerTest.class, ContinentControllerTest.class, CountryControllerTest.class, GeographicalMapControllerTest.class})
public class AppTest {
}