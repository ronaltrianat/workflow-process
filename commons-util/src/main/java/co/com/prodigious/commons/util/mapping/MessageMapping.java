package co.com.prodigious.commons.util.mapping;

import java.util.HashMap;
import java.util.Map;

public class MessageMapping {

	private static Map<String, String> MESSAGE_MAP = new HashMap<>();
	
	static {
		MESSAGE_MAP.put("process_form_name_UNIQUE", "Ya existe un formulario con este nombre.");
	}
	
	public static String getErrorMessage(String key) {
		return MESSAGE_MAP.get(key);
	}
}
