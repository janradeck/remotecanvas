package de.janradeck.svgclient;

public class InjectionFactoryClientHttp implements InjectionFactoryClient {

	@Override
	public QueryGenerator getQueryGenerator(String request) {
		return new DynamicQuery(request);
	}

}
