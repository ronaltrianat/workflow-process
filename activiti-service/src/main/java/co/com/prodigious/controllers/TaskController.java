package co.com.prodigious.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.prodigious.dto.TaskDTO;
import co.com.prodigious.dto.request.CompleteTaskRequest;
import co.com.prodigious.dto.response.ApiResponse;
import co.com.prodigious.service.ProcessTaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	private final ProcessTaskService processTaskService;
	
	
	public TaskController(ProcessTaskService processTaskService) {
		this.processTaskService = processTaskService;
	}
	
	
	@GetMapping("/available/{role}")
	public ResponseEntity<List<TaskDTO>> getTasksAvailable(@PathVariable String role) {
		return ResponseEntity.ok(processTaskService.getTasksAvailable(role));
	}
	
	
	@GetMapping("/open/{assignee}")
	public ResponseEntity<List<TaskDTO>> getOpenTasks(@PathVariable String assignee) {
		return ResponseEntity.ok(processTaskService.getOpenTasks(assignee));
	}
	
	
	@PostMapping("/complete")
	public ResponseEntity<ApiResponse> completeTask(
			@Valid @RequestBody CompleteTaskRequest request) {
		return ResponseEntity.ok(processTaskService.completeTask(request));
	}
}
