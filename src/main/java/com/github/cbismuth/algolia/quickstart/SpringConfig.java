package com.github.cbismuth.algolia.quickstart;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
@ComponentScan("com.github.cbismuth.algolia.quickstart")
public class SpringConfig {

    // NOP
}
