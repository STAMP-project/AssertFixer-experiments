/*
 * Copyright 2018 The Hekate Project
 *
 * The Hekate Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.hekate.javadoc.messaging;

import io.hekate.HekateNodeTestBase;
import io.hekate.core.Hekate;
import io.hekate.core.HekateBootstrap;
import io.hekate.messaging.Message;
import io.hekate.messaging.MessageReceiver;
import io.hekate.messaging.MessagingChannel;
import io.hekate.messaging.MessagingChannelConfig;
import io.hekate.messaging.MessagingFutureException;
import io.hekate.messaging.MessagingServiceFactory;
import io.hekate.messaging.broadcast.AggregateFuture;
import io.hekate.messaging.broadcast.BroadcastFuture;
import io.hekate.messaging.unicast.RequestFuture;
import io.hekate.messaging.unicast.SendFuture;
import io.hekate.messaging.unicast.SubscribeFuture;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MessagingServiceJavadocTest extends HekateNodeTestBase {
    // Start:message_receiver
    public static class ExampleReceiver implements MessageReceiver<String> {
        @Override
        public void receive(Message<String> message) {
            // Get payload.
            String payload = message.get();

            // Check if sender is expecting a response.
            if (message.mustReply()) {
                System.out.println("Received request: " + payload);

                // Send back the response.
                message.reply("...some response...");
            } else {
                // No need to send a response since this is a unidirectional message.
                System.out.println("Received notification: " + payload);
            }
        }
    }
    // End:message_receiver

    @Test
    public void exampleMessageReceiver() throws Exception {
        Hekate hekate = new HekateBootstrap()
            .withService(new MessagingServiceFactory()
                .withChannel(MessagingChannelConfig.of(String.class)
                    .withName("example")
                    .withReceiver(new ExampleReceiver())))
            .join();

        hekate.messaging().channel("example", String.class).aggregate("example message").get();

        hekate.leave();
    }

    @Test
    public void exampleChannel() throws Exception {
        // Start:configure_channel
        // Configure channel that will support messages of String type (for simplicity).
        MessagingChannelConfig<String> channelCfg = MessagingChannelConfig.of(String.class)
            .withName("example.channel") // Channel name.
            // Message receiver (optional - if not specified then channel will act as a sender only)
            .withReceiver(msg -> {
                System.out.println("Received request: " + msg.get());

                // Send reply (if required).
                if (msg.mustReply()) {
                    msg.reply("some response");
                }
            });

        // Prepare messaging service factory and register channel.
        MessagingServiceFactory factory = new MessagingServiceFactory()
            .withChannel(channelCfg);

        // Start node.
        Hekate hekate = new HekateBootstrap()
            .withService(factory)
            .join();
        // End:configure_channel

        // Start:access_channel
        MessagingChannel<String> channel = hekate.messaging().channel("example.channel", String.class);
        // End:access_channel

        assertNotNull(channel);

        exampleUnicast(hekate);

        broadcastExample(hekate);

        hekate.leave();
    }

    private void exampleUnicast(Hekate hekate) throws Exception {
        MessagingChannel<String> channel = hekate.messaging().channel("example.channel", String.class);

        unicastRequestSyncExample(channel);

        unicastRequestAsyncExample(channel);

        unicastSendSyncExample(channel);

        unicastSendAsyncExample(channel);

        sendOperationExample(hekate);

        requestOperationExample(hekate);

        broadcastOperationExample(hekate);

        aggregateOperationExample(hekate);

        subscribeOperationExample(hekate);
    }

    private void sendOperationExample(Hekate hekate) throws Exception {
        // Start:send_operation
        MessagingChannel<String> channel = hekate.messaging().channel("example.channel", String.class);

        SendFuture future = channel.newSend("some-message") // Some dummy message.
            .withConfirmReceive(true) // Set confirmation mode.
            .submit(); // Asynchronously execute the operation.

        future.join(); // Await for confirmation.
        // End:send_operation
    }

    private void requestOperationExample(Hekate hekate) throws Exception {
        // Start:request_operation
        MessagingChannel<String> channel = hekate.messaging().channel("example.channel", String.class);

        RequestFuture<String> future = channel.newRequest("some-message") // Some dummy message.
            .withAffinity("100500") // Some dummy affinity (optional).
            .submit(); // Asynchronously execute the operation.

        // Await and print the response.
        System.out.println("Response: " + future.result());
        // End:request_operation
    }

    private void subscribeOperationExample(Hekate hekate) throws Exception {
        // Start:subscribe_operation
        MessagingChannel<String> channel = hekate.messaging().channel("example.channel", String.class);

        SubscribeFuture<String> future = channel.newSubscribe("some-message") // Some dummy message.
            .withAffinity("100500") // Some dummy affinity (optional).
            // Execute and listen for responses.
            .submit((err, rsp) -> {
                if (rsp.isPartial()) {
                    System.out.println("Got a response chunk: " + rsp.get());
                } else {
                    System.out.println("Got the last response chunk: " + rsp.get());
                }
            });

        // Await and print the last response.
        System.out.println("Last response: " + future.get());
        // End:subscribe_operation
    }

    private void broadcastOperationExample(Hekate hekate) throws Exception {
        // Start:broadcast_operation
        MessagingChannel<String> channel = hekate.messaging().channel("example.channel", String.class);

        BroadcastFuture<String> future = channel.newBroadcast("some-message") // Some dummy message.
            .withConfirmReceive(true) // Set confirmation mode.
            .submit(); // Asynchronously execute the operation.

        future.join(); // Await for confirmations.
        // End:broadcast_operation
    }

    private void aggregateOperationExample(Hekate hekate) throws Exception {
        // Start:aggregate_operation
        MessagingChannel<String> channel = hekate.messaging().channel("example.channel", String.class);

        AggregateFuture<String> future = channel.newAggregate("some-message") // Some dummy message.
            .withAffinity("100500") // Some dummy affinity (optional).
            .submit(); // Asynchronously execute the operation.

        // Await and print results.
        System.out.println("Results: " + future.results());
        // End:aggregate_operation
    }

    private void unicastSendAsyncExample(MessagingChannel<String> channel) {
        // Start:unicast_send_async
        // Send message to the oldest node
        // and process operation result in the asynchronous callback.
        channel.forOldest().newSend("example message").submit(err -> {
            if (err == null) {
                System.out.println("Message sent.");
            } else {
                System.out.println("Sending failed: " + err);
            }
        });
        // End:unicast_send_async
    }

    private void unicastSendSyncExample(MessagingChannel<String> channel) throws InterruptedException, MessagingFutureException {
        // Start:unicast_send_sync
        // Send message to the oldest node
        // and synchronously await for operation result (success/failure).
        channel.forOldest().newSend("example message").submit().get();
        // End:unicast_send_sync
    }

    private void unicastRequestAsyncExample(MessagingChannel<String> channel) {
        // Start:unicast_request_async
        // Submit request to the oldest node
        // and process reply in the asynchronous callback.
        channel.forOldest().newRequest("example request").submit((err, reply) -> {
            if (err == null) {
                System.out.println("Got reply: " + reply.get());
            } else {
                System.out.println("Request failed: " + err);
            }
        });
        // End:unicast_request_async
    }

    private void unicastRequestSyncExample(MessagingChannel<String> channel)
        throws MessagingFutureException, InterruptedException {
        // Start:unicast_request_sync
        // Execute request to the oldest node and synchronously await for reply.
        String response = channel.forOldest().request("example request").result();
        // End:unicast_request_sync

        assertNotNull(response);
    }

    private void broadcastExample(Hekate hekate) throws Exception {
        MessagingChannel<String> channel = hekate.messaging().channel("example.channel", String.class);

        // Start:aggregate_sync
        // Submit aggregation request to all remote nodes.
        channel.forRemotes().aggregate("example message").forEach(rslt ->
            System.out.println("Got result: " + rslt)
        );
        // End:aggregate_sync

        // Start:aggregate_async
        // Asynchronously submit aggregation request to all remote nodes.
        channel.forRemotes().newAggregate("example message").submit((err, results) -> {
            if (err == null) {
                results.forEach(rslt ->
                    System.out.println("Got result: " + rslt)
                );
            } else {
                System.out.println("Aggregation failure: " + err);
            }
        });
        // End:aggregate_async

        // Start:broadcast_sync
        // Broadcast message to all remote nodes.
        channel.forRemotes().broadcast("example message").get();
        // End:broadcast_sync

        // Start:broadcast_async
        // Asynchronously broadcast message to all remote nodes.
        channel.forRemotes().newBroadcast("example message").submit((err, result) -> {
            if (err == null) {
                System.out.println("Broadcast success.");
            } else {
                System.out.println("Broadcast failure: " + err);
            }
        });
        // End:broadcast_async
    }
}
