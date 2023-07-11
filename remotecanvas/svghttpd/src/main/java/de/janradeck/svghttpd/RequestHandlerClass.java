package de.janradeck.svghttpd;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public abstract class RequestHandlerClass  extends RequestHandler implements HttpHandler  {

	public RequestHandlerClass(SvgApplication application, CommunicationServer server) {
		super(application, server);
	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		CommunicationHttp communication = new CommunicationHttp(exchange);
		ParametersHttpGet params = new ParametersHttpGet(exchange.getRequestURI().getQuery());
		executeHandler(communication, params, application);
	}

}
