package com.saudeall.app.javaonly.api;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Logger;

import com.saudeall.app.javaonly.services.JavaOnlyParametersService;
import com.saudeall.app.javaonly.services.JavaOnlyService;
import com.sun.net.httpserver.HttpServer;

public class JavaOnlyController {
    static Logger log = Logger.getLogger(JavaOnlyController.class.getName());

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8084), 0);

        server.createContext("/v1/javaonly", new JavaOnlyService());
        server.createContext("/v1/javaonly/parameters", new JavaOnlyParametersService());

        server.setExecutor(null); // Use the default executor
        server.start();

        log.info("Server started on port 8084");
    }
}
