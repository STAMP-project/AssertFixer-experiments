package com.bindstone.portfolio.rest;


import com.bindstone.portfolio.PortfolioApplication;
import com.bindstone.portfolio.repository.CurrencyHistoryRepository;
import com.bindstone.portfolio.repository.CurrencyRepository;
import com.bindstone.portfolio.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.ServletContainerInitializer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PortfolioApplication.class, ServletContainerInitializer.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public abstract class AbstractRestTest {

    //@Value("${local.server.port}")
    protected int port = 8080;

    @Autowired
    private CurrencyHistoryRepository currencyHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Before
    @After
    public void clean() {
        currencyHistoryRepository.deleteAll();
        currencyRepository.deleteAll();
        userRepository.deleteAll();
    }


}