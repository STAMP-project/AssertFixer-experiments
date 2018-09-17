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
package com.helger.validator.pub;

import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.math.MathHelper;
import com.helger.commons.string.StringHelper;
import com.helger.commons.url.ISimpleURL;
import com.helger.commons.url.SimpleURL;
import com.helger.html.css.DefaultCSSClassProvider;
import com.helger.html.css.ICSSClassProvider;
import com.helger.html.hc.IHCNode;
import com.helger.html.hc.html.IHCElement;
import com.helger.html.hc.html.grouping.HCDiv;
import com.helger.html.hc.html.grouping.HCP;
import com.helger.html.hc.html.textlevel.HCA;
import com.helger.html.hc.html.textlevel.HCSpan;
import com.helger.html.hc.impl.HCEntityNode;
import com.helger.html.hc.impl.HCNodeList;
import com.helger.photon.basic.app.appid.CApplicationID;
import com.helger.photon.basic.app.appid.PhotonGlobalState;
import com.helger.photon.basic.app.menu.IMenuItemExternal;
import com.helger.photon.basic.app.menu.IMenuItemPage;
import com.helger.photon.basic.app.menu.IMenuObject;
import com.helger.photon.basic.app.menu.IMenuSeparator;
import com.helger.photon.basic.app.menu.IMenuTree;
import com.helger.photon.basic.app.menu.MenuItemDeterminatorCallback;
import com.helger.photon.bootstrap3.CBootstrapCSS;
import com.helger.photon.bootstrap3.alert.BootstrapErrorBox;
import com.helger.photon.bootstrap3.base.BootstrapContainer;
import com.helger.photon.bootstrap3.breadcrumbs.BootstrapBreadcrumbs;
import com.helger.photon.bootstrap3.breadcrumbs.BootstrapBreadcrumbsProvider;
import com.helger.photon.bootstrap3.ext.BootstrapSystemMessage;
import com.helger.photon.bootstrap3.grid.BootstrapRow;
import com.helger.photon.bootstrap3.navbar.BootstrapNavbar;
import com.helger.photon.bootstrap3.navbar.EBootstrapNavbarType;
import com.helger.photon.bootstrap3.pages.BootstrapWebPageUIHandler;
import com.helger.photon.bootstrap3.uictrls.ext.BootstrapMenuItemRenderer;
import com.helger.photon.bootstrap3.uictrls.ext.BootstrapMenuItemRendererHorz;
import com.helger.photon.core.app.context.ILayoutExecutionContext;
import com.helger.photon.core.app.context.LayoutExecutionContext;
import com.helger.photon.core.app.layout.CLayout;
import com.helger.photon.uicore.page.IWebPage;
import com.helger.photon.uicore.page.WebPageExecutionContext;
import com.helger.validator.app.PVHelper;
import com.helger.validator.ui.CAppCSS;
import com.helger.web.scope.IRequestWebScopeWithoutResponse;
import com.helger.xservlet.forcedredirect.ForcedRedirectManager;

/**
 * The viewport renderer (menu + content area)
 *
 * @author Philip Helger
 */
public final class AppRendererPublic
{
  private static final String PARAM_HTTP_ERROR = "httpError";
  private static final String VALUE_HTTP_ERROR = "true";
  private static final String PARAM_HTTP_STATUS_CODE = "httpStatusCode";
  private static final String PARAM_HTTP_STATUS_MESSAGE = "httpStatusMessage";
  private static final String PARAM_HTTP_REQUEST_URI = "httpRequestUri";

  private static final ICSSClassProvider CSS_CLASS_FOOTER_LINKS = DefaultCSSClassProvider.create ("footer-links");

  private static final ICommonsList <IMenuObject> s_aFooterObjectsCol1 = new CommonsArrayList <> ();
  private static final ICommonsList <IMenuObject> s_aFooterObjectsCol2 = new CommonsArrayList <> ();
  private static final ICommonsList <IMenuObject> s_aFooterObjectsCol3 = new CommonsArrayList <> ();
  private static final int m_nFooterRowCount;

  static
  {
    PhotonGlobalState.state (CApplicationID.APP_ID_PUBLIC).getMenuTree ().iterateAllMenuObjects ( (aCurrentObject) -> {
      if (aCurrentObject.attrs ().containsKey (CMenuPublic.FLAG_FOOTER_COL1))
        s_aFooterObjectsCol1.add (aCurrentObject);
      if (aCurrentObject.attrs ().containsKey (CMenuPublic.FLAG_FOOTER_COL2))
        s_aFooterObjectsCol2.add (aCurrentObject);
      if (aCurrentObject.attrs ().containsKey (CMenuPublic.FLAG_FOOTER_COL3))
        s_aFooterObjectsCol3.add (aCurrentObject);
    });
    m_nFooterRowCount = MathHelper.getMaxInt (s_aFooterObjectsCol1.size (),
                                              s_aFooterObjectsCol2.size (),
                                              s_aFooterObjectsCol3.size ());
  }

  private AppRendererPublic ()
  {}

  @Nonnull
  private static BootstrapNavbar _getNavbar (final LayoutExecutionContext aLEC)
  {
    final Locale aDisplayLocale = aLEC.getDisplayLocale ();
    final ISimpleURL aLinkToStartPage = aLEC.getLinkToMenuItem (aLEC.getMenuTree ().getDefaultMenuItemID ());

    final BootstrapNavbar aNavbar = new BootstrapNavbar (EBootstrapNavbarType.STATIC_TOP, true, aDisplayLocale);
    aNavbar.getContainer ().setFluid (true);
    aNavbar.addBrand (new HCSpan ().addClass (CAppCSS.CSS_CLASS_LOGO1).addChild (PVHelper.getApplicationTitle ()),
                      aLinkToStartPage);

    return aNavbar;
  }

  @Nonnull
  public static IHCNode getMenuContent (@Nonnull final LayoutExecutionContext aLEC)
  {
    // Main menu
    final IMenuTree aMenuTree = aLEC.getMenuTree ();
    final MenuItemDeterminatorCallback aCallback = new MenuItemDeterminatorCallback (aMenuTree,
                                                                                     aLEC.getSelectedMenuItemID ())
    {
      @Override
      protected boolean isMenuItemValidToBeDisplayed (@Nonnull final IMenuObject aMenuObj)
      {
        // Don't show items that belong to the footer
        if (aMenuObj.attrs ().containsKey (CMenuPublic.FLAG_FOOTER_COL1) ||
            aMenuObj.attrs ().containsKey (CMenuPublic.FLAG_FOOTER_COL2) ||
            aMenuObj.attrs ().containsKey (CMenuPublic.FLAG_FOOTER_COL3))
          return false;

        // Use default code
        return super.isMenuItemValidToBeDisplayed (aMenuObj);
      }
    };
    final IHCElement <?> aMenu = BootstrapMenuItemRenderer.createSideBarMenu (aLEC, aCallback);

    return new HCNodeList ().addChild (aMenu);
  }

  @SuppressWarnings ("unchecked")
  @Nonnull
  public static IHCNode getPageContent (@Nonnull final LayoutExecutionContext aLEC)
  {
    final IRequestWebScopeWithoutResponse aRequestScope = aLEC.getRequestScope ();

    // Get the requested menu item
    final IMenuItemPage aSelectedMenuItem = aLEC.getSelectedMenuItem ();

    // Resolve the page of the selected menu item (if found)
    IWebPage <WebPageExecutionContext> aDisplayPage;
    if (aSelectedMenuItem.matchesDisplayFilter ())
    {
      // Only if we have display rights!
      aDisplayPage = (IWebPage <WebPageExecutionContext>) aSelectedMenuItem.getPage ();
    }
    else
    {
      // No rights -> goto start page
      aDisplayPage = (IWebPage <WebPageExecutionContext>) aLEC.getMenuTree ().getDefaultMenuItem ().getPage ();
    }

    final WebPageExecutionContext aWPEC = new WebPageExecutionContext (aLEC, aDisplayPage);

    // Build page content: header + content
    final HCNodeList aPageContainer = new HCNodeList ();

    // System message always
    aPageContainer.addChild (BootstrapSystemMessage.createDefault ());

    // Handle 404 case here (see error404.jsp)
    if (VALUE_HTTP_ERROR.equals (aRequestScope.params ().getAsString (PARAM_HTTP_ERROR)))
    {
      final String sHttpStatusCode = aRequestScope.params ().getAsString (PARAM_HTTP_STATUS_CODE);
      final String sHttpStatusMessage = aRequestScope.params ().getAsString (PARAM_HTTP_STATUS_MESSAGE);
      final String sHttpRequestURI = aRequestScope.params ().getAsString (PARAM_HTTP_REQUEST_URI);
      aPageContainer.addChild (new BootstrapErrorBox ().addChild ("HTTP error " +
                                                                  sHttpStatusCode +
                                                                  " (" +
                                                                  sHttpStatusMessage +
                                                                  ")" +
                                                                  (StringHelper.hasText (sHttpRequestURI) ? " for request URI " +
                                                                                                            sHttpRequestURI
                                                                                                          : "")));
    }
    else
    {
      // Add the forced redirect content here
      if (aWPEC.params ().containsKey (ForcedRedirectManager.REQUEST_PARAMETER_PRG_ACTIVE))
        aPageContainer.addChild ((IHCNode) ForcedRedirectManager.getLastForcedRedirectContent (aDisplayPage.getID ()));
    }

    final String sHeaderText = aDisplayPage.getHeaderText (aWPEC);
    aPageContainer.addChild (BootstrapWebPageUIHandler.INSTANCE.createPageHeader (sHeaderText));

    // Main fill content
    aDisplayPage.getContent (aWPEC);
    // Add result
    aPageContainer.addChild (aWPEC.getNodeList ());

    return aPageContainer;
  }

  @Nullable
  private static IHCNode _getRenderedFooterMenuObj (@Nonnull final ILayoutExecutionContext aLEC,
                                                    @Nonnull final BootstrapMenuItemRendererHorz aRenderer,
                                                    @Nullable final IMenuObject aMenuObj)
  {
    if (aMenuObj == null)
      return null;

    if (aMenuObj instanceof IMenuSeparator)
      return aRenderer.renderSeparator (aLEC, (IMenuSeparator) aMenuObj);

    if (aMenuObj instanceof IMenuItemPage)
      return aRenderer.renderMenuItemPage (aLEC, (IMenuItemPage) aMenuObj, false, false, false);

    if (aMenuObj instanceof IMenuItemExternal)
      return aRenderer.renderMenuItemExternal (aLEC, (IMenuItemExternal) aMenuObj, false, false, false);

    throw new IllegalStateException ("Unsupported menu object type: " + aMenuObj);
  }

  @Nonnull
  public static IHCNode getContent (@Nonnull final LayoutExecutionContext aLEC)
  {
    final Locale aDisplayLocale = aLEC.getDisplayLocale ();
    final HCNodeList ret = new HCNodeList ();

    // Header
    ret.addChild (_getNavbar (aLEC));

    final BootstrapContainer aOuterContainer = ret.addAndReturnChild (new BootstrapContainer ().setFluid (true));

    // Breadcrumbs
    {
      final BootstrapBreadcrumbs aBreadcrumbs = BootstrapBreadcrumbsProvider.createBreadcrumbs (aLEC);
      aBreadcrumbs.addClass (CBootstrapCSS.HIDDEN_XS);
      aOuterContainer.addChild (aBreadcrumbs);
    }

    // Content
    {
      final BootstrapRow aRow = aOuterContainer.addAndReturnChild (new BootstrapRow ());
      final HCDiv aCol1 = aRow.createColumn (12, 4, 4, 3);
      final HCDiv aCol2 = aRow.createColumn (12, 8, 8, 9);

      // left
      // We need a wrapper span for easy AJAX content replacement
      aCol1.addChild (new HCSpan ().setID (CLayout.LAYOUT_AREAID_MENU)
                                   .addClass (CBootstrapCSS.HIDDEN_PRINT)
                                   .addChild (getMenuContent (aLEC)));
      aCol1.addChild (new HCDiv ().setID (CLayout.LAYOUT_AREAID_SPECIAL));

      // content
      aCol2.addChild (getPageContent (aLEC));
    }

    // Footer
    {
      final BootstrapContainer aDiv = new BootstrapContainer ().setFluid (true).setID (CLayout.LAYOUT_AREAID_FOOTER);

      aDiv.addChild (new HCP ().addChild ("phoss validator - ")
                               .addChild (HCEntityNode.newCopy ())
                               .addChild (" by P. Helger")
                               .addChild (" - GitHub: ")
                               .addChild (new HCA (new SimpleURL ("https://github.com/phax")).addChild ("phax"))
                               .addChild (" - Twitter: ")
                               .addChild (new HCA (new SimpleURL ("https://twitter.com/philiphelger")).addChild ("@philiphelger")));

      if (m_nFooterRowCount > 0)
      {
        final BootstrapMenuItemRendererHorz aRenderer = new BootstrapMenuItemRendererHorz (aDisplayLocale);
        final HCDiv aTable = new HCDiv ();
        aTable.addClass (CSS_CLASS_FOOTER_LINKS);
        for (int i = 0; i < m_nFooterRowCount; ++i)
        {
          final BootstrapRow aRow = aTable.addAndReturnChild (new BootstrapRow ());
          aRow.createColumn (4)
              .addChild (_getRenderedFooterMenuObj (aLEC, aRenderer, s_aFooterObjectsCol1.getAtIndex (i)));
          aRow.createColumn (4)
              .addChild (_getRenderedFooterMenuObj (aLEC, aRenderer, s_aFooterObjectsCol2.getAtIndex (i)));
          aRow.createColumn (4)
              .addChild (_getRenderedFooterMenuObj (aLEC, aRenderer, s_aFooterObjectsCol3.getAtIndex (i)));
        }
        aDiv.addChild (aTable);
      }

      ret.addChild (aDiv);
    }

    return ret;
  }
}
