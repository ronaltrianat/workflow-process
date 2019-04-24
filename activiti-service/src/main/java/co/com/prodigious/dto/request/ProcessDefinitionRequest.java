package co.com.prodigious.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProcessDefinitionRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String processName;

	@NotBlank
	private String processKey;

	@NotBlank
	private String processCategory;

	@NotNull
	private MultipartFile file;

}
