package com.example.simple.ui.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "simple-service-client", url = "http://simple-service:8080")
public interface SimpleServiceClient {

	@GetMapping("/ServiceInfo")
	ResponseEntity<String> getServiceInfo();

}
