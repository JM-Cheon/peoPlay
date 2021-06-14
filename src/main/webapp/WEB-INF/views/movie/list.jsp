<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 리스트</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/movie/list.css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

    <br><br><br><br><br><br><br>
    <!-- 장르 버튼 -->
    <section align="center" class="CategoryGenre">
	    <button id="genreAction">액션</button>
	    <button id="genreFantasy">판타지 </button>
	    <button id="genreRomance">로맨스 </button>
	    <button id="genreComedy">코미디 </button>
	    <button id="genreHorror">공포 </button>
    </section>
    <br><br>
    <!-- 영화 리스트 -->
    <section align="center">
        <h2>영화 리스트</h2><br>
        	<div class="searchTextArea" id="searchTextArea">
            	<input name="검색" class="searchText" id="searchText" placeholder="제목 검색">
            	<button type="button" id="movieSearch" class="movieSearch">검색</button>
        	</div>
    <br><br><br><br><br>
    </section>
    
    <h2 class="groupName" style="margin-left:900px;">리스트</h2><br><br>
      	<table id="CategoryGenre" border="1">
		<tbody></tbody>
      	</table>
    <section id="section_search_ajax" >
 	    	   <c:forEach var="movie" items="${ requestScope.list }">
		           	<article class="movieList">
		                 	<img src="${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/${ movie.movieFile.saveName }" alt="영화" class="mvimg">
		                 <button id="${ movie.no }" class="mvimg">
		                 	<c:out value="${ movie.name }"/>
		                 </button>
			        </article>
		       </c:forEach>
 	</section>
    <br><br><br><br><br><br><br><br>
   	 
<jsp:include page="../common/footer.jsp"/>
</body>
<link rel="stylesheet" href="/peoplay/resources/css/movie/main.css">

	
<script>
	/* 페이지 이동 */
	if(document.getElementsByTagName("article")) {
	const $tds = document.getElementsByTagName("article");
		for(var i = 0 ; i < $tds.length ; i++) {
	   
			$tds[i].onmouseenter = function() {
			   this.parentNode.style.cursor = "pointer";
			}
			   
			$tds[i].onclick = function() {
						  const no = $(this).children("button").attr("id");
					  	  location.href = "${ pageContext.servletContext.contextPath }/movie/" + parseInt(no);
			}   
		}
	} 
</script>	
	
<script>


<!-- 영화 검색 -->
	/* 검색 ajax */
	$("#movieSearch").click(function(){
	   
	   var searchText = document.getElementById("searchText").value; 
	   
	   if(searchText == ""){
	      alert("영화 제목을 입력해주세요");
	   } else{
	   		 	
	   		   console.log(searchText);
			   $.ajax({
			      
			      url : "movieSearch",
			      method : "POST",
			      data : {
			    	  	   "searchText" : searchText
			      		 },
			      success : function(SearchNameResult) {
				   	    console.table(SearchNameResult);
			            
				        var $section = $("#section_search_ajax");
			            $section.html(""); 
		
			            for(var index in SearchNameResult){
			            	
			 		        var $postList = $("<article class='movieList'>");
			 		        var $moreList = $( 
			 		        		
			 		        				"<img src=${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/"
							            	+SearchNameResult[index].movieFile.saveName + " alt='영화'" + "class='mvimg'>"
							            	+ "<button id=" + SearchNameResult[index].no + " class='mvimg'>"
											+ SearchNameResult[index].name + "</button>" + "</article>" 
				            				);
			 		        
			         	        console.log($section);
			         	        $postList.append($moreList);
			         	        $section.append($postList);	
			         	        
			         	   	if(document.getElementsByTagName("article")) {
			         	   	const $tds = document.getElementsByTagName("article");
				         	   	
				         	   	for(var i = 0 ; i < $tds.length ; i++) {
				         	   	
				         	   	   
					         	   	$tds[i].onmouseenter = function() {
					         	   	   this.parentNode.style.cursor = "pointer";
					         	   	}
					         	   	   
					         	   	$tds[i].onclick = function() {
					         	   			  const no = $(this).children("button").attr("id");
					         	   		  	  location.href = "${ pageContext.servletContext.contextPath }/movie/" + parseInt(no);
					         	   	}   
				         	   	}
			         	   	} 
				        }
				   },
			   });
 		 }
	});
					
	           
	/* 액션 장르 */
	$("#genreAction").click(function(){
	var genreAction = "액션"; 
		console.log("콘솔 전달 됨?")
		
		$.ajax({
			url: "movieGenre1",
			method: "POST",
			data: {
				'genreAction' : '액션'
				},
			success:function(genresResult1){
				console.table(genresResult1);
	            
		        var $section = $("#section_search_ajax");
	            $section.html(""); 

	            for(var index in genresResult1){
	            	
 		        var $postList = $("<article class='movieList'>");
 		        var $moreList = $( 
 		        		
 		        				"<img src=${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/"
				            	+genresResult1[index].movieFile.saveName + " alt='영화'" + "class='mvimg'>"
				            	+ "<button id=" + genresResult1[index].no + " class='mvimg'>"
								+ genresResult1[index].name + "</button>" + "</article>" 
	            				);
 		        
         	        console.log($section);
         	        $postList.append($moreList);
         	        $section.append($postList);	
         	        
         	   	if(document.getElementsByTagName("article")) {
         	   	const $tds = document.getElementsByTagName("article");
         	   	for(var i = 0 ; i < $tds.length ; i++) {
         	   	
         	   	   
         	   	$tds[i].onmouseenter = function() {
         	   	   this.parentNode.style.cursor = "pointer";
         	   	}
         	   	   
         	   	$tds[i].onclick = function() {
         	   			  const no = $(this).children("button").attr("id");
         	   		  	  location.href = "${ pageContext.servletContext.contextPath }/movie/" + parseInt(no);
         	   			}   
         	   		}
         	   	
         	   	} 
	            				
	           }
	            				
			},
		});
	});
	
 	/* 판타지 장르 */
	$("#genreFantasy").click(function(){
	var genreFantasy = "판타지"; 
		console.log("콘솔 전달 됨?")
		$.ajax({
			url: "movieGenre2",
			method: "POST",
			data: {
				'genreFantasy' : '판타지'
				},
			success:function(genresResult2){
				console.table(genresResult2);
	            
		        var $section = $("#section_search_ajax");
	            $section.html(""); 

	            for(var index in genresResult2){
	            	
 		        var $postList = $("<article class='movieList'>");
 		        var $moreList = $( 
 		        		
 		        				"<img src=${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/"
				            	+genresResult2[index].movieFile.saveName + " alt='영화'" + "class='mvimg'>"
				            	+ "<button id=" + genresResult2[index].no + " class='mvimg'>"
								+ genresResult2[index].name + "</button>" + "</article>" 
	            				);
 		        
         	        console.log($section);
         	        $postList.append($moreList);
         	        $section.append($postList);	
         	        
         	   	if(document.getElementsByTagName("article")) {
         	   	const $tds = document.getElementsByTagName("article");
         	   	for(var i = 0 ; i < $tds.length ; i++) {
         	   	
         	   	   
         	   	$tds[i].onmouseenter = function() {
         	   	   this.parentNode.style.cursor = "pointer";
         	   	}
         	   	   
         	   	$tds[i].onclick = function() {
         	   			  const no = $(this).children("button").attr("id");
         	   		  	  location.href = "${ pageContext.servletContext.contextPath }/movie/" + parseInt(no);
         	   			}   
         	   		}
         	   	
         	   	} 
	            				
	           }
	            				
			},
		});
	});
	/* 로맨스 장르 */
	$("#genreRomance").click(function(){
	var genreRomance = "로맨스"; 
		console.log("콘솔 전달 됨?")
		$.ajax({
			url: "movieGenre3",
			method: "POST",
			data: {
				'genreRomance' : '로맨스'
				},
			success:function(genresResult3){
				console.table(genresResult3);
	            
		        var $section = $("#section_search_ajax");
	            $section.html(""); 

	            for(var index in genresResult3){
	            	
 		        var $postList = $("<article class='movieList'>");
 		        var $moreList = $( 
 		        		
 		        				"<img src=${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/"
				            	+genresResult3[index].movieFile.saveName + " alt='영화'" + "class='mvimg'>"
				            	+ "<button id=" + genresResult3[index].no + " class='mvimg'>"
								+ genresResult3[index].name + "</button>" + "</article>" 
	            				);
 		        
         	        console.log($section);
         	        $postList.append($moreList);
         	        $section.append($postList);	
         	        
         	   	if(document.getElementsByTagName("article")) {
         	   	const $tds = document.getElementsByTagName("article");
         	   	for(var i = 0 ; i < $tds.length ; i++) {
         	   	
         	   	   
         	   	$tds[i].onmouseenter = function() {
         	   	   this.parentNode.style.cursor = "pointer";
         	   	}
         	   	   
         	   	$tds[i].onclick = function() {
         	   			  const no = $(this).children("button").attr("id");
         	   		  	  location.href = "${ pageContext.servletContext.contextPath }/movie/" + parseInt(no);
         	   			}   
         	   		}
         	   	
         	   	} 
	            				
	           }
	            				
			},
		});
	});
	/* 코미디 장르 */
	$("#genreComedy").click(function(){
	var genreComedy = "코미디"; 
		console.log("콘솔 전달 됨?")
		$.ajax({
			url: "movieGenre4",
			method: "POST",
			data: {
				'genreComedy' : '코미디'
				},
			success:function(genresResult4){
				console.table(genresResult4);
	            
		        var $section = $("#section_search_ajax");
	            $section.html(""); 

	            for(var index in genresResult4){
	            	
 		        var $postList = $("<article class='movieList'>");
 		        var $moreList = $( 
 		        		
 		        				"<img src=${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/"
				            	+genresResult4[index].movieFile.saveName + " alt='영화'" + "class='mvimg'>"
				            	+ "<button id=" + genresResult4[index].no + " class='mvimg'>"
								+ genresResult4[index].name + "</button>" + "</article>" 
	            				);
 		        
         	        console.log($section);
         	        $postList.append($moreList);
         	        $section.append($postList);	
         	        
         	   	if(document.getElementsByTagName("article")) {
         	   	const $tds = document.getElementsByTagName("article");
         	   	for(var i = 0 ; i < $tds.length ; i++) {
         	   	
         	   	   
         	   	$tds[i].onmouseenter = function() {
         	   	   this.parentNode.style.cursor = "pointer";
         	   	}
         	   	   
         	   	$tds[i].onclick = function() {
         	   			  const no = $(this).children("button").attr("id");
         	   		  	  location.href = "${ pageContext.servletContext.contextPath }/movie/" + parseInt(no);
         	   			}   
         	   		}
         	   	
         	   	} 
	            				
	           }
	            				
			},
		});
	});
	/* 공포 장르 */
	$("#genreHorror").click(function(){
	var genreHorror = "공포"; 
		console.log("콘솔 전달 됨?")
		$.ajax({
			url: "movieGenre5",
			method: "POST",
			data: {
				'genreHorror' : '공포'
				},
			success:function(genresResult5){
				console.table(genresResult5);
	            
		        var $section = $("#section_search_ajax");
	            $section.html(""); 

	            for(var index in genresResult5){
	            	
 		        var $postList = $("<article class='movieList'>");
 		        var $moreList = $( 
 		        		
 		        				"<img src=${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/"
				            	+genresResult5[index].movieFile.saveName + " alt='영화'" + "class='mvimg'>"
				            	+ "<button id=" + genresResult5[index].no + " class='mvimg'>"
								+ genresResult5[index].name + "</button>" + "</article>" 
	            				);
 		        
         	        console.log($section);
         	        $postList.append($moreList);
         	        $section.append($postList);	
         	        
         	   	if(document.getElementsByTagName("article")) {
         	   	const $tds = document.getElementsByTagName("article");
         	   	for(var i = 0 ; i < $tds.length ; i++) {
         	   	
         	   	   
         	   	$tds[i].onmouseenter = function() {
         	   	   this.parentNode.style.cursor = "pointer";
         	   	}
         	   	   
         	   	$tds[i].onclick = function() {
         	   			  const no = $(this).children("button").attr("id");
         	   		  	  location.href = "${ pageContext.servletContext.contextPath }/movie/" + parseInt(no);
         	   			}   
         	   		}
         	   	
         	   	} 
	            				
	           }
	            				
			},
		});
	});
</script>
</html>