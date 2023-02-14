<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>hello.jsp</title>
</head>
<body>

    <br>

    <c:set var="pageNum"  value="${param.pageNum == null ? 1 : param.pageNum}"/> <%-- 현재 페이지번호 --%>
    <c:set var="startNum" value="${pageNum - ((pageNum - 1) % 10)}"/>            <%-- for문 시작 번호 --%>
    <c:set var="endNum"   value="${startNum + 9}"/>                              <%-- for문 종료 번호 --%>
    <fmt:parseNumber var="pageNumEnd" value="${boardCount}" integerOnly="true"/>

    <div class="container">
        <p>현재 페이지 : ${pageNum}</p>
        <p>이전 페이지 : ${endNum - 19}</p>
        <p>다음 페이지 : ${endNum + 1}</p>
        <p>버튼(for문) : ${startNum} ~ ${endNum}</p>
        <p>버튼 개수 : ${boardCount}</p>
        <p>pageNumEnd : ${pageNumEnd - (pageNumEnd - 1) % 10}</p>
        <br>
        <table style="margin: 10px;" class="table table-hover">
            <tr style="text-align: center; height: 50px;" class="table-secondary">
                <th scope="row">번호</th>
                <th scope="row">제목</th>
                <th scope="row">작성자</th>
                <th scope="row">조회수</th>
                <th scope="row">작성일</th>
            </tr>
            <c:forEach var="i" items="${boardList}" end="9">
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
            <button ${pageNum < 11 ? "disabled='disabled'" : ""} onclick="location.href='/controller/hello?pageNum=1'" type="button" class="btn btn-secondary">◀◀</button>
            <button ${pageNum < 11 ? "disabled='disabled'" : ""} onclick="location.href='/controller/hello?pageNum=${endNum - 19}'" type="button" class="btn btn-secondary">◀</button>
            <c:forEach var="i" begin="${startNum}" end="${endNum}">
                <c:if test="${i <= boardCount}">
                    <button ${i != pageNum ? "style='background: #d2d2d2; border: none'" : ""} onclick="location.href='/controller/hello?pageNum=${i}'" type="button" class="btn btn-secondary">${i}</button>
                </c:if>
            </c:forEach>
            <button ${endNum > boardCount ? "disabled='disabled'" : ""} onclick="location.href='/controller/hello?pageNum=${endNum + 1}'"type="button" class="btn btn-secondary">▶</button>
            <button ${endNum > boardCount ? "disabled='disabled'" : ""} onclick="location.href='/controller/hello?pageNum=${pageNumEnd}'"type="button" class="btn btn-secondary">▶▶</button>
        </div>
    </div>



</table>
</body>
</html>
