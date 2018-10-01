/* Licensed under the Apache License, Version 2.0 (the "License");
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

package org.flowable.engine.test.api.runtime.migration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.common.engine.impl.util.IoUtil;
import org.flowable.engine.impl.migration.ProcessInstanceMigrationBuilderImpl;
import org.flowable.engine.impl.migration.ProcessInstanceMigrationDocumentImpl;
import org.flowable.engine.impl.test.AbstractTestCase;
import org.flowable.engine.migration.ProcessInstanceActivityMigrationMapping;
import org.flowable.engine.migration.ProcessInstanceMigrationDocument;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author Dennis Federico
 */
public class ProcessInstanceMigrationDocumentTest extends AbstractTestCase {

    @Test
    public void testDeSerializeCompleteProcessInstanceMigrationDocument() {

        String definitionId = "someProcessId";
        String definitionKey = "MyProcessKey";
        Integer definitionVer = 9;
        String definitionTenantId = "admin";

        ProcessInstanceActivityMigrationMapping.OneToOneMapping oneToOneMapping = ProcessInstanceActivityMigrationMapping.createMappingFor("originalActivity1", "newActivity1").setNewAssignee("kermit");
        ProcessInstanceActivityMigrationMapping.OneToManyMapping oneToManyMapping = ProcessInstanceActivityMigrationMapping.createMappingFor("originalActivity2", Arrays.asList("newActivity2.1", "newActivity2.2")).setNewAssignee("the frog");
        ProcessInstanceActivityMigrationMapping.ManyToOneMapping manyToOneMapping = ProcessInstanceActivityMigrationMapping.createMappingFor(Arrays.asList("originalActivity3", "originalActivity4"), "newActivity3");

        HashMap<String, Map<String, Object>> activityLocalVariables = new HashMap<String, Map<String, Object>>() {

            {
                put("newActivity1", new HashMap<String, Object>() {

                    {
                        put("varForNewActivity1", "varValue");
                    }
                });
                put("newActivity3", new HashMap<String, Object>() {

                    {
                        put("varForNewActivity3", 9876);
                    }
                });
                put("newActivity2.1", new HashMap<String, Object>() {

                    {
                        put("var1ForNewActivity2.x", "varValue");
                        put("var2ForNewActivity2.x", 1234.567);
                    }
                });
                put("newActivity2.2", new HashMap<String, Object>() {

                    {
                        put("var1ForNewActivity2.x", "varValue");
                        put("var2ForNewActivity2.x", 1234.567);
                    }
                });
            }
        };

        HashMap<String, Object> processInstanceVariables = new HashMap<String, Object>() {

            {
                put("processVar1", "varValue1");
                put("processVar2", 456.789);
            }
        };

        String jsonAsStr = IoUtil.readFileAsString("org/flowable/engine/test/api/runtime/migration/completeProcessInstanceMigrationDocument.json");

        ProcessInstanceMigrationDocument migrationDocument = ProcessInstanceMigrationDocumentImpl.fromProcessInstanceMigrationDocumentJson(jsonAsStr);

        assertEquals(definitionId, migrationDocument.getMigrateToProcessDefinitionId());
        assertEquals(definitionKey, migrationDocument.getMigrateToProcessDefinitionKey());
        assertEquals(definitionVer, migrationDocument.getMigrateToProcessDefinitionVersion());
        assertEquals(definitionTenantId, migrationDocument.getMigrateToProcessDefinitionTenantId());
        assertThat(migrationDocument.getActivityMigrationMappings()).usingFieldByFieldElementComparator().containsExactly(oneToOneMapping, oneToManyMapping, manyToOneMapping);
        assertThat(migrationDocument.getActivitiesLocalVariables()).isEqualTo(activityLocalVariables);
        assertThat(migrationDocument.getProcessInstanceVariables()).isEqualTo(processInstanceVariables);

    }

    @Test
    public void testSerializeDeSerializeCompleteProcessInstanceMigrationDocumentForDefinitionId() {

        String definitionId = "someProcessId";
        List<ProcessInstanceActivityMigrationMapping> activityMappings = new ArrayList<>();

        ProcessInstanceActivityMigrationMapping.OneToOneMapping oneToOneMapping = ProcessInstanceActivityMigrationMapping.createMappingFor("originalActivity1", "newActivity1").setNewAssignee("kermit");
        ProcessInstanceActivityMigrationMapping.OneToManyMapping oneToManyMapping = ProcessInstanceActivityMigrationMapping.createMappingFor("originalActivity2", Arrays.asList("newActivity2.1", "newActivity2.2")).setNewAssignee("the frog");
        ProcessInstanceActivityMigrationMapping.ManyToOneMapping manyToOneMapping = ProcessInstanceActivityMigrationMapping.createMappingFor(Arrays.asList("originalActivity3", "originalActivity4"), "newActivity3");
        HashMap newActivity2xVars = new HashMap<String, Object>() {

            {
                put("var1ForNewActivity2.x", "varValue");
                put("var2ForNewActivity2.x", 1234.567);
            }
        };
        HashMap<String, Map<String, Object>> activityLocalVariables = new HashMap<String, Map<String, Object>>() {

            {
                put("newActivity1", new HashMap<String, Object>() {

                    {
                        put("varForNewActivity1", "varValue");
                    }
                });
                put("newActivity3", new HashMap<String, Object>() {

                    {
                        put("varForNewActivity3", 9876);
                    }
                });
                put("newActivity2.1", new HashMap<String, Object>() {

                    {
                        put("var1ForNewActivity2.x", "varValue");
                        put("var2ForNewActivity2.x", 1234.567);
                    }
                });
                put("newActivity2.2", new HashMap<String, Object>() {

                    {
                        put("var1ForNewActivity2.x", "varValue");
                        put("var2ForNewActivity2.x", 1234.567);
                    }
                });
            }
        };

        HashMap<String, Object> processInstanceVariables = new HashMap<String, Object>() {

            {
                put("processVar1", "varValue1");
                put("processVar2", 456.789);
            }
        };

        ProcessInstanceMigrationDocument document = new ProcessInstanceMigrationBuilderImpl(null)
            .migrateToProcessDefinition(definitionId)
            .addActivityMigrationMapping("originalActivity1", "newActivity1", "varForNewActivity1", "varValue", "kermit")
            .addActivityMigrationMapping("originalActivity2", Arrays.asList("newActivity2.1", "newActivity2.2"), newActivity2xVars, "the frog")
            .addActivityMigrationMapping(Arrays.asList("originalActivity3", "originalActivity4"), "newActivity3", "varForNewActivity3", 9876)
            .withProcessInstanceVariable("processVar1", "varValue1")
            .withProcessInstanceVariable("processVar2", 456.789)
            .getProcessInstanceMigrationDocument();

        //Serialize the document as Json
        String serializedDocument = document.asJsonString();

        //DeSerialize the document
        ProcessInstanceMigrationDocument migrationDocument = ProcessInstanceMigrationDocumentImpl.fromProcessInstanceMigrationDocumentJson(serializedDocument);

        assertEquals(definitionId, migrationDocument.getMigrateToProcessDefinitionId());
        assertNull(migrationDocument.getMigrateToProcessDefinitionKey());
        assertNull(migrationDocument.getMigrateToProcessDefinitionVersion());
        assertNull(migrationDocument.getMigrateToProcessDefinitionTenantId());
        assertThat(migrationDocument.getActivityMigrationMappings()).usingFieldByFieldElementComparator().containsExactly(oneToOneMapping, oneToManyMapping, manyToOneMapping);
        assertThat(migrationDocument.getActivitiesLocalVariables()).isEqualTo(activityLocalVariables);
        assertThat(migrationDocument.getProcessInstanceVariables()).isEqualTo(processInstanceVariables);
    }

    @Test
    @Disabled("Pending change to new document")
    public void testDeSerializeProcessInstanceMigrationDocumentWithVariables() {

        String definitionId = "someProcessId";
        String definitionKey = "MyProcessKey";
        Integer definitionVer = 9;
        String definitionTenantId = "admin";

        ProcessInstanceActivityMigrationMapping.OneToOneMapping oneToOne1 = ProcessInstanceActivityMigrationMapping.createMappingFor("originalActivity1", "newActivity1");
        ProcessInstanceActivityMigrationMapping.OneToOneMapping oneToOne2 = ProcessInstanceActivityMigrationMapping.createMappingFor("originalActivity2", "newActivity2");

        Map<String, Object> localVariables = new HashMap<String, Object>() {

            {
                put("variableString", "stringValue");
                put("variableNumber", 12345);
            }
        };

        String jsonAsStr = IoUtil.readFileAsString("org/flowable/engine/test/api/runtime/migration/processInstanceMigrationDocumentWithVariables.json");

        ProcessInstanceMigrationDocument migrationDocument = ProcessInstanceMigrationDocumentImpl.fromProcessInstanceMigrationDocumentJson(jsonAsStr);

        assertEquals(definitionId, migrationDocument.getMigrateToProcessDefinitionId());
        assertEquals(definitionKey, migrationDocument.getMigrateToProcessDefinitionKey());
        assertEquals(definitionVer, migrationDocument.getMigrateToProcessDefinitionVersion());
        assertEquals(definitionTenantId, migrationDocument.getMigrateToProcessDefinitionTenantId());
        assertThat(migrationDocument.getActivityMigrationMappings()).usingFieldByFieldElementComparator().containsExactly(oneToOne1, oneToOne2);
        assertThat(migrationDocument.getActivitiesLocalVariables()).containsKey("newActivity1");
        Map<String, Object> activity1LocalVariables = migrationDocument.getActivitiesLocalVariables().get("newActivity1");
        assertThat(activity1LocalVariables).isEqualTo(localVariables);
    }

    @Test
    @Disabled("Missing validation to avoid repeating source mapping?")
    public void testSerializeDeSerializeProcessInstanceMigrationDocumentForDefinitionId2() {

        String definitionId = "someProcessId";
        List<String> instancesIds = Arrays.asList("123", "234", "567");
        List<ProcessInstanceActivityMigrationMapping> activityMappings = new ArrayList<>();
        activityMappings.add(ProcessInstanceActivityMigrationMapping.createMappingFor("originalActivity1", "newActivity1"));
        activityMappings.add(ProcessInstanceActivityMigrationMapping.createMappingFor("originalActivity2", "newActivity2"));

        HashMap newActivity2xVars = new HashMap<String, Object>() {

            {
                put("var1ForNewActivity2.x", "varValue");
                put("var2ForNewActivity2.x", 1234.567);
            }
        };

        //TODO WIP - validate that src/from activity is mapped only once
        ProcessInstanceMigrationDocument document = new ProcessInstanceMigrationBuilderImpl(null)
            .migrateToProcessDefinition(definitionId)
            .addActivityMigrationMapping("originalActivity1", "newActivity1", "varForNewActivity1", "varValue")
            .addActivityMigrationMapping("originalActivity1", "newActivity1", "varForNewActivity1", "varValue")
            .addActivityMigrationMapping("originalActivity2", Arrays.asList("newActivity2.1", "newActivity2.2"), newActivity2xVars)
            .addActivityMigrationMapping(Arrays.asList("originalActivity3", "originalActivity4"), "newActivity3", "varForNewActivity3", 9876)
            .withProcessInstanceVariable("processVar1", "varValue1")
            .withProcessInstanceVariable("processVar2", 456.789)
            .getProcessInstanceMigrationDocument();

        //Serialize the document as Json
        String serializedDocument = document.asJsonString();

        //DeSerialize the document
        ProcessInstanceMigrationDocument migrationDocument = ProcessInstanceMigrationDocumentImpl.fromProcessInstanceMigrationDocumentJson(serializedDocument);

        assertEquals(definitionId, migrationDocument.getMigrateToProcessDefinitionId());
        assertNull(migrationDocument.getMigrateToProcessDefinitionKey());
        assertNull(migrationDocument.getMigrateToProcessDefinitionVersion());
        assertNull(migrationDocument.getMigrateToProcessDefinitionTenantId());
        assertThat(migrationDocument.getActivityMigrationMappings()).isEqualTo(activityMappings);
    }

    @Test
    public void testSerializeDeSerializeProcessInstanceMigrationDocumentForDefinitionKeyVersion() {

        String definitionKey = "MyProcessKey";
        Integer definitionVer = 5;
        String definitionTenantId = "admin";
        ProcessInstanceActivityMigrationMapping.OneToOneMapping oneToOne1 = ProcessInstanceActivityMigrationMapping.createMappingFor("originalActivity1", "newActivity1");
        ProcessInstanceActivityMigrationMapping.OneToOneMapping oneToOne2 = ProcessInstanceActivityMigrationMapping.createMappingFor("originalActivity2", "newActivity2");

        //Build a process migration document
        ProcessInstanceMigrationDocument document = new ProcessInstanceMigrationBuilderImpl(null)
            .migrateToProcessDefinition(definitionKey, definitionVer)
            .withMigrateToProcessDefinitionTenantId(definitionTenantId)
            .addActivityMigrationMapping("originalActivity1", "newActivity1")
            .addActivityMigrationMapping("originalActivity2", "newActivity2")
            .getProcessInstanceMigrationDocument();

        //Serialize the document as Json
        String serializedDocument = document.asJsonString();

        //DeSerialize the document
        ProcessInstanceMigrationDocument migrationDocument = ProcessInstanceMigrationDocumentImpl.fromProcessInstanceMigrationDocumentJson(serializedDocument);

        assertNull(migrationDocument.getMigrateToProcessDefinitionId());
        assertEquals(definitionKey, migrationDocument.getMigrateToProcessDefinitionKey());
        assertEquals(definitionVer, migrationDocument.getMigrateToProcessDefinitionVersion());
        assertEquals(definitionTenantId, migrationDocument.getMigrateToProcessDefinitionTenantId());
        assertThat(migrationDocument.getActivityMigrationMappings()).usingFieldByFieldElementComparator().containsExactly(oneToOne1, oneToOne2);
    }

    @Test
    public void testSerializeDeSerializeProcessInstanceMigrationDocumentWithVariables() {
        String definitionKey = "MyProcessKey";
        Integer definitionVer = 5;
        String definitionTenantId = "admin";

        ProcessInstanceActivityMigrationMapping.OneToOneMapping oneToOne1 = ProcessInstanceActivityMigrationMapping.createMappingFor("originalActivity1", "newActivity1");
        ProcessInstanceActivityMigrationMapping.OneToOneMapping oneToOne2 = ProcessInstanceActivityMigrationMapping.createMappingFor("originalActivity2", "newActivity2");

        HashMap processInstanceVars = new HashMap<String, Object>() {

            {
                put("instanceVar1", "stringValue");
                put("instanceVar2", 12345.6789);
            }
        };

        //Build a process migration document
        ProcessInstanceMigrationDocument document = new ProcessInstanceMigrationBuilderImpl(null)
            .migrateToProcessDefinition(definitionKey, definitionVer)
            .withMigrateToProcessDefinitionTenantId(definitionTenantId)
            .addActivityMigrationMapping("originalActivity1", "newActivity1", Collections.singletonMap("variableString", "variableValue"))
            .addActivityMigrationMapping("originalActivity2", "newActivity2", Collections.singletonMap("variableDouble", 12345.6789))
            .withProcessInstanceVariable("instanceVar1", "stringValue")
            .withProcessInstanceVariable("instanceVar2", 12345.6789)
            .getProcessInstanceMigrationDocument();

        //Serialize the document as Json
        String serializedDocument = document.asJsonString();

        //DeSerialize the document
        ProcessInstanceMigrationDocument migrationDocument = ProcessInstanceMigrationDocumentImpl.fromProcessInstanceMigrationDocumentJson(serializedDocument);

        assertNull(migrationDocument.getMigrateToProcessDefinitionId());
        assertEquals(definitionKey, migrationDocument.getMigrateToProcessDefinitionKey());
        assertEquals(definitionVer, migrationDocument.getMigrateToProcessDefinitionVersion());
        assertEquals(definitionTenantId, migrationDocument.getMigrateToProcessDefinitionTenantId());
        assertThat(migrationDocument.getActivityMigrationMappings()).usingFieldByFieldElementComparator().containsExactly(oneToOne1, oneToOne2);
        assertThat(migrationDocument.getActivitiesLocalVariables()).containsKeys("newActivity1", "newActivity2");
        assertThat(migrationDocument.getActivitiesLocalVariables().get("newActivity1")).isEqualTo((Collections.singletonMap("variableString", "variableValue")));
        assertThat(migrationDocument.getActivitiesLocalVariables().get("newActivity2")).isEqualTo((Collections.singletonMap("variableDouble", 12345.6789)));
        assertThat(migrationDocument.getProcessInstanceVariables()).isEqualTo(processInstanceVars);

    }

    @Test
    public void testSerializeDeSerializeProcessInstanceMigrationDocumentWithSimpleLocalVariablesFluent() {
        String definitionKey = "MyProcessKey";
        Integer definitionVer = 5;
        String definitionTenantId = "admin";
        ProcessInstanceActivityMigrationMapping.OneToOneMapping oneToOne1 = ProcessInstanceActivityMigrationMapping.createMappingFor("originalActivity1", "newActivity1");
        ProcessInstanceActivityMigrationMapping.OneToOneMapping oneToOne2 = ProcessInstanceActivityMigrationMapping.createMappingFor("originalActivity2", "newActivity2");

        Map<String, Object> processInstanceVars = new HashMap<String, Object>() {

            {
                put("instanceVar1", "stringValue");
                put("instanceVar2", 12345.6789);
            }
        };

        //Build a process migration document
        ProcessInstanceMigrationDocument document = new ProcessInstanceMigrationBuilderImpl(null)
            .migrateToProcessDefinition(definitionKey, definitionVer)
            .withMigrateToProcessDefinitionTenantId(definitionTenantId)
            .addActivityMigrationMapping("originalActivity1", "newActivity1", "variableString", "variableValue")
            .addActivityMigrationMapping("originalActivity2", "newActivity2", Collections.singletonMap("variableDouble", 12345.6789))
            .withProcessInstanceVariables(processInstanceVars)
            .getProcessInstanceMigrationDocument();

        //Serialize the document as Json
        String serializedDocument = document.asJsonString();

        //DeSerialize the document
        ProcessInstanceMigrationDocument migrationDocument = ProcessInstanceMigrationDocumentImpl.fromProcessInstanceMigrationDocumentJson(serializedDocument);

        assertNull(migrationDocument.getMigrateToProcessDefinitionId());
        assertEquals(definitionKey, migrationDocument.getMigrateToProcessDefinitionKey());
        assertEquals(definitionVer, migrationDocument.getMigrateToProcessDefinitionVersion());
        assertEquals(definitionTenantId, migrationDocument.getMigrateToProcessDefinitionTenantId());
        assertThat(migrationDocument.getActivityMigrationMappings()).usingFieldByFieldElementComparator().containsExactly(oneToOne1, oneToOne2);
        assertThat(migrationDocument.getActivitiesLocalVariables()).containsKeys("newActivity1", "newActivity2");
        assertThat(migrationDocument.getActivitiesLocalVariables().get("newActivity1")).isEqualTo((Collections.singletonMap("variableString", "variableValue")));
        assertThat(migrationDocument.getActivitiesLocalVariables().get("newActivity2")).isEqualTo((Collections.singletonMap("variableDouble", 12345.6789)));
        assertThat(migrationDocument.getProcessInstanceVariables()).isEqualTo(processInstanceVars);
    }

    //TODO WIP - More tests for document mapping combinations??

}
