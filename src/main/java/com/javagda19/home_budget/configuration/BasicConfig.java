package com.javagda19.home_budget.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class BasicConfig implements WebMvcConfigurer {

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/static/**")) { /*Jeśli nie ma mappingu na adres static
                                                                        (nie ma kontrolera)*/
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
            // dodaj do handlerów - na adres 'static' wskaż
        }
    }


}
