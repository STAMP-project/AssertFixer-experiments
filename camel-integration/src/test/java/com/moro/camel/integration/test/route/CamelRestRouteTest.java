package com.moro.camel.integration.test.route;

import com.moro.camel.integration.mbeans.Direction;
import com.moro.model.Beer;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:camel-spring-test.xml"})
public class CamelRestRouteTest extends CamelTestSupport {

    @Value("${camel.route}")
    private String CAMEL_ENDPOINT;
    private static final String DIRECTION_PROPERTY = "direction";
    private static final String GET_DIRECTION_METHOD = "getDirection";

    @Autowired
    private Direction routeDirection;

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(CAMEL_ENDPOINT)
                        .setProperty(DIRECTION_PROPERTY, method(routeDirection, GET_DIRECTION_METHOD))
                        .choice()
                            .when(exchangeProperty(DIRECTION_PROPERTY).isEqualToIgnoreCase(routeDirection.getRestDirection()))
                                .log("REDIRECT TO THE REST")
                                .to("mock:rest")
                            .when(exchangeProperty("direction").isEqualToIgnoreCase(routeDirection.getSoapDirection()))
                                .log("REDIRECT TO THE SOAP")
//                                .process(soapExecutor)
//                                .marshal().json(JsonLibrary.Jackson)
                                .log(String.valueOf(body()))
                        .otherwise()
                            .throwException(RuntimeException.class, "No such direction. Available: rest, soap.")
                        .end();
            }
        };
    }

    @Test
    public void getBeersRest() throws Exception {
        MockEndpoint restMock = getMockEndpoint("mock:rest");

        restMock.expectedBodiesReceived("");
        restMock.expectedMessageCount(1);
        restMock.expectedHeaderReceived(Exchange.HTTP_METHOD, HttpMethod.GET);
        restMock.expectedHeaderReceived(Exchange.HTTP_PATH, "beerfactory/beers");

        Map<String, Object> headers = new HashMap<>();
        headers.put(Exchange.HTTP_METHOD, HttpMethod.GET);
        headers.put(Exchange.HTTP_PATH, "/beerfactory/beers");

        template.requestBodyAndHeaders(CAMEL_ENDPOINT,
                null, headers);

        assertMockEndpointsSatisfied();
    }

//    @Test
//    public void postBeerRest() throws InterruptedException {
//        MockEndpoint restMock = getMockEndpoint("mock:rest");
//
//        restMock.expectedHeaderReceived(Exchange.HTTP_METHOD, HttpMethod.POST);
//        restMock.expectedHeaderReceived(Exchange.HTTP_PATH, "beerfactory/beers");
//
//        Map<String, Object> headers = new HashMap<>();
//        headers.put(Exchange.HTTP_METHOD, HttpMethod.POST);
//        headers.put(Exchange.HTTP_PATH, "/beerfactory/beers");
//
//
//        Beer beer = new Beer("test", 5.0, "beer", 15, "image");
//        beer.setBeerId(1);
//
//        template.requestBodyAndHeaders(CAMEL_ENDPOINT,
//                beer, headers);
//
//        assertMockEndpointsSatisfied();
//    }
}
