package com.kakawait.security.cas;

import org.jasig.cas.client.validation.Cas20ServiceTicketValidator;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author Thibaud Leprêtre
 * @deprecated Please use new artifact id {@code spring-security-cas-extension}
 */
@Deprecated
public class DynamicProxyCallbackUrlCasAuthenticationProvider extends CasAuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication.getDetails() instanceof ProxyCallbackAndServiceAuthenticationDetails &&
                getTicketValidator() instanceof Cas20ServiceTicketValidator) {
            String proxyCallbackUrl = ((ProxyCallbackAndServiceAuthenticationDetails) authentication.getDetails())
                    .getProxyCallbackUrl();
            ((Cas20ServiceTicketValidator) getTicketValidator()).setProxyCallbackUrl(proxyCallbackUrl);
        }
        return super.authenticate(authentication);
    }
}
