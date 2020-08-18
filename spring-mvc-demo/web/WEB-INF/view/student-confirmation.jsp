<%--
  Created by IntelliJ IDEA.
  User: Thijs
  Date: 17/08/2020
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Registration Confirmation</title>
</head>
<body>
<h1>Confirmation</h1>
<p>The student is confirmed: ${student.firstName} ${student.lastName}</p>
<p>Country: ${student.country}</p>
<p>Favourite Language: ${student.favouriteLanguage}</p>
<p>Operating Systems:
<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
        <li>${temp}</li>
    </c:forEach>
</ul>
</p>
</body>
</html>
