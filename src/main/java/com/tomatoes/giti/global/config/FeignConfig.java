package com.tomatoes.giti.global.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.tomatoes.giti.global.feign")
public class FeignConfig {
}