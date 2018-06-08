/**
 * Copyright (c) 2016, 2018 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bosch Software Innovations GmbH - initial creation
 *    Red Hat Inc
 */

package org.eclipse.hono.service.metric;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.SharedMetricRegistries;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;

import io.vertx.core.Vertx;
import io.vertx.core.metrics.MetricsOptions;
import io.vertx.ext.dropwizard.DropwizardMetricsOptions;

/**
 * Spring bean definitions required by the metrics reporters.
 */
@Configuration
public class MetricConfig {

    private static final String HONO = "hono";

    private static final Logger LOG = LoggerFactory.getLogger(MetricConfig.class);

    private String prefix = HONO;

    private final MetricRegistry metricRegistry;

    /**
     * Create a new metric configuration.
     * 
     * @param metricRegistry The metric registry to use.
     */
    public MetricConfig(final MetricRegistry metricRegistry) {
        this.metricRegistry = metricRegistry;
    }

    /**
     * Set the prefix to scope values of each service.
     *
     * @param prefix The prefix
     */
    public void setPrefix(final String prefix) {
        this.prefix = prefix;
    }

    /**
     * Gets a gauge instance for the JVM memory.
     * 
     * @return A gauge instance for the JVM memory.
     */
    @Bean
    @ConditionalOnProperty(prefix = "hono.metric.jvm", name = "memory", havingValue = "true")
    public MemoryUsageGaugeSet jvmMetricsMemory() {
        LOG.info("metrics - jvm/memory activated");
        return metricRegistry.register(prefix(this.prefix, "jvm.memory"), new MemoryUsageGaugeSet());
    }

    /**
     * Gets a gauge instance for the JVM thread states.
     * 
     * @return A gauge instance for the JVM thread states.
     */
    @Bean
    @ConditionalOnProperty(prefix = "hono.metric.jvm", name = "thread", havingValue = "true")
    public ThreadStatesGaugeSet jvmMetricsThreads() {
        LOG.info("metrics - jvm/threads activated");
        return metricRegistry.register(prefix(this.prefix, "jvm.thread"), new ThreadStatesGaugeSet());
    }

    /**
     * Gets the vertx metrics options bean.
     * 
     * @return A new metrics options instance for vertx.
     */
    @Bean
    @ConditionalOnProperty(prefix = "hono.metric", name = "vertx", havingValue = "true")
    public MetricsOptions vertxMetricsOptions() {
        LOG.info("metrics - vertx activated");
        SharedMetricRegistries.add(HONO, metricRegistry);
        SharedMetricRegistries.setDefault(HONO, metricRegistry);
        return new DropwizardMetricsOptions()
                .setEnabled(true)
                .setRegistryName(HONO)
                .setBaseName(prefix(this.prefix, "vertx"))
                .setJmxEnabled(true);
    }

    /**
     * Gets a new instance for a console reporter.
     * 
     * @param period The period to update the state on console in milliseconds.
     * @return The new console reporter instance.
     */
    @Bean
    @ConditionalOnProperty(prefix = "hono.metric.reporter.console", name = "active", havingValue = "true")
    public ConsoleReporter consoleMetricReporter(
            @Value("${hono.metric.reporter.console.period:5000}") final Long period) {
        LOG.info("metrics - console reporter activated");
        final ConsoleReporter consoleReporter = ConsoleReporter.forRegistry(this.metricRegistry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .filter(MetricFilter.ALL)
                .build();
        consoleReporter.start(period, TimeUnit.MILLISECONDS);
        return consoleReporter;
    }

    /**
     * Gets a new instance for a Prometheus reporter.
     * 
     * @param vertx The vertx context used to the create the HTTP endpoint.
     * @param port The port number to bind the endpoint to.
     * @return The new prometheus reporter instance.
     */
    @Bean
    @ConfigurationProperties(prefix = "hono.metric.reporter.prometheus")
    public PrometheusMetricsReporter prometheusMetricReporter(
            final Vertx vertx,
            @Value("${hono.metric.reporter.prometheus.port:9779}") final int port
            ) {

        LOG.info("metrics - prometheus reporter activated");

        final PrometheusMetricsReporter reporter = new PrometheusMetricsReporter(vertx, port, this.metricRegistry);
        reporter.start();
        return reporter;
    }

    private static String prefix(final String prefix, final String string) {
        if (prefix == null || prefix.isEmpty()) {
            return string;
        }

        if (string == null) {
            return null;
        }

        return prefix + "." + string;
    }
}
