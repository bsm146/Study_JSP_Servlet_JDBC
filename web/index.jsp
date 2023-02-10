<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>


<%
    Connection con = null;
    try {
        String url = "jdbc:mysql://localhost:3306/board";
        String user = "root";
        String password = "1234";
//            Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, password);
        System.out.println("DB 연결 성공");
    }
    catch (Exception e) {
        System.out.println("DB 연결 실패");
        e.printStackTrace();
    }
%>


qwe

<a href="move.jsp">move</a>
<button onclick="location='move.jsp'" type="button">move</button>

</body>
</html>

