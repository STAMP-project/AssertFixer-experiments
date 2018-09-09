/**
 * Copyright (C) 2014-2018 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.validator.app;

import javax.annotation.concurrent.Immutable;

import com.helger.photon.security.mgr.PhotonSecurityManager;
import com.helger.photon.security.role.RoleManager;
import com.helger.photon.security.user.UserManager;
import com.helger.photon.security.usergroup.UserGroupManager;

@Immutable
public final class AppSecurity
{
  private AppSecurity ()
  {}

  public static void init ()
  {
    final UserManager aUserMgr = PhotonSecurityManager.getUserMgr ();
    final UserGroupManager aUserGroupMgr = PhotonSecurityManager.getUserGroupMgr ();
    final RoleManager aRoleMgr = PhotonSecurityManager.getRoleMgr ();

    // Standard users
    if (!aUserMgr.containsWithID (CPVApp.USER_ADMINISTRATOR_ID))
    {
      final boolean bDisabled = false;
      aUserMgr.createPredefinedUser (CPVApp.USER_ADMINISTRATOR_ID,
                                     CPVApp.USER_ADMINISTRATOR_LOGINNAME,
                                     CPVApp.USER_ADMINISTRATOR_EMAIL,
                                     CPVApp.USER_ADMINISTRATOR_PASSWORD,
                                     CPVApp.USER_ADMINISTRATOR_FIRSTNAME,
                                     CPVApp.USER_ADMINISTRATOR_LASTNAME,
                                     CPVApp.USER_ADMINISTRATOR_DESCRIPTION,
                                     CPVApp.USER_ADMINISTRATOR_LOCALE,
                                     CPVApp.USER_ADMINISTRATOR_CUSTOMATTRS,
                                     bDisabled);
    }

    // Create all roles
    if (!aRoleMgr.containsWithID (CPVApp.ROLE_CONFIG_ID))
      aRoleMgr.createPredefinedRole (CPVApp.ROLE_CONFIG_ID,
                                     CPVApp.ROLE_CONFIG_NAME,
                                     CPVApp.ROLE_CONFIG_DESCRIPTION,
                                     CPVApp.ROLE_CONFIG_CUSTOMATTRS);
    if (!aRoleMgr.containsWithID (CPVApp.ROLE_VIEW_ID))
      aRoleMgr.createPredefinedRole (CPVApp.ROLE_VIEW_ID,
                                     CPVApp.ROLE_VIEW_NAME,
                                     CPVApp.ROLE_VIEW_DESCRIPTION,
                                     CPVApp.ROLE_VIEW_CUSTOMATTRS);

    // User group Administrators
    if (!aUserGroupMgr.containsWithID (CPVApp.USERGROUP_ADMINISTRATORS_ID))
    {
      aUserGroupMgr.createPredefinedUserGroup (CPVApp.USERGROUP_ADMINISTRATORS_ID,
                                               CPVApp.USERGROUP_ADMINISTRATORS_NAME,
                                               CPVApp.USERGROUP_ADMINISTRATORS_DESCRIPTION,
                                               CPVApp.USERGROUP_ADMINISTRATORS_CUSTOMATTRS);
      // Assign administrator user to administrators user group
      aUserGroupMgr.assignUserToUserGroup (CPVApp.USERGROUP_ADMINISTRATORS_ID, CPVApp.USER_ADMINISTRATOR_ID);
    }
    aUserGroupMgr.assignRoleToUserGroup (CPVApp.USERGROUP_ADMINISTRATORS_ID, CPVApp.ROLE_CONFIG_ID);
    aUserGroupMgr.assignRoleToUserGroup (CPVApp.USERGROUP_ADMINISTRATORS_ID, CPVApp.ROLE_VIEW_ID);

    // User group for Config users
    if (!aUserGroupMgr.containsWithID (CPVApp.USERGROUP_CONFIG_ID))
      aUserGroupMgr.createPredefinedUserGroup (CPVApp.USERGROUP_CONFIG_ID,
                                               CPVApp.USERGROUP_CONFIG_NAME,
                                               CPVApp.USERGROUP_CONFIG_DESCRIPTION,
                                               CPVApp.USERGROUP_CONFIG_CUSTOMATTRS);
    aUserGroupMgr.assignRoleToUserGroup (CPVApp.USERGROUP_CONFIG_ID, CPVApp.ROLE_CONFIG_ID);

    // User group for View users
    if (!aUserGroupMgr.containsWithID (CPVApp.USERGROUP_VIEW_ID))
      aUserGroupMgr.createPredefinedUserGroup (CPVApp.USERGROUP_VIEW_ID,
                                               CPVApp.USERGROUP_VIEW_NAME,
                                               CPVApp.USERGROUP_VIEW_DESCRIPTION,
                                               CPVApp.USERGROUP_VIEW_CUSTOMATTRS);
    aUserGroupMgr.assignRoleToUserGroup (CPVApp.USERGROUP_VIEW_ID, CPVApp.ROLE_VIEW_ID);
  }
}
