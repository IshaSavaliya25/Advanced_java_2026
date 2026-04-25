<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:useBean id="productBean" class="com.allysoftsolutions.store.ProductBean" scope="page"/>

<html>
<body>

<h2>Search</h2>

<form action="search.jsp">
    <input type="text" name="searchName">
    <input type="submit">
</form>

<p>Search: ${param.searchName}</p>

<p>Cart Size: ${empty sessionScope.cart ? 0 : fn:length(sessionScope.cart)}</p>

<p>Bean Discount Example: ${productBean.calculateDiscountedTotal(6)}</p>

<a href="productList.jsp">Back</a>

</body>
</html>