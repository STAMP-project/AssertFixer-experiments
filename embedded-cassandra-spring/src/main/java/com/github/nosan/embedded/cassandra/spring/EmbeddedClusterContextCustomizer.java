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

import com.datastax.driver.core.Cluster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.test.context.ContextCustomizer;
import org.springframework.test.context.MergedContextConfiguration;
import org.springframework.util.Assert;

import com.github.nosan.embedded.cassandra.CassandraOld;

/**
 * {@link ContextCustomizer} to add {@link EmbeddedClusterBeanFactoryPostProcessor} if
 * a {@code Test Class} has an {@link EmbeddedCluster}.
 *
 * @author Dmytro Nosan
 */
class EmbeddedClusterContextCustomizer implements ContextCustomizer {

	@Override
	public void customizeContext(@Nonnull ConfigurableApplicationContext context,
			@Nonnull MergedContextConfiguration mergedConfig) {
		context.addBeanFactoryPostProcessor(new EmbeddedClusterBeanFactoryPostProcessor());
	}


	/**
	 * {@link BeanDefinitionRegistryPostProcessor} to register a {@link Cluster} bean.
	 */
	static final class EmbeddedClusterBeanFactoryPostProcessor
			implements BeanDefinitionRegistryPostProcessor, Ordered {

		private static final Logger log = LoggerFactory.getLogger(EmbeddedClusterBeanFactoryPostProcessor.class);


		@Override
		public void postProcessBeanDefinitionRegistry(@Nonnull BeanDefinitionRegistry registry)
				throws BeansException {
			Assert.isInstanceOf(ConfigurableListableBeanFactory.class, registry,
					"EmbeddedClusterBeanFactoryPostProcessor can only be used with a ConfigurableListableBeanFactory");
			process(registry, (ConfigurableListableBeanFactory) registry);
		}

		@Override
		public void postProcessBeanFactory(@Nonnull ConfigurableListableBeanFactory beanFactory)
				throws BeansException {
		}

		private void process(@Nonnull BeanDefinitionRegistry registry,
				@Nonnull ConfigurableListableBeanFactory beanFactory) {
			BeanDefinitionHolder holder = getClusterBeanDefinition(beanFactory);
			if (registry.containsBeanDefinition(holder.getBeanName())) {
				registry.removeBeanDefinition(holder.getBeanName());
			}
			registry.registerBeanDefinition(holder.getBeanName(),
					holder.getBeanDefinition());
		}

		@Nonnull
		private BeanDefinitionHolder getClusterBeanDefinition(@Nonnull ConfigurableListableBeanFactory beanFactory) {
			String[] beanNames = beanFactory.getBeanNamesForType(Cluster.class);
			if (beanNames.length == 1) {
				String beanName = beanNames[0];
				BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
				log.info("Replacing '{}' Cluster bean with {} embedded version",
						beanName, (!beanDefinition.isPrimary() ? "" : "a primary"));
				return new BeanDefinitionHolder(
						createEmbeddedBeanDefinition(beanDefinition.isPrimary()),
						beanName);
			}

			for (String beanName : beanNames) {
				BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
				if (beanDefinition.isPrimary()) {
					log.info(
							"Replacing primary '{}' Cluster bean with a primary embedded version",
							beanName);
					return new BeanDefinitionHolder(createEmbeddedBeanDefinition(true),
							beanName);
				}
			}

			log.info("There is no Cluster beans. Embedded primary 'cluster' Cluster bean will be registered");

			return new BeanDefinitionHolder(createEmbeddedBeanDefinition(true), "cluster");
		}

		@Nonnull
		private BeanDefinition createEmbeddedBeanDefinition(boolean primary) {
			BeanDefinition beanDefinition = new RootBeanDefinition(EmbeddedClusterFactoryBean.class);
			beanDefinition.setPrimary(primary);
			return beanDefinition;
		}

		@Override
		public int getOrder() {
			return Ordered.LOWEST_PRECEDENCE;
		}
	}

	/**
	 * {@link FactoryBean} to create a {@link Cluster} bean.
	 */
	static class EmbeddedClusterFactoryBean implements FactoryBean<Cluster>, ApplicationContextAware {


		@Nullable
		private ApplicationContext context;

		@Override
		@Nonnull
		public Cluster getObject() {
			if (this.context != null) {
				this.context.getBean(CassandraOld.class).getCluster();
			}
			throw new NoSuchBeanDefinitionException(CassandraOld.class, "Embedded Cluster requires a bean of type " +
					"'Cassandra'");
		}

		@Override
		@Nonnull
		public Class<?> getObjectType() {
			return Cluster.class;
		}

		@Override
		public boolean isSingleton() {
			return true;
		}

		@Override
		public void setApplicationContext(@Nonnull ApplicationContext context) throws BeansException {
			this.context = context;
		}


	}


}
