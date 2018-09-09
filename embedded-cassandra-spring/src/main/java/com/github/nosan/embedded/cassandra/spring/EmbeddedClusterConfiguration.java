/*
 * Copyright 2012-2018 the original author or authors.
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

import com.datastax.driver.core.Cluster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.util.Assert;

/**
 * {@link Configuration Configuration} for {@link com.github.nosan.embedded.cassandra.spring.EmbeddedCluster
 * EmbeddedCluster}
 * support. Configuration overrides any existing {@link Cluster Cluster} beans with an
 * embedded {@link Cluster Cluster}.
 *
 * @author Dmytro Nosan
 */
@Configuration
@Order
class EmbeddedClusterConfiguration {


	private static final Logger log = LoggerFactory
			.getLogger(EmbeddedClusterConfiguration.class);


	@Bean
	@Nonnull
	public static EmbeddedClusterBeanFactoryPostProcessor embeddedClusterBeanFactoryPostProcessor() {
		return new EmbeddedClusterBeanFactoryPostProcessor();
	}


	private static class EmbeddedClusterBeanFactoryPostProcessor
			implements BeanDefinitionRegistryPostProcessor, Ordered {

		@Override
		public void postProcessBeanDefinitionRegistry(@Nonnull BeanDefinitionRegistry registry)
				throws BeansException {
			Assert.isInstanceOf(ConfigurableListableBeanFactory.class, registry,
					"Embedded Cassandra Configuration can only be used with a ConfigurableListableBeanFactory");
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
		private BeanDefinitionHolder getClusterBeanDefinition(
				@Nonnull ConfigurableListableBeanFactory beanFactory) {
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
			BeanDefinition beanDefinition = new RootBeanDefinition(
					EmbeddedClusterFactoryBean.class);
			beanDefinition.setPrimary(primary);
			return beanDefinition;
		}

		@Override
		public int getOrder() {
			return Ordered.LOWEST_PRECEDENCE;
		}
	}


}
