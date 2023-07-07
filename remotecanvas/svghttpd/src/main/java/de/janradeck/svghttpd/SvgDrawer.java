package de.janradeck.svghttpd;

public interface SvgDrawer {
	void clearCanvas();
	
	void draw(String message, String path, String style);
}
