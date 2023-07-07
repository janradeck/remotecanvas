package de.janradeck.svgclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class DynamicQuery implements QueryGenerator {
	private static final String userAgent = "Mozilla/5.0";
	private static final int PORT = 8000;

	private String query;
	private int parameterCount;

	public DynamicQuery(String verb) {
		this.query = verb;
		parameterCount = 0;

	}

	public void addParameter(String name, String value) {
		try {
			String fullParameter = name + "=" + URLEncoder.encode(value, "UTF-8");
			if (0 == parameterCount) {
				query = query + "?" + fullParameter;
			} else {
				query = query + "&" + fullParameter;
			}
			parameterCount++;
		} catch (UnsupportedEncodingException e) {
		}
	}

	public void executeGetQuery() {
		String fullQuery = String.format("http://localhost:%d%s", PORT, query);
		try {
			URL url = new URL(fullQuery);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("User-Agent", userAgent);
			urlConnection.getResponseCode();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}

}
