package de.janradeck.svghttpd;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class ServerAbstraction implements CommunicationServer {
	private static final int SERVER_PORT = 8000;
	private HttpServer server = null;

	public ServerAbstraction() {
		try {
			server = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);
		} catch (IOException e) {
		}
	}

	public void addHandler(String context, RequestHandlerClass requestHandler) {
		server.createContext(context, requestHandler);
	}

	public void start() {
		server.setExecutor(null);
		server.start();
	}

	public void stop(int delaySeconds) {
		server.stop(delaySeconds);
	}
}
