package org.eclipse.hono.service.command;

import java.util.Map;
import java.util.Objects;

import org.apache.qpid.proton.amqp.Binary;
import org.apache.qpid.proton.amqp.messaging.ApplicationProperties;
import org.apache.qpid.proton.amqp.messaging.Data;
import org.apache.qpid.proton.message.Message;
import org.eclipse.hono.client.MessageSender;
import org.eclipse.hono.client.impl.AbstractSender;
import org.eclipse.hono.config.ClientConfigProperties;
import org.eclipse.hono.util.CommandConstants;
import org.eclipse.hono.util.MessageHelper;

import io.vertx.core.AsyncResult;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.proton.ProtonConnection;
import io.vertx.proton.ProtonDelivery;
import io.vertx.proton.ProtonHelper;
import io.vertx.proton.ProtonQoS;
import io.vertx.proton.ProtonSender;

/**
 * The response sender for a received command.
 */
public class CommandResponseSenderImpl extends AbstractSender implements CommandResponseSender {

    CommandResponseSenderImpl(final ClientConfigProperties config, final ProtonSender sender, final String tenantId,
            final String targetAddress, final Context context) {
        super(config, sender, tenantId, targetAddress, context);
    }

    @Override
    protected Future<ProtonDelivery> sendMessage(final Message message) {
        return sendMessageAndWaitForOutcome(message);
    }

    @Override
    protected String getTo(final String deviceId) {
        return null;
    }

    @Override
    public String getEndpoint() {
        return CommandConstants.COMMAND_ENDPOINT;
    }

    @Override
    public Future<ProtonDelivery> sendAndWaitForOutcome(final Message message) {
        return send(message);
    }

    static final String getTargetAddress(final String tenantId, final String deviceId, final String replyId) {
        return String.format("%s/%s/%s/%s", CommandConstants.COMMAND_ENDPOINT, tenantId, deviceId, replyId);
    }

    /**
     * {@inheritDoc}
     */
    public Future<ProtonDelivery> sendCommandResponse(
            final String correlationId,
            final Buffer payload,
            final Map<String, Object> properties,
            final int status) {
        LOG.debug("send back a command response [correlationId: {}, status: {}]", correlationId, status);
        return sendAndWaitForOutcome(createResponseMessage(targetAddress, correlationId, payload, properties, status));
    }

    private static Message createResponseMessage(
            final String targetAddress,
            final String correlationId,
            final Buffer payload,
            final Map<String, Object> properties,
            final int status) {

        Objects.requireNonNull(targetAddress);
        Objects.requireNonNull(correlationId);
        final Message msg = ProtonHelper.message();
        msg.setCorrelationId(correlationId);
        msg.setAddress(targetAddress);
        if (payload != null) {
            msg.setBody(new Data(new Binary(payload.getBytes())));
        }
        if (properties != null) {
            msg.setApplicationProperties(new ApplicationProperties(properties));
        }
        MessageHelper.setCreationTime(msg);
        MessageHelper.addProperty(msg, MessageHelper.APP_PROPERTY_STATUS, status);
        return msg;
    }

    /**
     * Creates a new sender to send responses for commands back to the business application.
     *
     * @param context The vertx context to run all interactions with the server on.
     * @param clientConfig The configuration properties to use.
     * @param con The connection to the AMQP network.
     * @param tenantId The tenant that the command response will be send for and the device belongs to.
     * @param deviceId The device that sends the command response.
     * @param replyId The reply id as the unique postfix of the replyTo address.
     * @param closeHook A handler to invoke if the peer closes the link unexpectedly.
     * @param creationHandler The handler to invoke with the result of the creation attempt.
     * @throws NullPointerException if any of context, clientConfig, con, tenantId, deviceId or replyId  is {@code null}.
     */
    public static void create(
            final Context context,
            final ClientConfigProperties clientConfig,
            final ProtonConnection con,
            final String tenantId,
            final String deviceId,
            final String replyId,
            final Handler<String> closeHook,
            final Handler<AsyncResult<MessageSender>> creationHandler) {

        Objects.requireNonNull(context);
        Objects.requireNonNull(clientConfig);
        Objects.requireNonNull(con);
        Objects.requireNonNull(tenantId);
        Objects.requireNonNull(deviceId);
        Objects.requireNonNull(replyId);

        final String targetAddress = CommandResponseSenderImpl.getTargetAddress(tenantId, deviceId, replyId);
        createSender(context, clientConfig, con, targetAddress, ProtonQoS.AT_LEAST_ONCE, closeHook).compose(sender -> {
            return Future.<MessageSender> succeededFuture(
                    new CommandResponseSenderImpl(clientConfig, sender, tenantId, targetAddress, context));
        }).setHandler(creationHandler);
    }
}
