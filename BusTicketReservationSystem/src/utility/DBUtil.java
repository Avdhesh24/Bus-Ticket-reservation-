//package utility;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBUtil {
//    public static Connection provideConnection() {
//        Connection conn = null;
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        String url = "jdbc:mysql://localhost:3306/bus_ticket_reservation";
//
//        try {
//            conn = DriverManager.getConnection(url, "root", "Avijalaj@24");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return conn;
//    }
//}

package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    // Configuration for SSL and database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/bus_ticket_reservation?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "Avijalaj@24";

    public static Connection provideConnection() {
        Connection conn = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Please add the JDBC library to the classpath.");
            e.printStackTrace();
        }

        try {
            // Establish connection to the database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Connection to the database failed. Check the URL, user, and password.");
            e.printStackTrace();
        }

        return conn;
    }
}

