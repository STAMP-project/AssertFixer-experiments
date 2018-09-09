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

import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.datastax.driver.core.Cluster;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.github.nosan.embedded.cassandra.DataStaxCassandra;

/**
 * {@link FactoryBean} to create {@link Cluster} bean.
 *
 * @author Dmytro Nosan
 */
class EmbeddedClusterFactoryBean implements FactoryBean<Cluster>, ApplicationContextAware {


	@Nullable
	private ApplicationContext context;

	@Override
	@Nonnull
	public Cluster getObject() {
		ApplicationContext context = this.context;
		Objects.requireNonNull(context, "Application Context must not be null.");
		return context.getBean(DataStaxCassandra.class).getCluster();
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
