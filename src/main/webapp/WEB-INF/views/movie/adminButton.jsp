<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 영화 관리</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/peoplay/resources/css/movie/list.css">

</head>
<body>
	<br><br><br><br><br><br><br><br><br><br><br>
	<div align="center">
		<button class="mvimg" onclick="location.href='${ pageContext.servletContext.contextPath }/movie/adminInsert'"> 등록 페이지</button>
		<br>
		<button class="mvimg" onclick="location.href='${ pageContext.servletContext.contextPath }/movie/adminUpdateSelect'"> 수정 페이지</button>
		<br>
		<button class="mvimg" onclick="location.href='${ pageContext.servletContext.contextPath }'"> 메인으로</button>
		<br>
	</div>
</body>
	<link rel="stylesheet" href="/peoplay/resources/css/movie/main.css">
</html>