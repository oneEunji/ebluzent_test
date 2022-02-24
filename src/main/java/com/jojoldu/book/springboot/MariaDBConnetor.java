package com.jojoldu.book.springboot;

import java.sql.*;

public class MariaDBConnetor {
    public static void main(String[] args) {
        Connection con = null;

        String server = "127.0.0.1:13306";
        String database = "youtrack";
        String user_name = "ebluzent";
        String password = "ebluzent051#";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" driver error : " + e.getMessage());
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection("jdbc:mariadb://" +
                    server + "/" +
                    database +
                    "?useSSL=false", user_name, password); // SSL 실행 확인
            System.out.println("connect");
        } catch(SQLException e) {
            System.err.println("driver error" + e.getMessage());
            e.printStackTrace();
        }

        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {}
    }
}