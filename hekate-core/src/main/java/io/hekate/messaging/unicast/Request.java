package io.hekate.messaging.unicast;

import io.hekate.messaging.MessagingChannel;
import io.hekate.messaging.loadbalance.LoadBalancer;

/**
 * Request operation.
 *
 * <p>
 * This interface represents a bidirectional request operation. Typical use of this interface is:
 * </p>
 * <ol>
 * <li>Obtain an instance of this interface via the {@link MessagingChannel#newRequest(Object)} method call</li>
 * <li>Set options (f.e. {@link #withAffinity(Object) affinity key})</li>
 * <li>Execute this operation via the {@link #execute()} method</li>
 * <li>Process the response (synchronously or asynchronously)</li>
 * </ol>
 * <h3>Example:</h3>
 * ${source: messaging/MessagingServiceJavadocTest.java#request_operation}
 *
 * @param <T> Message type.
 */
public interface Request<T> {
    /**
     * Affinity key.
     *
     * <p>
     * Specifying an affinity key ensures that all operation with the same key will always be transmitted over the same network
     * connection and will always be processed by the same thread.
     * </p>
     *
     * <p>
     * {@link LoadBalancer} can also make use of the affinity key in order to perform consistent routing of messages among the cluster
     * node. For example, the default load balancer makes sure that all messages, having the same key, are always routed to the same node
     * (unless the cluster topology doesn't change).
     * </p>
     *
     * @param affinity Affinity key.
     *
     * @return This instance.
     */
    Request<T> withAffinity(Object affinity);

    /**
     * Response condition.
     *
     * <p>
     * Operation will not be completed unless its results matches with the specified {@link RequestCondition}.
     * </p>
     *
     * @param condition Condition.
     *
     * @return This instance.
     */
    Request<T> until(RequestCondition<T> condition);

    /**
     * Asynchronously executes this operation.
     *
     * @return Future result of this operation.
     */
    ResponseFuture<T> execute();

    /**
     * Asynchronously executes this operation and notifies the specified callback upon completion.
     *
     * @param callback Callback.
     *
     * @return Future result of this operation.
     */
    default ResponseFuture<T> execute(ResponseCallback<T> callback) {
        ResponseFuture<T> future = execute();

        future.whenComplete((rsp, err) ->
            callback.onComplete(err, rsp)
        );

        return future;
    }
}
