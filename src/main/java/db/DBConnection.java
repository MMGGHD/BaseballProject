package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getInstance() {
        String url = "jdbc:mysql://localhost:3306/btmdb";
        String username = "root";
        String password = "root1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("DB연결 성공");
            return connection;
        } catch (Exception e) {
            System.out.println("DB연결 실패");
        }
        return null;
    }

}
