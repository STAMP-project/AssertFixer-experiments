package com.bindstone.portfolio.service;

import com.bindstone.portfolio.repository.CurrencyHistoryRepository;
import com.bindstone.portfolio.repository.CurrencyRepository;
import com.bindstone.portfolio.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractServiceTest {

    @Autowired
    protected CurrencyService currencyService;

    @Autowired
    protected CurrencyHistoryService currencyHistoryService;

    @Autowired
    protected UserService userService;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyHistoryRepository currencyHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Before
    @After
    public void clean() {
        currencyHistoryRepository.deleteAll();
        currencyRepository.deleteAll();
        userRepository.deleteAll();
    }


}
