/*
 * Copyright (c) 2018-present PowerFlows.org - all rights reserved.
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

package org.powerflows.dmn.domain.model.field;

import org.powerflows.dmn.domain.model.AbstractBuilder;

import java.util.function.Consumer;

public class Field {

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static Builder builder(Fields.Builder builder, Consumer<Field> fieldConsumer) {
        return new Builder(builder, fieldConsumer);
    }

    public static final class Builder extends AbstractBuilder<Field> {

        private Fields.Builder parentBuilder;
        private Consumer<Field> callback;

        private Builder(Fields.Builder builder, Consumer<Field> fieldConsumer) {
            this.parentBuilder = builder;
            this.callback = fieldConsumer;
        }

        @Override
        protected void initProduct() {
            this.product = new Field();
        }

        public Builder name(String name) {
            this.product.name = name;

            return this;
        }

        public Builder description(String description) {
            this.product.description = description;

            return this;
        }

        public Fields.Builder end() {
            callback.accept(build());

            return parentBuilder;
        }
    }
}
