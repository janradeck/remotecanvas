package de.janradeck.svgclient;

public interface QueryGenerator {
	void addParameter(String name, String value);
	
	void executeGetQuery();
}
