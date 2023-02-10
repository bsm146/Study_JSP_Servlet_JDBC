package controller;

import dao.BoardDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/qwe")
public class Controller extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.boardView(request, response);

        request.getRequestDispatcher("/move.jsp").forward(request, response);

    }
}