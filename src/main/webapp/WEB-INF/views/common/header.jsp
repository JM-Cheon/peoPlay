<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/common/header.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <header class="header">
        <div class="header_box">
            <div class="logo">
                <a href="${ pageContext.servletContext.contextPath }"><img src="${ pageContext.servletContext.contextPath }/resources/images/peoPlay.png"></a>
            </div>
            <div class="nav">
                <ul> 
                    <li><a href="${ pageContext.servletContext.contextPath }">홈</a></li>
                    <li><a href="${ pageContext.servletContext.contextPath }/movie/list">영화</a></li>
                    <li><a href="${ pageContext.servletContext.contextPath }/notice/ntclist">문의</a></li>
                    <li><a href="${ pageContext.servletContext.contextPath }/goods/goodslist">굿즈</a></li>
                    <c:if test="${ sessionScope.loginMember.userRole ne 'BLACK' }">	
 	                   <li><a href="${pageContext.servletContext.contextPath}/board/list">커뮤니티</a></li>
                    </c:if>
                    <li><a href="${ pageContext.servletContext.contextPath }/member/subscribe">구독권 결제</a></li>
                </ul>
            </div>
    	<c:if test="${ empty sessionScope.loginMember }">
	        <div class="mainlogin" onclick="location.href='${ pageContext.servletContext.contextPath }/member/login';">
	        	LOGIN
	        </div>
    	</c:if>
    	<c:if test="${ !empty sessionScope.loginMember }">
	    	<c:if test="${ sessionScope.loginMember.userRole eq 'MEMBER' || sessionScope.loginMember.userRole eq 'BLACK' }">
		        <div class="afterLogin">
		        	<ul>
		        		<li><a href="${ pageContext.servletContext.contextPath }/member/logout">로그아웃</a></li>
		        		<li><a href="${ pageContext.servletContext.contextPath }/member/mypage">${ sessionScope.loginMember.nickname }님 반갑습니다.</a></li>
		        	</ul>
		        </div>
	    	</c:if>
	    	<c:if test="${ sessionScope.loginMember.userRole eq 'ADMIN' }">
		        <div class="adminLogout" onclick="location.href='${ pageContext.servletContext.contextPath }/member/logout';">
	        	LOGOUT
	        	</div>
		        <div class="adminMode" onclick="location.href='${ pageContext.servletContext.contextPath }/admin/';">
	        	ADMIN MODE
	        	</div>
	    	</c:if>
        </c:if>
	    </div>
    </header>
    <script>
    $(document).ready(function(){
        $(window).on("scroll", function(){
            var scroll = $(window).scrollTop();
            if (scroll > 1) {
                $(".header_box").css("background" , "#2c2c2c");
            }
            else{
                $(".header_box").css("background" , "linear-gradient(to top, rgba(44, 44, 44, 0) 10%, rgba(44, 44, 44, 0.75) 75%)");   
            }
        })
    })
    
    $(".nav ul li").click(function(){
    	if("${ empty sessionScope.loginMember}" == "true"){
    		if($(this).text() != "홈"){
	    		alert("로그인 후 이용 가능합니다.");
	    		return false;
    		}
    	} else {
	    	return true;
    	}
    });
    </script>
</body>
</html>