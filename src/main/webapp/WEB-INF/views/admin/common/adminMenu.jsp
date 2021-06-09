<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/admin/admin.css">
</head>
<body>
	<div class="admin_nav">
		<div class="color1" onclick="location.href='${ pageContext.servletContext.contextPath }/#';">영화 관리</div>
		<div class="color2" onclick="location.href='${ pageContext.servletContext.contextPath }/admin/member';">회원 관리</div>
		<div class="color1" onclick="location.href='${ pageContext.servletContext.contextPath }/#';">굿즈 관리</div>
		<div class="color2" onclick="location.href='${ pageContext.servletContext.contextPath }/#';">신고 관리</div>
		<div class="color2" onclick="location.href='${ pageContext.servletContext.contextPath }/#';">공지사항 관리</div>
		<div class="color1" onclick="location.href='${ pageContext.servletContext.contextPath }/#';">FAQ 관리</div>
		<div class="color2" onclick="location.href='${ pageContext.servletContext.contextPath }/#';">문의 관리</div>
		<div class="color1" onclick="location.href='${ pageContext.servletContext.contextPath }/admin/adminBoard/list'">자유게시판 관리</div>
	</div>
</body>
</html>