<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>
.header {margin: 0px auto; width: 100%; position: fixed;}

/* header */
.header_box{position: absolute; width: 100%; height: 50px; background-color: #2c2c2c;  text-align: center; line-height: 50px; }
.logo{width: 150px; height: 50px; float: left;}
.nav{float: left; width: 700px; height: 50px;}
.nav > ul > li{float: left; margin-left: 60px; color: #ffffff; font-size: 15px;}
.mainlogin{width: 150px; height: 50px; background-color: #008916; float: right; color: #ffffff; font-size: 20px; font-weight: 600; cursor: pointer;} 
.afterLogin{float: right; width: 300px; height: 50px;}
.afterLogin > ul > li{float: right; margin: 0px 10px; color: #ffffff; font-size: 15px;}
.adminMode{width: 180px; height: 50px; background-color: #008916; float: right; color: #ffffff; font-size: 20px; font-weight: 600; cursor: pointer;} 
.adminLogout{width: 150px; height: 50px; background-color: #606060; float: right; color: #ffffff; font-size: 20px; font-weight: 600; cursor: pointer;} 
</style>
</head>
   <script>
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
<body>
   <header class="header">
        <div class="header_box">
            <div class="logo">
                <img src="${ pageContext.servletContext.contextPath }/resources/images/peoPlay.png">
            </div>
            <div class="nav">
                <ul>
                    <li><a href="${ pageContext.servletContext.contextPath }">홈</a></li>
                    <li><a href="${ pageContext.servletContext.contextPath }/movie/list">영화</a></li>
                    <li><a href="#">문의</a></li>
                    <li><a href="#">굿즈</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/board/list">커뮤니티</a></li>
                </ul>
            </div>
	        <div class="mainlogin" onclick="location.href='${ pageContext.servletContext.contextPath }/member/login';">
	                LOGIN
	        </div>
        </div>
    </header>
        <img  class="mainImage"src="${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/${requestScope.movieMainFiles.saveName}" alt="메인상단" width="1920px">
	<!-- 관람등급 -->
      <div class="main1">
      	  <c:choose> 
			  <c:when test="${!empty detail}">
		      	  <c:if test="${requestScope.detail.ratingName eq'전체관람' }">
			          <img src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/RATING_ALL.png" alt="연령제한"><br>
			          <c:out value="${requestScope.detail.ratingName}" />
				  </c:if>
		      	  <c:if test="${requestScope.detail.ratingName eq'12세이상관람' }">
			          <img src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/RATING_12.png" alt="연령제한"><br>
			          <c:out value="${requestScope.detail.ratingName}" />
				  </c:if>
		      	  <c:if test="${requestScope.detail.ratingName eq'15세이상관람' }">
			          <img src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/RATING_15.png" alt="연령제한"><br>
			          <c:out value="${requestScope.detail.ratingName}" />
				  </c:if>
		      	  <c:if test="${requestScope.detail.ratingName eq'청소년관람불가' }">
			          <img src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/RATING_18.png" alt="연령제한"><br>
			          <c:out value="${requestScope.detail.ratingName}" />
				  </c:if>
	          </c:when>
          </c:choose>
          <h2 style=font-size:30px>
           <c:out value="${requestScope.detail.name}" />
          </h2>
            <br><br><br>
          <div style="font-size:20px; width:600px; "> 
			<c:out value="${requestScope.detail.info}" />
          </div>
        </div>

      <button class="btn1" type="button" href="" onclick="location.href='${ pageContext.servletContext.contextPath}/movie/${ requestScope.detail.no }/play'">▶ 재생</button>



	<br><br>
   <section class="likes" style="width:800px">
    	<div style="width: 100px; margin: 0px 10px 10px 0px; float:left;">
	      <button type="button" id="likeUpdate" class="likeUpdate" style="border-radius:20px;">
	      	<img alt="좋아요" src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/like.png">
	      </button>
     	</div>

     	<div style="width: 100px; margin: 0px 10px 10px 0px; float:left;">
	      	<button type="button" id="disLikeUpdate" class="disLikeUpdate" style="border-radius:20px;">
	  	   		<img alt="싫어요" src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/dislike.png">
	  	    </button>
     	</div> 

     	<div id="divWish" style="width: 100px; margin: 0px 10px 10px 0px; float:left;" >
     		<input type="hidden" id="selectWishList" value="${wishList}">
 	      	<button type="button" id="wishList" class="wishListUpdate" style="border-radius:20px;">
      			<img id="img" alt="찜" src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/check.png">
      		</button>
     	</div>

  </section>

  <section class="mv_test"><br><br><br><br>
    <article class="art1">
        <div>
        <br>
          <h2>제작년도 : <c:out value="${requestScope.detail.productionYear}"/></h2><br>
          <h2>영화 시간 : <c:out value="${requestScope.detail.movieTime}"/></h2><br>
          <h2>감독 : <c:out value="${requestScope.detail.director}"/></h2>
        </div><br>
        
        <h2>작품 소개</h2>
        <p style="font-size:20px;"><c:out value="${requestScope.detail.info}" />
        </p>
    </article>
        <article  class="art2"><br>
              <h2>출현 :    
			  <c:out value="${requestScope.actorList}"/> 
			  </h2><br>  
              <h2>장르 : <c:out value="${requestScope.detail.genreName}" /> </h2><br>
              <h2>관람 등급 : <c:out value="${requestScope.detail.ratingName}" /> </h2>
            <div>
	       		<c:choose> 
					<c:when test="${!empty detail}">
							<tr	style="height: 60px; font-size: 17px; color: white; text-align: center;">
						<c:if test="${ requestScope.detail.watchFear eq '높음' }">
							<img src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/FEAR.png">
						 </c:if>
						<c:if test="${ requestScope.detail.watchModification eq '높음' }">
							<img src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/MODIFICATION.png">
						 </c:if>
						<c:if test="${ requestScope.detail.watchDrug eq '높음' }">
							<img src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/DRUG.png">
						 </c:if>
						<c:if test="${ requestScope.detail.watchSensationality eq '높음' }">
							<img src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/SENSATIONALITY.png">
						 </c:if>
						<c:if test="${ requestScope.detail.watchScript eq '높음' }">
							<img src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/SCRIPT.png">
						 </c:if>
						<c:if test="${ requestScope.detail.watchTitle eq '높음' }">
							<img src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/TITLE.png">
						 </c:if>
						<c:if test="${ requestScope.detail.watchViolence eq '높음' }">
							<img src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/VIOLENCE.png">
						 </c:if>
						</c:when>
				</c:choose>
            </div>
        </article>
    </section>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br>
	<!-- 후기 작성 -->
    <div align="center" style="background-color:gray;" class="replyAll">
    <div class="p-admin-comment">
          <h2 class="form-signin-heading">영화 후기</h2>
 	   <div class="replyTextArea" id="replyTextArea">
            <div id="counter">(0 / 50)</div>
                <input name="댓글달기" class="replyText" id="replyText"  >
            	<button type="button" class="repliedbtn" id="repliedbtn" > 등록하기 </button>
       </div>
    		<div class="div_reply_ajax" id="div_reply_ajax" style="overflow: auto;">
             <c:forEach var="movieReview" items="${ requestScope.review}">
                <table class="ajax_table">
                	<tr>
                		<td class="repliedId">
			                            닉네임 : ${ movieReview.memberInfo.nickname }
                		</td>
                		<td class="repliedtime">
			                <fmt:formatDate var="resultDate" value="${movieReview.registrationDate }" pattern="yyyy-MM-dd hh:mm:ss" />${resultDate}
                		</td>
                	</tr>	
                	<tr>
                		<td class="replied">
 				       		<c:out value="${movieReview.review }"/>
                		</td>
                	</tr>
                	<tr>
                        <td>
                        	<c:if test="${ movieReview.memberInfo.userNo eq sessionScope.loginMember.userNo }">
                        	<button type="button" class="replyDelete" id="${ movieReview.reviewNo }"> 삭제 </button>
                        	</c:if>
                        </td>
                    </tr>
                </table>
             </c:forEach>
          	</div>
		</div>           
      </div>
      
  <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
  	<jsp:include page="../common/footer.jsp"/>
</body>
	<link rel="stylesheet" href="/peoplay/resources/css/movie/detail.css">
	<link rel="stylesheet" href="/peoplay/resources/css/movie/review.css">


	
<script>  
/* 들어왔을 때  컬러 변경  wishList  */

$(function(){
	if(document.getElementById("selectWishList").value == '없음'){
		
	$("#wishList").css({"color" : "#008916","background-color": "white"});
	}else{
	$("#wishList").css({"color" : "white","background-color": "#008916"});
	}
	
}); 

/* 댓글 ajax */
$("#repliedbtn").click(function(){
   var $userNo = ${sessionScope.loginMember.userNo };
   var $movieNo = ${ requestScope.detail.no};
   var $replyText = document.getElementById("replyText").value; 
   
   if($replyText == ""){
      
      alert("리뷰를 빈칸으로 작성할 수 없습니다. 리뷰를 작성해주세요");
   } else{
   
   console.log($movieNo); 
   console.log($replyText);
   $.ajax({
      url : "reply",
      method : "POST",
      data : {
            "userNo" : parseInt($userNo),
            "movieNo" : parseInt($movieNo),
    	    "replyText" : $replyText
         	},
      
      success : function(reviews) {
            var $divReply = $("#div_reply_ajax"); 
            $divReply.html(""); 
            
            for(var index in reviews){
                if(reviews[index].memberInfo.userNo == $userNo){

            var $postList = $("<table class='ajax_table'>");
            var $moreList = $( "<tr>" + "<td class='repliedId'>" + "닉네임 : " + reviews[index].memberInfo.nickname + "</td>" + "<td class='repliedtime'>" 
            		         + reviews[index].registrationDate +  "</td>" + "</tr>"
            		         + "<tr>" + "<td class='replied'>" 
            				 + reviews[index].review + "</td>" + "</tr>"
            				 + "<tr>" +  "<td>" + "<button type='button' class='replyDelete' id='" + reviews[index].reviewNo + "'>" + " 삭제 " + "</button>"
                             +  "</td>" + "</tr>" 
            				 + "</table>"
            				);		

            console.log($divReply);
            $postList.append($moreList);
            $divReply.append($postList);
            $(".replyDelete").off('click'); 
            replyDelete();
                } else{
                    var $postList = $("<table class='ajax_table'>");
                    var $moreList = $( "<tr>" + "<td class='repliedId'>" + "닉네임 : " + reviews[index].memberInfo.nickname + "</td>" + "<td class='repliedtime'>" 
                    		         + reviews[index].registrationDate +  "</td>" + "</tr>"
                    		         + "<tr>" + "<td class='replied'>" 
                    				 + reviews[index].review + "</td>" + "</tr>"
                    				 + "<tr>" +  "</tr>" 
                    				 + "</table>"
                    				);		

                    console.log($divReply);
                    $postList.append($moreList);
                    $divReply.append($postList);
                    $(".replyDelete").off('click'); 
                    replyDelete();
                	
                }
            }
         }, 
      });
		   var reset = "";
		   document.getElementById("replyText").value = reset; 
   
   }
   
})
  /* 댓글 삭제 기능 */
function replyDelete(){
$(".replyDelete").click(function(){
	if(confirm("리뷰를 삭제하시겠습니까?") == true){ 
	   var $userNo = ${ sessionScope.loginMember.userNo };
	   var $movieNo = ${ requestScope.detail.no};
	   var $replyNum = $(this).attr("id");	
          console.log($replyNum);
		
      $.ajax({
            url : "replyDelete",
            method : "POST",
            data : 
               { 
            	 "replyNum": $replyNum, 
                 "movieNo": $movieNo
               },
               success : function(reviews) {
            	   var $divReply = $("#div_reply_ajax"); 
                   $divReply.html(""); 
                   
               for(var i = 0 ; i < reviews.length ; i++){
               if(reviews[i].memberInfo.userNo == $userNo){

                   var $postList =  $("<table class='ajax_table'>");
                   var $moreList = $( "<tr>" + "<td class='repliedId'>" + "닉네임 : " + reviews[i].memberInfo.nickname + "</td>" + "<td class='repliedtime'>" 
                   		         + reviews[i].registrationDate +  "</td>" + "</tr>"
                   		         + "<tr>" + "<td class='replied'>" 
                   				 + reviews[i].review + "</td>" + "</tr>"
                   				 + "<tr>" +  "<td>" + "<button type='button' class='replyDelete' id='" + reviews[i].reviewNo + "'>" + " 삭제 " + "</button>"
                                    +  "</td>" + "</tr>" 
                   				 + "</table>"
                   				);		
                   
                   console.log($divReply);
                   $postList.append($moreList);
                   $divReply.append($postList);
                   $(".replyDelete").off('click'); 
                   replyDelete();

                   
               		} else {
               			
                        var $postList =  $("<table class='ajax_table'>");
                        var $moreList = $( "<tr>" + "<td class='repliedId'>" + "닉네임 : " + reviews[i].memberInfo.nickname + "</td>" + "<td class='repliedtime'>" 
                        		         + reviews[i].registrationDate +  "</td>" + "</tr>"
                        		         + "<tr>" + "<td class='replied'>" 
                        				 + reviews[i].review + "</td>" + "</tr>"
                        				 + "<tr>" + "</tr>" 
                        				 + "</table>"
                        				);		
                        
                        console.log($divReply);
                        $postList.append($moreList);
                        $divReply.append($postList);
                        $(".replyDelete").off('click'); 
                        replyDelete();
               	}
                   }
               }, 
      });  
}
   })	
}
  /* 댓글 삭제 기능 */
$(".replyDelete").click(function(){
	   if(confirm("리뷰를 삭제하시겠습니까?") == true){ 
	   var $userNo = ${ sessionScope.loginMember.userNo };
	   var $movieNo = ${ requestScope.detail.no};
	   var $replyNum = $(this).attr("id");	
          console.log($replyNum);
		
      $.ajax({
            url : "replyDelete",
            method : "POST",
            data : 
               {
            	 "replyNum": $replyNum, 
                 "movieNo": $movieNo
               },
               success : function(reviews) {
            	   var $divReply = $("#div_reply_ajax"); 
                   $divReply.html(""); 
         

               for(var i = 0 ; i < reviews.length ; i++){
               if(reviews[i].memberInfo.userNo == $userNo){

                   var $postList =  $("<table class='ajax_table'>");
                   var $moreList = $( "<tr>" + "<td class='repliedId'>" + "닉네임 : " + reviews[i].memberInfo.nickname + "</td>" + "<td class='repliedtime'>" 
                   		         + reviews[i].registrationDate +  "</td>" + "</tr>"
                   		         + "<tr>" + "<td class='replied'>" 
                   				 + reviews[i].review + "</td>" + "</tr>"
                   				 + "<tr>" +  "<td>" + "<button type='button' class='replyDelete' id='" + reviews[i].reviewNo + "'>" + " 삭제 " + "</button>"
                                    +  "</td>" + "</tr>" 
                   				 + "</table>"
                   				);		
                   
                   console.log($divReply);
                   $postList.append($moreList);
                   $divReply.append($postList);
                   $(".replyDelete").off('click'); 
                   replyDelete();
                   
               } else {
                   var $postList =  $("<table class='ajax_table'>");
                   var $moreList = $( "<tr>" + "<td class='repliedId'>" + "닉네임 : " + reviews[i].memberInfo.nickname + "</td>" + "<td class='repliedtime'>" 
                   		         + reviews[i].registrationDate +  "</td>" + "</tr>"
                   		         + "<tr>" + "<td class='replied'>" 
                   				 + reviews[i].review + "</td>" + "</tr>"
                   				 + "<tr>" + "</tr>" 
                   				 + "</table>"
                   				);		
                   
                   console.log($divReply);
                   $postList.append($moreList);
                   $divReply.append($postList);
                   $(".replyDelete").off('click'); 
                   replyDelete();	
                   
               
              	 }
               }
               }, 
      });  
	}
   })
/* 찜 기능 */
$("#wishList").click(function(){

	  var userNo = ${ sessionScope.loginMember.userNo };
      var movieNo = ${ requestScope.detail.no};
    	console.log(userNo);
    	console.log(movieNo);
    	
    	var selectWishList = document.getElementById("selectWishList").value;
    	
    	
    	if(selectWishList == '없음'){
    		
    	/*  ajax로 insert */
    	$.ajax({
            url : "${pageContext.servletContext.contextPath}/movie/wishList",
            method : "POST",
            data : {
            	'userNo' : userNo,
            	'movieNo' : movieNo
            },
               success : function(data) {
            	   alert("찜 등록 완료");
                   console.log($divWish);
<%--
                   $divWish.html("");

            	   var $postList = 	<input type="hidden" id="selectWishList" value="${wishList}">
 	      	<button type="button" id="wishList" class="wishListUpdate" style="border-radius:20px;">
      			<img alt="찜" src="${ pageContext.servletContext.contextPath }/resources/images/movieIcon/check.png">
      		</button>
     	</div>
            	   
                   $postList.append($moreList);
--%>
               }, 
               error:function(request, status, error){
           		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
           	}
      }) 
      
    		/*success 후 색 변경 */
    		document.getElementById("selectWishList").value =  "있음";
		 	$("#wishList").css({"color" : "white","background-color": "#008916"}); 
			
    	}else if(selectWishList == "있음"){
    		/*  ajax로 insert */
    		
		    	$.ajax({
		            url : "${pageContext.servletContext.contextPath}/movie/unWishList",
		            method : "POST",
		            data : {
		            	'userNo' : userNo,
		            	'movieNo' : movieNo
		            },
		               success : function(data) {
		           		alert("찜 제거 완료");
		               }, 
		               error:function(request, status, error){
		           		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		           	}
		       }) 
    		/* success 후 색 변경 */
    		document.getElementById("selectWishList").value =  "없음";
		 	$("#wishList").css({"color" : "#008916","background-color": "white"}); 
			
    	}
   })
/* 좋아요 기능 */
$(".likeUpdate").click(function(){
      var $movieNo = ${ requestScope.detail.no};
      	console.log($movieNo);
      $.ajax({
            url : "likeUpdate",
            method : "POST",
            data : 
               {
            	"likeUpdate" : $movieNo
               },
               success : function(likeUpdate) {
      			alert("좋아요 클릭");
                   console.log(data);
               }, 
      }) 
   })

/* 싫어요 기능 */
$(".disLikeUpdate").click(function(){
      var $movieNo = ${ requestScope.detail.no};
      	console.log($movieNo);
      $.ajax({
            url : "disLikeUpdate",
            method : "POST",
            data : 
               { "disLikeUpdate": $movieNo
            	
               },
               success : function(disLikeUpdate) {
      			alert("싫어요 클릭");
                   console.log(data);
               }, 
      }) 
   })


	
	
  /* 키업 */
     var replyText = document.getElementById("replyText").value; 

     $(document).ready(function() {
 	    $('#replyText').on('keyup', function() {
 	        $('#counter').html("("+$(this).val().length+" / 50)");

 	        if($(this).val().length > 50) {
 	            $(this).val($(this).val().substring(0, 50));
 	            $('#counter').html("(50 / 50)");
 	        }
 	    })
     })
  </script>
  

</html>