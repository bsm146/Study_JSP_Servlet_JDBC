<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="test.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>a</title>
</head>
<body>

<%
    Product iPhone = new Product("iPhone", "Apple", 800000);
    Product gram = new Product("gram", "LG", 900000);
    Product galaxy = new Product("galaxy", "Samsung", 1000000);

    List<Product> listProduct = new ArrayList<>();
    listProduct.add(iPhone);
    listProduct.add(gram);
    listProduct.add(galaxy);

    session.setAttribute("listProduct", listProduct);

    for (int i = 0; i < listProduct.size(); i++) {
%>
        <button onclick="location.href='b.jsp?index=<%=i%>'">보내기</button>
<%
    }
%>


</body>
</html>
