package com.weaverplatform.postgresql.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

/**
 * @author Mohamad Alamili
 */
public class FreeMarker {

  // Do not needlessly re-create Configuration instances; it's expensive, among others because you lose the template cache.
  // Configuration instances meant to be application-level singletons.
  private static final Configuration configuration;
  private static final HashMap<String, Template> templates;

  static {
    // Specify if up to what FreeMarker version (here 2.3.23) to apply the fixes that are not 100%
    // backward-compatible.
    configuration = new Configuration(Configuration.VERSION_2_3_23);

    // Specify the source where the template files come from. Note that this is in the resources folder.
    configuration.setClassForTemplateLoading(FreeMarker.class, "/templates/");

    // Set UTF-8 as the preferred charset template files are stored in.
    configuration.setDefaultEncoding("UTF-8");

    // Sets how errors will appear.
    // During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
    configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

    // Don't log exceptions inside FreeMarker that it will thrown anyway:
    configuration.setLogTemplateExceptions(false);

    // Make internal api functions available (for is_hash)
    try {
      configuration.setSetting("api_builtin_enabled", "true");
    } catch (TemplateException e) {
      throw new RuntimeException(e);
    }

    // Store templates in here as a cache
    templates = new HashMap<>();
  }

  /**
   * Process with dataModel
   * @param templateName
   * @param dataModel
   * @return
   */
  public static final String process(String templateName, Object dataModel){

    // Add template to cache if not yet exists
    if (!templates.containsKey(templateName)){
      try {
        templates.put(templateName, configuration.getTemplate(templateName));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    // Get template
    Template template = templates.get(templateName);

    // Write the freemarker output to a StringWriter
    StringWriter stringWriter = new StringWriter();

    try {
      template.process(dataModel, stringWriter);
    } catch (TemplateException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return stringWriter.toString();
  }

  /**
   * Process without dataModel
   * @param templateName
   * @return
   */
  public static final String process(String templateName){
    return process(templateName, null);
  }

  protected FreeMarker() {
  }
}
