/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.nosan.embedded.cassandra.spring;

import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.github.nosan.embedded.cassandra.cql.CqlScriptUtils;


/**
 * {@code TestExecutionListener} that provides support for executing CQL
 * {@link Cql#scripts scripts} and inlined {@link Cql#statements statements}
 * configured via the {@link Cql @Cql} annotation.
 * <p>Scripts and inlined statements will be executed {@linkplain #beforeTestMethod(TestContext) before}
 * or {@linkplain #afterTestMethod(TestContext) after} execution of the corresponding
 * {@linkplain java.lang.reflect.Method test method}, depending on the configured
 * value of the {@link Cql#executionPhase executionPhase} flag.
 *
 * @author Dmytro Nosan
 * @see Cql
 * @see CqlScripts
 */
class CqlExecutionListener extends AbstractTestExecutionListener {

	private static final Logger log = LoggerFactory.getLogger(CqlExecutionListener.class);


	/**
	 * Returns {@code 5000}.
	 */
	@Override
	public final int getOrder() {
		return 5000;
	}

	/**
	 * Execute CQL scripts configured via {@link Cql @Cql} for the supplied
	 * {@link TestContext} <em>before</em> the current test method.
	 */
	@Override
	public void beforeTestMethod(@Nonnull TestContext testContext) {
		executeCqlScripts(testContext, Cql.ExecutionPhase.BEFORE_TEST_METHOD);
	}

	/**
	 * Execute CQL scripts configured via {@link Cql @Cql} for the supplied
	 * {@link TestContext} <em>after</em> the current test method.
	 */
	@Override
	public void afterTestMethod(@Nonnull TestContext testContext) {
		executeCqlScripts(testContext, Cql.ExecutionPhase.AFTER_TEST_METHOD);
	}

	private void executeCqlScripts(@Nonnull TestContext testContext, @Nonnull Cql.ExecutionPhase executionPhase) {
		Set<Cql> cqlAnnotations = AnnotatedElementUtils.getMergedRepeatableAnnotations(
				testContext.getTestMethod(), Cql.class, CqlScripts.class);
		for (Cql cql : cqlAnnotations) {
			executeCqlScripts(cql, executionPhase, testContext);
		}
	}

	private void executeCqlScripts(@Nonnull Cql cql, @Nonnull Cql.ExecutionPhase executionPhase,
			TestContext testContext) {
		if (executionPhase != cql.executionPhase()) {
			return;
		}
		ApplicationContext applicationContext = testContext.getApplicationContext();
		Cluster cluster = getCluster(cql.cluster(), testContext);
		Assert.state(cluster != null, () -> String.format("Failed to execute CQL scripts for a test context %s: " +
				"supply a Cluster bean", testContext));
		try (Session session = cluster.connect()) {
			CqlConfig config = new CqlConfig();
			config.setEncoding(cql.encoding());
			config.setScripts(cql.scripts());
			config.setStatements(cql.statements());
			config.setTestClass(testContext.getTestClass());
			CqlScriptUtils.execute(session, CqlConfigUtils.getScripts(applicationContext, config));
		}

	}

	private Cluster getCluster(@Nonnull String name, @Nonnull TestContext testContext) {
		BeanFactory bf = testContext.getApplicationContext().getAutowireCapableBeanFactory();
		try {
			if (StringUtils.hasText(name)) {
				return bf.getBean(name, Cluster.class);
			}
		}
		catch (BeansException ex) {
			log.error(String.format("Failed to retrieve Cluster named '%s' bean for a test context %s", name,
					testContext), ex);
			throw ex;
		}

		try {
			if (bf instanceof ListableBeanFactory) {
				ListableBeanFactory lbf = (ListableBeanFactory) bf;
				Map<String, Cluster> clusters = BeanFactoryUtils.beansOfTypeIncludingAncestors(lbf, Cluster.class);
				if (clusters.size() == 1) {
					return clusters.values().iterator().next();
				}
				try {
					return bf.getBean(Cluster.class);
				}
				catch (BeansException ex) {
					log.debug(String.format("Failed to retrieve Cluster primary bean for a test context %s",
							testContext), ex);
				}
			}
			return bf.getBean("cluster", Cluster.class);
		}
		catch (BeansException ex) {
			log.debug(String.format("Failed to retrieve Cluster named 'cluster' bean for a test context %s",
					testContext), ex);
			return null;
		}
	}


}
