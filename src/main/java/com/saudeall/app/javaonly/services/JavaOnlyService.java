package com.saudeall.app.javaonly.services;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;

import com.sun.net.httpserver.HttpHandler;

public class JavaOnlyService implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        String body = "This is the return message from JavaOnlyService!";
        exchange.sendResponseHeaders(200, body.getBytes().length); // headers for the response of this endpoint
        try(OutputStream os = exchange.getResponseBody()){
            os.write(body.getBytes()); // write the body of the response in the responseBody
        }
    }
}
