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
    <c:set var="startNum" value="${pageNum - ((pageNum - 1) % 10)}"/>            <%-- for문 시작 index --%>
    <c:set var="endNum"   value="${startNum + 9}"/>                              <%-- for문 종료 index --%>
    <fmt:parseNumber var="pageNumEnd" value="${boardCount}" integerOnly="true"/> <%-- 버튼 개수(boardCount)를 정수로 변환 후 pageNumEnd에 넘김(마지막 버튼(▶▶) 만들기 위해서) --%>

    <div class="container">
        <p>현재 페이지 : ${pageNum}</p>                             <%-- 현재 페이지번호 --%>
        <p>이전 페이지 : ${endNum - 19}</p>                         <%-- 이전 버튼(◀) --%>
        <p>다음 페이지 : ${endNum + 1}</p>                          <%-- 다음 버튼(▶) --%>
        <p>버튼(for문) : ${startNum} ~ ${endNum}</p>               <%-- for문 시작 index, 종료 index --%>
        <p>버튼 개수 : ${boardCount}</p>                           <%-- 버튼 개수 --%>
        <p>pageNumEnd : ${pageNumEnd - (pageNumEnd - 1) % 10}</p> <%-- 마지막(▶▶) 버튼 눌렀을때의 페이지 번호 --%>
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
            <%-- 1 ~ 10 페이지에서 처음(◀◀), 이전(◀) 버튼 비활성화 --%>
            <button ${pageNum < 11 ? "disabled='disabled'" : ""} onclick="location.href='/controller/hello?pageNum=1'" type="button" class="btn btn-secondary">◀◀</button>
            <button ${pageNum < 11 ? "disabled='disabled'" : ""} onclick="location.href='/controller/hello?pageNum=${endNum - 19}'" type="button" class="btn btn-secondary">◀</button>
            <c:forEach var="i" begin="${startNum}" end="${endNum}">
                <%-- 시작 index <= 버튼 개수면 숫자 버튼 생성 --%>
                <c:if test="${i <= boardCount}">
                    <%-- for문 index == 현재 페이지 번호일때만 진하게, 나머지는 연하게 --%>
                    <button ${i != pageNum ? "style='background: #d2d2d2; border: none'" : ""} onclick="location.href='/controller/hello?pageNum=${i}'" type="button" class="btn btn-secondary">${i}</button>
                </c:if>
            </c:forEach>
            <%-- for문 종료 index > 버튼 개수면 다음(▶), 마지막(▶▶) 버튼 비활성화 --%>
            <button ${endNum > boardCount ? "disabled='disabled'" : ""} onclick="location.href='/controller/hello?pageNum=${endNum + 1}'"type="button" class="btn btn-secondary">▶</button>
            <button ${endNum > boardCount ? "disabled='disabled'" : ""} onclick="location.href='/controller/hello?pageNum=${pageNumEnd - (pageNumEnd - 1) % 10}'"type="button" class="btn btn-secondary">▶▶</button>
        </div>
    </div>

</table>
</body>
</html>
