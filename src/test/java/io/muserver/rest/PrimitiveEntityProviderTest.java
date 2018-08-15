package io.muserver.rest;

import io.muserver.MuServer;
import okhttp3.Response;
import org.junit.After;
import org.junit.Test;
import scaffolding.MuAssert;
import scaffolding.RawClient;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.muserver.MuServerBuilder.httpServer;
import static io.muserver.rest.RestHandlerBuilder.restHandler;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static scaffolding.ClientUtils.call;
import static scaffolding.ClientUtils.request;
import static scaffolding.MuAssert.stopAndCheck;

public class PrimitiveEntityProviderTest {

    private MuServer server;
    private static final Map<String, String> requests = new HashMap<>();

    @Test
    public void booleansSupported() throws Exception {
        @Path("samples")
        class Sample {
            @POST
            public boolean echo(boolean value) {
                return value;
            }
        }
        this.server = httpServer().addHandler(restHandler(new Sample())).start();
        check(true);
        check(false);
        checkNoBody();
    }

    @Test
    public void integersSupported() throws Exception {
        @Path("samples")
        class Sample {
            @POST
            public int echo(int value) {
                return value;
            }
        }
        this.server = httpServer().addHandler(restHandler(new Sample())).start();
        check(Integer.MAX_VALUE);
        check(Integer.MIN_VALUE);
        check(0);
        check(128);
        check(-128);
        checkNoBody();
    }

    @Test
    public void shortsSupported() throws Exception {
        @Path("samples")
        class Sample {
            @POST
            public short echo(short value) {
                return value;
            }
        }
        this.server = httpServer().addHandler(restHandler(new Sample())).start();
        check(Short.MAX_VALUE);
        check(Short.MIN_VALUE);
        check((short)0);
        check((short)128);
        check((short)-128);
        checkNoBody();
    }

    @Test
    public void longsSupported() throws Exception {
        @Path("samples")
        class Sample {
            @POST
            public long echo(long value) {
                return value;
            }
        }
        this.server = httpServer().addHandler(restHandler(new Sample())).start();
        check(Long.MAX_VALUE);
        check(Long.MIN_VALUE);
        check((long)0);
        check((long)128);
        check((long)-128);
        checkNoBody();
    }

    @Test
    public void charsSupported() throws Exception {
        @Path("samples")
        class Sample {
            @POST
            public char echo(char value) {
                return value;
            }
        }
        this.server = httpServer().addHandler(restHandler(new Sample())).start();
        check(Character.MAX_VALUE);
        check('好');
        check('�');
        check(Character.MIN_VALUE);
        check('h');
        check('i');
        checkNoBody();
    }

    @Test
    public void bytesSupported() throws Exception {
        @Path("samples")
        class Sample {
            @POST
            public byte echo(byte value) {
                return value;
            }
        }
        this.server = httpServer().addHandler(restHandler(new Sample())).start();
        check(Byte.MAX_VALUE);
        check(Byte.MIN_VALUE);
        check((byte)0);
        check((byte)1);
        checkNoBody();
    }

    @Test
    public void floatsSupported() throws Exception {
        @Path("samples")
        class Sample {
            @POST
            public float echo(float value) {
                return value;
            }
        }
        this.server = httpServer().addHandler(restHandler(new Sample())).start();
        check(Float.MAX_VALUE);
        check(Float.MIN_VALUE);
        check((float)0);
        check((float)0.0);
        check((float)3.14);
        checkNoBody();
    }

    @Test
    public void doublesSupported() throws Exception {
        @Path("samples")
        class Sample {
            @POST
            public double echo(double value) {
                return value;
            }
        }
        this.server = httpServer().addHandler(restHandler(new Sample())).start();
        check(Double.MAX_VALUE);
        check(Double.MIN_VALUE);
        check((double)0);
        check((double)0.0);
        check((double)3.14);
        checkNoBody();
    }

    @Test
    public void numbersCanBeReturned() throws Exception {
        @Path("samples")
        class Sample {
            @GET
            public Number echo() {
                return 123;
            }
        }
        this.server = httpServer().addHandler(restHandler(new Sample())).start();
        try (Response resp = call(request()
            .url(server.uri().resolve("/samples").toString())
        )) {
            assertThat(resp.code(), equalTo(200));
            assertThat(resp.header("Content-Type"), equalTo("text/plain;charset=UTF-8"));
            assertThat(resp.body().string(), equalTo("123"));
        }
    }

    private RawClient rawClient;
    private RawClient getRawClient() throws IOException {
        if (rawClient == null) {
            rawClient = RawClient.create(server.uri());
        }
        return rawClient;
    }

    private void check(Object value) throws Exception {
        String content = String.valueOf(value);
        byte[] contentAsBytes = content.getBytes(UTF_8);
        RawClient client = getRawClient();


        sendAndWaitForResponse(contentAsBytes, client);

        String resp = client.responseString();
        assertThat(resp, startsWith("HTTP/1.1 200 OK\r\n"));
        assertThat(resp, containsString("\r\ncontent-type: text/plain;charset=UTF-8\r\n"));
        assertThat(resp, containsString("\r\ncontent-length: " + contentAsBytes.length + "\r\n"));

        String body = resp.substring(resp.indexOf("\r\n\r\n") + 4);
        assertThat(body, equalTo(content));

        rawClient.clear();

    }

    private void checkNoBody() throws Exception {

        RawClient client = getRawClient();

        if (client.bytesReceived() > 0) {
            throw new RuntimeException("There are some left over bytes! " + client.responseString());
        }

        sendAndWaitForResponse(new byte[0], client);
        String resp = client.responseString();

        assertThat(resp, startsWith("HTTP/1.1 400 Bad Request\r\n"));
        assertThat(resp, containsString("\r\ncontent-type: text/html\r\n"));
        assertThat(resp, containsString("\r\ncontent-length: "));

        String body = resp.substring(resp.indexOf("\r\n\r\n") + 4);
        assertThat(body, containsString("<h1>400 Bad Request</h1>"));

        rawClient.clear();
    }

    private void sendAndWaitForResponse(byte[] contentAsBytes, RawClient client) throws Exception {
        client.sendStartLine("POST", "/samples");
        client.sendHeader("Host", server.uri().getAuthority());
        client.sendHeader("Content-Type", "text/plain;charset=UTF-8");
        client.sendHeader("Content-Length", String.valueOf(contentAsBytes.length));
        client.endHeaders();
        client.send(contentAsBytes);
        client.flushRequest();
        MuAssert.waitUntil( () -> client.responseString().contains("\r\n\r\n"));
        Thread.sleep(20);
    }


    @After
    public void stop() {
        stopAndCheck(server);
    }

}