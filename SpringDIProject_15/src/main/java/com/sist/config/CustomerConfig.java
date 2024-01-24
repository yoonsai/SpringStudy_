package com.sist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//<context:component-scan base-package="com.sist.*"></context:component-scan>
@ComponentScan(basePackages = "com.sist.*")
public class CustomerConfig {

}
