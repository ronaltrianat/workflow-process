package co.com.prodigious.util;

import java.util.Objects;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import co.com.prodigious.dto.ProcessDefinitionDTO;
import co.com.prodigious.dto.request.ProcessDefinitionRequest;
import co.com.prodigious.exceptions.ProcessDefinitionException;

public class ProcessDefinitionUtil {

	private static final String ERROR_TAG_PROCESS_NOT_FOUNT = "TAG_PROCESS_NOT_FOUNT";
	private static final String ERROR_ITEM_ID_OR_NAME_NOT_FOUNT = "ITEM_ID_OR_NAME_NOT_FOUNT";
	private static final String TAG_PROCESS = "process";
	private static final String ITEM_ID = "id";
	private static final String ITEM_NAME = "name";
	
	
	/**
	 * Metodo encargado de obtener los parametros del proceso a configurar.
	 * @param request Objeto que contiene la informacion del proceso.
	 * @return Objeto con los parametros del proceso.
	 * @throws Exception
	 */
	public static ProcessDefinitionDTO getProcessParameters(ProcessDefinitionRequest request) throws Exception {
		
		ProcessDefinitionDTO processDefinitionDTO = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(request.getFile().getInputStream());
		NodeList nodeList = doc.getElementsByTagName(TAG_PROCESS);
		
		// validar que exista el tag process en el proceso a configurar
		if(Objects.isNull(nodeList) || nodeList.getLength() == 0) {
			throw new ProcessDefinitionException(ERROR_TAG_PROCESS_NOT_FOUNT);
		}
		
		NamedNodeMap node = nodeList.item(0).getAttributes();
		
		// validar que exista el id y el nombre del proceso en el proceso a configurar
		if (Objects.isNull(node) || Objects.isNull(node.getNamedItem(ITEM_ID))
				|| Objects.isNull(node.getNamedItem(ITEM_NAME))) {
			throw new ProcessDefinitionException(ERROR_ITEM_ID_OR_NAME_NOT_FOUNT);
		}
		
		// armar objeto de respuesta
		processDefinitionDTO = ProcessDefinitionDTO.builder()
				.processDefinitionKey(node.getNamedItem(ITEM_ID).getTextContent())
				.processDefinitionName(node.getNamedItem(ITEM_NAME).getTextContent()).build();
		
		return processDefinitionDTO;
		
	}
	
}
