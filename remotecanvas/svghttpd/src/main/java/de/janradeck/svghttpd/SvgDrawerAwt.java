package de.janradeck.svghttpd;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.swing.JSVGCanvas;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGElement;

public class SvgDrawerAwt implements SvgDrawer {
    private static final String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;

	protected JSVGCanvas canvas;
	protected SVGDocument doc;
	protected SVGGraphics2D g;
		
	public SvgDrawerAwt(JSVGCanvas canvas)  {
		this.canvas = canvas;
		clearCanvas();
	}
	
	public void clearCanvas() {
		System.out.println("clearCanvas");
		DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
	    this.doc = (SVGDocument) impl.createDocument(svgNS, "svg", null);
	    this.g = new SVGGraphics2D(doc);		
	    this.canvas.setSVGDocument(doc);
	}

	public void draw(String message, String path, String style) {
		System.out.println(message);
		SVGElement svgPath = (SVGElement) this.doc.createElementNS(svgNS, "path");
		
		svgPath.setAttribute("d", path);
		svgPath.setAttribute("style", style);
		doc.getRootElement().appendChild(svgPath);
		updateCanvas();
	}
	
	protected void updateCanvas() {
		// Anregung aus
		// https://javaranch.com/journal/200410/JavaDesigns-SwingMultithreading.html
		final JSVGCanvas localCanvas = canvas;
		try {
			javax.swing.SwingUtilities.invokeAndWait(new Runnable() {

				public void run() {
					localCanvas.setSVGDocument(doc);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		// this.canvas.setSVGDocument(doc);
	}

}
