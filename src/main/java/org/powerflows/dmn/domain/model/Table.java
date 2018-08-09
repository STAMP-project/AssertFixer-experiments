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

package org.powerflows.dmn.domain.model;

import org.powerflows.dmn.domain.model.decision.Decisions;
import org.powerflows.dmn.domain.model.field.Fields;

import java.io.Serializable;
import java.util.function.Consumer;

public class Table implements Serializable {

    private static final long serialVersionUID = 1;

    private String id;
    private String name;
    private HitPolicy hitPolicy;
    private Fields fields;
    private Decisions decisions;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HitPolicy getHitPolicy() {
        return hitPolicy;
    }

    public Fields getFields() {
        return fields;
    }

    public Decisions getDecisions() {
        return decisions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractBuilder<Table> {

        private Builder() {
        }

        @Override
        protected void initProduct() {
            this.product = new Table();
        }

        public Builder id(String id) {
            this.product.id = id;

            return this;
        }

        public Builder name(String name) {
            this.product.name = name;

            return this;
        }

        public Builder hitPolicy(HitPolicy hitPolicy) {
            this.product.hitPolicy = hitPolicy;

            return this;
        }

        public Fields.Builder fields() {
            final Consumer<Fields> fieldsConsumer = fields -> this.product.fields = fields;

            return Fields.builder(this, fieldsConsumer);
        }

        public Builder decisions(Decisions decisions) {
            this.product.decisions = decisions;

            return this;
        }
    }

}
