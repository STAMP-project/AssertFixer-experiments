/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.controller

import org.apache.nifi.authorization.Authorizer
import org.apache.nifi.cluster.coordination.ClusterCoordinator
import org.apache.nifi.cluster.coordination.node.NodeConnectionState
import org.apache.nifi.cluster.coordination.node.NodeConnectionStatus
import org.apache.nifi.cluster.coordination.node.OffloadCode
import org.apache.nifi.cluster.protocol.NodeIdentifier
import org.apache.nifi.cluster.protocol.impl.NodeProtocolSenderListener
import org.apache.nifi.cluster.protocol.message.OffloadMessage
import org.apache.nifi.components.state.Scope
import org.apache.nifi.components.state.StateManager
import org.apache.nifi.components.state.StateManagerProvider
import org.apache.nifi.controller.queue.FlowFileQueue
import org.apache.nifi.controller.status.ProcessGroupStatus
import org.apache.nifi.encrypt.StringEncryptor
import org.apache.nifi.groups.ProcessGroup
import org.apache.nifi.groups.RemoteProcessGroup
import org.apache.nifi.state.MockStateMap
import org.apache.nifi.util.NiFiProperties
import org.apache.nifi.web.revision.RevisionManager
import spock.lang.Specification
import spock.util.concurrent.AsyncConditions
import spock.util.concurrent.BlockingVariable

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class StandardFlowServiceSpec extends Specification {
    def "handle an OffloadMessage"() {
        given:
        def asyncConditions = new AsyncConditions(1)

        def nodeToOffload = createNodeIdentifier 1

        def stateManager = Mock StateManager
        def stateMap = new MockStateMap([:], 1)
        stateManager.getState(_ as Scope) >> stateMap
        def stateManagerProvider = Mock StateManagerProvider
        stateManagerProvider.getStateManager(_ as String) >> stateManager

        def rootGroup = Mock ProcessGroup
        def flowController = Mock FlowController
        flowController.getStateManagerProvider() >> stateManagerProvider
        _ * flowController.rootGroup >> rootGroup

        def clusterCoordinator = Mock ClusterCoordinator

        def processGroupStatus = Mock ProcessGroupStatus
        def processorNode = Mock ProcessorNode
        def remoteProcessGroup = Mock RemoteProcessGroup
        def flowFileQueue = Mock FlowFileQueue

        def flowService = StandardFlowService.createClusteredInstance(flowController, NiFiProperties.createBasicNiFiProperties('src/test/resources/conf/nifi.properties',
                [(NiFiProperties.CLUSTER_NODE_PROTOCOL_PORT): nodeToOffload.socketPort as String,
                 (NiFiProperties.WEB_HTTP_PORT)             : nodeToOffload.apiPort as String,
                 (NiFiProperties.LOAD_BALANCE_PORT)         : nodeToOffload.loadBalancePort as String]),
                Mock(NodeProtocolSenderListener), clusterCoordinator, Mock(StringEncryptor), Mock(RevisionManager), Mock(Authorizer))

        def waitForFinishOffload = new BlockingVariable(5, TimeUnit.SECONDS)//new CountDownLatch(1)

        when:
        flowService.handle(new OffloadMessage(nodeId: nodeToOffload, explanation: 'unit test offload'), [] as Set)
        waitForFinishOffload.get()

        then:
        noExceptionThrown()

        and: 'expected methods on collaborators are invoked'
        1 * flowController.setConnectionStatus({ NodeConnectionStatus status ->
            status.nodeIdentifier.logicallyEquals(nodeToOffload) && status.state == NodeConnectionState.OFFLOADING && status.offloadCode == OffloadCode.OFFLOADED
        } as NodeConnectionStatus)
        then:
        1 * flowController.stopAllProcessors()
        then:
        1 * processorNode.scheduledState >> ScheduledState.STOPPED
        1 * processorNode.processGroup >> rootGroup
        1 * rootGroup.terminateProcessor({ ProcessorNode pn -> pn == processorNode } as ProcessorNode)
        1 * rootGroup.findAllProcessors() >> [processorNode]
        then:
        1 * remoteProcessGroup.stopTransmitting()
        1 * rootGroup.findAllRemoteProcessGroups() >> [remoteProcessGroup]
        then:
        1 * flowFileQueue.offloadQueue()
        1 * flowController.getAllQueues() >> [flowFileQueue]
        then:
        1 * processGroupStatus.getQueuedCount() >> 0
        1 * flowController.getControllerStatus() >> processGroupStatus
        then:
        1 * flowFileQueue.resetOffloadedQueue()
        1 * flowController.getAllQueues() >> [flowFileQueue]
        then:
        1 * flowController.setConnectionStatus({ NodeConnectionStatus status ->
            status.nodeIdentifier.logicallyEquals(nodeToOffload) && status.state == NodeConnectionState.OFFLOADED && status.offloadCode == OffloadCode.OFFLOADED
        } as NodeConnectionStatus)
        then:
        1 * clusterCoordinator.finishNodeOffload({ NodeIdentifier nodeIdentifier ->
            nodeIdentifier.logicallyEquals(nodeToOffload)
        } as NodeIdentifier) >> { waitForFinishOffload.set(it) }
    }

    private static NodeIdentifier createNodeIdentifier(final int index) {
        new NodeIdentifier("node-id-$index", "localhost", 8000 + index, "localhost", 9000 + index,
                "localhost", 10000 + index, 11000 + index, false)
    }
}
