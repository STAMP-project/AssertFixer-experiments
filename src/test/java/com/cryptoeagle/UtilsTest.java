package com.cryptoeagle;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void cut() {

        String test ="https://stackoverflow.com/questions/";

        String end =  Utils.cut(test);
    }

    @Test
    public void clearString() {

        String test = Utils.clearString("<p>This is a paid-for submitted press release. CCN does not endorse, nor is responsible for any material included below and isn’t responsible for any damages or losses connected with any products or services mentioned in the press release. CCN urges readers to conduct their own research with due diligence into the company, product or service mentioned</p> <p>The post <a rel=\"nofollow\" href=\"https://www.ccn.com/internet-of-things-marketplace-databroker-dao-continues-at-full-speed/\">Internet of Things Marketplace DataBroker DAO Continues at Full Speed, Announcing 3 New Alliance Members and Listing on Tokenjar</a> appeared first on <a rel=\"nofollow\" href=\"https://www.ccn.com\">CCN</a></p>...");
        System.out.println();
    }

}