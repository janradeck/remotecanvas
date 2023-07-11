package de.janradeck.svghttpd;

public interface SvgApplication extends SvgDrawer {
	
    public void draw(String title, String path, String style);
    
    public void clearCanvas();
    
    public void close();
   
}