package dao;

import database.JDBConnect;
import dto.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO extends JDBConnect {
//public class BoardDAO {

    public void boardView(HttpServletRequest request, HttpServletResponse response) {

        List<BoardDTO> boardList = new ArrayList<>();

//        try {
//            String url = "jdbc:mysql://localhost:3306/board";
//            String user = "root";
//            String password = "1234";
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection(url, user, password);
//            System.out.println("DB 연결 성공");
//        } catch (Exception e) {
//            System.out.println("DB 연결 실패");
//            e.printStackTrace();
//        }

        try {
            String sql = "SELECT * FROM board";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString(1) + "   " + rs.getString(2));
                BoardDTO boardDTO = new BoardDTO();
                boardDTO.setId(rs.getInt("id"));
                boardDTO.setName(rs.getString("name"));
                boardDTO.setPasswd(rs.getString("passwd"));
                boardList.add(boardDTO);
            }

            request.setAttribute("boardList", boardList);

        } catch (SQLException ex) {
            System.out.print("조회 실패");
            System.out.print("SQLException : " + ex.getMessage());
            ex.printStackTrace();
        }


    }
}
