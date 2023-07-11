package de.janradeck.svghttpd;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;

public class CommunicationHttp implements Communication {
	private HttpExchange exchange;

	public CommunicationHttp(HttpExchange exchange) {
		this.exchange = exchange;
	}

	public void reply(int status, String message) {
		try {
			exchange.sendResponseHeaders(status, message.length());
			OutputStream os = exchange.getResponseBody();
			os.write(message.getBytes());
			os.close();
		} catch (IOException ex) {

		}
	}
}
