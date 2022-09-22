package com.file.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

public class ProperFileParserService {
	public String getPropertyValueForKey(String propertyFileCodeValue, String propertyFileName) throws IOException {
		String entityCode = "";
		Map<String, String> propFileMap = new HashMap<>();
		propFileMap.put("propFileKey", "propFileValue");
		if (!propertyFileName.isEmpty()) {
			String entityPropertyFile = propFileMap.get(propertyFileName);
			Properties props = readPropertiesFile(entityPropertyFile);
			Optional<String> propValue = props.entrySet().stream()
					.filter(e -> e.getKey().toString().equals(propertyFileCodeValue))
					.map(map -> map.getValue().toString()).findFirst();
			entityCode = propValue.orElse("");
		}
		return entityCode;
	}

	public static Properties readPropertiesFile(String fileName) throws IOException {
		Properties prop = new Properties();
		InputStream iStream = null;
		iStream = ProperFileParserService.class.getClassLoader().getResourceAsStream(fileName);
		if (iStream == null) {
			throw new IOException("File Not Found" + fileName);
		}
		prop.load(iStream);
		return prop;
	}

}
