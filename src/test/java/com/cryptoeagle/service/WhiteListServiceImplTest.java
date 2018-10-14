package com.cryptoeagle.service;

import com.cryptoeagle.AbstractTest;
import com.cryptoeagle.entity.WhiteList;
import com.cryptoeagle.service.abst.WhiteListService;
import org.junit.Assume;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WhiteListServiceImplTest extends AbstractTest {

    private final static int WHITELIST_COUNT = 64;

    @Autowired
    WhiteListService service;

    @Test
    public void getWhiteList() {
        List<WhiteList> whiteLists = service.getWhiteList();
        Assume.assumeTrue(whiteLists.size() == WHITELIST_COUNT);
    }

    @Test
    public void checkWhiteList() {
        List<WhiteList> whiteLists = service.getWhiteList();
        WhiteList whitelist = whiteLists.stream().findFirst().get();
        Assume.assumeTrue(whitelist.getCategory() != null);
        Assume.assumeTrue(whitelist.getLogo() != null);
        Assume.assumeTrue(whitelist.getName() != null);
        Assume.assumeTrue(whitelist.getStatus() != null);
    }

    @Test
    public void update() {
        service.updateWhitelist();
    }

}