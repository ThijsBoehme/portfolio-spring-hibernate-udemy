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

<!-- Logout button -->
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>
