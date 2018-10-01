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
package org.flowable.engine.migration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author Dennis
 */
@JsonDeserialize(using = ProcessInstanceActivityMigrationMapping.ProcessInstanceActivityMigrationMappingDeSerializer.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class ProcessInstanceActivityMigrationMapping {

    public static enum MappingType {ONE_TO_ONE, ONE_TO_MANY, MANY_TO_ONE}

    @JsonIgnore
    protected final MappingType mappingType;

    protected String newAssignee;

    public ProcessInstanceActivityMigrationMapping(MappingType mappingType) {
        this.mappingType = mappingType;
    }

    public MappingType getMappingType() {
        return mappingType;
    }

    public abstract List<String> getFromActivityIds();

    public abstract List<String> getToActivityIds();

    public String getNewAssignee() {
        return newAssignee;
    }

    @SuppressWarnings("unchecked")
    public <T extends ProcessInstanceActivityMigrationMapping> T setNewAssignee(String newAssignee) {
        this.newAssignee = newAssignee;
        return (T) this;
    }

    public static ProcessInstanceActivityMigrationMapping.OneToOneMapping createMappingFor(String fromActivityId, String toActivityId) {
        return new OneToOneMapping(fromActivityId, toActivityId);
    }

    public static ProcessInstanceActivityMigrationMapping.OneToManyMapping createMappingFor(String fromActivityId, List<String> toActivityIds) {
        return new OneToManyMapping(fromActivityId, toActivityIds);
    }

    public static ProcessInstanceActivityMigrationMapping.ManyToOneMapping createMappingFor(List<String> fromActivityIds, String toActivityId) {
        return new ManyToOneMapping(fromActivityIds, toActivityId);
    }

    @JsonDeserialize(as = OneToOneMapping.class)
    public static class OneToOneMapping extends ProcessInstanceActivityMigrationMapping {

        public String fromActivityId;
        public String toActivityId;

        @JsonCreator
        public OneToOneMapping(@JsonProperty("fromActivityId") String fromActivityId, @JsonProperty("toActivityId") String toActivityId) {
            super(MappingType.ONE_TO_ONE);
            this.fromActivityId = fromActivityId;
            this.toActivityId = toActivityId;
        }

        @Override
        @JsonIgnore
        public List<String> getFromActivityIds() {
            ArrayList<String> list = new ArrayList<>();
            list.add(fromActivityId);
            return list;
        }

        @Override
        @JsonIgnore
        public List<String> getToActivityIds() {
            ArrayList<String> list = new ArrayList<>();
            list.add(toActivityId);
            return list;
        }

        public String getFromActivityId() {
            return fromActivityId;
        }

        public String getToActivityId() {
            return toActivityId;
        }

        @Override
        public String toString() {
            return "OneToOneMapping{" + "fromActivityId='" + fromActivityId + '\'' + ", toActivityId='" + toActivityId + '\'' + '}';
        }
    }

    @JsonDeserialize(as = OneToManyMapping.class)
    public static class OneToManyMapping extends ProcessInstanceActivityMigrationMapping {

        public String fromActivityId;
        public List<String> toActivityIds;

        @JsonCreator
        public OneToManyMapping(@JsonProperty("fromActivityId") String fromActivityId, @JsonProperty("toActivityIds") List<String> toActivityIds) {
            super(MappingType.ONE_TO_MANY);
            this.fromActivityId = fromActivityId;
            this.toActivityIds = toActivityIds;
        }

        @Override
        @JsonIgnore
        public List<String> getFromActivityIds() {
            ArrayList<String> list = new ArrayList<>();
            list.add(fromActivityId);
            return list;
        }

        @Override
        public List<String> getToActivityIds() {
            return new ArrayList<>(toActivityIds);
        }

        public String getFromActivityId() {
            return fromActivityId;
        }

        @Override
        public String toString() {
            return "OneToManyMapping{" + "mappingType=" + mappingType + ", fromActivityId='" + fromActivityId + '\'' + ", toActivityIds=" + toActivityIds + '}';
        }
    }

    @JsonDeserialize(as = ManyToOneMapping.class)
    public static class ManyToOneMapping extends ProcessInstanceActivityMigrationMapping {

        public List<String> fromActivityIds;
        public String toActivityId;

        @JsonCreator
        public ManyToOneMapping(@JsonProperty("fromActivityIds") List<String> fromActivityIds, @JsonProperty("toActivityId") String toActivityId) {
            super(MappingType.MANY_TO_ONE);
            this.fromActivityIds = fromActivityIds;
            this.toActivityId = toActivityId;
        }

        @Override
        public List<String> getFromActivityIds() {
            return new ArrayList<>(fromActivityIds);
        }

        @Override
        @JsonIgnore
        public List<String> getToActivityIds() {
            ArrayList<String> list = new ArrayList<>();
            list.add(toActivityId);
            return list;
        }

        public String getToActivityId() {
            return toActivityId;
        }

        @Override
        public String toString() {
            return "ManyToOneMapping{" + "fromActivityIds=" + fromActivityIds + ", toActivityId='" + toActivityId + '\'' + '}';
        }
    }

    public static class ProcessInstanceActivityMigrationMappingDeSerializer extends JsonDeserializer<ProcessInstanceActivityMigrationMapping> {

        @Override
        public ProcessInstanceActivityMigrationMapping deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            //TODO WIP - Check type of element??
            BitSet flags = new BitSet(4);
            ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
            ObjectNode root = mapper.readTree(jsonParser);
            Class<? extends ProcessInstanceActivityMigrationMapping> mappingClass = null;
            Iterator<Map.Entry<String, JsonNode>> elementsIterator = root.fields();
            while (elementsIterator.hasNext()) {
                Map.Entry<String, JsonNode> element = elementsIterator.next();
                String name = element.getKey();
                switch (name) {
                    case "fromActivityId":
                        flags.set(0);
                        break;
                    case "fromActivityIds":
                        flags.set(1);
                        break;
                    case "toActivityId":
                        flags.set(2);
                        break;
                    case "toActivityIds":
                        flags.set(3);
                        break;
                }
            }
            System.out.printf(flags.toString());
            if (flags.get(0) && flags.get(2)) {
                mappingClass = OneToOneMapping.class;
            }
            if (flags.get(0) && flags.get(3)) {
                mappingClass = OneToManyMapping.class;
            }
            if (flags.get(1) && flags.get(2)) {
                mappingClass = ManyToOneMapping.class;
            }
            if (mappingClass == null) {
                return null;
            }
            return mapper.treeToValue(root, mappingClass);
        }
    }
}