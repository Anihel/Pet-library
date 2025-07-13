package com.an.library;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(TestEnvLoader.class)
public class TestApplication {
}
