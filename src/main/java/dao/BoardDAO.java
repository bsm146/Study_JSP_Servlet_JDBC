package dao;

import database.JDBConnect;
import dto.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO extends JDBConnect {

    public void boardView(HttpServletRequest request, HttpServletResponse response) {

        List<BoardDTO> boardList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM board";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                BoardDTO boardDTO = new BoardDTO();
                boardDTO.setId(rs.getInt("id"));
                boardDTO.setName(rs.getString("name"));
                boardDTO.setPasswd(rs.getString("passwd"));
                boardList.add(boardDTO);
            }

            request.setAttribute("boardList", boardList);
        }

        catch (SQLException ex) {
            System.out.print("boardView 실패");
            ex.printStackTrace();
        }

        finally {
            close();
        }













    }
}
