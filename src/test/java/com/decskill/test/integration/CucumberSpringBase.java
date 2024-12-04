package com.decskill.test.integration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "spring.flyway.locations=classpath:db/migration")
@CucumberContextConfiguration
public class CucumberSpringBase {
}