<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team Management</title>
</head>
<body>
	<h1>Teams List</h1>
	
	<div>${success}</div>
	
	<table>
		<tr>
			<td>Name</td>
		</tr>
		<c:forEach items="${teams }" var="team">
			<tr>
				<td><a href="${s:mvcUrl('TC#team').arg(0, team).build() }">${team.name }</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>