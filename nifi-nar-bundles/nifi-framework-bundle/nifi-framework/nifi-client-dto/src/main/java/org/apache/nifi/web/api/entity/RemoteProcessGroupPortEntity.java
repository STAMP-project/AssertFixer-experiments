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
package org.apache.nifi.web.api.entity;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModelProperty;
import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;

/**
 * A serialized representation of this class can be placed in the entity body of a request or response to or from the API. This particular entity holds a reference to a RemoteProcessGroupPortDTO.
 */
@XmlRootElement(name = "remoteProcessGroupPortEntity")
public class RemoteProcessGroupPortEntity extends ComponentEntity implements OperationPermissible {

    private RemoteProcessGroupPortDTO remoteProcessGroupPort;
    private PermissionsDTO operatePermissions;

    /**
     * The RemoteProcessGroupPortDTO that is being serialized.
     *
     * @return The RemoteProcessGroupPortDTO object
     */
    public RemoteProcessGroupPortDTO getRemoteProcessGroupPort() {
        return remoteProcessGroupPort;
    }

    public void setRemoteProcessGroupPort(RemoteProcessGroupPortDTO remoteProcessGroupPort) {
        this.remoteProcessGroupPort = remoteProcessGroupPort;
    }

    /**
     * @return The permissions for this component operations
     */
    @ApiModelProperty(
            value = "The permissions for this component operations."
    )
    @Override
    public PermissionsDTO getOperatePermissions() {
        return operatePermissions;
    }

    @Override
    public void setOperatePermissions(PermissionsDTO operatePermissions) {
        this.operatePermissions = operatePermissions;
    }
}
