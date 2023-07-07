package de.janradeck.svghttpd;

public class InjectionFactoryServerHttp implements InjectionFactoryServer {

	@Override
	public CommunicationServer getServer() {
		return new ServerAbstraction();
	}

}
