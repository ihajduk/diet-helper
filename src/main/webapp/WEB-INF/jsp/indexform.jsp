<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Diet Helper</title>
<style type="text/css">
    .error{
        color: #ff0000;
    }
    .errorblock{
        color: #000;
        background-color: #ffEEEE;
        border: 3px solid #ff0000;
        padding: 8px;
        margin: 16px;
    }

</style>

</head>

<body>
<form:form commandName="caloricNeedsForm">
    <form:errors path="*" cssClass="errorbock" element="div"/>
    <label for="textinput1">weight:</label>
    <form:input path="weight" cssErrorClass="error"/>
    <form:errors path="weight" cssClass="error"/>
    <label for="textinput2">height:</label>
    <form:input path="height" cssErrorClass="error"/>
    <form:errors path="height" cssClass="error"/>
    <label for="textinput3">age:</label>
    <form:input path="age" cssErrorClass="error"/>
    <form:errors path="age" cssClass="error"/>
    <br>
    <input type="submit" class="btn" value="Generate diet" />
</form:form>

</body>
</html>