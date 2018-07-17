package com.server;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResponseBodyBuilderTest {

    @Test
    public void getBodyReturnsImATeapotIfPathIsCoffee(){
        String path = "/coffee";
        String method = "GET";
        String publicDir = "/foo";
        RequestRouter rr = new RequestRouter();
        ResponseBodyBuilder responseBodyBuilder = new ResponseBodyBuilder(rr, publicDir);
        String body = responseBodyBuilder.getBody(path, method);

        String expected = "I'm a teapot";

        assertEquals(expected, body);
    }

    @Test
    public void getBodyReturnsDirectoryListIfPathIsRootOfPublicDir(){
        String path = "/";
        String method = "GET";
        String publicDir = "/Users/shibani/Documents/projects/server/cob_spec/public";
        //String publicDir = "/foo";
        RequestRouter rr = new RequestRouter();
        ResponseBodyBuilder responseBodyBuilder = new ResponseBodyBuilder(rr, publicDir);
        String body = responseBodyBuilder.getBody(path, method);

        String expected = "text-file.txt, file2, patch-content.txt, image.gif, image.jpeg, file1, partial_content.txt, put-target, image.png";

        assertEquals(expected, body);
    }

}