/*
 * Copyright 2018-2018 the original author or authors.
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextCustomizer;
import org.springframework.test.context.MergedContextConfiguration;
import org.springframework.util.Assert;

import com.github.nosan.embedded.cassandra.CassandraOld;
import com.github.nosan.embedded.cassandra.cql.CqlScript;
import com.github.nosan.embedded.cassandra.cql.CqlScriptUtils;
import com.github.nosan.embedded.cassandra.ttconfiguration.BootstrapSettings;
import com.github.nosan.embedded.cassandra.ttconfiguration.ClusterFactory;

/**
 * {@link ContextCustomizer} to add {@link EmbeddedCassandraFactoryBean} if
 * a {@code Test Class} has an {@link EmbeddedCassandra} annotation.
 *
 * @author Dmytro Nosan
 */
class EmbeddedCassandraContextCustomizer implements ContextCustomizer {

	@Nonnull
	private final EmbeddedCassandra annotation;

	EmbeddedCassandraContextCustomizer(@Nonnull EmbeddedCassandra annotation) {
		this.annotation = annotation;
	}

	@Override
	public void customizeContext(@Nonnull ConfigurableApplicationContext context,
			@Nonnull MergedContextConfiguration mergedConfig) {
		Assert.isInstanceOf(BeanDefinitionRegistry.class, context.getBeanFactory(),
				"Embedded Cassandra Context Customizer can only be used with a BeanDefinitionRegistry");
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context.getBeanFactory();

		CqlConfig config = new CqlConfig();
		config.setEncoding(this.annotation.encoding());
		config.setScripts(this.annotation.scripts());
		config.setStatements(this.annotation.statements());
		config.setTestClass(mergedConfig.getTestClass());

		CqlScript[] cqlScripts = CqlConfigUtils.getScripts(context, config);

		RootBeanDefinition beanDefinition = new RootBeanDefinition(EmbeddedCassandraFactoryBean.class);
		beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, cqlScripts);
		registry.registerBeanDefinition("embeddedCassandra", beanDefinition);
	}


	/**
	 * {@link FactoryBean} to create a {@link CassandraOld} bean.
	 *
	 * @author Dmytro Nosan
	 */
	static class EmbeddedCassandraFactoryBean implements FactoryBean<CassandraOld>, InitializingBean, DisposableBean,
			ApplicationContextAware {


		private ApplicationContext context;

		@Nullable
		private CassandraOld cassandra;

		@Nonnull
		private CqlScript[] scripts;

		EmbeddedCassandraFactoryBean(@Nullable CqlScript[] scripts) {
			this.scripts = (scripts != null) ? scripts : new CqlScript[0];
		}

		@Override
		public CassandraOld getObject() {
			return this.cassandra;
		}

		@Override
		public Class<?> getObjectType() {
			return CassandraOld.class;
		}


		@Override
		public void afterPropertiesSet() {
			BootstrapSettings settings = getBean(this.context, BootstrapSettings.class);
			ClusterFactory clusterFactory = getBean(this.context, ClusterFactory.class);
			this.cassandra = new CassandraOld(settings, clusterFactory);
			this.cassandra.start();
			if (this.scripts.length > 0) {
				CqlScriptUtils.execute(this.cassandra.getSession(), this.scripts);
			}
		}

		@Override
		public void destroy() {
			if (this.cassandra != null) {
				this.cassandra.stop();
			}
		}

		@Override
		public void setApplicationContext(@Nonnull ApplicationContext applicationContext) throws BeansException {
			this.context = applicationContext;
		}

		private static <T> T getBean(@Nullable ApplicationContext context, @Nonnull Class<T> targetClass) {
			try {
				return (context != null) ? context.getBean(targetClass) : null;
			}
			catch (BeansException ex) {
				return null;
			}
		}

	}


}
