<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Diet Helper</title>
</head>
<body>
<h1>You have to eat daily: ${calories}kcal</h1>
<form:form modelAttribute="productsList">
<table>
<tr>
	<th>Product name</th>
	<th>Grams</th>
	<th>Protein</th>
	<th>Carbohydrate</th>
	<th>Fat</th>
</tr>
	<c:forEach items="${productsList}" var="prod">
		<tr>
			<td>${prod.productName}</td>
			<td>${prod.weightBase}</td>
			<td>${prod.protein}</td>
			<td>${prod.carbohydrate}</td>
			<td>${prod.fat}</td>
		</tr>
	</c:forEach>
</table>
</form:form>
</body>
</html>
