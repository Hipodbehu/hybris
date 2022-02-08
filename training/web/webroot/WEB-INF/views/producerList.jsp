<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>Producer List</title>
<body>
<h1>Producer List</h1>
<ul>
    <c:forEach var="producer" items="${producers}">
        <li>${producer.firstName} ${producer.lastName}</li>
    </c:forEach>
</ul>
</body>
</html>