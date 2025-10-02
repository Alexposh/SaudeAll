package com.saudeall.app.javaonly.services;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class JavaOnlyParametersService implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();

        Map<String, String> queryParams = parseQueryParams(query);

        String java = queryParams.getOrDefault("java", "JavaDefault");
        String java2 = queryParams.getOrDefault("java2", "Java2Default");
        String body = "Our first java message is " + java + " and our second java message is " + java2 + "!";

        exchange.sendResponseHeaders(200, body.getBytes().length); // headers for the response of this endpoint
        try(OutputStream os = exchange.getResponseBody()){
            os.write(body.getBytes()); // write the body of the response in the responseBody
        }
    }

    // Utility method to parse query parameters into a Map
    private Map<String, String> parseQueryParams(String query) {
        Map<String, String> queryParams = new HashMap<>();
        if (query != null) {
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    queryParams.put(keyValue[0], keyValue[1]);
                }
            }
        }
        return queryParams;
    }
}