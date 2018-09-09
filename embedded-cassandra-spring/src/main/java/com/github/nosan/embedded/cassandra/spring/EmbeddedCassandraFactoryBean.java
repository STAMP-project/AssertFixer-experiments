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
import javax.annotation.Nullable;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

import com.github.nosan.embedded.cassandra.DataStaxCassandra;
import com.github.nosan.embedded.cassandra.configuration.BootstrapSettings;
import com.github.nosan.embedded.cassandra.cql.CqlScript;
import com.github.nosan.embedded.cassandra.cql.CqlScriptUtils;

/**
 * {@link FactoryBean} to create {@link DataStaxCassandra} bean.
 *
 * @author Dmytro Nosan
 */
class EmbeddedCassandraFactoryBean implements FactoryBean<DataStaxCassandra>, InitializingBean, DisposableBean {


	@Nullable
	private DataStaxCassandra cassandra;

	@Nonnull
	private final ApplicationContext context;

	@Nonnull
	private CqlScript[] scripts;

	EmbeddedCassandraFactoryBean(@Nonnull ApplicationContext context, @Nullable CqlScript[] scripts) {
		this.context = context;
		this.scripts = (scripts != null) ? scripts : new CqlScript[0];
	}

	@Override
	public DataStaxCassandra getObject() {
		return this.cassandra;
	}

	@Override
	public Class<?> getObjectType() {
		return DataStaxCassandra.class;
	}


	@Override
	public void afterPropertiesSet() {
		BootstrapSettings settings = getBean(this.context, BootstrapSettings.class);
		DataStaxCassandra.ClusterFactory clusterFactory = getBean(this.context, DataStaxCassandra.ClusterFactory.class);
		this.cassandra = new DataStaxCassandra(settings, clusterFactory);
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

	private static <T> T getBean(ApplicationContext context, Class<T> targetClass) {
		try {
			return context.getBean(targetClass);
		}
		catch (BeansException ex) {
			return null;
		}
	}

}
