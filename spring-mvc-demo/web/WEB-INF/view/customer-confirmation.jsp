<%--
  Created by IntelliJ IDEA.
  User: Thijs
  Date: 18/08/2020
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>
<p>The customer is registered: ${customer.firstName} ${customer.lastName}</p>
<p>Free passes: ${customer.freePasses}</p>
<p>Postal code: ${customer.postalCode}</p>
</body>
</html>
