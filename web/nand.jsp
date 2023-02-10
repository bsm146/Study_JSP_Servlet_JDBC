<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<p>move.jsp</p>

<br>

<c:forEach var="i" items="${boardList}" varStatus="st">
    <p>${st.index + 1}번</p>
    <p>id = ${i.id}</p>
    <p>name = ${i.name}</p>
    <p>passwd = ${i.passwd}</p>
    <br>
</c:forEach>


</body>
</html>
