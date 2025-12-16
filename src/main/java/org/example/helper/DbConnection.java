package org.example.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

public static String url = "jdbc:sqlserver://KEDS-LPT30662-2:1433;databaseName=LMSDB;encrypt=false; trustServerCertificate=true;";
public static String user = "gezimc";
public static String password = "gezimc";


public static Connection connect() {
    try {
        return DriverManager.getConnection(url, user, password);
} catch (SQLException e) {
        throw new RuntimeException(e);
    }
}


}
