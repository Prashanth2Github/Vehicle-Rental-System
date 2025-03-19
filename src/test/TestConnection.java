package test;

import config.ConnectionManager;
import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        Connection conn = ConnectionManager.getConnection();
        if (conn != null) {
            System.out.println("🎉 Connection successful!");
        } else {
            System.out.println("❌ Connection failed!");
        }
    }
}
