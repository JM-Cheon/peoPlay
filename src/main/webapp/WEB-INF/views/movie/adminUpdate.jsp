<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
   button.mvimg{ height: 40px; width: 150px; background-color: #606060; margin-top: 10px; margin-bottom: 10px; }

</style>
</head>
<body>
		<br><br><br>
		<h2 align="center">관리자 영화 수정</h2> 
		<div align="center">
		<form action="${ pageContext.servletContext.contextPath }/admin/${ no }" id="enroll" method="post" encType="multipart/form-data">
			<input type="hidden" id="no" name="no" value="${ requestScope.detail.no }">
	 		<div class="movie_insert_box">
				영화이름 : <br>
				<input type="text" id="name" name="name" value="${ requestScope.detail.name }" ><br>
	        </div>
	 		<div class="movie_insert_box">
				영화정보 : <br>
				<input type="text" id="info" name="info" value="${ requestScope.detail.info }"><br>
	        </div>
	 		<div class="movie_insert_box">
	 			감독 : <br>
	 			<input type="text" id="director" name="director" value="${ requestScope.detail.director }">
	        </div>
	 		<div class="movie_insert_box">
	 			제작년도 : <br> 
	 			<input type="text" id="productionYear" name="productionYear" value="${ requestScope.detail.productionYear }">
	        </div>
	 		<div class="movie_insert_box">
	 			영화시간 : <br>  
	 			<input type="text" id="movieTime" name="movieTime" value="${ requestScope.detail.movieTime }">
	        </div>
	 		<div class="movie_insert_box">
	 			공포 : <br>
	 			<c:if test="${ requestScope.detail.watchFear == '높음'}">
	 			높음 : 
	 			<input type="radio" id="watchFear" name="watchFear" value="높음" checked>
	 			적음 : 
	 			<input type="radio" id="watchFear" name="watchFear" value="적음">
	 			</c:if>
	 			<c:if test="${ requestScope.detail.watchFear == '적음'}">
	 			높음 : 
	 			<input type="radio" id="watchFear" name="watchFear" value="높음" >
	 			적음 : 
	 			<input type="radio" id="watchFear" name="watchFear" value="적음" checked>
	 			</c:if>
	        </div>
	 		<div class="movie_insert_box">
	 			모방위험 : <br>
	 			<c:if test="${ requestScope.detail.watchModification == '높음'}">
	 			높음 : 
	 			<input type="radio" id="watchModification" name="watchModification" value="높음" checked>
	 			적음 : 
	 			<input type="radio" id="watchModification" name="watchModification" value="적음">
	 			</c:if>
	 			<c:if test="${ requestScope.detail.watchModification == '적음'}">
	 			높음 : 
	 			<input type="radio" id="watchModification" name="watchModification" value="높음" >
	 			적음 : 
	 			<input type="radio" id="watchModification" name="watchModification" value="적음" checked>
	 			</c:if>
	        </div>
	 		<div class="movie_insert_box">
	 			약물 : <br>
	 			<c:if test="${ requestScope.detail.watchDrug == '높음'}">
	 			높음 : 
	 			<input type="radio" id="watchDrug" name="watchDrug" value="높음" checked>
	 			적음 : 
	 			<input type="radio" id="watchDrug" name="watchDrug" value="적음">
	 			</c:if>
	 			<c:if test="${ requestScope.detail.watchDrug == '적음'}">
	 			높음 : 
	 			<input type="radio" id="watchDrug" name="watchDrug" value="높음" >
	 			적음 : 
	 			<input type="radio" id="watchDrug" name="watchDrug" value="적음" checked>
	 			</c:if>
	        </div>
	 		<div class="movie_insert_box">
	 			선정성 : <br>
	 			<c:if test="${ requestScope.detail.watchSensationality == '높음'}">
	 			높음 : 
	 			<input type="radio" id="watchSensationality" name="watchSensationality" value="높음" checked>
	 			적음 : 
	 			<input type="radio" id="watchSensationality" name="watchSensationality" value="적음">
	 			</c:if>
	 			<c:if test="${ requestScope.detail.watchSensationality == '적음'}">
	 			높음 : 
	 			<input type="radio" id="watchSensationality" name="watchSensationality" value="높음" >
	 			적음 : 
	 			<input type="radio" id="watchSensationality" name="watchSensationality" value="적음" checked>
	 			</c:if>
	        </div>
	 		<div class="movie_insert_box">
	 			대사 : <br>
	 			<c:if test="${ requestScope.detail.watchScript == '높음'}">
	 			높음 : 
	 			<input type="radio" id="watchScript" name="watchScript" value="높음" checked>
	 			적음 : 
	 			<input type="radio" id="watchScript" name="watchScript" value="적음">
	 			</c:if>
	 			<c:if test="${ requestScope.detail.watchScript == '적음'}">
	 			높음 : 
	 			<input type="radio" id="watchScript" name="watchScript" value="높음" >
	 			적음 : 
	 			<input type="radio" id="watchScript" name="watchScript" value="적음" checked>
	 			</c:if>
	        </div>
	 		<div class="movie_insert_box">
	 			주제 : <br>
	 			<c:if test="${ requestScope.detail.watchTitle == '높음'}">
	 			높음 : 
	 			<input type="radio" id="watchTitle" name="watchTitle" value="높음" checked>
	 			적음 : 
	 			<input type="radio" id="watchTitle" name="watchTitle" value="적음">
	 			</c:if>
	 			<c:if test="${ requestScope.detail.watchTitle == '적음'}">
	 			높음 : 
	 			<input type="radio" id="watchTitle" name="watchTitle" value="높음" >
	 			적음 : 
	 			<input type="radio" id="watchTitle" name="watchTitle" value="적음" checked>
	 			</c:if>
	        </div>
	 		<div class="movie_insert_box">
	 			폭력성 : <br> 
	 			<c:if test="${ requestScope.detail.watchViolence == '높음'}">
	 			높음 : 
	 			<input type="radio" id="watchViolence" name="watchViolence" value="높음" checked>
	 			적음 : 
	 			<input type="radio" id="watchViolence" name="watchViolence" value="적음">
	 			</c:if>
	 			<c:if test="${ requestScope.detail.watchViolence == '적음'}">
	 			높음 : 
	 			<input type="radio" id="watchViolence" name="watchViolence" value="높음">
	 			적음 : 
	 			<input type="radio" id="watchViolence" name="watchViolence" value="적음" checked>
	 			</c:if>
	        </div>
	 		<div class="movie_insert_box">
	 			관람등급 : <br>
	 			<c:if test="${ requestScope.detail.ratingName == '전체관람'}">
	 			전체관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="전체관람" checked>
	 			12세이상관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="12세이상관람">
	 			15세이상관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="15세이상관람">
	 			청소년관람불가 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="청소년관람불가">
	 			</c:if>
	 			<c:if test="${ requestScope.detail.ratingName == '12세이상관람'}">
	 			전체관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="전체관람">
	 			12세이상관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="12세이상관람" checked>
	 			15세이상관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="15세이상관람">
	 			청소년관람불가 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="청소년관람불가">
	 			</c:if>
	 			<c:if test="${ requestScope.detail.ratingName == '15세이상관람'}">
	 			전체관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="전체관람">
	 			12세이상관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="12세이상관람">
	 			15세이상관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="15세이상관람" checked>
	 			청소년관람불가 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="청소년관람불가">
	 			</c:if>
	 			<c:if test="${ requestScope.detail.ratingName == '청소년관람불가'}">
	 			전체관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="전체관람">
	 			12세이상관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="12세이상관람">
	 			15세이상관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="15세이상관람">
	 			청소년관람불가 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="청소년관람불가" checked>
	 			</c:if>
	        </div>
	 		<div class="movie_insert_box">
	 			장르이름 : <br>
	 			<c:if test="${ requestScope.detail.genreName == '액션'}">
	 			액션 : 
	 			<input type="radio" id="genreName" name="genreName" value="액션" checked>
	 			판타지 : 
	 			<input type="radio" id="genreName" name="genreName" value="판타지">
	 			로맨스 : 
	 			<input type="radio" id="genreName" name="genreName" value="로맨스">
	 			코미디 : 
	 			<input type="radio" id="genreName" name="genreName" value="코미디">
	 			공포 : 
	 			<input type="radio" id="genreName" name="genreName" value="공포">
	 			</c:if>
	 			<c:if test="${ requestScope.detail.genreName == '판타지'}">
	 			액션 : 
	 			<input type="radio" id="genreName" name="genreName" value="액션" >
	 			판타지 : 
	 			<input type="radio" id="genreName" name="genreName" value="판타지" checked>
	 			로맨스 : 
	 			<input type="radio" id="genreName" name="genreName" value="로맨스">
	 			코미디 : 
	 			<input type="radio" id="genreName" name="genreName" value="코미디">
	 			공포 : 
	 			<input type="radio" id="genreName" name="genreName" value="공포">
	 			</c:if>
	 			<c:if test="${ requestScope.detail.genreName == '로맨스'}">
	 			액션 : 
	 			<input type="radio" id="genreName" name="genreName" value="액션" >
	 			판타지 : 
	 			<input type="radio" id="genreName" name="genreName" value="판타지">
	 			로맨스 : 
	 			<input type="radio" id="genreName" name="genreName" value="로맨스" checked>
	 			코미디 : 
	 			<input type="radio" id="genreName" name="genreName" value="코미디">
	 			공포 : 
	 			<input type="radio" id="genreName" name="genreName" value="공포">
	 			</c:if>
	 			<c:if test="${ requestScope.detail.genreName == '코미디'}">
	 			액션 : 
	 			<input type="radio" id="genreName" name="genreName" value="액션" >
	 			판타지 : 
	 			<input type="radio" id="genreName" name="genreName" value="판타지">
	 			로맨스 : 
	 			<input type="radio" id="genreName" name="genreName" value="로맨스">
	 			코미디 : 
	 			<input type="radio" id="genreName" name="genreName" value="코미디" checked>
	 			공포 : 
	 			<input type="radio" id="genreName" name="genreName" value="공포">
	 			</c:if>
	 			<c:if test="${ requestScope.detail.genreName == '공포'}">
	 			액션 : 
	 			<input type="radio" id="genreName" name="genreName" value="액션" >
	 			판타지 : 
	 			<input type="radio" id="genreName" name="genreName" value="판타지">
	 			로맨스 : 
	 			<input type="radio" id="genreName" name="genreName" value="로맨스">
	 			코미디 : 
	 			<input type="radio" id="genreName" name="genreName" value="코미디">
	 			공포 : 
	 			<input type="radio" id="genreName" name="genreName" value="공포" checked>
	 			</c:if>
	        </div>
	 		<div class="movie_insert_box">
	 			영상링크주소 : <br>
	 			<input type="text" id="movieVideoRink" name="movieVideoRink" value="${ requestScope.detail.movieVideoRink }">
	        </div>
			
	 		<div class="movie_insert_box">
	 			출현 배우 : <br>
             	<c:forEach var="actorList" items="${ requestScope.adminActorList }">
	 			<input type="text" id="actorName1" name="actorName1" value="${ actorList.actorName1 }">
	 		 	<input type="text" id="actorName2" name="actorName2" value="${ actorList.actorName2 }">
	 			<input type="text" id="actorName3" name="actorName3" value="${ actorList.actorName3 }">
	 			<input type="text" id="actorName4" name="actorName4" value="${ actorList.actorName4 }">
	 			<input type="text" id="actorName5" name="actorName5" value="${ actorList.actorName5 }">
	 			</c:forEach>
	        </div>
	 		<div class="movie_insert_box">	<!-- 영화 파일 el로 이미지 넣기 -->
				메인사진 파일 : 
				<input type="file" id="singleFile1" name="singleFile1" onchange="loadImg(this,1)"><br>
				서브사진 파일 : 
				<input type="file" id="singleFile2" name="singleFile2" onchange="loadImg(this,2)"><br>
	        </div>
			<br><br>
	        <div class="content-img-area1" id="contentImgArea1">
 				<figure>
				<img style="width: 1000px; height: 500px;" src="${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/${requestScope.movieMainFiles.saveName}">
				<figcaption>메인 사진</figcaption>
				</figure> 
				<div class="content-img-area1" id="contentImgArea1">
					<img id="contentImg1" width="1200" height="500">
				</div>
			</div>
			<div class="content-img-area2" id="contentImgArea2">
				<figure> 
				<img style="width: 300px; height: 300px;" src="${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/${requestScope.movieSubFiles.saveName}">
				<figcaption>서브 사진</figcaption> 
				</figure>
				<div class="content-img-area2" id="contentImgArea2">
					<img id="contentImg2" width="300" height="300">
				</div> 
			</div>	

			<br><br>
           		<button class="movieUpdate mvimg" id="movieUpdateBtn"  type="button">
           		영화정보 수정
           		</button>
             	<button class="mvimg" type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/movie/adminUpdateSelect'">
             	뒤로가기
             	</button>
 		</form>
	</div>
		<!-- 삭제 폼 -->
		<div align="center">
 		<form action="${ pageContext.servletContext.contextPath }/admin/movieDelete" id="enrollDelete" method="post" encType="multipart/form-data">
		        <input type="hidden" id="movieNo" name="movieNo" value="${ requestScope.detail.no }">
		        
		        <button class="movieDelete mvimg" id="movieDeleteBtn" type="button">
		                 영화 삭제
		        </button>
		</form> 
		</div>
		
		    <br><br><br><br><br><br><br><br><br><br>
</body>
<script>

	/* 이미지 처리 */
	const $contentImgArea1 = document.getElementById("contentImgArea1");
	const $contentImgArea2 = document.getElementById("contentImgArea2");
	
	$contentImgArea1.onclick = function() {
		document.getElementById("thumbnailImg1").click();
	}
	$contentImgArea2.onclick = function() {
		document.getElementById("thumbnailImg2").click();
	}
	
	function loadImg(value, num) {
		if(value.files && value.files[0]) {
			const reader = new FileReader();
			
			reader.onload = function(e) {
				switch(num) {
					case 1: document.getElementById("contentImg1").src = e.target.result;
							break;
					case 2: document.getElementById("contentImg2").src = e.target.result;
							break;
				}
			}
			reader.readAsDataURL(value.files[0]);
		}
	}

	/* 빈칸 처리 */
 	$("#movieUpdateBtn").click(function(){
 		if(document.getElementById("name").value == ""){
 			alert("영화이름 값을 확인해주세요.");
 		} else if(document.getElementById("info").value == ""){
 			alert("영화정보 값을 확인해주세요.");
 		} else if(document.getElementById("director").value == ""){
 			alert("감독 값을 확인해주세요.");
 		} else if(document.getElementById("productionYear").value == ""){
 			alert("제작년도 값을 확인해주세요.");
 		} else if(document.getElementById("movieTime").value == ""){
 			alert("영화시간 값을 확인해주세요.");
 		} else if(document.getElementById("watchFear").value == ""){
 			alert("공포등급 값을 확인해주세요."); 
 		} else if(document.getElementById("watchModification").value == ""){
 			alert("모방위험등급 값을 확인해주세요.");
 		} else if(document.getElementById("watchDrug").value == ""){
 			alert("약물 값을 확인해주세요.");
 		} else if(document.getElementById("watchSensationality").value == ""){
 			alert("선정성 값을 확인해주세요.");
 		} else if(document.getElementById("watchScript").value == ""){
 			alert("대사 값을 확인해주세요.");
 		} else if(document.getElementById("watchTitle").value == ""){
 			alert("주제 값을 확인해주세요.");
 		} else if(document.getElementById("watchViolence").value == ""){
 			alert("폭력성 값을 확인해주세요.");
 		} else if(document.getElementById("ratingName").value == ""){
 			alert("관람등급 값을 확인해주세요.");
 		} else if(document.getElementById("genreName").value == ""){
 			alert("장르명 값을 확인해주세요.");
 		} else if(document.getElementById("movieVideoRink").value == ""){
 			alert("영화링크 값을 확인해주세요.");
 		} else if(document.getElementById("actorName1").value == ""){
 			alert("배우1 값을 확인해주세요.");
 		} else if(document.getElementById("actorName2").value == ""){
 			alert("배우2 값을 확인해주세요.");
 		} else if(document.getElementById("actorName3").value == ""){
 			alert("배우3 값을 확인해주세요.");
 		} else if(document.getElementById("actorName4").value == ""){
 			alert("배우4 값을 확인해주세요.");
 		} else if(document.getElementById("actorName5").value == ""){
 			alert("배우5 값을 확인해주세요.");
 		} else{
 			alert("영화가 수정되었습니다.");
 			$("#enroll").submit();
 		}
 	});
	
	/* 삭제 처리 */
	$("#movieDeleteBtn").click(function(){
		$("#enrollDelete").submit();
			alert("삭제완료");
	}); 
	
	
</script>
	<link rel="stylesheet" href="/peoplay/resources/css/movie/main.css">
</html>