package de.janradeck.svghttpd;

public interface CommunicationServer {
	void addHandler(String context, RequestHandler requestHandler);
	
	void start();
	
	void stop(int delaySeconds);
}
