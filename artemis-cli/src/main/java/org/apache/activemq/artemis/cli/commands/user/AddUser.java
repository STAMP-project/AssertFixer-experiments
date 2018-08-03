/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.artemis.cli.commands.user;

import io.airlift.airline.Command;
import io.airlift.airline.Option;
import org.apache.activemq.artemis.cli.commands.ActionContext;
import org.apache.activemq.artemis.cli.commands.util.HashUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * Adding a new user, example:
 * ./artemis user add --username guest --role admin --password ***
 */
@Command(name = "add", description = "Add a new user")
public class AddUser extends PasswordAction {

   @Option(name = "--plaintext", description = "using plaintext (Default false)")
   boolean plaintext = false;

   @Override
   public Object execute(ActionContext context) throws Exception {
      super.execute(context);

      checkInputUser();
      checkInputPassword();
      checkInputRole();

      String hash = plaintext ? password : HashUtil.tryHash(context, password);
      add(hash, StringUtils.split(role, ","));

      return null;
   }

   /**
    * Adding a new user
    * @param hash the password
    * @param role the role
    * @throws IllegalArgumentException if user exists
    */
   private void add(String hash, String... role) throws Exception {
      FileBasedSecStoreConfig config = getConfiguration();
      config.addNewUser(username, hash, role);
      config.save();
      context.out.println("User added successfully.");
   }
}
