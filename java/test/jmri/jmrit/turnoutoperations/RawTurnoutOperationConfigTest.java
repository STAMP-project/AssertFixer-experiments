package jmri.jmrit.turnoutoperations;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class RawTurnoutOperationConfigTest {

    @Test
    public void testCTor() {
        jmri.TurnoutOperation to = new jmri.RawTurnoutOperation();
        RawTurnoutOperationConfig t = new RawTurnoutOperationConfig(to);
        Assert.assertNotNull("exists",t);
    }

    // The minimal setup for log4J
    @Before
    public void setUp() {
        JUnitUtil.setUp();
    }

    @After
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(RawTurnoutOperationConfigTest.class);

}
