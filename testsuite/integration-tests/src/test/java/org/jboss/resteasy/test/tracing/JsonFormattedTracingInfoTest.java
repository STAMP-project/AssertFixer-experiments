package org.jboss.resteasy.test.tracing;

import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.resteasy.tracing.api.RESTEasyTracing;
import org.jboss.resteasy.tracing.api.RESTEasyTracingMessage;
import org.jboss.resteasy.util.HttpResponseCodes;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.junit.Assert;
import org.junit.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class JsonFormattedTracingInfoTest extends BasicTracingTest {

    @Test
    @OperateOnDeployment(WAR_BASIC_TRACING_FILE)
    public void testJsonTracing() throws Exception {
        war.as(ZipExporter.class).exportTo(new File("/tmp/" + war.getName()), true);
//        Thread.currentThread().join();

        String url = generateURL("/logger", WAR_BASIC_TRACING_FILE);
        WebTarget base = client.target(url);
        try {
            Response response = base.request().header(RESTEasyTracing.HEADER_ACCEPT_FORMAT, "JSON").get();
            System.out.println(response);

            Assert.assertEquals(HttpResponseCodes.SC_OK, response.getStatus());
            boolean hasTracing = false;
            for (Map.Entry entry : response.getStringHeaders().entrySet()) {
//                System.out.println("<K, V> ->" + entry);
                if (entry.getKey().toString().startsWith(RESTEasyTracing.HEADER_TRACING_PREFIX)) {
                    hasTracing = true;
                    String jsonText = entry.getValue().toString();
                    Jsonb jsonb = JsonbBuilder.create();
                    List<RESTEasyTracingMessage> messageList = jsonb.fromJson(jsonText, List.class);
                    assertNotNull(messageList);
                    assertNotNull(messageList.get(0));
                    List<Map> list = (List<Map>) messageList.get(0);
                    String[] keys = {"duration", "text", "event", "timestamp"};
                    for (Map map : list) {
                        assertNotNull(map);
                        for (String key : keys) {
                            assertNotNull(map.get(key));
                        }
                    }

                    break;
                }
            }
            assertTrue(hasTracing);
            response.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
