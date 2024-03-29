package co.com.prodigious.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.prodigious.dto.request.StartProcessInstanceRequest;
import co.com.prodigious.dto.response.StartProcessInstanceResponse;
import co.com.prodigious.service.ProcessRuntimeService;


@RestController
@RequestMapping("/process-instance")
public class ProcessInstanceController {

	private final ProcessRuntimeService processRuntimeService;

	public ProcessInstanceController(ProcessRuntimeService processRuntimeService) {
		this.processRuntimeService = processRuntimeService;
	}

	@PostMapping("/start")
	public ResponseEntity<StartProcessInstanceResponse> startProcessInstance(
			@Valid @RequestBody StartProcessInstanceRequest request) throws Exception {
		return ResponseEntity.ok(processRuntimeService.startProcessInstance(request));
	}
	
}
