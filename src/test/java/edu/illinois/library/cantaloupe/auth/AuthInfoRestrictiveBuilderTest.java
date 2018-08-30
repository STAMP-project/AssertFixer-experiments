package edu.illinois.library.cantaloupe.auth;

import edu.illinois.library.cantaloupe.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthInfoRestrictiveBuilderTest extends BaseTest {

    private AuthInfo.RestrictiveBuilder instance;

    public void setUp() throws Exception {
        super.setUp();
        instance = new AuthInfo.RestrictiveBuilder();
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildWithMissingRedirectURIAndScaleConstraint() {
        instance.withResponseStatus(301).build();
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildWithRedirectURIAnd2xxStatus() {
        instance.withRedirectURI("http://example.org/")
                .withResponseStatus(200)
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildWithRedirectURIAnd4xxStatus() {
        instance.withRedirectURI("http://example.org/")
                .withResponseStatus(401)
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildWith401StatusAndNullWWWAuthenticateValue() {
        instance.withRedirectURI("http://example.org/")
                .withResponseStatus(401)
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildWithWWWAuthenticateValueAndNon401Status() {
        instance.withRedirectURI("http://example.org/")
                .withChallengeValue("Basic")
                .withResponseStatus(403)
                .build();
    }

    @Test
    public void testBuildWithRedirect() {
        AuthInfo info = instance.withResponseStatus(301)
                .withRedirectURI("http://example.org/")
                .build();
        assertEquals(301, info.getResponseStatus());
        assertEquals("http://example.org/", info.getRedirectURI());
    }

    @Test
    public void testBuildWithScaleConstraint() {
        AuthInfo info = instance.withResponseStatus(302)
                .withRedirectScaleConstraint(1L, 2L)
                .build();
        assertEquals(302, info.getResponseStatus());
        assertEquals(1, info.getScaleConstraint().getNumerator());
        assertEquals(2, info.getScaleConstraint().getDenominator());
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildWithScaleConstraintAnd2xxStatus() {
        instance.withRedirectScaleConstraint(1L, 2L)
                .withResponseStatus(200)
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildWithScaleConstraintAnd4xxStatus() {
        instance.withRedirectScaleConstraint(1L, 2L)
                .withResponseStatus(401)
                .build();
    }

    @Test
    public void testBuildWithUnauthorized() {
        AuthInfo info = instance.withResponseStatus(401)
                .withChallengeValue("Basic")
                .build();
        assertEquals(401, info.getResponseStatus());
        assertEquals("Basic", info.getChallengeValue());
    }

}
