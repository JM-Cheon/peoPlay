<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 영화 등록</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/movie/admin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<br><br><br>
	<h2 align="center">관리자 영화 등록</h2>
	<form action="${ pageContext.servletContext.contextPath }/movie/admin" method="post" id="enroll" encType="multipart/form-data">
	<div align="center">
	 		<div class="movie_insert_box">
				영화이름 : <br>
				<input type="text" id="name" name="name"><br>
	        </div>
	 		<div class="movie_insert_box"  >
				영화정보 : <br>
				<input type="text" id="info" name="info"><br>
	        </div>
	 		<div class="movie_insert_box">
	 			감독 : <br>  
	 			<input type="text" id="director" name="director">
	        </div>
	 		<div class="movie_insert_box">
	 			제작년도 : <br>  <!-- 연도만 체크박스 있으면 .... -->
	 			<input type="text" id="productionYear" name="productionYear">
	        </div>
	 		<div class="movie_insert_box">
	 			영화시간 : <br>  
	 			<input type="text" id="movieTime" name="movieTime">
	        </div>
	 		<div class="movie_insert_box">
	 			공포 : <br>
	 			높음 : 
	 			<input type="radio" id="watchFear" name="watchFear" value="높음">
	 			적음 : 
	 			<input type="radio" id="watchFear" name="watchFear" value="적음">
	        </div>
	 		<div class="movie_insert_box"> 
	 			모방위험 : <br>
	 			높음 : 
	 			<input type="radio" id="watchModification" name="watchModification" value="높음">
	 			적음 : 
	 			<input type="radio" id="watchModification" name="watchModification" value="적음">
	        </div>
	 		<div class="movie_insert_box">
	 			약물 : <br>
	 			높음 : 
	 			<input type="radio" id="watchDrug" name="watchDrug" value="높음">
	 			적음 : 
	 			<input type="radio" id="watchDrug" name="watchDrug" value="적음">
	        </div>
	 		<div class="movie_insert_box">
	 			선정성 : <br> 
	 			높음 : 
	 			<input type="radio" id="watchSensationality" name="watchSensationality" value="높음">
	 			적음 : 
	 			<input type="radio" id="watchSensationality" name="watchSensationality" value="적음">
	        </div>
	 		<div class="movie_insert_box">
	 			대사 : <br>
	 			높음 : 
	 			<input type="radio" id="watchScript" name="watchScript" value="높음">
	 			적음 : 
	 			<input type="radio" id="watchScript" name="watchScript" value="적음">
	        </div>
	 		<div class="movie_insert_box">
	 			주제 : <br>
	 			높음 : 
	 			<input type="radio" id="watchTitle" name="watchTitle" value="높음">
	 			적음 : 
	 			<input type="radio" id="watchTitle" name="watchTitle" value="적음">
	        </div>
	 		<div class="movie_insert_box">
	 			폭력성 : <br> 
	 			높음 : 
	 			<input type="radio" id="watchViolence" name="watchViolence" value="높음">
	 			적음 : 
	 			<input type="radio" id="watchViolence" name="watchViolence" value="적음">
	        </div>
	 		<div class="movie_insert_box">
	 			관람등급 : <br>
	 			전체관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="전체관람">
	 			12세이상관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="12세이상관람">
	 			15세이상관람 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="15세이상관람">
	 			청소년관람불가 : 
	 			<input type="radio" id="ratingName" name="ratingName" value="청소년관람불가">
	        </div>
	 		<div class="movie_insert_box">
	 			장르이름 : <br>
	 			액션 : 
	 			<input type="radio" id="genreName" name="genreName" value="액션">
	 			판타지 : 
	 			<input type="radio" id="genreName" name="genreName" value="판타지">
	 			로맨스 : 
	 			<input type="radio" id="genreName" name="genreName" value="로맨스">
	 			코미디 : 
	 			<input type="radio" id="genreName" name="genreName" value="코미디">
	 			공포 : 
	 			<input type="radio" id="genreName" name="genreName" value="공포">
	        </div>
	 		<div class="movie_insert_box">
	 			영상링크주소 : <br>
	 			<input type="text" id="movieVideoRink" name="movieVideoRink">
	        </div>

	 		<div class="movie_insert_box">
	 			출현 배우  <br>
	 			배우 1:  <input type="text" id="actorName1" name="actorName1"><br>
	 		 	배우 2:  <input type="text" id="actorName2" name="actorName2"><br>
	 			배우 3:  <input type="text" id="actorName3" name="actorName3"><br>
	 			배우 4:  <input type="text" id="actorName4" name="actorName4"><br>
	 			배우 5:  <input type="text" id="actorName5" name="actorName5"><br>
	        </div><br>
	 		<div class="movie_insert_box">
				메인사진 파일 :   
				<input type="file" id="singleFile1" name="singleFile1" onchange="loadImg(this,1)"><br>
				서브사진 파일 : 
				<input type="file" id="singleFile2" name="singleFile2" onchange="loadImg(this,2)"><br>
	        </div>
			<br><br>
			<div class="content-img-area2" id="contentImgArea2">
				<div class="content-img-area2" id="contentImgArea2">
					<img id="contentImg2" width="150" height="200">
				</div> 
			</div>
			<div class="content-img-area1" id="contentImgArea1">
				<div class="content-img-area1" id="contentImgArea1">
					<img id="contentImg1" width="1920" height="800">
				</div>
			</div>
			
			
			<br><br>
	        <div class="movie_insert_box">
           		<button class="movieInsertbtn mvimg" id="movieInsertBtn" type="button">영화등록</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	<button class="mvimg" type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/movie/adminButton'">뒤로가기</button>
            </div>
            <br>
	</div>
 	</form>
 	
</body>

<script>

		<!-- 등록시 썸네일 출력 -->
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
</script>
<script>
<!--빈 값 체크-->
 	$("#movieInsertBtn").click(function(){
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
 		} else if(document.getElementById("singleFile1").value == ""){
 			alert("메인파일 값을 확인해주세요.");
 		} else if(document.getElementById("singleFile2").value == ""){
 			alert("서브파일 값을 확인해주세요.");
 		} else{
 			alert("영화가 등록되었습니다.");
 			$("#enroll").submit();
 		}
 	});
 </script>
 <link rel="stylesheet" href="/peoplay/resources/css/movie/main.css">
 	
 	
</html>