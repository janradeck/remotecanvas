package de.janradeck.svgdemo;

import de.janradeck.svgclient.InjectionFactoryClient;
import de.janradeck.svgclient.InjectionFactoryClientHttp;
import de.janradeck.svgclient.SvgDrawerClient;

public class SvgDemo {

	public static void main(String[] args) {
		InjectionFactoryClient  client = new InjectionFactoryClientHttp();
		SvgDrawerClient drawerClient = new SvgDrawerClient(client);
		int resultCode = drawerClient.drawBlack("Hello, world!", "M 100,100 L 100,200 200,200 200, 100 z");
		System.out.println(String.format("drawBlack resultCode: %d", resultCode));
	}

}
