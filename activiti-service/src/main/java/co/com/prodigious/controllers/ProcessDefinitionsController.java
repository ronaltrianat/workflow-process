package co.com.prodigious.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.prodigious.dto.request.ProcessDefinitionRequest;
import co.com.prodigious.dto.response.ProcessDefinitionResponse;
import co.com.prodigious.service.ProcessDefinitionsService;

@RestController
@RequestMapping("/process-definition")
public class ProcessDefinitionsController {

	private final ProcessDefinitionsService processDefinitionsService;

	public ProcessDefinitionsController(ProcessDefinitionsService processDefinitionsService) {
		this.processDefinitionsService = processDefinitionsService;
	}

	@PostMapping
	public ResponseEntity<ProcessDefinitionResponse> uploadProcessInstance(
			@Valid @ModelAttribute ProcessDefinitionRequest request) throws Exception {
		return ResponseEntity.ok(processDefinitionsService.uploadProcessDefinition(request));
	}
}
