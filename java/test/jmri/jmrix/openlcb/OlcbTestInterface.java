package jmri.jmrix.openlcb;

import java.util.List;
import java.util.concurrent.Semaphore;

import jmri.InstanceManager;
import jmri.jmrix.can.CanMessage;
import jmri.jmrix.can.CanSystemConnectionMemo;
import jmri.jmrix.can.ConfigurationManager;
import jmri.jmrix.can.TestTrafficController;

import org.junit.Assert;
import org.openlcb.Connection;
import org.openlcb.NodeID;
import org.openlcb.OlcbInterface;
import org.openlcb.can.CanFrame;
import org.openlcb.can.CanInterface;
import org.openlcb.can.GridConnect;

/**
 * @author Balazs Racz Copyright (C) 2016
 */

public class OlcbTestInterface {
    /**
     * Creates a lightweight test setup.
     */
    public OlcbTestInterface() {
        tc = new TestTrafficController();
        nodeID = new NodeID("02.01.0D.00.00.01");
        canInterface = OlcbConfigurationManagerScaffold.createOlcbCanInterface(nodeID, tc);
        iface = canInterface.getInterface();
    }

    public static class CreateConfigurationManager {}

    /**
     * Creates a more heavyweight test setup, using the standard ConfigurationManager class.
     * @param hh ignored
     */
    public OlcbTestInterface(CreateConfigurationManager hh) {
        tc = new TestTrafficController();
        InstanceManager.store(new NodeID("02.01.0D.00.00.01"), NodeID.class);
        CanSystemConnectionMemo memo = new CanSystemConnectionMemo();
        memo.setTrafficController(tc);
        memo.setProtocol(ConfigurationManager.OPENLCB);
        memo.configureManagers();
        configurationManager = InstanceManager.getDefault(OlcbConfigurationManager.class);
        canInterface = configurationManager.olcbCanInterface;
        iface = canInterface.getInterface();
        nodeID = iface.getNodeId(); //
        waitForStartup();
    }

    public void waitForStartup() {
        final Semaphore s = new Semaphore(0);
        iface.getOutputConnection().registerStartNotification(new Connection.ConnectionListener() {
            @Override
            public void connectionActive(Connection c) {
                s.release();
            }
        });
        s.acquireUninterruptibly();
        flush();
    }

    public void sendMessage(CanMessage msg) {
        canInterface.frameInput().send(OlcbConfigurationManager.convertFromCan(msg));
    }

    /**
     * Injects an incoming message from the bus.
     * @param gridconnectMessage CAN frame in gridconnect format. Can contain multiple frames.
     */
    public void sendMessage(String gridconnectMessage) {
        List<CanFrame> l = GridConnect.parse(gridconnectMessage);
        for (CanFrame m : l) {
            canInterface.frameInput().send(m);
        }
        flush();
    }

    /**
     * Asserts that the last message sent to the bus is a given CAN frame.
     * @param gridconnectMessage single CAN frame in gridconnect format.
     */
    public void assertSentMessage(String gridconnectMessage) {
        List<CanFrame> l = GridConnect.parse(gridconnectMessage);
        Assert.assertEquals(1, l.size());
        Assert.assertEquals(OlcbConfigurationManager.convertToCan(l.get(0)), tc.rcvMessage);
        tc.rcvMessage = null;
    }

    /**
     * Asserts that no message was sent to the bus.
     */
    public void assertNoSentMessages() {
        Assert.assertNull(tc.rcvMessage);
    }

    /**
     * Injects a packet coming from the bus then asserts a given response generated by the stack.
     * @param gridconnectRequest message coming from the bus, in gridconnect format.
     * @param gridconnectReply expected response, in gridconnect format.
     */
    public void sendMessageAndExpectResponse(String gridconnectRequest, String gridconnectReply) {
        sendMessage(gridconnectRequest);
        flush();
        assertSentMessage(gridconnectReply);
    }

    public void flush() {
        iface.flushSendQueue();
    }

    public static OlcbSystemConnectionMemo createForLegacyTests() {
        OlcbTestInterface testIf = new OlcbTestInterface();
        OlcbSystemConnectionMemo memo = new OlcbSystemConnectionMemo();
        memo.setTrafficController(testIf.tc);
        memo.setInterface(testIf.iface);
        testIf.waitForStartup();
        return memo;
    }

    /**
     * @return an OlcbSystemConnectionMemo bound to this test interface for integration tests.
     */
    public OlcbSystemConnectionMemo createSystemConnectionMemo() {
        OlcbSystemConnectionMemo memo = new OlcbSystemConnectionMemo();
        memo.setTrafficController(tc);
        memo.setInterface(iface);
        waitForStartup();
        return memo;
    }

    /**
     * @return an OlcbConfigurationManager bound to this test interface for integration tests.
     * Internally it will have created all the individual managers.
     */
    public OlcbConfigurationManager createConfigurationManager() {
        OlcbSystemConnectionMemo memo = createSystemConnectionMemo();
        OlcbConfigurationManager t = new OlcbConfigurationManagerScaffold(memo);
        t.configureManagers();
        return t;
    }

    public TestTrafficController tc;
    public NodeID nodeID;
    public CanInterface canInterface;
    public OlcbInterface iface;
    public OlcbConfigurationManager configurationManager;

    public void dispose(){
      // terminate the OlcbInterface (and terminate thread)
      new Thread(() -> { iface.dispose();},"OLCB Interface dispose thread").start();
    }


}
