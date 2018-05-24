package com.github.cbismuth.algolia.quickstart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Use Spring {@link DirtiesContext} to reload context and create a new time-based index for each test to promote
 * records isolation and ease concurrent testing.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SpringITest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringITest.class);

    @Test
    public void test_contextLoads() {
        LOGGER.info("Spring context successfully loaded");
    }
}
