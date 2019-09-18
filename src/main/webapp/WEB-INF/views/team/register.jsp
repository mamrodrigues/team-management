<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team Management</title>
</head>
<body>
	<h1>Team Register</h1>
	<form:form action="${s:mvcUrl('TC#register').build() }" method="post" commandName="team" enctype="multipart/form-data">
		<div>
			<label>Name</label>
			<form:input path="name" />
			<form:errors path="name" />
		</div>
		<div>
		    <label>Emblem</label>
		    <input name="emblem" type="file" />
		</div>
		<button type="submit">Register</button>
	</form:form>
</body>
</html>