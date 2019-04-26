package co.com.prodigious.admin.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.prodigious.admin.dto.request.FormConfigurationRequest;
import co.com.prodigious.admin.services.FormsConfigurationService;
import co.com.prodigious.commons.util.dto.response.ApiResponse;

@RestController
@RequestMapping("/forms-configuration")
public class FormsConfigurationController {

	private final FormsConfigurationService formsConfigurationService;

	public FormsConfigurationController(FormsConfigurationService formsConfigurationService) {
		this.formsConfigurationService = formsConfigurationService;
	}

	@PostMapping
	public ResponseEntity<ApiResponse> configureForm(
			@Valid @RequestBody FormConfigurationRequest request) {
		return ResponseEntity.ok(formsConfigurationService.configureForm(request));
	}
}
