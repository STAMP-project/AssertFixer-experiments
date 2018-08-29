/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.atlas.provenance.lineage;

import org.apache.nifi.atlas.NiFiFlow;
import org.apache.nifi.atlas.provenance.AnalysisContext;
import org.apache.nifi.provenance.ProvenanceEventRecord;
import org.apache.nifi.provenance.ProvenanceEventType;

public interface LineageStrategy {

    default ProvenanceEventType[] getTargetEventTypes(){
        return new ProvenanceEventType[0];
    }

    void setLineageContext(LineageContext lineageContext);

    void processEvent(AnalysisContext analysisContext, NiFiFlow nifiFlow, ProvenanceEventRecord event);

}
