<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<h2 align="center"><c:out value="${requestScope.play.name}"/></h2>
	<br><br>
	<div align="center">
      <iframe width="1400" height="600" src="${requestScope.play.movieVideoRink}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	</div>
	<br><br><br><br><br><br><br><br><br>
<jsp:include page="../common/footer.jsp"/>
</body>
<link rel="stylesheet" href="/peoplay/resources/css/movie/main.css">
</html>