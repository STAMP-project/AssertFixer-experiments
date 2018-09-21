/*
 * Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.http.apache;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class ProxyConfigurationTest {

    @Before
    public void setup() {
        clearProxyProperties();
    }

    @AfterClass
    public static void cleanup() {
        clearProxyProperties();
    }

    @Test
    public void testProxyConfigurationWithSystemPropertyDisabled() throws Exception {
        Set<String> nonProxyHosts = new HashSet<>();
        nonProxyHosts.add("foo.com");

        // system property should not be used
        System.setProperty("http.proxyHost", "foo.com");
        System.setProperty("http.nonProxyHosts", "bar.com");
        System.setProperty("http.proxyUser", "user");

        ProxyConfiguration config = ProxyConfiguration.builder()
                                                      .nonProxyHosts(nonProxyHosts)
                                                      .useSystemPropertyValues(Boolean.FALSE)
                                                      .build();

        assertThat(config.nonProxyHosts()).isEqualTo(nonProxyHosts);
        assertThat(config.host()).isNull();
        assertThat(config.username()).isNull();
    }

    @Test
    public void testProxyConfigurationWithSystemPropertyEnabled() throws Exception {
        Set<String> nonProxyHosts = new HashSet<>();
        nonProxyHosts.add("foo.com");

        // system property should not be used
        System.setProperty("http.proxyHost", "foo.com");
        System.setProperty("http.nonProxyHosts", "bar.com");
        System.setProperty("http.proxyUser", "user");

        ProxyConfiguration config = ProxyConfiguration.builder()
                                                      .nonProxyHosts(nonProxyHosts)
                                                      .build();

        assertThat(config.nonProxyHosts()).isEqualTo(nonProxyHosts);
        assertThat(config.host()).isEqualTo("foo.com");
        assertThat(config.username()).isEqualTo("user");
    }

    @Test
    public void testEndpoint() {
        ProxyConfiguration config = ProxyConfiguration.builder().endpoint(URI.create("http://localhost:1234")).build();

        assertThat(config.host()).isEqualTo("localhost");
        assertThat(config.port()).isNotZero();
        assertThat(config.scheme()).isEqualTo("http");
    }

    private static void clearProxyProperties() {
        System.clearProperty("http.nonProxyHosts");
    }
}
