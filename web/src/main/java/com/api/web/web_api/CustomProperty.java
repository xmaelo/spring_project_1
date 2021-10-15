package com.api.web.web_api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


@Configuration
@ConfigurationProperties(prefix = "com.api.web.webapi")
@Data
public class CustomProperty {

    private String apiUrl;

}