package com.example.simple.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

	private static HttpStatus httpStatus = HttpStatus.OK;

	@GetMapping
	public ResponseEntity<String> health() {
		return new ResponseEntity<>(httpStatus);
	}

	@PostMapping
	public String changeHealth(@RequestParam Integer statusCode) {
		HttpStatus newStatus = HttpStatus.resolve(statusCode);
		String response = String.format("Status was changed from %s to %s", httpStatus, newStatus);
		httpStatus = newStatus;

		return response;
	}

	@GetMapping("/death")
	public ResponseEntity<String> death() {
		return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
	}

}
