<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>luv2code Company Home Page</title>
</head>
<body>
<h1>luv2code Company Home Page</h1>
<hr/>
<p>Welcome to the luv2code company home page!</p>

<!-- Logout button -->
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>
