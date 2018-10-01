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
package com.helger.validator.pub.page;

import java.util.Locale;
import java.util.Map;

import javax.annotation.Nonnull;

import com.helger.bdve.executorset.IValidationExecutorSet;
import com.helger.bdve.executorset.VESID;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.url.SimpleURL;
import com.helger.html.hc.html.grouping.HCP;
import com.helger.html.hc.html.grouping.HCUL;
import com.helger.html.hc.html.textlevel.HCA;
import com.helger.html.hc.html.textlevel.HCCode;
import com.helger.html.hc.impl.HCNodeList;
import com.helger.html.hc.impl.HCTextNode;
import com.helger.photon.uicore.page.WebPageExecutionContext;
import com.helger.validator.app.validation.ExtValidationKeyRegistry;
import com.helger.validator.ui.page.AbstractAppWebPage;

public class PagePublicValidationLanding extends AbstractAppWebPage
{
  public PagePublicValidationLanding (@Nonnull @Nonempty final String sID)
  {
    super (sID, "Document Validation");
  }

  @Override
  protected void fillContent (@Nonnull final WebPageExecutionContext aWPEC)
  {
    final HCNodeList aNodeList = aWPEC.getNodeList ();
    final Locale aDisplayLocale = aWPEC.getDisplayLocale ();

    aNodeList.addChild (new HCP ().addChild ("This is a standalone validator for business documents. " +
                                             "See the menu items on the left for more details."));
    aNodeList.addChild (new HCP ().addChild ("Note: the complete source code of this web site can be found on ")
                                  .addChild (new HCA (new SimpleURL ("https://github.com/phax/phoss-validator")).addChild ("GitHub")));

    aNodeList.addChild (new HCP ().addChild ("Supported execution sets are:"));
    final HCUL aUL = new HCUL ();
    for (final Map.Entry <VESID, IValidationExecutorSet> aEntry : ExtValidationKeyRegistry.getAllSortedByDisplayName (aDisplayLocale)
                                                                                          .entrySet ())
      aUL.addItem (new HCCode ().addChild (aEntry.getKey ().getAsSingleID ()),
                   new HCTextNode (" - " + aEntry.getValue ().getDisplayName ()));
    aNodeList.addChild (aUL);
  }
}
