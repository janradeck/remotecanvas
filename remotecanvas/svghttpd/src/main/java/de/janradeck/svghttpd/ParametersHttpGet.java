package de.janradeck.svghttpd;

import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParametersHttpGet implements Parameters {
	private Map<String, String> parameters;

	public ParametersHttpGet(String query) {
		parameters = new LinkedHashMap<>();
		if (null == query)
			return;
		String[] pairs = query.split("&");
		for (String pair : pairs) {
			int idx = pair.indexOf("=");
			try {
				parameters.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
						URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
			} catch (Exception e) {
			}
		}
	}

	@Override
	public String get(String key) {
		return parameters.get(key);
	}

}
