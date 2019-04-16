package co.com.prodigious.service;

import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

	public void storeResume(DelegateExecution execution) throws Exception {
		Map<String, Object> vars = execution.getVariables();
		System.out.println("Storing resume ...");
		vars.forEach((k, v) -> System.out.println((k + ":" + v)));
	}
	
	public void storePeriod(DelegateExecution execution) throws Exception {
		Map<String, Object> vars = execution.getVariables();
		System.out.println("Storing period ...");
		vars.forEach((k, v) -> System.out.println((k + ":" + v)));
	}
}
