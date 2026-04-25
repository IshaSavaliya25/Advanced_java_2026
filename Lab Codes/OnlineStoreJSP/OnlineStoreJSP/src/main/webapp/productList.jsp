<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="productBean" class="com.allysoftsolutions.store.ProductBean" scope="page"/>

<html>
<body>

<h2>Product List</h2>

<table border="1">
    <tr><th>Name</th><th>Price</th><th>Stock</th><th>Order</th></tr>

    <c:forEach var="p" items="${applicationScope.inventory}">
        <tr>
            <td>${fn:toUpperCase(p.name)}</td>
            <td><fmt:formatNumber value="${p.price}" type="currency"/></td>

            <td>
                <c:choose>
                    <c:when test="${p.stockQuantity < 10}">
                        <span style="color:red;">Low Stock</span>
                    </c:when>
                    <c:otherwise>Available</c:otherwise>
                </c:choose>
            </td>

            <td>
                <form action="placeOrder" method="post">
                    <input type="hidden" name="productId" value="${p.id}">
                    <input type="number" name="quantity" required>
                    <input type="submit" value="Buy">
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

<h3>Cart</h3>

<c:set var="cartTotal" value="0"/>

<c:if test="${not empty sessionScope.cart}">
    <c:forEach var="item" items="${sessionScope.cart}">
        <p>${item.product.name} -
            <fmt:formatNumber value="${item.totalValue}" type="currency"/></p>

        <c:set var="cartTotal" value="${cartTotal + item.totalValue}"/>
    </c:forEach>

    <p><strong>Total: <fmt:formatNumber value="${cartTotal}" type="currency"/></strong></p>
</c:if>

<h3>Global Sales:
    <fmt:formatNumber value="${applicationScope.globalSales}" type="currency"/></h3>

</body>
</html>