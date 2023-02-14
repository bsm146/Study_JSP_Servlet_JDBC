package dao;

import database.JDBConnect;
import dto.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO extends JDBConnect {

    public void boardList(HttpServletRequest request, HttpServletResponse response) {

        pstmt = null;
        rs = null;
        List<BoardDTO> boardList = new ArrayList<>();

        Integer pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));
        pageNum = (pageNum - 1) * 10;

        try {
            String sql = "SELECT * FROM board ORDER BY id DESC LIMIT ?, 10";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, pageNum);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardDTO boardDTO = new BoardDTO();
                boardDTO.setId(rs.getInt("id"));
                boardDTO.setTitle(rs.getString("title"));
                boardDTO.setContent(rs.getString("content"));
                boardList.add(boardDTO);
            }

            request.setAttribute("boardList", boardList);
            request.setAttribute("boardCount", boardCount());

        } catch (SQLException ex) {
            System.out.println("boardView 실패");
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    public int boardCount() {

        stmt = null;
        rs = null;
        int boardCount = 0;

        try {
            String sql = "SELECT CEIL(COUNT(*) / 10) FROM board";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                boardCount = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("boardCount 실패");
            ex.printStackTrace();
        } finally {
            close();
        }

        return boardCount;
    }

}