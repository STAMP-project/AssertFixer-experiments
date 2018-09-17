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
package com.helger.validator.servlet;

import javax.annotation.Nonnull;
import javax.servlet.ServletContext;

import org.slf4j.bridge.SLF4JBridgeHandler;

import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.system.SystemProperties;
import com.helger.commons.vendor.VendorInfo;
import com.helger.photon.basic.app.appid.CApplicationID;
import com.helger.photon.basic.app.appid.PhotonGlobalState;
import com.helger.photon.basic.app.locale.ILocaleManager;
import com.helger.photon.basic.app.menu.MenuTree;
import com.helger.photon.basic.configfile.ConfigurationFile;
import com.helger.photon.basic.configfile.ConfigurationFileManager;
import com.helger.photon.basic.configfile.EConfigurationFileSyntax;
import com.helger.photon.bootstrap3.servlet.WebAppListenerBootstrap;
import com.helger.photon.core.ajax.IAjaxInvoker;
import com.helger.validator.app.AppInternalErrorHandler;
import com.helger.validator.app.AppSecurity;
import com.helger.validator.app.AppSettings;
import com.helger.validator.app.CPVApp;
import com.helger.validator.app.ajax.CAjax;
import com.helger.validator.app.mgr.PVMetaManager;
import com.helger.validator.app.validation.ExtValidationKeyRegistry;
import com.helger.validator.pub.MenuPublic;
import com.helger.validator.secure.MenuSecure;
import com.helger.validator.ui.AppCommonUI;

/**
 * This listener is invoked during the servlet initialization. This is basically
 * a ServletContextListener.
 *
 * @author Philip Helger
 */
public final class AppWebAppListener extends WebAppListenerBootstrap
{
  public static final String SYS_PROP_SERVLET_CONTEXT_BASE = "servletContextBase";

  @Override
  protected String getInitParameterDebug (@Nonnull final ServletContext aSC)
  {
    return AppSettings.getGlobalDebug ();
  }

  @Override
  protected String getInitParameterProduction (@Nonnull final ServletContext aSC)
  {
    return AppSettings.getGlobalProduction ();
  }

  @Override
  @Nonnull
  protected String getServletContextPath (@Nonnull final ServletContext aSC) throws IllegalStateException
  {
    // Set in MainStart
    final String ret = SystemProperties.getPropertyValueOrNull (SYS_PROP_SERVLET_CONTEXT_BASE);
    if (ret != null)
      return ret;

    return super.getServletContextPath (aSC);
  }

  @Override
  protected String getDataPath (@Nonnull final ServletContext aSC)
  {
    return AppSettings.getDataPath ();
  }

  @Override
  protected boolean shouldCheckFileAccess (@Nonnull final ServletContext aSC)
  {
    return AppSettings.isCheckFileAccess ();
  }

  @Override
  protected void initGlobalSettings ()
  {
    // JUL to SLF4J
    SLF4JBridgeHandler.removeHandlersForRootLogger ();
    SLF4JBridgeHandler.install ();

    VendorInfo.setVendorName ("Philip Helger");
    VendorInfo.setVendorURL ("http://github.com/phax/phoss-validator");
    VendorInfo.setVendorEmail ("philip@helger.com");
    VendorInfo.setVendorLocation ("Vienna, Austria");
    VendorInfo.setInceptionYear (2017);
  }

  @Override
  public void initLocales (@Nonnull final ILocaleManager aLocaleMgr)
  {
    aLocaleMgr.registerLocale (CPVApp.LOCALE_EN);
    aLocaleMgr.setDefaultLocale (CPVApp.DEFAULT_LOCALE);
  }

  @Override
  public void initAjax (@Nonnull final IAjaxInvoker aAjaxInvoker)
  {
    aAjaxInvoker.registerFunction (CAjax.DATATABLES);
    aAjaxInvoker.registerFunction (CAjax.DATATABLES_I18N);
  }

  @Override
  protected void initMenu ()
  {
    // Create all menu items
    {
      final MenuTree aMenuTree = new MenuTree ();
      MenuPublic.init (aMenuTree);
      PhotonGlobalState.state (CApplicationID.APP_ID_PUBLIC).setMenuTree (aMenuTree);
    }
    {
      final MenuTree aMenuTree = new MenuTree ();
      MenuSecure.init (aMenuTree);
      PhotonGlobalState.state (CApplicationID.APP_ID_SECURE).setMenuTree (aMenuTree);
    }
  }

  @Override
  protected void initUI ()
  {
    // UI stuff
    AppCommonUI.init ();
  }

  @Override
  protected void initSecurity ()
  {
    // Set all security related stuff
    AppSecurity.init ();
  }

  @Override
  protected void initManagers ()
  {
    // Load managers
    PVMetaManager.getInstance ();

    // Setup error handler
    AppInternalErrorHandler.doSetup ();

    final ConfigurationFileManager aCfgMgr = ConfigurationFileManager.getInstance ();
    aCfgMgr.registerConfigurationFile (new ConfigurationFile (new ClassPathResource ("log4j2.xml")).setDescription ("Log4J2 configuration file")
                                                                                                   .setSyntaxHighlightLanguage (EConfigurationFileSyntax.XML));
    aCfgMgr.registerConfigurationFile (new ConfigurationFile (new ClassPathResource ("webapp.properties")).setDescription ("Web application properties")
                                                                                                          .setSyntaxHighlightLanguage (EConfigurationFileSyntax.PROPERTIES));
  }

  @Override
  protected void beforeContextDestroyed (@Nonnull final ServletContext aSC)
  {
    ExtValidationKeyRegistry.cleanupOnShutdown ();
  }
}
