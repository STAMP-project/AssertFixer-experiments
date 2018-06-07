package com.kakawait.security.cas;

import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.web.authentication.ServiceAuthenticationDetails;
import org.springframework.security.cas.web.authentication.ServiceAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Thibaud Leprêtre
 * @deprecated Please use new artifact id {@code spring-security-cas-extension}
 */
@Deprecated
public class ProxyCallbackAndServiceAuthenticationDetailsSource extends ServiceAuthenticationDetailsSource {
    private final String proxyCallbackPath;

    public ProxyCallbackAndServiceAuthenticationDetailsSource(ServiceProperties serviceProperties,
            String proxyCallbackPath) {
        super(serviceProperties);
        this.proxyCallbackPath = proxyCallbackPath;
    }

    @Override
    public ServiceAuthenticationDetails buildDetails(HttpServletRequest context) {
        return new DefaultProxyCallbackAndServiceAuthenticationDetails(context, proxyCallbackPath);
    }
}
