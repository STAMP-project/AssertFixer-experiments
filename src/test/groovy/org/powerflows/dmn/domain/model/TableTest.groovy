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

package org.powerflows.dmn.domain.model

import spock.lang.Specification

class TableTest extends Specification {

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
        final Table table = Table.builder()
                .id(someTableId)
                .name(someTableName)
                .hitPolicy(someHitPolicy)
                .fields()
                    .input()
                        .name(someInputName1)
                        .description(someInputDescription1)
                        .end()
                    .input()
                        .name(someInputName2)
                        .description(someInputDescription2)
                        .end()
                    .output()
                        .name(someOutputName1)
                        .description(someOutputDescription1)
                        .end()
                    .output()
                        .name(someOutputName2)
                        .description(someOutputDescription2)
                        .end()
                    .end()
                .decisions(null)
                .build()

        then:
        table != null
        table.getId() == someTableId
        table.getName() == someTableId
        table.getHitPolicy() == someHitPolicy
        table.getFields().getInputs().size() == 2
        table.getFields().getInputs().get(0).getName() == someInputName1
        table.getFields().getInputs().get(0).getDescription() == someInputDescription1
        table.getFields().getInputs().get(1).getName() == someInputName2
        table.getFields().getInputs().get(1).getDescription() == someInputDescription2
        table.getDecisions() == null
    }
}
