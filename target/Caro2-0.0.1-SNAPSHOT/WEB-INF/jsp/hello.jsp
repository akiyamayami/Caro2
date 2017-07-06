<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Hello Facebook</title>
</head>
<body>
	<h3>Hello, <span><c:out value="${facebookProfile.name}"></c:out></span>!</h3>

	<h4>Here is your feed:</h4>

	<c:forEach items="${feed}" var="post">
		<b ><c:out value="${post.from.name}"/></b> Date post: <c:out value="${post.createdTime}"/> <a href="/delete-${post.id}">Delete Post</a>
		<p>wrote:</p>
		<p><c:out value="${post.message}"/></p>
		<p>${post.picture}</p>
		<c:if test="${post.picture != null}">
			<img src="${post.picture}"/>
		</c:if>
		<hr/>
	</c:forEach>
</body>
</html>