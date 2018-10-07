package io.hekate.messaging.internal;

import io.hekate.cluster.ClusterNodeId;
import io.hekate.failover.FailureInfo;
import io.hekate.messaging.intercept.OutboundType;
import io.hekate.messaging.loadbalance.LoadBalancerException;
import io.hekate.messaging.unicast.ReplyDecision;
import io.hekate.messaging.unicast.Response;
import io.hekate.partition.PartitionMapper;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

abstract class MessageOperation<T> {
    private final T message;

    private final MessageOperationOpts<T> opts;

    private final Object affinityKey;

    private final int affinity;

    private final MessagingWorker worker;

    private final MessagingGatewayContext<T> gateway;

    public MessageOperation(
        T message,
        Object affinityKey,
        MessagingGatewayContext<T> gateway,
        MessageOperationOpts<T> opts,
        boolean threadAffinity
    ) {
        this.message = message;
        this.gateway = gateway;
        this.opts = opts;
        this.affinityKey = affinityKey;

        if (affinityKey == null) {
            // Use artificial affinity.
            affinity = ThreadLocalRandom.current().nextInt();

            if (threadAffinity) {
                worker = gateway.async().workerFor(affinity);
            } else {
                worker = gateway.async().pooledWorker();
            }
        } else {
            // Use key-based affinity.
            affinity = affinityKey.hashCode();

            worker = gateway.async().workerFor(affinity);
        }
    }

    public abstract ClusterNodeId route(PartitionMapper mapper, Optional<FailureInfo> prevFailure) throws LoadBalancerException;

    public abstract OutboundType type();

    public abstract ReplyDecision accept(Throwable error, Response<T> response);

    public abstract boolean complete(Throwable error, Response<T> response);

    public abstract CompletableFuture<?> future();

    public boolean isDone() {
        return future().isDone();
    }

    public boolean shouldExpireOnTimeout() {
        return true;
    }

    public T message() {
        return message;
    }

    public MessagingGatewayContext<T> gateway() {
        return gateway;
    }

    public MessageOperationOpts<T> opts() {
        return opts;
    }

    public Object affinityKey() {
        return affinityKey;
    }

    public boolean hasAffinity() {
        return affinityKey != null;
    }

    public int affinity() {
        return affinity;
    }

    public MessagingWorker worker() {
        return worker;
    }
}
