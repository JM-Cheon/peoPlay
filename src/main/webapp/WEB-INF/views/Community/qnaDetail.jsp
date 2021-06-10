<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Q&A 상세페이지</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/Community/board.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/common/reset.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="p-board-wrapper">
		<div class="p-board-container">
			<!--제목-->
			<div class="p-board-title">
				<h2>Q&A</h2>
			</div>
			<!--//제목-->	
			<!--컨텐츠-->
			<div class="p-board-panel">
				<!--네비-->
				<aside class="p-left-snb">
					<ul>
						<li>
							<a href="${pageContext.servletContext.contextPath}/notice/ntclist">공지사항</a>
						</li>
						<li>
							<a href="${pageContext.servletContext.contextPath}/Faq/faqList">FAQ</a>
						</li>
						<li>
							<a href="${pageContext.servletContext.contextPath}/QNA/qnaList" class="on">Q&A</a>
						</li>
					</ul>
				</aside>
				<!--//네비-->
				<!--리스트-->
				<section class="p-right-list">
					<!--상세-->
					<div class="p-board-detail">
						<dl>
							<dt>제목</dt>
							<dd>${ requestScope.qnaDetail.inquiryTitles }</dd>
						</dl>
						<dl>
							<dt>작성일</dt>
							<dd>${ requestScope.qnaDetail.creationDate }</dd>
							<dt>회원 이름</dt>
							<dd>${ requestScope.qnaDetail.writer.nickname }</dd>
						</dl>
						<section class="p-board-view">
							${ requestScope.qnaDetail.inquiryContent }
						</section>
					</div>
					<!--//상세-->
					<!--관리자 답변-->
					<div class="p-comment-box">
						<div class="p-admin-comment">
								<h3>관리자 답변</h3>
								<c:if test="${ sessionScope.loginMember.userRole eq 'ADMIN'}">
								<!--답변 작성-->
								<div class="p-comment-edit">
									 <input type="hidden" id="inquiryNo" name="inquiryNo" value="${qnaDetail.inquiryNo }" />        
										<textarea id="replyContent" name="replyContent" placeholder="관리자 답변을 입력해주세요."></textarea>
									<div class="p-comment-btn">
										<button type="button" id="replyButton" name="replyButton">등록</button>
									</div>
								</div>
							<table></table>
							</c:if>
							<!--//답변 작성-->
							<!--답변-->
							<div class="p-comment-view" id="comment">
								<c:forEach items="${ selectComment }" var="qna">
								<div class="p-comment-area">
									<input type="hidden" id="commentNo" name="commentNo" value="${qna.commentNo }" />  
									<span> 
										<fmt:formatDate var="resultDate" value="${qna.creationDate}"  pattern="yyyy-MM-dd HH:mm:ss" />
											<c:out value="${resultDate}" />
									</span>
									<p>
										<c:out value="${ qna.replyContent }" />
									</p>
									<div class="p-edit-btns">
										<c:if test="${ sessionScope.loginMember.userRole eq 'ADMIN'}">
											<button type="button" class="replyUpdate" name="replyUpdate" data-toggle="modal" data-target="#myModal">수정</button>
											<button type="button" class="replyDelete" name="replyDelete">삭제</button>
										</c:if>
									</div>
								</div>
								</c:forEach>
								<table></table>
							</div>
							<!--//답변-->
							<!-- 모달  -->
							 <!-- The Modal -->
								<div class="modals" id="myModal">
									<div class="modal-dialog">
										<div class="modal-content">
											<!-- Modal Header -->
											<div class="modal-header">
												<h4 class="modal-title">댓글 수정하기</h4>
											</div>
												<!-- Modal body -->
											<form action="${ pageContext.servletContext.contextPath }/QNAadmin/reply/update" method="post">
												<div class="modal-body">
													    <textarea  class="modal-body-textarea" name="replyContent" required="required"></textarea><br>
														<input type="hidden" id="commentNo2" name="commentNo" value="${ requestScope.selectComment[0].commentNo} " />  
													    <input type="hidden" id="inquiryNo" name="inquiryNo" value="${ qnaDetail.inquiryNo }" />        
												</div>
												 <!-- Modal footer -->
												<div class="modal-footer">
													<button type="submit" class="btn btn-danger1">수정</button>
													<button type="submit" class="btn btn-danger" data-dismiss="modal">취소</button>
												</div>
											 </form> 
										</div>
									</div>
								 </div>
						<!-- 모달  -->
						</div>
					</div>
					<!--//관리자 답변-->
					<!--버튼-->
					<div class="p-btn-group">
						<button type="button" class="p-btn-default" id="btnList">목록으로</button>
						<c:if test="${ sessionScope.loginMember.nickname eq qnaDetail.writer.nickname || sessionScope.loginMember.userRole eq 'ADMIN' }">
							<button type="button" class="p-btn-delete" id="delete">삭제</button>
							<button type="button" class="p-btn-modify" id="update" onclick="location.href='${ pageContext.servletContext.contextPath}/QNA/update/${ requestScope.qnaDetail.inquiryNo }'">수정</button>
						</c:if>
					</div>
					<!--//버튼-->
				</section>
				<!--//리스트-->
			</div>
			<!--// 컨텐츠-->
		</div>
	</div>
<script>
	
/*  ${fn:length(requestScope.selectComment)}
 *  ${ requestScope.selectComment[0].replyContent} 
 *  ${ requestScope.selectComment[0].creationDate} 
 */
			/* 디테일 페이지 목록 삭제 버튼 */
			
			var admin = ${sessionScope.loginMember.userRole == 'ADMIN'};
			
        	$(document).on('click','#delete',function (e) {
                        
            	var con = confirm("게시글을 삭제하시겠습니까?");
            	
            		if(con){
            			alert("삭제되었습니다.");
            			 if(admin){
                         	
            	                location.href = "${ pageContext.request.contextPath}/QNAadmin/qnaList";
            	                	
            	                }else{
            	                	
            	                location.href = "${ pageContext.request.contextPath}/QNA/qnaList";
            	                }
            		}else{
            			alert("취소 되었습니다.");
            		}
      		  });
            $(document).on('click', '#btnList', function (e) {
                e.preventDefault();
                if(admin){
                	
                location.href = "${ pageContext.request.contextPath}/QNAadmin/qnaList";
                	
                }else{
                	
                location.href = "${ pageContext.request.contextPath}/QNA/qnaList";
                }
            });
            
            $(document).on('click','#delete',function (e) {
                
            	
      		  });
</script>
        
<script>
		/* 댓글 작성 */
        $('#replyButton').click(function(){ 
        const inquiryNo = ${ qnaDetail.inquiryNo }; 
        const replyContent = $('#replyContent').val();
		
        if(replyContent === ""){
        	alert("댓글을 입력해주세요.");
        }
        
            console.log(inquiryNo);
            console.log(replyContent);
            $.ajax({
                url : "${pageContext.servletContext.contextPath}/QNAadmin/qnaDetail/reply",
                type : "POST",
                data : {
	                	"inquiryNo" : inquiryNo,
	                    "replyContent" : replyContent
               		   },
                success : function(selectComment){

                	const $div = $("#comment");
                	$div.html("");
    
                	for(var index in selectComment){
                		
					$area =	$( "<div class='p-comment-view' id='comment'>" + "<div class='p-comment-area'>" + "<input type='hidden' id='commentNo' name='commentNo' value='" + selectComment[index].commentNo + "'/>" +
							"<span>" + selectComment[index].creationDate + "</span>" +
							"<p>" + selectComment[index].replyContent + "</p>" + 
							"<div class='p-edit-btns'>" +
							"<button type='button' class='replyUpdate' name='replyUpdate' data-toggle='modal' data-target='#myModal'>" + "수정" + "</button>" +
							"<button type='button' class='replyDelete' name='replyDelete'>" + "삭제" + "</button>" +
							"</div>" + "</div>" + "</div>");
			
						$div.append($area);
						
     					$(".replyDelete").off('click');
     				    $(".replyUpdate").off('click');
     				    deleteButton();
     				    
     				   document.getElementById("commentNo2").value = document.getElementById("commentNo").value;
     				    
                	}
                	alert("댓글이 작성되었습니다.")
                }
            });
               			var reset ="";
     					document.getElementById("replyContent").value = reset;	
     				   
     					
     				   
        });
    
		/* 디테일 페이지 댓글 목록 삭제  */
        $(".replyDelete").click(function(){ 
        	 const inquiryNo = ${ qnaDetail.inquiryNo }; 
        	 const commentNo  = this.parentNode.parentNode.children[0].value;
        	 if(confirm("삭제 하시겠습니까?") == true){
        		
        		$.ajax({
        			url : "${pageContext.servletContext.contextPath}/QNAadmin/qnaDetail/reply/delete",
        			type : "POST",
        			data : {"commentNo" : commentNo,
        				    "inquiryNo" : inquiryNo},
        			success : function(selectComment){
        				
        				const $div = $("#comment");
                    	$div.html("");
        
                    	for(var index in selectComment){
                    		
    					$area =	$( "<div class='p-comment-view' id='comment'>" + "<div class='p-comment-area'>" + "<input type='hidden' id='commentNo' name='commentNo' value='" + selectComment[index].commentNo + "'/>" +
    							"<span>" + selectComment[index].creationDate + "</span>" +
    							"<p>" + selectComment[index].replyContent + "</p>" + 
    							"<div class='p-edit-btns'>" +
    							"<button type='button' class='replyUpdate' name='replyUpdate' data-toggle='modal' data-target='#myModal'>" + "수정" + "</button>" +
    							"<button type='button' class='replyDelete' name='replyDelete'>" + "삭제" + "</button>" +
    							"</div>" + "</div>" + "</div>");
    			
    						$div.append($area);
    						
         					$(".replyDelete").off('click');
         				    $(".replyUpdate").off('click');
         				    deleteButton();
         				   
                    	}
        				
              	 	 alert("댓글이 삭제되었습니다.")
              	 	
        			}
        		});
             }
        	
        }); 
</script>

<script>
        /* ajax 댓글 삭제 */
        function deleteButton(){
        	
        	  $(".replyDelete").click(function(){ 
        		  
        		const $inquiryNo = this.parentNode.parentNode.parentNode.parentNode.parentNode.children[1].children[0];
        		const $commentNo = this.parentNode.parentNode.children[0];

              	  
              	if(confirm("삭제 하시겠습니까?") == true){
              		
              		$.ajax({
              			url : "${pageContext.servletContext.contextPath}/QNAadmin/qnaDetail/reply/delete",
              			type : "POST",
              			data : {"commentNo" : $commentNo.value,
              			     	"inquiryNo" : $inquiryNo.value},
              			success : function(selectComment){

            				const $div = $("#comment");
                        	$div.html("");
            
                        	for(var index in selectComment){
                        		
        					$area =	$( "<div class='p-comment-view' id='comment'>" + "<div class='p-comment-area'>" + 
        							"<input type='hidden' id='commentNo' name='commentNo' value='" + selectComment[index].commentNo + "'/>" +
        							"<span>" + selectComment[index].creationDate + "</span>" +
        							"<p>" + selectComment[index].replyContent + "</p>" + 
        							"<div class='p-edit-btns'>" +
        							"<button type='button' class='replyUpdate' name='replyUpdate' data-toggle='modal' data-target='#myModal'>" + "수정" + "</button>" +
        							"<button type='button' class='replyDelete' name='replyDelete'>" + "삭제" + "</button>" +
        							"</div>" + "</div>" + "</div>");
        			
        						$div.append($area);
        						
             					$(".replyDelete").off('click');
             				    $(".replyUpdate").off('click');
             				    deleteButton();
             				    
                        	}
            				
                  	 	 alert("댓글이 삭제되었습니다.")
                    	 	
              			}
              		});
              	}
              	
              });
        }
        
</script>
<script>

</script>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>