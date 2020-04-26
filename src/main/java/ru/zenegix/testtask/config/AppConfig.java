package ru.zenegix.testtask.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ClassLoader classLoader(ApplicationContext applicationContext) {
        return applicationContext.getClassLoader();
    }

}
