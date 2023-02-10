package database;

import java.sql.*;

public class JDBConnect {

    public Connection con;
    public ResultSet rs;
    public PreparedStatement pstmt;
    public Statement stmt;

    public JDBConnect() {

        try {
            String url = "jdbc:mysql://localhost:3306/board";
            String user = "root";
            String password = "1234";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("DB 연결 성공");
        } catch (Exception e) {
            System.out.println("DB 연결 실패");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (rs != null)		rs.close();
            if (con != null)	con.close();
            if (stmt != null)	stmt.close();
            if (pstmt != null)	pstmt.close();
            System.out.println("DB 해제 성공\n");
        }
        catch (Exception e) {
            System.out.println("DB 해제 실패\n");
            e.printStackTrace();
        }
    }
}
