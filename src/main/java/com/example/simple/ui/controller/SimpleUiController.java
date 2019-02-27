package com.example.simple.ui.controller;

import com.example.simple.ui.client.SimpleServiceClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SimpleUiController {

	@Autowired
	private SimpleServiceClient simpleServiceClient;

	@Value("${version}")
	private String version;

	@GetMapping("/ServiceInfo")
	public ResponseEntity<String> getServiceInfo() {
		try {

			return simpleServiceClient.getServiceInfo();
		} catch (FeignException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}

	@GetMapping("/UiInfo")
	public String getUiInfo() {
		return version;
	}

}
