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

        // 마지막 / 이후의 단어(어느 페이지에서 왔는지)를 추출하는 과정
        // JSP 파일에서 /controller/hello를 호출했다면 requestURI는 hello가 됨
        String requestURI = request.getRequestURI();
        int lastSlash = requestURI.lastIndexOf("/");
        requestURI = (requestURI.substring(lastSlash)).substring(1);

        String route = "";    // 어느 페이지로 이동할건지
        String routeHow = ""; // request와 response중 어떤 방식으로 페이지 이동할건지

        System.out.println();

        // -----------------------------------------------------------------------------------------------------------------



        // -----------------------------------------------------------------------------------------------------------------

        System.out.println();

        if (requestURI.equals("hello")) {
            BoardDAO boardDAO = new BoardDAO();
            boardDAO.boardList(request, response);
            route = "/hello.jsp";
            routeHow = "request";
        }

        if (routeHow.equals("request")) {
            request.getRequestDispatcher(route).forward(request, response);
        }

        else if (routeHow.equals("response")) {
            response.sendRedirect(route);
        }
    }
}