package com.d0v4h.rhumapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="com.d0v4h.rhumapp")
public class CustomProperties {

	private String apiurl;

}
