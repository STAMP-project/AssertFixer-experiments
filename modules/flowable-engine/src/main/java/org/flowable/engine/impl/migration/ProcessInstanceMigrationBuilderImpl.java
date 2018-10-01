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

package org.flowable.engine.impl.migration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.migration.ProcessInstanceActivityMigrationMapping;
import org.flowable.engine.migration.ProcessInstanceMigrationBuilder;
import org.flowable.engine.migration.ProcessInstanceMigrationDocument;

/**
 * @author Dennis Federico
 */
public class ProcessInstanceMigrationBuilderImpl implements ProcessInstanceMigrationBuilder {

    protected RuntimeService runtimeService;
    protected ProcessInstanceMigrationDocumentBuilderImpl migrationDocumentBuilder = new ProcessInstanceMigrationDocumentBuilderImpl();

    public ProcessInstanceMigrationBuilderImpl(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @Override
    public ProcessInstanceMigrationBuilder fromProcessInstanceMigrationDocument(ProcessInstanceMigrationDocument document) {
        migrationDocumentBuilder.setProcessDefinitionToMigrateTo(document.getMigrateToProcessDefinitionId());
        migrationDocumentBuilder.setProcessDefinitionToMigrateTo(document.getMigrateToProcessDefinitionKey(), document.getMigrateToProcessDefinitionVersion());
        migrationDocumentBuilder.setTenantId(document.getMigrateToProcessDefinitionTenantId());
        migrationDocumentBuilder.addActivityMigrationMappings(document.getActivityMigrationMappings());
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder migrateToProcessDefinition(String processDefinitionId) {
        this.migrationDocumentBuilder.setProcessDefinitionToMigrateTo(processDefinitionId);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder migrateToProcessDefinition(String processDefinitionKey, int processDefinitionVersion) {
        this.migrationDocumentBuilder.setProcessDefinitionToMigrateTo(processDefinitionKey, processDefinitionVersion);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder migrateToProcessDefinition(String processDefinitionKey, int processDefinitionVersion, String processDefinitionTenantId) {
        this.migrationDocumentBuilder.setProcessDefinitionToMigrateTo(processDefinitionKey, processDefinitionVersion);
        this.migrationDocumentBuilder.setTenantId(processDefinitionTenantId);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder withMigrateToProcessDefinitionTenantId(String processDefinitionTenantId) {
        this.migrationDocumentBuilder.setTenantId(processDefinitionTenantId);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(String fromActivityId, String toActivityId) {
        ProcessInstanceActivityMigrationMapping.OneToOneMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityId, toActivityId);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(String fromActivityId, String toActivityId, String newAssigneeId) {
        ProcessInstanceActivityMigrationMapping.OneToOneMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityId, toActivityId);
        mapping.setNewAssignee(newAssigneeId);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(String fromActivityId, String toActivityId, String variableName, Object variableValue) {
        ProcessInstanceActivityMigrationMapping.OneToOneMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityId, toActivityId);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        Map<String, Object> activityVariables = this.migrationDocumentBuilder.activitiesLocalVariables.computeIfAbsent(toActivityId, k -> new HashMap<>());
        activityVariables.put(variableName, variableValue);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(String fromActivityId, String toActivityId, String variableName, Object variableValue, String newAssigneeId) {
        ProcessInstanceActivityMigrationMapping.OneToOneMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityId, toActivityId);
        mapping.setNewAssignee(newAssigneeId);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        Map<String, Object> activityVariables = this.migrationDocumentBuilder.activitiesLocalVariables.computeIfAbsent(toActivityId, k -> new HashMap<>());
        activityVariables.put(variableName, variableValue);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(String fromActivityId, String toActivityId, Map<String, Object> localVariables) {
        ProcessInstanceActivityMigrationMapping.OneToOneMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityId, toActivityId);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        Map<String, Object> activityVariables = this.migrationDocumentBuilder.activitiesLocalVariables.computeIfAbsent(toActivityId, k -> new HashMap<>());
        activityVariables.putAll(localVariables);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(String fromActivityId, String toActivityId, Map<String, Object> localVariables, String newAssigneeId) {
        ProcessInstanceActivityMigrationMapping.OneToOneMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityId, toActivityId);
        mapping.setNewAssignee(newAssigneeId);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        Map<String, Object> activityVariables = this.migrationDocumentBuilder.activitiesLocalVariables.computeIfAbsent(toActivityId, k -> new HashMap<>());
        activityVariables.putAll(localVariables);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(String fromActivityId, List<String> toActivityIds) {
        ProcessInstanceActivityMigrationMapping.OneToManyMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityId, toActivityIds);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(String fromActivityId, List<String> toActivityIds, String newAssigneeId) {
        ProcessInstanceActivityMigrationMapping.OneToManyMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityId, toActivityIds);
        mapping.setNewAssignee(newAssigneeId);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(String fromActivityId, List<String> toActivityIds, String variableName, Object variableValue) {
        ProcessInstanceActivityMigrationMapping.OneToManyMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityId, toActivityIds);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        toActivityIds.forEach(activityId -> {
            Map<String, Object> activityVariables = this.migrationDocumentBuilder.activitiesLocalVariables.computeIfAbsent(activityId, k -> new HashMap<>());
            activityVariables.put(variableName, variableValue);
        });
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(String fromActivityId, List<String> toActivityIds, String variableName, Object variableValue, String newAssigneeId) {
        ProcessInstanceActivityMigrationMapping.OneToManyMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityId, toActivityIds);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        toActivityIds.forEach(activityId -> {
            Map<String, Object> activityVariables = this.migrationDocumentBuilder.activitiesLocalVariables.computeIfAbsent(activityId, k -> new HashMap<>());
            activityVariables.put(variableName, variableValue);
        });
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(String fromActivityId, List<String> toActivityIds, Map<String, Object> localVariables) {
        ProcessInstanceActivityMigrationMapping.OneToManyMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityId, toActivityIds);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        toActivityIds.forEach(activityId -> {
            Map<String, Object> activityVariables = this.migrationDocumentBuilder.activitiesLocalVariables.computeIfAbsent(activityId, k -> new HashMap<>());
            activityVariables.putAll(localVariables);
        });
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(String fromActivityId, List<String> toActivityIds, Map<String, Object> localVariables, String newAssigneeId) {
        ProcessInstanceActivityMigrationMapping.OneToManyMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityId, toActivityIds);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        mapping.setNewAssignee(newAssigneeId);
        toActivityIds.forEach(activityId -> {
            Map<String, Object> activityVariables = this.migrationDocumentBuilder.activitiesLocalVariables.computeIfAbsent(activityId, k -> new HashMap<>());
            activityVariables.putAll(localVariables);
        });
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(List<String> fromActivityIds, String toActivityId) {
        ProcessInstanceActivityMigrationMapping.ManyToOneMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityIds, toActivityId);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(List<String> fromActivityIds, String toActivityId, String newAssigneeId) {
        ProcessInstanceActivityMigrationMapping.ManyToOneMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityIds, toActivityId);
        mapping.setNewAssignee(newAssigneeId);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(List<String> fromActivityIds, String toActivityId, String variableName, Object variableValue) {
        ProcessInstanceActivityMigrationMapping.ManyToOneMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityIds, toActivityId);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        Map<String, Object> activityVariables = this.migrationDocumentBuilder.activitiesLocalVariables.computeIfAbsent(toActivityId, k -> new HashMap<>());
        activityVariables.put(variableName, variableValue);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(List<String> fromActivityIds, String toActivityId, String variableName, Object variableValue, String newAssigneeId) {
        ProcessInstanceActivityMigrationMapping.ManyToOneMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityIds, toActivityId);
        mapping.setNewAssignee(newAssigneeId);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        Map<String, Object> activityVariables = this.migrationDocumentBuilder.activitiesLocalVariables.computeIfAbsent(toActivityId, k -> new HashMap<>());
        activityVariables.put(variableName, variableValue);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(List<String> fromActivityIds, String toActivityId, Map<String, Object> localVariables) {
        ProcessInstanceActivityMigrationMapping.ManyToOneMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityIds, toActivityId);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        Map<String, Object> activityVariables = this.migrationDocumentBuilder.activitiesLocalVariables.computeIfAbsent(toActivityId, k -> new HashMap<>());
        activityVariables.putAll(localVariables);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder addActivityMigrationMapping(List<String> fromActivityIds, String toActivityId, Map<String, Object> localVariables, String newAssigneeId) {
        ProcessInstanceActivityMigrationMapping.ManyToOneMapping mapping = ProcessInstanceActivityMigrationMapping.createMappingFor(fromActivityIds, toActivityId);
        mapping.setNewAssignee(newAssigneeId);
        this.migrationDocumentBuilder.addActivityMigrationMapping(mapping);
        Map<String, Object> activityVariables = this.migrationDocumentBuilder.activitiesLocalVariables.computeIfAbsent(toActivityId, k -> new HashMap<>());
        activityVariables.putAll(localVariables);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder withProcessInstanceVariable(String variableName, Object variableValue) {
        this.migrationDocumentBuilder.processInstanceVariables.put(variableName, variableValue);
        return this;
    }

    @Override
    public ProcessInstanceMigrationBuilder withProcessInstanceVariables(Map<String, Object> variables) {
        this.migrationDocumentBuilder.processInstanceVariables.putAll(variables);
        return this;
    }

    @Override
    public ProcessInstanceMigrationDocument getProcessInstanceMigrationDocument() {
        return this.migrationDocumentBuilder.build();
    }

    @Override
    public void migrate(String processInstanceId) {
        ProcessInstanceMigrationDocument document = migrationDocumentBuilder.build();
        runtimeService.migrateProcessInstance(processInstanceId, document);
    }

    @Override
    public ProcessInstanceMigrationValidationResult validateMigration(String processInstanceId) {
        ProcessInstanceMigrationDocument document = migrationDocumentBuilder.build();
        return runtimeService.validateMigrationForProcessInstance(processInstanceId, document);
    }

    @Override
    public void migrateProcessInstances(String processDefinitionId) {
        ProcessInstanceMigrationDocument document = migrationDocumentBuilder.build();
        runtimeService.migrateProcessInstancesOfProcessDefinition(processDefinitionId, document);
    }

    @Override
    public ProcessInstanceMigrationValidationResult validateMigrationOfProcessInstances(String processDefinitionId) {
        ProcessInstanceMigrationDocument document = migrationDocumentBuilder.build();
        return runtimeService.validateMigrationForProcessInstancesOfProcessDefinition(processDefinitionId, document);
    }

    @Override
    public void migrateProcessInstances(String processDefinitionKey, int processDefinitionVersion, String processDefinitionTenantId) {
        ProcessInstanceMigrationDocument document = migrationDocumentBuilder.build();
        runtimeService.migrateProcessInstancesOfProcessDefinition(processDefinitionKey, processDefinitionVersion, processDefinitionTenantId, document);
    }

    @Override
    public ProcessInstanceMigrationValidationResult validateMigrationOfProcessInstances(String processDefinitionKey, int processDefinitionVersion, String processDefinitionTenantId) {
        ProcessInstanceMigrationDocument document = migrationDocumentBuilder.build();
        return runtimeService.validateMigrationForProcessInstancesOfProcessDefinition(processDefinitionKey, processDefinitionVersion, processDefinitionTenantId, document);
    }
}
