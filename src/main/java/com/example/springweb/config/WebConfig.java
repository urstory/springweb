package com.example.springweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// 스프링 설정.
@Configuration
@EnableWebMvc // <mvc:annotation-driven />
// com.example패키지 이하에서 @Controller가붙은 클래스를 다 Bean으로 등록해달라.
// @ComponentScan은 @Component, @Controller, @Service, @Repository를 찾습니다.
@ComponentScan(basePackages = { "com.example" },
        useDefaultFilters = false,
        includeFilters = { @ComponentScan.Filter(Controller.class) })
public class WebConfig implements WebMvcConfigurer {
    public WebConfig() {
        System.out.println("WebConfig가 실행됩니다.");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    // Tomcat이 기본으로 제공하는 서블릿(정적자원)을 사용하도록 설정.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        System.out.println("configureDefaultServletHandling 이 실행됩니다.");
        configurer.enable(); // 디폴트 서블릿을 사용하도록 설정.
    }

    // 스프링은 ViewResolver 를 설정하라. JSP를 사용하려면 InternalResourceViewResolver가 필요한다.
    // InternalResourceViewResolver를 Bean으로 등록하라.
    // /WEB-INF/view/ + "hello" + ".jsp"
    // jsp는 url을 통하여 직접 접근할 수 없다.
    // Controller를 통해서만 접근할 수 있도록 한다.
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
