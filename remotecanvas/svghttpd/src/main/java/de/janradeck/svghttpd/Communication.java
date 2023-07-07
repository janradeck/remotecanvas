package de.janradeck.svghttpd;

public interface Communication {
	
	void setStatus(int status);
	
	void reply(String message);

}
