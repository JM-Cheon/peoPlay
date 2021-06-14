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
	<input type="hidden" id="selectWatchList" value="${watchList}">

</body>

<script>
/* 재생 카운트 기능 */
 $(document).ready(function() {
    var userNo = ${ sessionScope.loginMember.userNo };
    var movieNo = ${ requestScope.no};
	console.log(userNo);
	console.log(movieNo);
	
	var selectWatchList = document.getElementById("selectWatchList").value;
	
	
	if(selectWatchList == '없음'){
		
/*  ajax로 insert */
	$.ajax({
        url : "${pageContext.servletContext.contextPath}/movie/watchList",
        method : "POST",
        data : {
        	'userNo' : userNo,
        	'movieNo' : movieNo
        },
           success : function(data) {

           }, 
           error:function(request, status, error){
       		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
       		}
  		}) 
	}else if(selectWatchList == "있음"){
}
})
</script>
<link rel="stylesheet" href="/peoplay/resources/css/movie/main.css">
</html>