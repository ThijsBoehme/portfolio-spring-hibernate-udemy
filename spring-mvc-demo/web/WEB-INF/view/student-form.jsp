<%--
  Created by IntelliJ IDEA.
  User: Thijs
  Date: 17/08/2020
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    First name: <form:input path="firstName"/><br/>
    Last name: <form:input path="lastName"/><br/>
    Country:
        <form:select path="country">
            <form:options items="${student.countryOptions}"/>
        </form:select><br/>
    Favourite Programming Language:
        Java<form:radiobutton path="favouriteLanguage" value="Java"/>
        Swift<form:radiobutton path="favouriteLanguage" value="Swift"/>
        Kotlin<form:radiobutton path="favouriteLanguage" value="Kotlin"/>
        Ruby<form:radiobutton path="favouriteLanguage" value="Ruby"/><br/>
    Operating Systems:
        Linux<form:checkbox path="operatingSystems" value="Linux"/>
        macOS<form:checkbox path="operatingSystems" value="macOS"/>
        Windows<form:checkbox path="operatingSystems" value="Windows"/><br/>

    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
