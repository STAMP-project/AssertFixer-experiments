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
package com.helger.validator.ui;

import java.time.LocalDateTime;
import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.datetime.PDTToString;
import com.helger.commons.type.ITypedObject;
import com.helger.commons.url.ISimpleURL;
import com.helger.html.hc.IHCNode;
import com.helger.html.hc.html.textlevel.HCA;
import com.helger.html.hc.impl.HCNodeList;
import com.helger.html.hc.impl.HCTextNode;
import com.helger.html.jquery.JQueryAjaxBuilder;
import com.helger.html.jscode.JSAssocArray;
import com.helger.photon.basic.app.menu.IMenuObject;
import com.helger.photon.basic.app.request.RequestParameterHandlerURLPathNamed;
import com.helger.photon.basic.app.request.RequestParameterManager;
import com.helger.photon.bootstrap3.ext.BootstrapSystemMessage;
import com.helger.photon.bootstrap3.pages.BootstrapPagesMenuConfigurator;
import com.helger.photon.bootstrap3.uictrls.datatables.BootstrapDataTables;
import com.helger.photon.security.mgr.PhotonSecurityManager;
import com.helger.photon.security.role.IRole;
import com.helger.photon.security.user.IUser;
import com.helger.photon.security.usergroup.IUserGroup;
import com.helger.photon.security.util.SecurityHelper;
import com.helger.photon.uicore.css.CPageParam;
import com.helger.photon.uicore.page.IWebPageExecutionContext;
import com.helger.photon.uictrls.datatables.DataTablesLengthMenu;
import com.helger.photon.uictrls.datatables.EDataTablesFilterType;
import com.helger.photon.uictrls.datatables.ajax.AjaxExecutorDataTables;
import com.helger.photon.uictrls.datatables.ajax.AjaxExecutorDataTablesI18N;
import com.helger.photon.uictrls.datatables.plugins.DataTablesPluginSearchHighlight;
import com.helger.validator.app.ajax.CAjax;
import com.helger.web.scope.IRequestWebScopeWithoutResponse;

@Immutable
public final class AppCommonUI
{
  private static final DataTablesLengthMenu LENGTH_MENU = new DataTablesLengthMenu ().addItem (25)
                                                                                     .addItem (50)
                                                                                     .addItem (100)
                                                                                     .addItemAll ();

  private AppCommonUI ()
  {}

  public static void init ()
  {
    RequestParameterManager.getInstance ().setParameterHandler (new RequestParameterHandlerURLPathNamed ());

    BootstrapDataTables.setConfigurator ( (aLEC, aTable, aDataTables) -> {
      final IRequestWebScopeWithoutResponse aRequestScope = aLEC.getRequestScope ();
      aDataTables.setAutoWidth (false)
                 .setLengthMenu (LENGTH_MENU)
                 .setAjaxBuilder (new JQueryAjaxBuilder ().url (CAjax.DATATABLES.getInvocationURL (aRequestScope))
                                                          .data (new JSAssocArray ().add (AjaxExecutorDataTables.OBJECT_ID,
                                                                                          aTable.getID ())))
                 .setServerFilterType (EDataTablesFilterType.ALL_TERMS_PER_ROW)
                 .setTextLoadingURL (CAjax.DATATABLES_I18N.getInvocationURL (aRequestScope),
                                     AjaxExecutorDataTablesI18N.LANGUAGE_ID)
                 .addPlugin (new DataTablesPluginSearchHighlight ());
    });

    // By default allow markdown in system message
    BootstrapSystemMessage.setDefaultUseMarkdown (true);
  }

  @Nullable
  public static IHCNode getDTAndUser (@Nonnull final IWebPageExecutionContext aWPEC,
                                      @Nullable final LocalDateTime aDateTime,
                                      @Nullable final String sUserID)
  {
    final Locale aDisplayLocale = aWPEC.getDisplayLocale ();

    String sDateTime = null;
    if (aDateTime != null)
      sDateTime = PDTToString.getAsString (aDateTime, aDisplayLocale);
    IHCNode aUserName = null;
    if (sUserID != null)
    {
      final IUser aUser = PhotonSecurityManager.getUserMgr ().getUserOfID (sUserID);
      aUserName = createViewLink (aWPEC, aUser);
    }

    if (sDateTime != null)
    {
      if (aUserName != null)
      {
        // Date and user
        return new HCNodeList ().addChildren (new HCTextNode ("on " + sDateTime + " by "), aUserName);
      }

      // Date only
      return new HCTextNode ("on  " + sDateTime);
    }

    if (aUserName != null)
    {
      // User only
      return new HCNodeList ().addChildren (new HCTextNode ("by "), aUserName);
    }

    // Neither nor
    return null;
  }

  @Nonnull
  public static ISimpleURL getViewLink (@Nonnull final IWebPageExecutionContext aWPEC,
                                        @Nonnull @Nonempty final String sMenuItemID,
                                        @Nonnull final ITypedObject <String> aObject)
  {
    ValueEnforcer.notNull (aObject, "Object");

    return getViewLink (aWPEC, sMenuItemID, aObject.getID ());
  }

  @Nonnull
  public static ISimpleURL getViewLink (@Nonnull final IWebPageExecutionContext aWPEC,
                                        @Nonnull @Nonempty final String sMenuItemID,
                                        @Nonnull final String sObjectID)
  {
    return aWPEC.getLinkToMenuItem (sMenuItemID)
                .add (CPageParam.PARAM_ACTION, CPageParam.ACTION_VIEW)
                .add (CPageParam.PARAM_OBJECT, sObjectID);
  }

  @Nonnull
  public static IHCNode createViewLink (@Nonnull final IWebPageExecutionContext aWPEC,
                                        @Nullable final ITypedObject <String> aObject)
  {
    return createViewLink (aWPEC, aObject, null);
  }

  @Nonnull
  public static IHCNode createViewLink (@Nonnull final IWebPageExecutionContext aWPEC,
                                        @Nullable final ITypedObject <String> aObject,
                                        @Nullable final String sDisplayName)
  {
    if (aObject == null)
      return HCTextNode.createOnDemand (sDisplayName);

    final Locale aDisplayLocale = aWPEC.getDisplayLocale ();

    if (aObject instanceof IRole)
    {
      final IRole aTypedObj = (IRole) aObject;
      final String sRealDisplayName = sDisplayName != null ? sDisplayName : aTypedObj.getName ();
      final String sMenuItemID = BootstrapPagesMenuConfigurator.MENU_ADMIN_SECURITY_ROLE;
      final IMenuObject aObj = aWPEC.getMenuTree ().getItemDataWithID (sMenuItemID);
      if (aObj != null && aObj.matchesDisplayFilter ())
        return new HCA (getViewLink (aWPEC, sMenuItemID, aTypedObj)).addChild (sRealDisplayName)
                                                                    .setTitle ("Show details of role '" +
                                                                               sRealDisplayName +
                                                                               "'");
      return new HCTextNode (sRealDisplayName);
    }

    if (aObject instanceof IUser)
    {
      final IUser aTypedObj = (IUser) aObject;
      final String sRealDisplayName = sDisplayName != null ? sDisplayName
                                                           : SecurityHelper.getUserDisplayName (aTypedObj,
                                                                                                aDisplayLocale);
      final String sMenuItemID = BootstrapPagesMenuConfigurator.MENU_ADMIN_SECURITY_USER;
      final IMenuObject aObj = aWPEC.getMenuTree ().getItemDataWithID (sMenuItemID);
      if (aObj != null && aObj.matchesDisplayFilter ())
        return new HCA (getViewLink (aWPEC, sMenuItemID, aTypedObj)).addChild (sRealDisplayName)
                                                                    .setTitle ("Show details of user '" +
                                                                               sRealDisplayName +
                                                                               "'");
      return new HCTextNode (sRealDisplayName);
    }
    if (aObject instanceof IUserGroup)
    {
      final IUserGroup aTypedObj = (IUserGroup) aObject;
      final String sRealDisplayName = sDisplayName != null ? sDisplayName : aTypedObj.getName ();
      final String sMenuItemID = BootstrapPagesMenuConfigurator.MENU_ADMIN_SECURITY_USER_GROUP;
      final IMenuObject aObj = aWPEC.getMenuTree ().getItemDataWithID (sMenuItemID);
      if (aObj != null && aObj.matchesDisplayFilter ())
        return new HCA (getViewLink (aWPEC, sMenuItemID, aTypedObj)).addChild (sRealDisplayName)
                                                                    .setTitle ("Show details of user group '" +
                                                                               sRealDisplayName +
                                                                               "'");
      return new HCTextNode (sRealDisplayName);
    }

    // add other types as desired
    throw new IllegalArgumentException ("Unsupported object: " + aObject);
  }
}
