package io.hekate.messaging.internal;

import io.hekate.messaging.intercept.OutboundType;
import io.hekate.messaging.unicast.ReplyDecision;
import io.hekate.messaging.unicast.Response;
import io.hekate.messaging.unicast.SendFuture;

class SendOperation<T> extends UnicastOperation<T> {
    private final SendFuture future = new SendFuture();

    private final boolean confirm;

    public SendOperation(T message, Object affinityKey, MessagingGatewayContext<T> gateway, MessageOperationOpts<T> opts, boolean confirm) {
        super(message, affinityKey, gateway, opts, false);

        this.confirm = confirm;
    }

    @Override
    public OutboundType type() {
        return confirm ? OutboundType.SEND_WITH_ACK : OutboundType.SEND_NO_ACK;
    }

    @Override
    public ReplyDecision accept(Throwable error, Response<T> response) {
        return ReplyDecision.DEFAULT;
    }

    @Override
    public boolean complete(Throwable error, Response<T> response) {
        if (error == null) {
            return future.complete(null);
        } else {
            return future.completeExceptionally(error);
        }
    }

    @Override
    public SendFuture future() {
        return future;
    }
}
