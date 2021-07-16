package Sem12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;

public class ConnectionManager {
    private static Connection conn;
    private Lock lock;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(conn == null) {

        }
        return conn;
    }
}
