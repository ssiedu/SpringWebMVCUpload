
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.List"%>
<%@page import="com.ssi.User"%>


<html>
<body>
<h2>All-User-Details</h2>
<table border="2">
<tr><td>UID</td><td>NAME</td><td>Pic</td></tr>
<c:forEach items="${users}" var="user">
<tr>
<td>${user.userId}</td>
<td>${user.userName}</td>
<td><img src="imageDisplay?id=${user.userId}" width="50" height="50"/></td>
</c:forEach>
</table>
</body>
</html>
