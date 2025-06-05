package com.saudeall.app.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionService {
    public void connect(){
        String jdbcUrl ="jdbc:postgresql://localhost:5432/health";
        String password = "123456";
        String username = "postgres";

        try{
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("We were able to connect");
            connection.close();
        }catch(Exception e){
            System.out.println("We found an exception: "+ e);
        }
    }
}
