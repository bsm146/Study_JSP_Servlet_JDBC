package controller;

import dao.BoardDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller/*")
public class MainController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        int lastSlash = requestURI.lastIndexOf("/");
        requestURI = (requestURI.substring(lastSlash)).substring(1);
        System.out.println();

        // ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────



        // ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────

        System.out.println();

        if (requestURI.equals("hello")) {
            BoardDAO boardDAO = new BoardDAO();
            boardDAO.boardList(request, response);
            request.getRequestDispatcher("/hello.jsp").forward(request, response);
        }
    }
}