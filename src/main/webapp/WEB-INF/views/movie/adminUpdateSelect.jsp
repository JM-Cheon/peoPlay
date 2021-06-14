<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 영화수정 리스트</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<style>
   button.mvimg{ height: 40px; width: 150px; background-color: #606060; margin-top: 10px; margin-bottom: 10px; }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<hr>
	<h2 align="center">관리자 영화 수정</h2>
      <br><br><br><br><br>   
	   <section id="section_search_ajax" style="width:1300px; margin-left:270px; height: 500px; overflow: auto;">
 	    	   <c:forEach var="movie" items="${ requestScope.list }">
		           	<article id="movieList" style="width: 200px; height: 150px; margin: 0px 10px 10px 0px; float:left;">
		                 <button id="${ movie.no }" class="mvimg">
		                 	<c:out value="${ movie.no }"/>.
		                 	<c:out value="${ movie.name }"/>
		                 </button>
						<button id="movieUpdate" type="button" class="movieUpdate mvimg" value="${ movie.no }">영화 수정
						</button>		                 
			        </article>
		       </c:forEach>
 	  </section>
 	   	  <button class="mvimg" type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/movie/adminButton'"> 뒤로가기</button>
 	  
</body>
	<link rel="stylesheet" href="/peoplay/resources/css/movie/main.css">
<script>
	/* 영화 수정 페이지 이동 */
	if(document.getElementsByTagName("article")) {
	const $tds = document.getElementsByTagName("article");
	for(var i = 0 ; i < $tds.length ; i++) {
	   
	$tds[i].onmouseenter = function() {
	   this.parentNode.style.cursor = "pointer";
	}
	   
	$tds[i].onclick = function() {
			  const no = $(this).children("button").attr("id");
		  	  location.href = "${ pageContext.servletContext.contextPath }/admin/" + parseInt(no);
		}   
	}
	
	} 
</script>
	<link rel="stylesheet" href="/peoplay/resources/css/movie/main.css">

</html>