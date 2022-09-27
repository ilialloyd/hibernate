package com.exercise.jdbc.connector;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        //we use useSSL to prevent warning
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "JPA_relationships";
        String password = "jpa055";
        try{
            System.out.println("Connecting to database: "+jdbcUrl);

            Connection connection=
                    DriverManager.getConnection(jdbcUrl,user,password);

            System.out.println("Connection successful");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


