/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.artemis.tests.timing.core.server.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.activemq.artemis.api.core.Message;
import org.apache.activemq.artemis.api.core.SimpleString;
import org.apache.activemq.artemis.core.server.Consumer;
import org.apache.activemq.artemis.core.server.HandleStatus;
import org.apache.activemq.artemis.core.server.MessageReference;
import org.apache.activemq.artemis.core.server.impl.QueueImpl;
import org.apache.activemq.artemis.tests.unit.core.server.impl.fakes.FakeConsumer;
import org.apache.activemq.artemis.tests.util.ActiveMQTestBase;
import org.apache.activemq.artemis.utils.ActiveMQThreadFactory;
import org.apache.activemq.artemis.utils.actors.ArtemisExecutor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueImplTest extends ActiveMQTestBase {

   private static final SimpleString queue1 = new SimpleString("queue1");

   private static final long TIMEOUT = 10000;

   private ScheduledExecutorService scheduledExecutor;

   private ExecutorService executor;

   @Override
   @Before
   public void setUp() throws Exception {
      super.setUp();

      scheduledExecutor = new ScheduledThreadPoolExecutor(1);
      executor = Executors.newSingleThreadExecutor(ActiveMQThreadFactory.defaultThreadFactory());
   }

   @Override
   @After
   public void tearDown() throws Exception {
      scheduledExecutor.shutdownNow();
      executor.shutdown();

      super.tearDown();
   }

   // The tests ----------------------------------------------------------------

   @Test
   public void testScheduledNoConsumer() throws Exception {
      QueueImpl queue = new QueueImpl(1, new SimpleString("address1"), new SimpleString("queue1"), null, null, false, true, false, scheduledExecutor, null, null, null, ArtemisExecutor.delegate(executor), null, null);

      // Send one scheduled

      long now = System.currentTimeMillis();

      MessageReference ref1 = generateReference(queue, 1);
      ref1.setScheduledDeliveryTime(now + 700);
      queue.addTail(ref1);

      // Send some non scheduled messages

      MessageReference ref2 = generateReference(queue, 2);
      queue.addTail(ref2);
      MessageReference ref3 = generateReference(queue, 3);
      queue.addTail(ref3);
      MessageReference ref4 = generateReference(queue, 4);
      queue.addTail(ref4);

      // Now send some more scheduled messages

      MessageReference ref5 = generateReference(queue, 5);
      ref5.setScheduledDeliveryTime(now + 500);
      queue.addTail(ref5);

      MessageReference ref6 = generateReference(queue, 6);
      ref6.setScheduledDeliveryTime(now + 400);
      queue.addTail(ref6);

      MessageReference ref7 = generateReference(queue, 7);
      ref7.setScheduledDeliveryTime(now + 300);
      queue.addTail(ref7);

      MessageReference ref8 = generateReference(queue, 8);
      ref8.setScheduledDeliveryTime(now + 600);
      queue.addTail(ref8);

      List<MessageReference> refs = new ArrayList<>();

      // Scheduled refs are added back to *FRONT* of queue - otherwise if there were many messages in the queue
      // They may get stranded behind a big backlog

      refs.add(ref1);
      refs.add(ref8);
      refs.add(ref5);
      refs.add(ref6);
      refs.add(ref7);

      refs.add(ref2);
      refs.add(ref3);
      refs.add(ref4);

      Thread.sleep(750);

      FakeConsumer consumer = new FakeConsumer();

      queue.addConsumer(consumer);

      queue.deliverNow();

      assertRefListsIdenticalRefs(refs, consumer.getReferences());
   }

   @Test
   public void testScheduled() throws Exception {
      QueueImpl queue = new QueueImpl(1, new SimpleString("address1"), new SimpleString("queue1"), null, null, false, true, false, scheduledExecutor, null, null, null, ArtemisExecutor.delegate(executor), null, null);

      FakeConsumer consumer = null;

      // Send one scheduled

      long now = System.currentTimeMillis();

      MessageReference ref1 = generateReference(queue, 1);
      ref1.setScheduledDeliveryTime(now + 700);
      queue.addTail(ref1);

      // Send some non scheduled messages

      MessageReference ref2 = generateReference(queue, 2);
      queue.addTail(ref2);
      MessageReference ref3 = generateReference(queue, 3);
      queue.addTail(ref3);
      MessageReference ref4 = generateReference(queue, 4);
      queue.addTail(ref4);

      // Now send some more scheduled messages

      MessageReference ref5 = generateReference(queue, 5);
      ref5.setScheduledDeliveryTime(now + 500);
      queue.addTail(ref5);

      MessageReference ref6 = generateReference(queue, 6);
      ref6.setScheduledDeliveryTime(now + 400);
      queue.addTail(ref6);

      MessageReference ref7 = generateReference(queue, 7);
      ref7.setScheduledDeliveryTime(now + 300);
      queue.addTail(ref7);

      MessageReference ref8 = generateReference(queue, 8);
      ref8.setScheduledDeliveryTime(now + 600);
      queue.addTail(ref8);

      consumer = new FakeConsumer();

      queue.addConsumer(consumer);

      queue.deliverNow();

      List<MessageReference> refs = new ArrayList<>();

      refs.add(ref2);
      refs.add(ref3);
      refs.add(ref4);

      assertRefListsIdenticalRefs(refs, consumer.getReferences());

      refs.clear();
      consumer.getReferences().clear();

      MessageReference ref = consumer.waitForNextReference(QueueImplTest.TIMEOUT);
      Assert.assertEquals(ref7, ref);
      long now2 = System.currentTimeMillis();
      Assert.assertTrue(now2 - now >= 300);

      ref = consumer.waitForNextReference(QueueImplTest.TIMEOUT);
      Assert.assertEquals(ref6, ref);
      now2 = System.currentTimeMillis();
      Assert.assertTrue(now2 - now >= 400);

      ref = consumer.waitForNextReference(QueueImplTest.TIMEOUT);
      Assert.assertEquals(ref5, ref);
      now2 = System.currentTimeMillis();
      Assert.assertTrue(now2 - now >= 500);

      ref = consumer.waitForNextReference(QueueImplTest.TIMEOUT);
      Assert.assertEquals(ref8, ref);
      now2 = System.currentTimeMillis();
      Assert.assertTrue(now2 - now >= 600);

      ref = consumer.waitForNextReference(QueueImplTest.TIMEOUT);
      Assert.assertEquals(ref1, ref);
      now2 = System.currentTimeMillis();
      Assert.assertTrue(now2 - now >= 700);

      Assert.assertTrue(consumer.getReferences().isEmpty());
   }

   @Test
   public void testDeliveryScheduled() throws Exception {
      final CountDownLatch countDownLatch = new CountDownLatch(1);
      Consumer consumer = new FakeConsumer() {
         @Override
         public synchronized HandleStatus handle(final MessageReference reference) {
            countDownLatch.countDown();
            return HandleStatus.HANDLED;
         }

         @Override
         public void disconnect() {
         }
      };
      QueueImpl queue = new QueueImpl(1, new SimpleString("address1"), QueueImplTest.queue1, null, null, false, true, false, scheduledExecutor, null, null, null,
                                      ArtemisExecutor.delegate(executor), null, null);
      MessageReference messageReference = generateReference(queue, 1);
      queue.addConsumer(consumer);
      messageReference.setScheduledDeliveryTime(System.currentTimeMillis() + 200);
      queue.addHead(messageReference, false);

      boolean gotLatch = countDownLatch.await(3000, TimeUnit.MILLISECONDS);
      Assert.assertTrue(gotLatch);
   }

   @Test
   public void testGroupMessageWithManyConsumers() throws Exception {
      final CountDownLatch firstMessageHandled = new CountDownLatch(1);
      final CountDownLatch finished = new CountDownLatch(2);
      final Consumer groupConsumer = new FakeConsumer() {

         int count = 0;

         @Override
         public synchronized HandleStatus handle(MessageReference reference) {
            if (count == 0) {
               //the first message is handled and will be used to determine this consumer
               //to be the group consumer
               count++;
               firstMessageHandled.countDown();
               return HandleStatus.HANDLED;
            } else if (count <= 2) {
               //the next two attempts to send the second message will be done
               //attempting a direct delivery and an async one after that
               count++;
               finished.countDown();
               return HandleStatus.BUSY;
            } else {
               //this shouldn't happen, because the last attempt to deliver
               //the second message should have stop the delivery loop:
               //it will succeed just to let the message being handled and
               //reduce the message count to 0
               return HandleStatus.HANDLED;
            }
         }
      };
      final Consumer noConsumer = new FakeConsumer() {
         @Override
         public synchronized HandleStatus handle(MessageReference reference) {
            Assert.fail("this consumer isn't allowed to consume any message");
            throw new AssertionError();
         }
      };
      final QueueImpl queue = new QueueImpl(1, new SimpleString("address1"), QueueImplTest.queue1,
                                            null, null, false, true, false,
                                            scheduledExecutor, null, null, null,
                                            ArtemisExecutor.delegate(executor), null, null);
      queue.addConsumer(groupConsumer);
      queue.addConsumer(noConsumer);
      final MessageReference firstMessageReference = generateReference(queue, 1);
      final SimpleString groupName = SimpleString.toSimpleString("group");
      firstMessageReference.getMessage().putStringProperty(Message.HDR_GROUP_ID, groupName);
      final MessageReference secondMessageReference = generateReference(queue, 2);
      secondMessageReference.getMessage().putStringProperty(Message.HDR_GROUP_ID, groupName);
      queue.addTail(firstMessageReference, true);
      Assert.assertTrue("first message isn't handled", firstMessageHandled.await(3000, TimeUnit.MILLISECONDS));
      Assert.assertEquals("group consumer isn't correctly set", groupConsumer, queue.getGroups().get(groupName));
      queue.addTail(secondMessageReference, true);
      final boolean atLeastTwoDeliverAttempts = finished.await(3000, TimeUnit.MILLISECONDS);
      Assert.assertTrue(atLeastTwoDeliverAttempts);
      Thread.sleep(1000);
      Assert.assertEquals("The second message should be in the queue", 1, queue.getMessageCount());
   }

}
