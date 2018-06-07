package com.kakawait.security.cas;

import org.springframework.security.cas.web.authentication.ServiceAuthenticationDetails;

/**
 * @author Thibaud Leprêtre
 * @deprecated Please use new artifact id {@code spring-security-cas-extension}
 */
@Deprecated
public interface ProxyCallbackAndServiceAuthenticationDetails extends ServiceAuthenticationDetails {
    String getProxyCallbackUrl();
}
