package io.hekate.messaging.internal;

import io.hekate.messaging.intercept.OutboundType;
import io.hekate.messaging.unicast.ReplyDecision;
import io.hekate.messaging.unicast.RequestCondition;
import io.hekate.messaging.unicast.Response;
import io.hekate.messaging.unicast.ResponseFuture;

class RequestOperation<T> extends UnicastOperation<T> {
    private final ResponseFuture<T> future = new ResponseFuture<>();

    private final RequestCondition<T> condition;

    public RequestOperation(
        T message,
        Object affinityKey,
        MessagingGatewayContext<T> gateway,
        MessageOperationOpts<T> opts,
        RequestCondition<T> condition
    ) {
        super(message, affinityKey, gateway, opts, false);

        this.condition = condition;
    }

    @Override
    public OutboundType type() {
        return OutboundType.REQUEST;
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
        if (error == null) {
            return future.complete(response);
        } else {
            return future.completeExceptionally(error);
        }
    }

    @Override
    public ResponseFuture<T> future() {
        return future;
    }
}
