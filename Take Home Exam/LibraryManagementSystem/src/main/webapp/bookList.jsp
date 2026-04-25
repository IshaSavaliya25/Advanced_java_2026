<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="book" items="${sessionScope.issuedBooks}">

    <c:if test="${book.availablecopies < 2}">
        <p style="color:red;">
                ${book.title} (Low Stock)
        </p>
    </c:if>

    <c:if test="${book.availablecopies >= 2}">
        <p>${book.title}</p>
    </c:if>

</c:forEach>