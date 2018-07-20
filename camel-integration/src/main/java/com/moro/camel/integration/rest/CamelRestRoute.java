package com.moro.camel.integration.rest;

import com.moro.camel.integration.mbeans.Direction;
import com.moro.camel.integration.mbeans.DirectionMBean;
import com.moro.camel.integration.processor.SoapExecutorProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;

import javax.management.*;
import java.lang.management.ManagementFactory;


public class CamelRestRoute extends RouteBuilder {

    private MBeanServer server;
    private final Direction direction;
    private final SoapExecutorProcessor soapExecutor;

    private static final String DIRECTION_PROPERTY = "direction";
    private static final String GET_DIRECTION_METHOD = "getDirection";

    @Autowired
    public CamelRestRoute(final SoapExecutorProcessor soapExecutor, final Direction direction)
            throws MalformedObjectNameException,
            NotCompliantMBeanException,
            InstanceAlreadyExistsException,
            MBeanException {

        this.direction = direction;
        server = ManagementFactory.getPlatformMBeanServer();
        server.registerMBean(direction,
                new ObjectName("com.moro", "name", "directionBean"));

        this.soapExecutor = soapExecutor;

    }


    @Override
    public void configure() throws Exception {
            from("jetty:{{camel.address}}?matchOnUriPrefix=true&bridgeEndpoint=true")
                    .setProperty(DIRECTION_PROPERTY, method(direction, GET_DIRECTION_METHOD))
                    .choice()
                        .when(exchangeProperty(DIRECTION_PROPERTY).isEqualToIgnoreCase(direction.getRestDirection()))
                            .log("REDIRECT TO THE REST")
                            .to("{{rest.address}}?bridgeEndpoint=true&throwExceptionOnFailure=false")

                        .when(exchangeProperty("direction").isEqualToIgnoreCase(direction.getSoapDirection()))
                            .log("REDIRECT TO THE SOAP")
                            .process(soapExecutor)
                            .marshal().json(JsonLibrary.Jackson)
                            .log(String.valueOf(body()))

                        .otherwise()
                            .throwException(RuntimeException.class, "No such direction. Available: rest, soap.")
                    .end();
    }

}
