package io.opentracing.contrib.jaxrs2.itest.resteasy;

import io.opentracing.contrib.jaxrs2.itest.common.AbstractWildcardOperationNameTest;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * @author Pavol Loffay
 */
public class RestEasyWildcardOperationNameITest extends AbstractWildcardOperationNameTest {

    @Override
    protected void initServletContext(ServletContextHandler context) {
        RestEasyHelper.initServletContext(context);
    }
}
