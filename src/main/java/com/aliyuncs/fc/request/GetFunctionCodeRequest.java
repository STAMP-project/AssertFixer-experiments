/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.aliyuncs.fc.request;

import com.aliyuncs.fc.constants.Const;
import com.google.common.base.Strings;

/**
 * TODO: add javadoc
 */
public class GetFunctionCodeRequest extends GetFunctionRequest {

    public GetFunctionCodeRequest(String serviceName, String functionName) {
        super(serviceName, functionName);
    }

    public String getPath() {
        if (Strings.isNullOrEmpty(getQualifier())) {
            return String.format(Const.FUNCTION_CODE_PATH, Const.API_VERSION, getServiceName(),
                getFunctionName());
        }
        else {
            return String.format(Const.FUNCTION_CODE_WITH_QUALIFIER_PATH, Const.API_VERSION,
                getServiceName(), getQualifier(), getFunctionName());
        }
    }
}
