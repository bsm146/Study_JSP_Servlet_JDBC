package dao;

import database.JDBConnect;
import dto.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO extends JDBConnect {

    // 게시글 조회 메소드.
    // DB에 있는 게시글 전부를 가져오지 않고 최대 10개만 추출하려고 함
    public void boardList(HttpServletRequest request, HttpServletResponse response) {

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
            // 숫자 버튼 마지막 숫자를 알기 위한 메소드 boardCount()
            // 게시글이 13개일때 버튼은 2개
            // 게시글이 21개일때 버튼은 3개
            request.setAttribute("boardCount", boardCount());
        }
        catch (Exception e) {
            System.out.println("boardView 실패");
            e.printStackTrace();
        }
        finally {
            close();
        }
    }

    // 숫자 버튼 마지막 숫자를 알기 위한 메소드
    public int boardCount() {

        int boardCount = 0;

        try {
            String sql = "SELECT CEIL(COUNT(*) / 10) FROM board";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                boardCount = rs.getInt(1);
            }
        }
        catch (Exception e) {
            System.out.println("boardCount 실패");
            e.printStackTrace();
        }
        finally {
            close();
        }

        return boardCount;
    }
}