package dao;

import java.sql.*;

//public class BoardDAO extends JDBConnect {
public class BoardDAO {

    public void boardView() {

        System.out.println(2);

        Statement stmt = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            String url = "jdbc:mysql://localhost:3306/board";
            String user = "root";
            String password = "1234";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("DB 연결 성공");
        }
        catch (Exception e) {
            System.out.println("DB 연결 실패");
            e.printStackTrace();
        }

        try {
            String sql = "SELECT * FROM board";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString(1) + "   " + rs.getString(2));
            }
        }
        catch(SQLException ex) {
            System.out.print("조회 실패");
            System.out.print("SQLException : " + ex.getMessage());
            ex.printStackTrace();
        }




    }
}
