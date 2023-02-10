<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>nand.jsp</title>
</head>
<body>

<br><br><br>
<c:set var="pageNum" value="${pageNum == null ? 1 : param.pageNum}"/>

<div class="container">
    <p>현재 페이지(pageNum) : ${pageNum}
    <table style="margin: 10px;" class="table table-hover">
        <tr style="text-align: center; height: 50px;" class="table-secondary">
            <th scope="row">번호</th>
            <th scope="row">제목</th>
            <th scope="row">작성자</th>
            <th scope="row">조회수</th>
            <th scope="row">작성일</th>
        </tr>
        <c:forEach var="i" items="${boardList}" end="9" >
            <tr style="text-align: center; height: 50px;">
                <td width="10%" scope="row">${i.id}</td>
                <td width="50%" scope="row">${i.title}</td>
                <td width="15%" scope="row">${i.content}</td>
                <td width="10%" scope="row"></td>
                <td width="15%" scope="row"></td>
            </tr>
        </c:forEach>
    </table>
    <div style="text-align: center">
        <c:forEach var="i" begin="1" end="5">
            <button onclick="location.href=''" type="button" class="btn btn-secondary">${i}</button>
        </c:forEach>
    </div>
</div>


</table>
</body>
</html>
