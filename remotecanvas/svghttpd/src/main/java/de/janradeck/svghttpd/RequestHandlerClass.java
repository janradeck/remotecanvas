package de.janradeck.svghttpd;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public abstract class RequestHandlerClass  implements RequestHandler, HttpHandler  {
	private SvgApplication application;
	protected CommunicationServer server;

	public RequestHandlerClass(SvgApplication application, CommunicationServer server) {
		this.application = application;
		this.server = server;
	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		CommunicationHttp communication = new CommunicationHttp(exchange);
		ParametersHttpGet params = new ParametersHttpGet(exchange.getRequestURI().getQuery());
		executeHandler(communication, params, application);
	}

}
