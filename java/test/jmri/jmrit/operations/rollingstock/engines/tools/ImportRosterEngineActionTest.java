package jmri.jmrit.operations.rollingstock.engines.tools;

import java.awt.GraphicsEnvironment;
import jmri.jmrit.operations.rollingstock.engines.EnginesTableFrame;
import jmri.jmrit.operations.rollingstock.engines.tools.ImportRosterEngineAction;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class ImportRosterEngineActionTest {

    @Test
    public void testCTor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        EnginesTableFrame etf = new EnginesTableFrame();
        ImportRosterEngineAction t = new ImportRosterEngineAction("Test Action",etf);
        Assert.assertNotNull("exists",t);
        JUnitUtil.dispose(etf);
    }

    // The minimal setup for log4J
    @Before
    public void setUp() {
        JUnitUtil.setUp();
        JUnitUtil.resetProfileManager();
    }

    @After
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(ImportRosterEngineActionTest.class);

}
