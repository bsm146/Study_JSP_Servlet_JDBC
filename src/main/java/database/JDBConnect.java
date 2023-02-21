package database;

import java.sql.*;

public class JDBConnect {

    public ResultSet rs;
    public Statement stmt;
    public Connection con;
    public PreparedStatement pstmt;

    public JDBConnect() {

        try {
            final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
            final String DB_URL = "jdbc:mysql://localhost:3306/board";
            final String DB_USER = "root";
            final String DB_PASSWORD = "1234";

            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("DB 연결 성공");
        }
        catch (Exception e) {
            System.out.println("DB 연결 실패");
            e.printStackTrace();
        }
    }

    public void close() {

        try {
            if (rs != null) rs.close();
            if (con != null) con.close();
            if (stmt != null) stmt.close();
            if (pstmt != null) pstmt.close();
            System.out.println("DB 해제 성공");
        }

        catch (Exception e) {
            System.out.println("DB 해제 실패");
            e.printStackTrace();
        }
    }
}
