/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.servicecomb.saga.alpha.server.tcc;

import java.lang.invoke.MethodHandles;
import java.util.List;
import org.apache.servicecomb.saga.alpha.server.tcc.callback.TccCallbackEngine;
import org.apache.servicecomb.saga.alpha.server.tcc.jpa.GlobalTxEvent;
import org.apache.servicecomb.saga.alpha.server.tcc.jpa.ParticipatedEvent;
import org.apache.servicecomb.saga.alpha.server.tcc.service.MemoryEventRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Manage TCC transaction event.
 */
@Component("defaultTccTxEventFacade")
public final class DefaultTccTxEventFacadeImpl implements TccTxEventFacade {

  private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @Autowired
  @Qualifier("memoryCallbackEngine")
  private TccCallbackEngine tccCallbackEngine;

  @Override
  public boolean onTccStartEvent(GlobalTxEvent globalTxEvent) {
    MemoryEventRegistry.addGlobalTxEvent(globalTxEvent);
    LOG.info("Registered participated event, global tx: {}, local tx: {}, parent id: {}, "
            + "txType: {}, service [{}] instanceId [{}]",
        globalTxEvent.getGlobalTxId(), globalTxEvent.getLocalTxId(), globalTxEvent.getParentTxId(),
        globalTxEvent.getTxType(), globalTxEvent.getServiceName(), globalTxEvent.getInstanceId());
    return true;
  }

  /**
   * Register participate event.
   *
   * @param participatedEvent participated event
   */

  @Override
  public boolean onParticipateEvent(ParticipatedEvent participatedEvent) {
    MemoryEventRegistry.addParticipateEvent(participatedEvent);
    LOG.info("Registered participated event, global tx: {}, local tx: {}, parent id: {}, "
            + "confirm: {}, cancel: {}, status: {}, service [{}] instanceId [{}]",
        participatedEvent.getGlobalTxId(), participatedEvent.getLocalTxId(), participatedEvent.getParentTxId(),
        participatedEvent.getConfirmMethod(), participatedEvent.getCancelMethod(), participatedEvent.getStatus(),
        participatedEvent.getServiceName(), participatedEvent.getInstanceId());

    // TODO We need to updated the event which transactionStatus is failed.
    return true;
  }

  @Override
  public boolean onTccEndEvent(GlobalTxEvent globalTxEvent) {
    MemoryEventRegistry.addGlobalTxEvent(globalTxEvent);
    return tccCallbackEngine.execute(globalTxEvent);
  }

  @Override
  public void onCoordinatedEvent(String globalTxId, String localTxId) {
    MemoryEventRegistry.migrateParticipate(globalTxId, localTxId);
  }

  @Override
  public List<GlobalTxEvent> getGlobalTxEventByGlobalTxId(String globalTxId) {
    return MemoryEventRegistry.getGlobalTxEventByGlobalTxId(globalTxId);
  }

  /**
   * Retrieve participate event from registry.
   *
   * @param globalTxId global transaction id
   * @return participate events
   */
  @Override
  public List<ParticipatedEvent> getParticipateEventByGlobalTxId(String globalTxId) {
    return MemoryEventRegistry.getParticipateEventByGlobalTxId(globalTxId);
  }

  @Override
  public void migrationGlobalTxEvent(String globalTxId, String localTxId) {
    MemoryEventRegistry.migrationGlobalTxEvent(globalTxId, localTxId);
  }
}
