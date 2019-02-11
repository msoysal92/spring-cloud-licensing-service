package com.msoft.licenses.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ServiceConfig {
	
	@Value("${example.property}")
	private String exampleProperty;
	
}
