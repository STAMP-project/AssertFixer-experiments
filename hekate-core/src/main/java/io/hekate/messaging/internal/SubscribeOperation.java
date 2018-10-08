package io.hekate.messaging.internal;

import io.hekate.messaging.intercept.OutboundType;
import io.hekate.messaging.unicast.ReplyDecision;
import io.hekate.messaging.unicast.RequestCondition;
import io.hekate.messaging.unicast.Response;
import io.hekate.messaging.unicast.ResponseCallback;
import io.hekate.messaging.unicast.SubscribeFuture;

class SubscribeOperation<T> extends UnicastOperation<T> {
    private final SubscribeFuture<T> future = new SubscribeFuture<>();

    private final ResponseCallback<T> callback;

    private final RequestCondition<T> condition;

    private volatile boolean active;

    public SubscribeOperation(
        T message,
        Object affinityKey,
        MessagingGatewayContext<T> gateway,
        MessageOperationOpts<T> opts,
        ResponseCallback<T> callback,
        RequestCondition<T> condition
    ) {
        super(message, affinityKey, gateway, opts, true);

        this.callback = callback;
        this.condition = condition;
    }

    @Override
    public OutboundType type() {
        return OutboundType.SUBSCRIBE;
    }

    @Override
    public boolean shouldExpireOnTimeout() {
        if (active) {
            // Reset flag so that we could detect inactivity upon the next invocation of this method.
            active = false;

            return false;
        } else {
            // There was no activity between this invocation and the previous invocation of this method.
            return true;
        }
    }

    @Override
    public ReplyDecision accept(Throwable error, Response<T> response) {
        if (condition == null) {
            return ReplyDecision.DEFAULT;
        }

        return condition.accept(error, response);
    }

    @Override
    public boolean complete(Throwable error, Response<T> response) {
        // Keep alive (for timeouts handling).
        if (!active) {
            active = true;
        }

        boolean completed = false;

        try {
            callback.onComplete(error, response);
        } finally {
            if (error == null) {
                if (!response.isPartial()) {
                    // Complete only if this is a final response.
                    completed = future.complete(response);
                }
            } else {
                completed = future.completeExceptionally(error);
            }
        }

        return completed;
    }

    @Override
    public SubscribeFuture<T> future() {
        return future;
    }
}
