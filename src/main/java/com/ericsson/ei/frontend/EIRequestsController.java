/*
   Copyright 2017 Ericsson AB.
   For a full list of individual contributors, please see the commit history.
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package com.ericsson.ei.frontend;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.ei.frontend.model.BackEndInformation;
import com.ericsson.ei.frontend.utils.BackEndInstancesUtils;

@RestController
public class EIRequestsController {

    private static final Logger LOG = LoggerFactory.getLogger(EIRequestsController.class);

    private static final List<String> REQUESTS_WITH_QUERY_PARAM = new ArrayList<>(Arrays.asList("/queryAggregatedObject", "/queryMissedNotifications", "/query"));
    private static final String BACKEND_KEY_NAME = "backendurl";

    private CloseableHttpClient client = HttpClientBuilder.create().build();

    @Autowired
    private BackEndInstancesUtils backEndInstancesUtils;

    /**
     * Bridge all EI Http Requests with GET method. Used for fetching
     * Subscription by id or all subscriptions and EI Env Info.
     */
    @CrossOrigin
    @RequestMapping(value = { "/subscriptions", "/subscriptions/*", "/information", "/download/*", "/auth",
        "/auth/*", "/queryAggregatedObject", "/queryMissedNotifications", "/query", "/rules/rule-check/testRulePageEnabled" }, method = RequestMethod.GET)
    public ResponseEntity<String> getRequests(Model model, HttpServletRequest request) {
        String eiRequestUrl = getEIRequestURL(request);
        HttpGet eiRequest = new HttpGet(eiRequestUrl);

        String header = request.getHeader("Authorization");
        if (header != null) {
            eiRequest.addHeader("Authorization", header);
        }

        return getResponse(eiRequest);
    }

    /**
     * Bridge all EI Http Requests with POST method.
     */
    @CrossOrigin
    @RequestMapping(value = { "/subscriptions", "/rules/rule-check/aggregation", "/query" }, method = RequestMethod.POST)
    public ResponseEntity<String> postRequests(Model model, HttpServletRequest request) {
        String eiRequestUrl = getEIRequestURL(request);
        String requestBody = "";

        try {
            requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator())).replaceAll("(\\r)", "");
        } catch (IOException e) {
            LOG.error("Forward Request Errors: " + e);
        }

        LOG.debug("Input Request JSON Content to be forwarded:\n" + requestBody);

        HttpEntity inputReqJsonEntity = new ByteArrayEntity(requestBody.getBytes());

        HttpPost eiRequest = new HttpPost(eiRequestUrl);
        eiRequest.setEntity(inputReqJsonEntity);
        eiRequest.setHeader("Content-type", "application/json");

        String header = request.getHeader("Authorization");
        if (header != null) {
            eiRequest.addHeader("Authorization", header);
        }

        return getResponse(eiRequest);
    }

    /**
     * Bridge all EI Http Requests with PUT method. E.g. Making Update
     * Subscription Request.
     */
    @CrossOrigin
    @RequestMapping(value = "/subscriptions", method = RequestMethod.PUT)
    public ResponseEntity<String> putRequests(Model model, HttpServletRequest request) {
        String eiRequestUrl = getEIRequestURL(request);
        String requestBody = "";

        try {
            requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator())).replaceAll("(\\r)", "");
        } catch (IOException e) {
            LOG.error("Forward Request Errors: " + e);
        }

        LOG.debug("Input Request JSON Content to be forwarded:\n" + requestBody);

        HttpEntity inputReqJsonEntity = new ByteArrayEntity(requestBody.getBytes());

        HttpPut eiRequest = new HttpPut(eiRequestUrl);
        eiRequest.setEntity(inputReqJsonEntity);
        eiRequest.setHeader("Content-type", "application/json");

        String header = request.getHeader("Authorization");
        if (header != null) {
            eiRequest.addHeader("Authorization", header);
        }

        return getResponse(eiRequest);
    }

    /**
     * Bridge all EI Http Requests with DELETE method. Used for DELETE
     * subscriptions.
     */
    @CrossOrigin
    @RequestMapping(value = "/subscriptions/*", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteRequests(Model model, HttpServletRequest request) {
        String eiRequestUrl = getEIRequestURL(request);

        HttpDelete eiRequest = new HttpDelete(eiRequestUrl);

        String header = request.getHeader("Authorization");
        if (header != null) {
            eiRequest.addHeader("Authorization", header);
        }

        return getResponse(eiRequest);
    }

    private String getEIRequestURL(HttpServletRequest request) {
        String eiBackendAddressSuffix = request.getServletPath();
        String requestQuery = request.getQueryString();
        String requestUrl = null;

        if (requestQuery != null && requestQuery.contains(BACKEND_KEY_NAME)) {
            // Selecting back end from user input as parameter.
            List<NameValuePair> params = getParameters(requestQuery);
            requestUrl = extractUrlFromParameters(params);
            requestQuery = removeBackendDataFromQueryString(params);
        } else {
            BackEndInformation backEndInformation = getEIBackendInformation(request);
        	requestUrl = getEIBackendSubscriptionAddress(backEndInformation);
        }

        if(REQUESTS_WITH_QUERY_PARAM.contains(eiBackendAddressSuffix)) {
            String query = (requestQuery != null && !requestQuery.isEmpty()) ? "?" + requestQuery : "";
            requestUrl = requestUrl + eiBackendAddressSuffix + query;
        } else {
            requestUrl = requestUrl + eiBackendAddressSuffix;
        }
        LOG.debug("Got HTTP Request with method " + request.getMethod() + "\nUrlSuffix: " + eiBackendAddressSuffix
                + "\nForwarding Request to EI Backend with url: " + requestUrl);
        return requestUrl;
    }

    private List<NameValuePair> getParameters(String requestQuery) {
        List<NameValuePair> params = null;

        try {
            params = URLEncodedUtils.parse(new URI("?" + requestQuery), Charset.forName("UTF-8"));
        } catch (URISyntaxException e) {
            LOG.error("Error while encoding URL parameters: " + e);
        }
        return params;
    }

    private String extractUrlFromParameters(List<NameValuePair> params) {
        String urlFromParams = null;
        for (NameValuePair param : params) {
            if (param.getName().equals(BACKEND_KEY_NAME)) {
                urlFromParams = param.getValue();
            }
        }
        return urlFromParams;
    }

    private String removeBackendDataFromQueryString(List<NameValuePair> params) {
		List<NameValuePair> processedParams = new ArrayList<>();
		for (NameValuePair param : params) {
			String name = param.getName(), value = param.getValue();
			if (name.equals(BACKEND_KEY_NAME)) {
				continue;
			}
            processedParams.add(new BasicNameValuePair(name, value));
        }

        if (processedParams.size() == 0)
            return null;

		return URLEncodedUtils.format(processedParams, "UTF8");
	}

	private BackEndInformation getEIBackendInformation(HttpServletRequest request) {
	    String backEndInstanceName = null;

	    if (request.getSession().getAttribute("backEndInstanceName") != null) {
            backEndInstanceName = request.getSession().getAttribute("backEndInstanceName").toString();
    	}

        return backEndInstancesUtils.getBackEndInformationByName(backEndInstanceName);
	}

    private String getEIBackendSubscriptionAddress(BackEndInformation backEndInformation) {
        String httpMethod = "http";
        if (backEndInformation.isUseSecureHttpBackend()) {
            httpMethod = "https";
        }

        if (backEndInformation.getPath() != null && !backEndInformation.getPath().isEmpty()) {
            return httpMethod + "://" + backEndInformation.getHost() + ":" + backEndInformation.getPort() + "/"
                    + backEndInformation.getPath();
        }
        return httpMethod + "://" + backEndInformation.getHost() + ":" + backEndInformation.getPort();
    }

	private ResponseEntity<String> getResponse(HttpRequestBase request) {
        String responseBody = "";
        int statusCode = HttpStatus.PROCESSING.value();
        try (CloseableHttpResponse eiResponse = client.execute(request)) {
            responseBody = StringUtils.defaultIfBlank(EntityUtils.toString(eiResponse.getEntity(), "utf-8"), "[]");
            statusCode = eiResponse.getStatusLine().getStatusCode();
            LOG.info("EI Http response status code: " + statusCode
                    + "\nEI Received response body:\n" + responseBody
                    + "\nForwarding response back to EI Frontend WebUI.");
        } catch (IOException e) {
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
            LOG.error("Forward Request Errors: " + e);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(responseBody, headers, HttpStatus.valueOf(statusCode));
    }

}
