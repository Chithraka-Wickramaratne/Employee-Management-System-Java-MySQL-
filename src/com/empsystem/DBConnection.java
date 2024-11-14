package com.empsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

        static Connection con;
        public static Connection createDBConnection(){

            try{

                String url = "jdbc:mysql://localhost:3306/employeeDB?useSSL=false";
                String username = "root";
                String password = "123";

               con = DriverManager.getConnection(url,username,password);

            }catch(Exception ex){
                ex.printStackTrace();
            }
            return con;
        }
}
