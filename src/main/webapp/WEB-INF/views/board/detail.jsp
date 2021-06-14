<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>PEOPLAY: 자유게시판</title>

<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/board/board.css">

 <script src="https://code.jquery.com/jquery-latest.js"></script>
<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 --> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style type="text/css">
.modal_wrap{
        display: none;
        width: 500px;
        height: 500px;
        position: absolute;
        top:100%;
        left: 50%;
        margin: -250px 0 0 -250px;
        background:#eee;
        z-index: 2;
    }
    .black_bg{
        display: none;
        position: absolute;
        content: "";
        width: 100%;
        height: 100%;
        top:0;
        left: 0;
        z-index: 1;
    }
    .modal_close{
        width: 26px;
        height: 26px;
        position: absolute;
        top: -30px;
        right: 0;
    }
    .modal_close> a{
        display: block;
        width: 100%;
        height: 100%;
        background:url(https://img.icons8.com/metro/26/000000/close-window.png);
        text-indent: -9999px;
    }
</style>


</head>
<body>

	<jsp:include page="../common/header.jsp" />

    <section>
        <div class="detail-wrap" style="height: auto;">
            <div style="height: 100px;"></div>
            <div class="detail-title" >자유게시판 </div>
            <div style="height: 110px;"></div>
            </div>
            </section>
            
            
            
            <section>
            <div class="detail-wrap" style="height: auto;">
            <div class="article" style="height: auto;" >
                <div style="height: auto;">
             
                    <table>
                        <tr>
                            <td class="detail-title-td"> 제목</td>
                            <td class="detail-title-input-td" colspan="5">${requestScope.detail.title}</td>
                        </tr>

                        <tr>
                            <td class="detail-tds">작성날짜</td>
                            <td class="detail-tds">${requestScope.detail.creationDate}</td>
                            <td class="detail-tds">작성자</td>
                            <td class="detail-tds">${requestScope.detail.memberDTO.nickname}</td>
                            <td class="detail-tds">카테고리</td>
                            <td class="detail-tds">${requestScope.detail.category}</td>
                           
                        </tr>
                    </table>
                    <div class="detail-content" style="margin: 10px;">${requestScope.detail.content}</div>
                </div>
                
                <div>
                <form action="${pageContext.servletContext.contextPath}/board/delete" method="get">
                   <input type="hidden" name="no" value="${requestScope.detail.no }">
                    <table>
                    
                            <tr>
                                <td style="width: 20px;"></td>
                                <td><button class="btn-report"type="button"  id="report_modal"  >신고</button></td>
                                <td style="width: 30px;"></td>
                                <td><button type="button"  class="btn-detail-modify" onclick="location.href='${ pageContext.servletContext.contextPath}/board/list'">목록으로</button> </td>
                                <td style="width: 530px"> </td>
                                <c:if test="${sessionScope.loginMember.userNo ==  requestScope.detail.userNo || sessionScope.loginMember.userRole == 'ADMIN'}"> 
                              <td> <button class="btn-detail-cancel" id="delete" type="submit" onclick="location.href='${ pageContext.servletContext.contextPath}/board/delete/${ requestScope.detail.no }'">삭제</button></td>
                                <td style="width: 55px;"></td>
                                <td><button class="btn-detail-modify" id="update" type="button" onclick="location.href='${pageContext.servletContext.contextPath}/board/modify?no=${ requestScope.detail.no }'">수정</button></td>
                                <td style="width: 25px;"></td>
                                </c:if>
                            </tr>
                    </table>
					</form>
                </div>
                </div>
                </div>
			</section>
			
			
			
			
			<section>
			        <div class="detail-wrap" style="height: auto;">
			            <div class="article" style="height: auto; background-color: #181818;" >
			
                <div style="height: 100px; background-color: #181818;"> </div>
                
              
               	<form action="${pageContext.servletContext.contextPath}/board/insertReply" method="get" id="insertReplyForm">
                 <input type="hidden" name="postNo" value="${requestScope.detail.no }">
      			 <input type="hidden" name="userNo" value="${sessionScope.loginMember.userNo }"/> 
      	           
                <table id="comentList">
                    <tr>
                        <td class="comment-td">댓글</td>
                        <td><input type="text" class="comment-input" name="content" id="replyInput" placeholder="댓글을 입력하세요"></td>
                        <td><button type="submit" class="btn-comment" id="comment_submit">작성</button></td>

                    </tr>
                  
                </table>
              </form>
             
              </div>
              </div>
              </section>
              
              
              
              
              <section>
                  <div class="detail-wrap" style="height: auto; background-color: #181818;">
			            <div class="article" style="height: auto;" >
          
              <c:forEach items="${requestScope.reply }" var="reply" varStatus="status">
              
              <div style="height: 30px; background-color: #181818;"> </div>
                
                <form action="${pageContext.servletContext.contextPath}/board/replyDelete" method="get" >
                
                 <input type="hidden" name="replyNo" value="${reply.no }">
              	<input type="hidden" name="boardNo" value="${detail.no }">
          	<table style="border: 1px; background-color: #2C2C2C;">
          	<tbody style="border-style: solid; border-color: white; border-width: 1px; font-size: 16px">
          	
          	 <tr>
          	 <td style="color: white; width: 200px;"> <c:out value="${ reply.memberDTO.nickname}"/>  </td>   
          	  </tr>
          	  
          	  <tr>          	 
          	  <td style="color: white; " width="1100px"> <c:out value="${ reply.content}"/> </td>
          	   </tr>
          	   
           <tr>
           <td style="color: white; width: 200px"><c:out value="${ reply.date}"></c:out></td>
           <td style="width: 300px"></td>
             <c:if test="${sessionScope.loginMember.userNo ==  requestScope.detail.userNo || sessionScope.loginMember.userRole == 'ADMIN'}"> 
           
           <td > <button type="button" id="replyModify_${status.index} "  style=" width: 100px; color: white; background-color:#2C2C2C;">수정</button></td>
           <td > <button type="submit" id="replyDelete" style=" width: 100px; color: white;">삭제 </button></td>
           </c:if>
           <td> <button type="button" id="replyReport_${status.index}" style=" width: 100px; color: white; background-color:#2C2C2C; " >신고</button> </td>
           <td > <button type="button" id="insertReplyOf_${reply.no }" name="insertReplyOf" class="insertReplyOf" style=" width: 100px; color: white; background-color:#2C2C2C; ">댓글</button></td>
           </tr>
           
           </tbody>
           	</table>
           	
           	</form>
           	
           	 <!--대댓글 작성 창 -->
           	 	<form action="${pageContext.servletContext.contextPath}/board/insertReplyOf" method="get" id="insertReplyOfForm">
           	 	<input type="hidden" name="refNo" value="${reply.no }">
      			 <input type="hidden" name="userNo" value="${sessionScope.loginMember.userNo }"/> 
           	 	<input type="hidden" name="refBoardNo" value="${detail.no}">
           	 <div id="replyOfDiv_${status.index}" style="display: none;">
      	<table>
           	 	
            <tr class=replyOfInput id="replyOfInput_${status.index}" style=" margin-right: 30px; height: 30px; font-size: 16px; margin-left: 30px; background-color: #2C2C2C;">
           	<td style="color: white" width="200px">댓글 작성: </td>
           	<td><input type="text" name="replyOfContent" style="width: 700px;height: 30px;text-align: center;" placeholder="댓글을 입력해주세요" id="replyOfContent_${status.index}" ></td>
           	<td width="100px"></td>
           	<td><button style="color: white; width: 100px" type="submit" id="replyOfInsert_${status.index}"  >작성</button> </td>
           	<td width="30px;"> </td>
           	<td><button style="color: white; width: 100px" id="cancleReplyOf_${status.index}" type="button" >취소</button> </td>
           	
            </tr>
            
        </table>
            </div>
            
            
            
          </form>
          	 <!--댓글 신고 창 -->
           	 	<form action="${pageContext.servletContext.contextPath}/board/reportReply" method="get">
           	 	<input type="hidden" name="refNo" value="${reply.no }">
      			 <input type="hidden" name="userNo" value="${sessionScope.loginMember.userNo }"/> 
           	 	<input type="hidden" name="refBoardNo" value="${detail.no}">
           	 	<input type="hidden" name="reportedPerson" value="${reply.userNo }">
           	 <div id="replyReportDiv_${status.index}" style="display: none; margin-left: 300px;">
      		<table>
           	 	
            <tr class=replyOfInput id="replyReport_${status.index}" style=" margin-right: 30px; height: 30px; font-size: 16px; margin-left: 30px; background-color: #2C2C2C;">
           	<td style="color: white" width="200px">신고사유:  </td>
           	<td><select name="reportReason"  style="color: white; background-color:#2C2C2C;  width: 400px">
           			  <option value="욕설">욕설 </option>
           	          <option value="혐오발언">불쾌감을 일으키는 혐오발언 </option>
           	          <option value="주제에 맞지 않는 글">주제에 어긋난 글 </option>
           	          <option value="음란물,광고글">음란물 혹은 광고글 </option>
           	
           	</select></td>
           	<td width="100px"></td>
           	<td><button style="color: white; width: 100px" type="submit" >신고</button> </td>
           	<td width="30px;"> </td>
           	<td><button style="color: white; width: 100px" id="cancleReportReplyBtn_${status.index }" type="button" >취소</button> </td>
           	
            </tr>
            
        </table>
            </div>
          </form>


            <!-- 댓글 수정 창 -->
          	<form action="${pageContext.servletContext.contextPath}/board/modifyReply" method="get" id="modifyReplyForm">
          	
          	<div style="display: none;" id="modifyArea_${status.index }">
          	
          	<input type="hidden" name="replyNo" value="${reply.no }">
          	<input type="hidden" name="boardNo" value="${detail.no }">

           	<table style="margin-left: 200px; font-size: 16px;">
           	<tr style="height: 30px; background-color: #2C2C2C;">
           	<td style="color: white;" width="130px"> 내용 : </td>
           	<td  width="600px"><input type="text" name="modifyContent" value="${reply.content }" style="width: 600px; height: 30px; " id="modiftReplyInput_${status.index}"></td>
           	<td width="200px"> </td>
           	<td><button type="submit" style="color: white; width: 100px" id="modifyReplyBtn_${status.index}">수정</button> </td>
           	<td><button type="button" id="cancleModifyReplyBtn_${status.index }" style=" color: white; width: 100px" >취소</button> </td>
           	
           	</tr>
           	</table>
           	</div>
         </form>
           	
           	
           	<div style="background-color: #181818;">
           	
           	
           	<!--대댓글 출력  -->
        	<c:forEach items="${requestScope.replyOf }" var="replyOf"> 
        	<form action="${pageContext.servletContext.contextPath}/board/deleteReplyOf" method="get">
        	<input type="hidden" name="replyOfNo" value="${replyOf.no}">
           	 	<input type="hidden" name="refBoardNo" value="${detail.no}">
          	          	 <c:if test="${replyOf.refRelyNo eq reply.no}">
           	    	<table style="border: 1px; background-color: #2C2C2C; margin-left: 50px">
          	<tbody style="border-style: solid; border-color: white; border-width: 1px; font-size: 16px; background-color: #2C2C2C;">
          	
          	 <tr>
          	 <td style="color: white; width: 200px;"> <c:out value="↪${ replyOf.memberDTO.nickname}"/>  </td>
          	
          	  </tr>
          	  
          	  <tr>          	 
          	  <td style="color: white; " width="1100px"> <c:out value="${ replyOf.content}"/> </td>
          	   </tr>
           <tr>
           <td style="color: white; width: 200px"><c:out value="${ replyOf.date}"></c:out></td>
           <td style="width: 200px"></td>
            <c:if test="${sessionScope.loginMember.userNo ==  requestScope.detail.userNo || sessionScope.loginMember.userRole == 'ADMIN'}"> 
           
           <td > <button type="button" id="modifyReplyOf_${status.index }"  style=" width: 100px; color: white;">수정 </button></td>
           <td > <button type="submit"  style=" width: 100px; color: white;">삭제 </button></td>
           </c:if>
           <td > <button type="button"  id="replyOfReportBtn_${status.index }" style=" width: 100px; color: white;">신고 </button></td>
           
           </tr>
           </tbody>
          	</table>
          </c:if>
          	 	</form>
          	 	
          	 	
          	 	
          	 <!--대댓글 신고 창 -->
           	 	<form action="${pageContext.servletContext.contextPath}/board/reportReplyOf" method="get">
           	 	<input type="hidden" name="replyOfNo" value="${replyOf.no}">
      			 <input type="hidden" name="userNo" value="${sessionScope.loginMember.userNo }"/> 
           	 	<input type="hidden" name="refBoardNo" value="${detail.no}">
           	 	<input type="hidden" name="reportedPerson" value="${replyOf.userNo }">
           	 	    <c:if test="${replyOf.refRelyNo eq reply.no}">
           	 	
           	 <div id="replyOfReportDiv_${status.index}" style="margin-left: 300px; display: none;">
      	<table>
           	 	
            <tr class=replyOfInput id="replyOfReport_${status.index}" style=" margin-right: 30px; height: 30px; font-size: 16px; margin-left: 30px; background-color: #2C2C2C;">
           	<td style="color: white" width="200px">신고사유:  </td>
           	<td><select name="reportReason"  style="color: white; background-color:#2C2C2C;  width: 400px">
           			  <option value="욕설">욕설 </option>
           	          <option value="혐오발언">불쾌감을 일으키는 혐오발언 </option>
           	          <option value="주제에 맞지 않는 글">주제에 어긋난 글 </option>
           	          <option value="음란물,광고글">음란물 혹은 광고글 </option>
           	
           	</select></td>
           	<td width="100px"></td>
           	<td><button style="color: white; width: 100px" type="submit" >신고</button> </td>
           	<td width="30px;"> </td>
           	<td><button style="color: white; width: 100px" id="cancleReportReplyOfBtn_${status.index }" type="button"  >취소</button> </td>
           	
            </tr>
            
        </table>
            </div>
            </c:if>
 </form>	
          	 
          	 <!--대댓글 수정 -->
          	 <form action="${pageContext.servletContext.contextPath}/board/modifyReplyOf" method="get" id="modifyReplyOfForm">
          	           	          	 <c:if test="${replyOf.refRelyNo eq reply.no}">
          	 
          	<div style="display: none; " id="modifyReplyOfArea_${status.index }">
          	
          	<input type="hidden" name="replyOfNo" value="${replyOf.no }">
          	<input type="hidden" name="boardNo" value="${detail.no }">

           	<table style="margin-left: 200px; font-size: 16px;">
           	
           	<tr style="height: 30px; background-color: #2C2C2C;">
           	<td style="color: white;" width="130px"> 내용 : </td>
           	<td  width="600px"><input type="text" id="modifyReplyOfContent_${status.index}" name="modifyReplyOfContent" value="${replyOf.content }" style="width: 600px;height: 30px;"></td>
           	<td width="200px"> </td>
           	<td><button type="submit" style="color: white; width: 100px" id="modifyReplyOfBtn_${status.index}">수정</button> </td>
           	<td><button type="button" id="cancleModifyReplyOfBtn_${status.index }" style=" color: white; width: 100px">취소</button> </td>
           	
           	</tr>
           	</table>
           	</div>
           	</c:if>
         </form> 
          	</c:forEach>
       </div>
          </c:forEach>
          </div>
           
			</div>
  	  </section>
    <div style="height: 100px; background-color: #181818;"></div>
    
    
    
    <!--신고창 html -->
    <form action="${pageContext.servletContext.contextPath}/board/report" method="get" id="reportForm">
    <div class="black_bg"></div>
<div class="modal_wrap">
    <div class="modal_close"><a href="#">close</a></div>
    <div align="center">
        <h2 align="center">신고하기</h2>
       <div style="height: 80px"></div>
       <label  style="font-size: 15px; text-align: center; width: 100px">신고 사유 : </label>
        <select id="reportReason" name="reason" style="font-size: 15px; align-content: center;" onchange="reportCategoryChanged(this.value)" >
       			<option value="음란물">음란물 신고</option>
                <option value="광고물">광고물 신고</option>
                <option value="회원간 분쟁">회원간 분쟁을 유도</option>
                <option value="욕설">욕설</option>                
                <option value="기타">기타 사유</option>
        </select>
        <input type="hidden" name="placeNo" value="${requestScope.detail.no }"/> 
        <input type="hidden" name="reportedPerson" value="${requestScope.detail.userNo }"/> 
        <input type="hidden" name="userNo" value="${sessionScope.loginMember.userNo }"/> 
        
       <div style="height: 40px"></div>
       
        <textarea id="reportContent" name="otherReason" style="width:40% ; height: 50px; display: none; " placeholder="기타사유를 입력해주세요"></textarea>
        <div style="height: 30px;"></div>
        <button type="submit" style="height: 40px; width: 60px; background-color: red;" id="boardReportBtn">제출</button> 
        <button type="button" style="height: 40px; width: 60px; background-color: green;" onclick="location.href='${pageContext.servletContext.contextPath}/board/list'">취소</button>
    </div>
 </div>
 </form>



    	<jsp:include page="../common/footer.jsp" />
    	

  
  
   <!--게시글 신고창 -->
  <script>
  
        	window.onload = function() {
        		 
        	    function onClick() {
        	        document.querySelector('.modal_wrap').style.display ='block';
        	        document.querySelector('.black_bg').style.display ='block';
        	    }   
        	    function offClick() {
        	        document.querySelector('.modal_wrap').style.display ='none';
        	        document.querySelector('.black_bg').style.display ='none';
        	    }
        	 
        	    document.getElementById('report_modal').addEventListener('click', onClick);
        	    document.querySelector('.modal_close').addEventListener('click', offClick);
        	 
        	};
        	/* 기타 사유 선택시 textArea */
        	function reportCategoryChanged(reportReason){
        		
        		console.log(reportReason);
        		
        		if(reportReason == '기타'){
        			
        			var $reportContentText = document.getElementById("reportContent");
        			$reportContentText.style.display = "block";
        			
        		} else {
        			
        			var $reportContentText = document.getElementById("reportContent");
        			$reportContentText.style.display = "none";
        			
        		}
        		
        	};
        	
        	  </script>
        	  

	   	<script type="text/javascript">
 	
	   	
	  
        
	/* 대댓글 작성버튼 */
				
        var insertBtn =$("button[id^='insertReplyOf_']");
        var inputBtn =$("div[id^='replyOfDiv_']");
     	
	  				$(insertBtn).on('click',function(){	
			   			inputBtn[insertBtn.index(this)].style.display='block';
	  			});
		   			 
		   	
		   		
	   		/* 대댓글 취소 버튼 */
	  	$("button[id^='cancleReplyOf']").on('click',function(){
	   		for(var i=0 ;i<insertBtn.length ;i++){
	   			
	   			
	   			$("tr[id^='replyOfInput_']")[i].style.display='none';
	   			
	   			
	   		}
	   		})	;
   		
	 /* 댓글 수정 창 활성화  */
        var modifyInput = $("div[id^='modifyArea_']");
        var modifyBtn =$("button[id^='replyModify_']");
        
	  	$(modifyBtn).on('click',function(){
	  		
				console.log(modifyBtn.index(this));
				console.log(modifyInput);
				
	  		modifyInput[modifyBtn.index(this)].style.display='block';
	  	});
		
	 /* 대댓글 수정 창 활성화 */
	 
        var modifyReplyOfArea = $("div[id^='modifyReplyOfArea_']");
        var modifyReplyOfClick =$("button[id^='modifyReplyOf_']");
        	 
		 	$(modifyReplyOfClick).on('click',function(){
				console.log(modifyReplyOfBtn.index(this));
				console.log(modifyReplyOfArea);
				modifyReplyOfArea[modifyReplyOfClick.index(this)].style.display='block';
	  	});
	 
	 /* 댓글 신고창 활성화 */
	 var replyReportArea =$("div[id^='replyReportDiv_']");
	 var replyReportBtn = $("button[id^='replyReport_']");
	
	 $(replyReportBtn).on('click',function(){
			console.log(replyReportBtn.index(this));
			console.log(replyReportArea);
			replyReportArea[replyReportBtn.index(this)].style.display='block';
	});
	 /* 대댓글 신고창 */
	 
	 var replyOfReportArea =$("div[id^='replyOfReportDiv_']");
	 var replyOfReportBtn = $("button[id^='replyOfReportBtn_']");
	
	 $(replyOfReportBtn).on('click',function(){
			replyOfReportArea[replyOfReportBtn.index(this)].style.display='block';
	 
	 });
	 
	 
	 /*취소 버튼 */
        var cancleModifyReplyBtn =$("button[id^='cancleModifyReplyBtn_']");
        var cancleReportReplyBtn =$("button[id^='cancleReportReplyBtn_']");
        var cancleModifyReplyOfBtn =$("button[id^='cancleModifyReplyOfBtn_']");
        var cancleReportReplyOfBtn =$("button[id^='cancleReportReplyOfBtn_']");
       
        $(cancleModifyReplyBtn).on('click',function(){
        	modifyInput[cancleModifyReplyBtn.index(this)].style.display='none';
	 
	 });
        
        $(cancleReportReplyBtn).on('click',function(){
        	replyReportArea[cancleReportReplyBtn.index(this)].style.display='none';
	 
	 });
        $(cancleModifyReplyOfBtn).on('click',function(){
        	modifyReplyOfArea[cancleModifyReplyOfBtn.index(this)].style.display='none';
	 
	 });
        $(cancleReportReplyOfBtn).on('click',function(){
        	replyOfReportArea[cancleReportReplyOfBtn.index(this)].style.display='none';
	 
	 });
        
	 </script>

<script type="text/javascript">

/*  댓글 널 값 처리 */
$(document).on('click', '#comment_submit', function (e) {
	
	if(document.getElementById("replyInput").value == ""){
		
		alert("내용을 입력해주세요");
		e.preventDefault();

		return;
		
	}
	else{
		
	$("#insertReplyForm").submit();

	}
	
	  });

/* 대댓글 널 값 처리 */
 
  var replyOfContent =$("input[id^='replyOfContent_']");
 var replyOfInsert =$("button[id^='replyOfInsert_']");

	
				$(replyOfInsert).on('click',function(e){	
					
					if($(replyOfContent[replyOfInsert.index(this)]).val()==""){
						
						alert("내용을 입력해주세요");
						e.preventDefault()
						return;
					}else{
						$('insertReplyOfForm').submit();
					}
		});

	   
/* 댓글 수정 */
 var modiftReplyInput =$("input[id^='modiftReplyInput_']");
 var modifyReplyBtn =$("button[id^='modifyReplyBtn_']");
 
 $(modifyReplyBtn).on('click',function(e){	
		
		if($(modiftReplyInput[modifyReplyBtn.index(this)]).val()==""){
			
			alert("내용을 입력해주세요");
			e.preventDefault()
			return;
		}else{
			$('modifyReplyForm').submit();
		}
});



/* 대댓글 수정 */ 
 var modifyReplyOfContent =$("input[id^='modifyReplyOfContent_']");
 var modifyReplyOfBtn =$("button[id^='modifyReplyOfBtn_']");
 
 		$(modifyReplyOfBtn).on('click',function(e){	
		
		if($(modifyReplyOfContent[modifyReplyOfBtn.index(this)]).val()==""){
			
			alert("내용을 입력해주세요");
			e.preventDefault()
			return;
		}else{
			$('modifyReplyOfForm').submit();
		}
});
 
 
 
 /* 게시판 신고 기타 사유 */
$(document).on('click', '#boardReportBtn', function (e) {
	
	if(document.getElementById("reportReason").value == '기타'){
		
	
	
		if(document.getElementById("reportContent").value == ""){
		
		alert("내용을 입력해주세요");
		e.preventDefault();

		return;
		
	}
	else{
		
	$("#reportForm").submit();

	}
	
 }}); 
 
</script>


</body>
</html>