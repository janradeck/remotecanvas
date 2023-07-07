package de.janradeck.svghttpd;

public interface RequestHandler {
	void executeHandler(Communication communication, Parameters params, SvgApplication application);
}
