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

package org.flowable.job.service.impl.asyncexecutor.multitenant;

import java.util.Set;

import org.flowable.job.service.impl.asyncexecutor.AsyncExecutor;

/**
 * Interface for {@link AsyncExecutor} implementations used in conjunction with the MultiSchemaMultiTenantProcessEngineConfiguration. Allows to dynamically add tenant executors to the engine.
 * 
 * @author Joram Barrez
 */
public interface TenantAwareAsyncExecutor extends AsyncExecutor {

    Set<String> getTenantIds();

    void addTenantAsyncExecutor(String tenantId, boolean startExecutor);

    AsyncExecutor getTenantAsyncExecutor(String tenantId);
    
    void removeTenantAsyncExecutor(String tenantId);

}
