package org.fogbowcloud.ras.core.plugins.aaa.authentication;

import org.fogbowcloud.ras.core.PropertiesHolder;
import org.fogbowcloud.ras.core.constants.ConfigurationConstants;
import org.fogbowcloud.ras.core.exceptions.UnauthenticatedUserException;
import org.fogbowcloud.ras.core.models.tokens.FederationUserToken;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PowerMockIgnore({"javax.management.*"})
@PrepareForTest({RASAuthenticationHolder.class, PropertiesHolder.class})
@RunWith(PowerMockRunner.class)
public class RASAuthenticationPluginTest {

	private static final String DEFAULT_LOCAL_MEMBER_ID = "default_local_member_id";
	private RASAuthenticationPlugin rasAuthenticationPlugin;
	private PropertiesHolder propertiesHolder;
	private RASAuthenticationHolder rasAuthenticationHolder;

	@Before
	public void setUp() {		
		this.propertiesHolder = Mockito.mock(PropertiesHolder.class);
		PowerMockito.mockStatic(PropertiesHolder.class);
		BDDMockito.given(PropertiesHolder.getInstance()).willReturn(this.propertiesHolder);
		
		Mockito.when(this.propertiesHolder.getProperty(Mockito.eq(ConfigurationConstants.LOCAL_MEMBER_ID)))
					.thenReturn(DEFAULT_LOCAL_MEMBER_ID);
		
		this.rasAuthenticationHolder = Mockito.mock(RASAuthenticationHolder.class);
		PowerMockito.mockStatic(RASAuthenticationHolder.class);
		BDDMockito.given(RASAuthenticationHolder.getInstance()).willReturn(this.rasAuthenticationHolder);
		
		this.rasAuthenticationPlugin = new RASAuthenticationPluginWrapper();
	}
	
	// test case: Same local member and is authenticated
	@Test
	public void testIsAuthentic() throws UnauthenticatedUserException {
		// set up
		String requestingMember = DEFAULT_LOCAL_MEMBER_ID;
		FederationUserToken federationUserToken = new FederationUserToken(requestingMember, "", "", "");
			    	    
	    Mockito.when(this.rasAuthenticationHolder.verifySignature(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
		
	    // exercise
		boolean isAuthenticated = this.rasAuthenticationPlugin.isAuthentic(requestingMember, federationUserToken);
		
		// verify
		Assert.assertTrue(isAuthenticated);
	}
	
	// test case: Same local member and is not authenticated
	@Test
	public void testIsNotAuthentic() throws UnauthenticatedUserException {
		// set up
		String requestingMember = DEFAULT_LOCAL_MEMBER_ID;
		FederationUserToken federationUserToken = new FederationUserToken(requestingMember, "", "", "");
			    	    
	    Mockito.when(this.rasAuthenticationHolder.verifySignature(Mockito.anyString(), Mockito.anyString())).thenReturn(false);
		
	    // exercise
		boolean isAuthenticated = this.rasAuthenticationPlugin.isAuthentic(requestingMember, federationUserToken);
		
		// verify
		Assert.assertFalse(isAuthenticated);
	}	
	
	public class RASAuthenticationPluginWrapper extends RASAuthenticationPlugin {

		@Override
		protected String getTokenMessage(FederationUserToken federationUserToken) {return null;}

		@Override
		protected String getSignature(FederationUserToken federationUserToken) {return null;}
		
	}
	
}
