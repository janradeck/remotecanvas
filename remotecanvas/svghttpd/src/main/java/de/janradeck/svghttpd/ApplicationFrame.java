package de.janradeck.svghttpd;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.apache.batik.swing.JSVGCanvas;

public class ApplicationFrame extends JFrame implements SvgApplication {
	
	private static final long serialVersionUID = 29887733520762941L;

	private SvgDrawerAwt svgDrawer;
    protected SvgDrawerServer server;

    protected JFrame frame;

    protected JButton buttonClear = new JButton("Clear");
    protected JButton buttonClose = new JButton("Stop");
    protected static JSVGCanvas jsvgCanvas = new JSVGCanvas();

    public ApplicationFrame() {	
    	InjectionFactoryServer factory = new InjectionFactoryServerHttp();
       	server = new SvgDrawerServer(this, factory);
        
        frame = new JFrame("SVG Application");
        frame.getContentPane().add(createComponents());
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setSize(1280, 800);
        frame.setVisible(true);
      
        svgDrawer = new SvgDrawerAwt(jsvgCanvas);   
    }
    
    @Override
    public void draw(String title, String path, String style) {
    	svgDrawer.draw(title, path, style);
    }
    
    @Override
    public void clearCanvas() {
    	svgDrawer.clearCanvas();
    }
    
    @Override
    public void close() {
    	System.exit(0);
    }

    public JComponent createComponents() {
        // Create a panel and add the button, status statusLabel and the SVG canvas.
        final JPanel panel = new JPanel(new BorderLayout());

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.add(buttonClear);
        p.add(buttonClose);

        panel.add("North", p);
        panel.add("Center", jsvgCanvas);

        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	svgDrawer.clearCanvas();
            }
        });
        
        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	server.stop();
            	close();
            }
        });

        return panel;
    }
    
    public static void main(String[] args) {
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { 	
            	new ApplicationFrame();
            }
        });
    }
     
}