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
 * See the License for the specific language governing permissions end
 * limitations under the License.
 */

package org.powerflows.dmn.domain.model

import spock.lang.Specification

class DecisionSpec extends Specification {

    void 'should build table'() {
        given:
        final String someTableId = 'some_table_id'
        final String someTableName = 'Some Table Name'
        final HitPolicy someHitPolicy = HitPolicy.UNIQUE
        final String someInputName1 = 'Some Input Name 1'
        final String someInputDescription1 = 'Some Input Description 1'
        final String someInputName2 = 'Some Input Name 2'
        final String someInputDescription2 = 'Some Input Description 2'
        final String someOutputName1 = 'Some Input Name 1'
        final String someOutputDescription1 = 'Some Output Description 1'
        final String someOutputName2 = 'Some Output Name 2'
        final String someOutputDescription2 = 'Some Output Description 2'

        when:
        final Decision table = Decision.builder()
                .id(someTableId)
                .name(someTableName)
                .hitPolicy(someHitPolicy)
                .withInputs(
                { inputs ->
                    inputs.add()
                            .name(someInputName1)
                            .description(someInputDescription1)

                    inputs.add()
                            .name(someInputName2)
                            .description(someInputDescription2)
                })
                .withOutputs(
                { outputs ->
                    outputs.add()
                            .name(someOutputName1)
                            .description(someOutputDescription1)
                    outputs.add()
                            .name(someOutputName2)
                            .description(someOutputDescription2)

                }).withRules(
                { rules ->
                    rules.add()
                            .description('rule-1')
                            .withInputEntries(
                            { inputEntries ->
                                inputEntries.add()
                                        .name('in-1').build()
                                inputEntries.add()
                                        .name('in-2')
                            })
                            .withOutputEntries(
                            { outputEntries ->
                                outputEntries.add()
                                        .name('out-1')
                                outputEntries.add()
                                        .name('out-2')
                            })
                })
                .build()

        then:
        table != null
        /*table.getId() == someTableId
        table.getName() == someTableName
        table.getHitPolicy() == someHitPolicy
        table.getFields().getInputs().size() == 2
        table.getFields().getInputs().get(0).getName() == someInputName1
        table.getFields().getInputs().get(0).getDescription() == someInputDescription1
        table.getFields().getInputs().get(1).getName() == someInputName2
        table.getFields().getInputs().get(1).getDescription() == someInputDescription2
        table.getFields().getOutputs().size() == 2
        table.getFields().getOutputs().get(0).getName() == someOutputName1
        table.getFields().getOutputs().get(0).getDescription() == someOutputDescription1
        table.getFields().getOutputs().get(1).getName() == someOutputName2
        table.getFields().getOutputs().get(1).getDescription() == someOutputDescription2
        table.getRules() == null*/
    }
}
