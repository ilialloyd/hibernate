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
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni?useSSL=false";
        String user = "root";
        String password = "*Lenovo2022";
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


