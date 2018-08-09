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
import org.powerflows.dmn.domain.model.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Collections.unmodifiableList;

public class Fields {

    private List<Field> inputs = new ArrayList<>();
    private List<Field> outputs = new ArrayList<>();

    public List<Field> getInputs() {
        return unmodifiableList(inputs);
    }

    public List<Field> getOutputs() {
        return unmodifiableList(outputs);
    }

    public static Builder builder(Table.Builder builder, Consumer<Fields> fieldsConsumer) {
        return new Builder(builder, fieldsConsumer);
    }

    public static final class Builder extends AbstractBuilder<Fields> {

        private Table.Builder parentBuilder;
        private Consumer<Fields> callback;

        private Builder(Table.Builder builder, Consumer<Fields> fieldsConsumer) {
            this.parentBuilder = builder;
            this.callback = fieldsConsumer;
        }

        @Override
        protected void initProduct() {
            this.product = new Fields();
        }

        public Field.Builder input() {
            final Consumer<Field> inputConsumer = input -> this.product.inputs.add(input);

            return Field.builder(this, inputConsumer);
        }

        public Field.Builder output(Field field) {
            final Consumer<Field> outputConsumer = output -> this.product.inputs.add(output);

            return Field.builder(this, outputConsumer);
        }

        public Table.Builder end() {
            callback.accept(build());

            return parentBuilder;
        }
    }
}
