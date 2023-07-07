package de.janradeck.svghttpd;

public interface CommunicationServer {
	void addHandler(String context, RequestHandlerClass requestHandler);
	
	void start();
	
	void stop(int delaySeconds);
}
