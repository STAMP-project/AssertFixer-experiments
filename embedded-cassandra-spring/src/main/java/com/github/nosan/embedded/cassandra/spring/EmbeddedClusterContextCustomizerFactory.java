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

import java.util.List;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.test.context.ContextConfigurationAttributes;
import org.springframework.test.context.ContextCustomizer;
import org.springframework.test.context.ContextCustomizerFactory;

/**
 * {@link ContextCustomizerFactory} to support {@link EmbeddedCluster}.
 *
 * @author Dmytro Nosan
 */
class EmbeddedClusterContextCustomizerFactory implements ContextCustomizerFactory {

	private static final Logger log = LoggerFactory.getLogger(EmbeddedClusterContextCustomizerFactory.class);

	@Override
	public ContextCustomizer createContextCustomizer(@Nonnull Class<?> testClass,
			@Nonnull List<ContextConfigurationAttributes> configAttributes) {
		EmbeddedCluster annotation = AnnotatedElementUtils
				.findMergedAnnotation(testClass, EmbeddedCluster.class);
		if (annotation != null) {
			if (!isEmbeddedCassandraAnnotationPresent(testClass)) {
				log.warn("@EmbeddedCluster annotation works only in conjunction with @EmbeddedCassandra");
				return null;
			}
			return new EmbeddedClusterContextCustomizer();
		}
		return null;
	}

	private boolean isEmbeddedCassandraAnnotationPresent(@Nonnull Class<?> testClass) {
		return AnnotatedElementUtils.findMergedAnnotation(testClass, EmbeddedCassandra.class) != null;
	}

}
