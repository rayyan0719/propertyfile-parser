package com.file.parser;

import java.io.IOException;

public class PropertyFileParserMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProperFileParserService fileParser = new ProperFileParserService();
		fileParser.getPropertyValueForKey("valuetoSearchInPropertyFile", "PropertyFileToCheck");
			
	}

}
