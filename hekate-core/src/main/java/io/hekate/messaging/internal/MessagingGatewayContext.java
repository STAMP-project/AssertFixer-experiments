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

package io.hekate.messaging.internal;

import io.hekate.cluster.ClusterNode;
import io.hekate.cluster.ClusterNodeId;
import io.hekate.cluster.ClusterTopology;
import io.hekate.cluster.ClusterView;
import io.hekate.codec.CodecException;
import io.hekate.core.HekateException;
import io.hekate.failover.FailoverPolicy;
import io.hekate.failover.FailoverRoutingPolicy;
import io.hekate.failover.FailureInfo;
import io.hekate.failover.FailureResolution;
import io.hekate.failover.internal.DefaultFailoverContext;
import io.hekate.messaging.MessageQueueOverflowException;
import io.hekate.messaging.MessageQueueTimeoutException;
import io.hekate.messaging.MessageReceiver;
import io.hekate.messaging.MessageTimeoutException;
import io.hekate.messaging.MessagingChannelClosedException;
import io.hekate.messaging.MessagingChannelId;
import io.hekate.messaging.MessagingException;
import io.hekate.messaging.loadbalance.EmptyTopologyException;
import io.hekate.messaging.loadbalance.UnknownRouteException;
import io.hekate.messaging.unicast.FailureResponse;
import io.hekate.messaging.unicast.RejectedReplyException;
import io.hekate.messaging.unicast.ReplyDecision;
import io.hekate.messaging.unicast.Response;
import io.hekate.network.NetworkConnector;
import io.hekate.network.NetworkFuture;
import io.hekate.partition.PartitionMapper;
import io.hekate.util.async.ExtendedScheduledExecutor;
import io.hekate.util.async.Waiting;
import io.hekate.util.format.ToString;
import io.hekate.util.format.ToStringIgnore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import org.slf4j.Logger;

import static io.hekate.failover.FailoverRoutingPolicy.RETRY_SAME_NODE;
import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;
import static java.util.Collections.unmodifiableSet;
import static java.util.stream.Collectors.toList;

class MessagingGatewayContext<T> {
    private interface FailoverCallback {
        void retry(FailoverRoutingPolicy routingPolicy, Optional<FailureInfo> newFailure);

        void fail(Throwable cause);
    }

    private static class ClientSelectionRejectedException extends Exception {
        private static final long serialVersionUID = 1;

        public ClientSelectionRejectedException(Throwable cause) {
            super(null, cause, false, false);
        }
    }

    private final String name;

    private final Class<T> baseType;

    @ToStringIgnore
    private final Logger log;

    @ToStringIgnore
    private final boolean debug;

    @ToStringIgnore
    private final MessagingChannelId id;

    @ToStringIgnore
    private final ClusterNode localNode;

    @ToStringIgnore
    private final NetworkConnector<MessagingProtocol> net;

    @ToStringIgnore
    private final ClusterView cluster;

    @ToStringIgnore
    private final MessageReceiver<T> receiver;

    @ToStringIgnore
    private final boolean checkIdle;

    @ToStringIgnore
    private final StampedLock lock = new StampedLock();

    @ToStringIgnore
    private final MessagingExecutor async;

    @ToStringIgnore
    private final MessagingMetrics metrics;

    @ToStringIgnore
    private final ReceivePressureGuard receivePressure;

    @ToStringIgnore
    private final SendPressureGuard sendPressure;

    @ToStringIgnore
    private final MessageInterceptors<T> interceptors;

    @ToStringIgnore
    private final DefaultMessagingChannel<T> channel;

    @ToStringIgnore
    private final Set<MessagingConnectionIn<T>> inbound = new HashSet<>();

    @ToStringIgnore
    private final Map<ClusterNodeId, MessagingClient<T>> clients = new HashMap<>();

    @ToStringIgnore
    private final ExtendedScheduledExecutor timer;

    @ToStringIgnore
    private ClusterTopology clientsTopology;

    @ToStringIgnore
    private volatile boolean closed;

    public MessagingGatewayContext(
        String name,
        Class<T> baseType,
        NetworkConnector<MessagingProtocol> net,
        ClusterNode localNode,
        MessageReceiver<T> receiver,
        MessagingExecutor async,
        ExtendedScheduledExecutor timer,
        MessagingMetrics metrics,
        ReceivePressureGuard receivePressure,
        SendPressureGuard sendPressure,
        MessageInterceptors<T> interceptors,
        Logger log,
        boolean checkIdle,
        DefaultMessagingChannel<T> channel
    ) {
        assert name != null : "Name is null.";
        assert baseType != null : "Base type is null.";
        assert net != null : "Network connector is null.";
        assert localNode != null : "Local cluster node is null.";
        assert async != null : "Executor is null.";
        assert metrics != null : "Metrics are null.";
        assert channel != null : "Default channel is null.";

        this.id = new MessagingChannelId();
        this.name = name;
        this.baseType = baseType;
        this.net = net;
        this.localNode = localNode;
        this.cluster = channel.cluster();
        this.receiver = receiver;
        this.interceptors = interceptors;
        this.async = async;
        this.timer = timer;
        this.metrics = metrics;
        this.receivePressure = receivePressure;
        this.sendPressure = sendPressure;
        this.checkIdle = checkIdle;
        this.log = log;
        this.debug = log.isDebugEnabled();
        this.channel = channel;
    }

    public MessagingChannelId channelId() {
        return id;
    }

    public String name() {
        return name;
    }

    public ClusterNode localNode() {
        return localNode;
    }

    public MessageInterceptors<T> interceptors() {
        return interceptors;
    }

    public Logger log() {
        return log;
    }

    public MessageReceiver<T> receiver() {
        return receiver;
    }

    public Executor executor() {
        return async.pooledWorker();
    }

    public ClusterView cluster() {
        return cluster;
    }

    public void submit(MessageOperation<T> op) {
        checkMessageType(op.message());

        try {
            long remainingTimeout = applyBackPressure(op);

            if (op.opts().hasTimeout()) {
                scheduleTimeout(op, remainingTimeout);
            }

            routeAndSubmit(op, Optional.empty());
        } catch (RejectedExecutionException e) {
            notifyOnErrorAsync(op, channelClosedError(null));
        } catch (InterruptedException | MessageQueueOverflowException | MessageQueueTimeoutException e) {
            notifyOnErrorAsync(op, e);
        }
    }

    public boolean isClosed() {
        return closed;
    }

    public Waiting close() {
        List<Waiting> waiting;

        long writeLock = lock.writeLock();

        try {
            if (closed) {
                return Waiting.NO_WAIT;
            } else {
                if (debug) {
                    log.debug("Closing channel [name={}]", name);
                }

                // Mark as closed.
                closed = true;
                clientsTopology = null;

                // Terminate back pressure guard.
                if (sendPressure != null) {
                    sendPressure.terminate();
                }

                // Close all clients.
                List<NetworkFuture<MessagingProtocol>> disconnects = new ArrayList<>();

                for (MessagingClient<T> client : clients.values()) {
                    disconnects.addAll(client.close());
                }

                // Clear clients.
                clients.clear();

                // Close all inbound connections.
                List<MessagingConnectionIn<T>> localInbound;

                synchronized (inbound) {
                    // Create a local copy of inbound connections since they are removing themselves from the list during disconnect.
                    localInbound = new ArrayList<>(inbound);

                    inbound.clear();
                }

                localInbound.stream()
                    .map(MessagingConnectionIn::disconnect)
                    .filter(Objects::nonNull)
                    .forEach(disconnects::add);

                waiting = new ArrayList<>();

                // Collect disconnect futures to waiting list.
                disconnects.stream()
                    .map(future -> (Waiting)future::join)
                    .forEach(waiting::add);

                // Terminate async thread pool.
                waiting.add(async::terminate);
            }
        } finally {
            lock.unlockWrite(writeLock);
        }

        return Waiting.awaitAll(waiting);
    }

    private void routeAndSubmit(MessageOperation<T> op, Optional<FailureInfo> prevFailure) {
        MessageOperationAttempt<T> attempt = null;

        try {
            attempt = route(op, prevFailure);
        } catch (ClientSelectionRejectedException e) {
            notifyOnErrorAsync(op, e.getCause());
        } catch (HekateException e) {
            notifyOnErrorAsync(op, e);
        } catch (RuntimeException | Error e) {
            if (log.isErrorEnabled()) {
                log.error("Got an unexpected runtime error during message routing.", e);
            }

            notifyOnErrorAsync(op, e);
        }

        if (attempt != null) {
            attempt.submit();
        }
    }

    private MessageOperationAttempt<T> route(MessageOperation<T> op, Optional<FailureInfo> prevFailure) throws HekateException,
        ClientSelectionRejectedException {
        // Perform routing in a loop to circumvent concurrent cluster topology changes.
        while (true) {
            PartitionMapper mapperSnapshot = op.opts().partitions().snapshot();

            ClusterTopology topology = mapperSnapshot.topology();

            // Fail if topology is empty.
            if (topology.isEmpty()) {
                if (prevFailure.isPresent()) {
                    throw new ClientSelectionRejectedException(prevFailure.get().error());
                } else {
                    throw new EmptyTopologyException("No suitable receivers [channel=" + name + ']');
                }
            }

            ClusterNodeId routed = op.route(mapperSnapshot, prevFailure);

            // Check if routing was successful.
            if (routed == null) {
                if (prevFailure.isPresent()) {
                    throw new ClientSelectionRejectedException(prevFailure.get().error());
                } else {
                    throw new UnknownRouteException("Load balancer failed to select a target node.");
                }
            }

            // Enter lock (prevents channel state changes).
            long readLock = lock.readLock();

            try {
                // Make sure that channel is not closed.
                if (closed) {
                    throw channelClosedError(null);
                }

                MessagingClient<T> client = clients.get(routed);

                if (client == null) {
                    // Post-check that topology was not changed during routing.
                    // -------------------------------------------------------------
                    // We are comparing the following topologies:
                    //  - Latest topology that is known to the cluster
                    //  - Topology that was used for routing (since it could expire while routing was in progress)
                    //  - Topology of client connections (since it is updated asynchronously and can lag behind the latest cluster topology)
                    // In case of any mismatch between those topologies we need to perform another routing attempt.
                    ClusterTopology latestTopology = op.opts().partitions().topology();

                    if (latestTopology.version() == topology.version()
                        && clientsTopology != null // <-- Can be null if service was still initializing when this method got called.
                        && clientsTopology.version() >= topology.version()) {
                        // Report failure since topologies are consistent but the selected node is not within the cluster.
                        if (prevFailure.isPresent()) {
                            throw new ClientSelectionRejectedException(prevFailure.get().error());
                        } else {
                            throw new UnknownRouteException("Node is not within the channel topology [id=" + routed + ']');
                        }
                    }

                    // Retry routing (note we are not exiting the loop)...
                } else {
                    // Successful routing.
                    return createAttempt(op, prevFailure, topology, client);
                }
            } finally {
                lock.unlockRead(readLock);
            }

            // Since we are here it means that topology was changed during routing.
            if (debug) {
                log.debug("Retrying routing since topology was changed [balancer={}]", op.opts().balancer());
            }

            checkTopologyChanges();
        }
    }

    private MessageOperationAttempt<T> createAttempt(
        MessageOperation<T> op,
        Optional<FailureInfo> prevFailure,
        ClusterTopology topology,
        MessagingClient<T> client
    ) {
        MessageOperationCallback<T> callback = (attempt, reply, err) -> {
            // Signal that network connection is not idle.
            attempt.client().touch();

            MessageOperation<T> operation = attempt.operation();

            // Do not process completed operations.
            if (operation.isDone()) {
                return true;
            }

            // Check if reply is an application-level error message.
            if (err == null) {
                err = tryConvertToError(reply, attempt.receiver());
            }

            // Resolve effective reply.
            Response<T> effectiveReply = err == null ? reply : null;

            // Check if this is an acceptable response.
            ReplyDecision decision = operation.accept(err, effectiveReply);

            if (decision == null) {
                decision = ReplyDecision.DEFAULT;
            }

            boolean completed = true;

            if ((decision == ReplyDecision.DEFAULT && err == null) // No error.
                || (decision == ReplyDecision.COMPLETE) // Decided to force complete.
                || (operation.opts().failover() == null) // Error but no failover policy.
            ) {
                /////////////////////////////////////////////////////////////
                // Complete the operation.
                /////////////////////////////////////////////////////////////
                // Note that it is up to the operation to decide on whether it is really completed or not.
                completed = operation.complete(err, effectiveReply);
            } else if (!operation.isDone()) {
                /////////////////////////////////////////////////////////////
                // Apply failover.
                /////////////////////////////////////////////////////////////
                if (decision == ReplyDecision.REJECT) {
                    Object rejected = effectiveReply != null ? effectiveReply.get() : null;

                    err = new RejectedReplyException("Response was rejected by the request callback", rejected, err);
                }

                // Failover callback.
                FailoverCallback onFailover = new FailoverCallback() {
                    @Override
                    public void retry(FailoverRoutingPolicy routing, Optional<FailureInfo> failure) {
                        switch (routing) {
                            case RETRY_SAME_NODE: {
                                attempt.nextAttempt(failure).submit();

                                break;
                            }
                            case PREFER_SAME_NODE: {
                                if (isKnownNode(attempt.receiver())) {
                                    attempt.nextAttempt(failure).submit();
                                } else {
                                    routeAndSubmit(operation, failure);
                                }

                                break;
                            }
                            case RE_ROUTE: {
                                routeAndSubmit(operation, failure);

                                break;
                            }
                            default: {
                                throw new IllegalArgumentException("Unexpected routing policy: " + routing);
                            }
                        }
                    }

                    @Override
                    public void fail(Throwable cause) {
                        notifyOnErrorAsync(operation, cause);
                    }
                };

                // Apply failover.
                applyFailoverAsync(attempt, err, onFailover);
            }

            return completed;
        };

        return new MessageOperationAttempt<>(client, topology, op, prevFailure, callback);
    }

    private void applyFailoverAsync(MessageOperationAttempt<T> attempt, Throwable cause, FailoverCallback callback) {
        attempt.operation().worker().execute(() ->
            applyFailover(attempt, cause, callback)
        );
    }

    private void applyFailover(MessageOperationAttempt<T> attempt, Throwable cause, FailoverCallback callback) {
        // Do nothing if operation is already completed.
        if (attempt.operation().isDone()) {
            return;
        }

        boolean applied = false;

        Throwable finalCause = cause;

        FailoverPolicy policy = attempt.operation().opts().failover();

        if (policy != null && isRecoverable(cause)) {
            ClusterNode failedNode = attempt.receiver();

            DefaultFailoverContext failoverCtx = newFailoverContext(cause, failedNode, attempt.prevFailure());

            // Apply failover policy.
            try {
                FailureResolution resolution = policy.apply(failoverCtx);

                // Enter lock (prevents channel state changes).
                long readLock = lock.readLock();

                try {
                    if (closed) {
                        finalCause = channelClosedError(cause);
                    } else if (resolution != null && resolution.isRetry()) {
                        FailoverRoutingPolicy routing = resolution.routing();

                        // Apply failover only if re-routing was requested or if the target node is still within the cluster topology.
                        if (routing != RETRY_SAME_NODE || clients.containsKey(failedNode.id())) {
                            metrics.onRetry();

                            // Schedule timeout task to apply failover actions after the failover delay.
                            long delay = resolution.delay();

                            timer.schedule(() -> {
                                // Execute callback on the worker thread.
                                attempt.operation().worker().execute(() -> {
                                    try {
                                        callback.retry(routing, Optional.of(failoverCtx.withRouting(routing)));
                                    } catch (RuntimeException | Error e) {
                                        log.error("Got an unexpected error during failover task processing.", e);
                                    }
                                });
                            }, delay, TimeUnit.MILLISECONDS);

                            applied = true;
                        }
                    }
                } finally {
                    lock.unlockRead(readLock);
                }
            } catch (RuntimeException | Error e) {
                log.error("Got an unexpected error while applying failover policy.", e);
            }
        }

        if (!applied) {
            callback.fail(finalCause);
        }
    }

    private long applyBackPressure(MessageOperation<T> op) throws MessageQueueOverflowException, InterruptedException,
        MessageQueueTimeoutException {

        if (sendPressure != null) {
            long remainingTime = sendPressure.onEnqueue(op.opts().timeout(), op.message());

            op.future().whenComplete((rslt, err) ->
                sendPressure.onDequeue()
            );

            return remainingTime;
        }

        return op.opts().timeout();
    }

    private void scheduleTimeout(MessageOperation<T> op, long initTimeout) {
        assert initTimeout > 0 : "Timeout must be greater than zero [timeout=" + initTimeout + ']';

        Future<?> timeoutFuture = timer.repeatWithFixedDelay(() -> {
            if (op.isDone()) {
                // Do not execute anymore (operation already completed).
                return false;
            }

            if (op.shouldExpireOnTimeout()) {
                // Process expiration on the worker thread.
                op.worker().execute(() -> {
                    String errMsg = "Messaging operation timed out [timeout=" + op.opts().timeout() + ", message=" + op.message() + ']';

                    doNotifyOnError(op, new MessageTimeoutException(errMsg));
                });

                // Do not execute anymore (operation timed out).
                return false;
            }

            // Re-run this check later (for subscriptions).
            return true;
        }, initTimeout, op.opts().timeout(), TimeUnit.MILLISECONDS);

        op.future().whenComplete((rslt, err) ->
            timeoutFuture.cancel(false)
        );
    }

    DefaultMessagingChannel<T> channel() {
        return channel;
    }

    MessagingExecutor async() {
        return async;
    }

    MessagingMetrics metrics() {
        return metrics;
    }

    ReceivePressureGuard receiveGuard() {
        return receivePressure;
    }

    SendPressureGuard sendGuard() {
        return sendPressure;
    }

    boolean register(MessagingConnectionIn<T> conn) {
        long readLock = lock.readLock();

        try {
            if (closed) {
                return false;
            }

            synchronized (inbound) {
                inbound.add(conn);
            }

            return true;
        } finally {
            lock.unlockRead(readLock);
        }
    }

    void unregister(MessagingConnectionIn<T> conn) {
        long readLock = lock.readLock();

        try {
            synchronized (inbound) {
                inbound.remove(conn);
            }
        } finally {
            lock.unlockRead(readLock);
        }
    }

    void checkIdleConnections() {
        long readLock = lock.readLock();

        try {
            if (!closed) {
                clients.values().forEach(MessagingClient::disconnectIfIdle);
            }
        } finally {
            lock.unlockRead(readLock);
        }
    }

    void checkTopologyChanges() {
        List<MessagingClient<T>> clientsToClose = null;

        long writeLock = lock.writeLock();

        try {
            if (!closed) {
                ClusterTopology newTopology = cluster.topology();

                if (clientsTopology == null || clientsTopology.version() < newTopology.version()) {
                    if (debug) {
                        log.debug("Updating topology [channel={}, topology={}]", name, newTopology);
                    }

                    Set<ClusterNode> newNodes = newTopology.nodeSet();

                    Set<ClusterNode> added = null;
                    Set<ClusterNode> removed = null;

                    if (clientsTopology == null) {
                        added = new HashSet<>(newNodes);
                    } else {
                        for (ClusterNode node : newNodes) {
                            if (!clientsTopology.contains(node)) {
                                if (added == null) {
                                    added = new HashSet<>(newNodes.size(), 1.0f);
                                }

                                added.add(node);
                            }
                        }

                        for (ClusterNode node : clientsTopology) {
                            if (!newNodes.contains(node)) {
                                if (removed == null) {
                                    removed = new HashSet<>(newNodes.size(), 1.0f);
                                }

                                removed.add(node);
                            }
                        }
                    }

                    if (removed == null) {
                        removed = emptySet();
                    }

                    if (added == null) {
                        added = emptySet();
                    }

                    if (!removed.isEmpty()) {
                        clientsToClose = removed.stream()
                            .map(node -> clients.remove(node.id()))
                            .filter(Objects::nonNull)
                            .collect(toList());
                    }

                    if (!added.isEmpty()) {
                        added.forEach(node -> {
                            MessagingClient<T> client = createClient(node);

                            clients.put(node.id(), client);
                        });
                    }

                    this.clientsTopology = newTopology;
                }
            }
        } finally {
            lock.unlockWrite(writeLock);
        }

        if (clientsToClose != null) {
            clientsToClose.forEach(MessagingClient::close);
        }
    }

    // This method is for testing purposes only.
    MessagingClient<T> clientOf(ClusterNodeId nodeId) throws MessagingException {
        // Ensure that we are using the latest topology.
        checkTopologyChanges();

        long readLock = lock.readLock();

        try {
            return clients.get(nodeId);
        } finally {
            lock.unlockRead(readLock);
        }
    }

    private boolean isKnownNode(ClusterNode node) {
        long readLock = lock.readLock();

        try {
            return clients.containsKey(node.id());
        } finally {
            lock.unlockRead(readLock);
        }
    }

    private DefaultFailoverContext newFailoverContext(Throwable cause, ClusterNode failed, Optional<FailureInfo> prevFailure) {
        int attempt;
        FailoverRoutingPolicy prevRouting;
        Set<ClusterNode> failedNodes;

        if (prevFailure.isPresent()) {
            FailureInfo failure = prevFailure.get();

            attempt = failure.attempt() + 1;
            prevRouting = failure.routing();

            failedNodes = new HashSet<>(failure.allFailedNodes());

            failedNodes.add(failed);

            failedNodes = unmodifiableSet(failedNodes);
        } else {
            attempt = 0;
            prevRouting = RETRY_SAME_NODE;
            failedNodes = singleton(failed);
        }

        return new DefaultFailoverContext(attempt, cause, failed, failedNodes, prevRouting);
    }

    private boolean isRecoverable(Throwable cause) {
        return !(cause instanceof MessagingChannelClosedException)
            && !(cause instanceof CodecException);
    }

    private MessagingClient<T> createClient(ClusterNode node) {
        return new MessagingClient<>(node, net, this, checkIdle);
    }

    private void notifyOnErrorAsync(MessageOperation<T> op, Throwable err) {
        op.worker().execute(() ->
            doNotifyOnError(op, err)
        );
    }

    private void doNotifyOnError(MessageOperation<T> op, Throwable err) {
        try {
            op.complete(err, null);
        } catch (RuntimeException | Error e) {
            log.error("Got an unexpected runtime error while notifying on another error [cause={}]", err, e);
        }
    }

    private Throwable tryConvertToError(Response<T> reply, ClusterNode fromNode) {
        Throwable err = null;

        if (reply != null) {
            T replyMsg = reply.get();

            // Check if message should be converted to an error.
            if (replyMsg instanceof FailureResponse) {
                err = ((FailureResponse)replyMsg).asError(fromNode);

                if (err == null) {
                    err = new IllegalArgumentException(FailureResponse.class.getSimpleName() + " message returned null error "
                        + "[message=" + replyMsg + ']');
                }
            }
        }

        return err;
    }

    private MessagingChannelClosedException channelClosedError(Throwable cause) {
        return new MessagingChannelClosedException("Channel closed [channel=" + name + ']', cause);
    }

    private void checkMessageType(T msg) {
        assert msg != null : "Message must be not null.";

        if (!baseType.isInstance(msg)) {
            throw new ClassCastException("Messaging channel doesn't support the specified type "
                + "[channel-type=" + baseType.getName() + ", message-type=" + msg.getClass().getName() + ']');
        }
    }

    @Override
    public String toString() {
        return ToString.format(this);
    }
}
