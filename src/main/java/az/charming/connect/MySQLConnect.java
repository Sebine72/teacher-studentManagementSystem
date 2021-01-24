package az.charming.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnect {

    public static Connection connect() throws Exception {


        Class.forName("com.mysql.cj.jdbc.Driver");
        String host = "localhost";
        String port = "3306";
        String db = "librarymanagementdb";
        String conUrl = String.format("jdbc:mysql://%s:%s/%s", host, port, db);
        Connection con = DriverManager.getConnection(conUrl, "root", "12345");
        System.out.println("Connected");
        return con;

    }


}
