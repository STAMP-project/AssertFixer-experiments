package com.github.cbismuth.algolia.quickstart.repository;

import com.github.cbismuth.algolia.quickstart.SpringITest;
import com.github.cbismuth.algolia.quickstart.nobel.NobelPrizeRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class NobelPrizeRepositoryITest extends SpringITest {

    @Autowired
    private NobelPrizeRepository nobelPrizeRepository;

    @Test
    public void test_noop() {
        Assertions.assertThat(nobelPrizeRepository).isNotNull();
    }
}
