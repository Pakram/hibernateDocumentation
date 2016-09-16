<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <c:forEach items="${persons}" var="person">
        <tr><td>${person.id}</td><td>${person.firstName}</td><td>${person.lastName}</td><td>${person.age}</td></tr>
        <c:forEach var="address" items="${person.addresses}">
            <tr><td>${address.id}</td><td>${address.city}</td><td>${address.street}</td><td>${address.house}</td></tr>
        </c:forEach>
    </c:forEach>
</table>

