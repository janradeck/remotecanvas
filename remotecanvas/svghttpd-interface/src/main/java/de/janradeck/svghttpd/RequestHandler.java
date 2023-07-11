package de.janradeck.svghttpd;

public abstract class RequestHandler {
	protected SvgApplication application;
	protected CommunicationServer server;

	public RequestHandler(SvgApplication application, CommunicationServer server) {
		this.application = application;
		this.server = server;
	}
		
	public abstract void executeHandler(Communication communication, Parameters params, SvgApplication application);
}
