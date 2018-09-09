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

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.io.resource.ClassPathResource;
import com.helger.photon.basic.app.menu.IMenuItemPage;
import com.helger.photon.basic.app.menu.IMenuTree;
import com.helger.validator.pub.page.PagePublicToolsDocumentValidation;
import com.helger.validator.pub.page.PagePublicValidationLanding;
import com.helger.validator.ui.page.AppPageViewExternal;

@Immutable
public final class MenuPublic
{
  private MenuPublic ()
  {}

  public static void init (@Nonnull final IMenuTree aMenuTree)
  {
    // Validation stuff
    final IMenuItemPage aValidation = aMenuTree.createRootItem (new PagePublicValidationLanding (CMenuPublic.MENU_VALIDATION));
    aMenuTree.createItem (aValidation, new PagePublicToolsDocumentValidation (CMenuPublic.MENU_VALIDATION_UPLOAD));
    aMenuTree.createItem (aValidation,
                          new AppPageViewExternal (CMenuPublic.MENU_VALIDATION_WS,
                                                   "Document Validation WebService",
                                                   new ClassPathResource ("viewpages/en/validation_dvs.xml")));

    // Set default
    aMenuTree.setDefaultMenuItemID (CMenuPublic.MENU_VALIDATION);
  }
}
