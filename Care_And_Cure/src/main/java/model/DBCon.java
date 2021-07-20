/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alex
 */
public class DBCon {

    public Connection createConnection() throws ClassNotFoundException, SQLException, URISyntaxException {
       Class.forName("com.mysql.jdbc.Driver");
 
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/care_and_cure", "root", "");
//        return con;

        
        
        URI dbUri = new URI(System.getenv("mysql://b23002138febbb:2cc02d85@us-cdbr-east-04.cleardb.com/heroku_f92d980babf5ec7?reconnect=true"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        Connection con = DriverManager.getConnection(dbUrl, username, password);
        return con;

    }
}
