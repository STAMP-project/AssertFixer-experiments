package com.tda.test;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jet533 on 9/18/2018.
 */
public class FormOwn {

    @Test
    public  void  testtest()
    {
        TestNG testNG=new TestNG();
        XmlSuite suite=new XmlSuite();
       // suite.setName("MySuite");



        XmlTest xmlTest=new XmlTest(suite);
        //xmlTest.setName("MyTest");

        List<XmlClass> xmlClasses=new ArrayList<XmlClass>();
        XmlClass xmlClass=new XmlClass("com.tda.test.ListTests");

        List<XmlInclude> methods=new ArrayList<XmlInclude>();
        methods.add(new XmlInclude("Test2"));
        xmlClass.setIncludedMethods(methods);

        xmlClasses.add(xmlClass);
        xmlTest.setXmlClasses(xmlClasses);

        List<XmlSuite> xmlSuites=new ArrayList<XmlSuite>();
        xmlSuites.add(suite);
        testNG.setXmlSuites(xmlSuites);
        testNG.run();
    }
}
