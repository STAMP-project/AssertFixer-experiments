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
    public ResponseFuture<T> future() {
        return future;
    }

    @Override
    public ReplyDecision accept(Throwable error, Response<T> response) {
        if (condition == null) {
            return ReplyDecision.DEFAULT;
        }

        return condition.accept(error, response);
    }

    @Override
    protected void doReceiveFinal(Response<T> response) {
        future.complete(response);
    }

    @Override
    protected void doFail(Throwable error) {
        future.completeExceptionally(error);
    }
}
