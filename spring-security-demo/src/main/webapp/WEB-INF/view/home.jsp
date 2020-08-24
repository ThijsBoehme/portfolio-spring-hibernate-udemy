<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>luv2code Company Home Page</title>
</head>
<body>
<h1>luv2code Company Home Page</h1>
<hr/>

<p>Welcome to the luv2code company home page!</p>
<hr/>

<!-- Display user name and role -->
<p>
    User: <security:authentication property="principal.username"/>
    <br/><br/>
    Role(s): <security:authentication property="principal.authorities"/>
</p>
<hr/>

<security:authorize access="hasRole('MANAGER')">
    <!-- Add a link to /leaders (for the managers) -->
    <p>
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a> (only for managers)
    </p>
    <hr/>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
    <!-- Add a link to /systems (for the admins) -->
    <p>
        <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a> (only for admins)
    </p>
    <hr/>
</security:authorize>

<!-- Logout button -->
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>
