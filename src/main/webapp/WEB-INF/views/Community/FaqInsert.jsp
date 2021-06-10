<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>FAQ 글작성</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/Community/board.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/common/reset.css">
</head>
<body>
<jsp:include page="../common/header.jsp"/>
	<div class="p-board-wrapper">
		<div class="p-board-container">
			<!--제목-->
			<div class="p-board-title">
				<h2>글 작성</h2>
			</div>
			<!--//제목-->
			
			<!--컨텐츠-->
			<div class="p-board-panel">
				<!--리스트-->
				<section class="p-right-write">
				<form action="${ pageContext.servletContext.contextPath }/FaqAdmin/insertWrite" id="form" name="form" method="post">
				  <input type="hidden" name="userNo" value="${sessionScope.loginMember.userNo }"> 
					<!--상세-->
					<div class="p-board-detail">
						<dl>
							<dt>제목</dt>
							<dd>
								<input type="text" class="p-input-box" name="faqTitle" id="faqTitle" placeholder="글 제목을 입력해주세요.">
							</dd>
						</dl>
							<dl>
								<textarea class="p-text-box" name="faqContent" id="faqContent" placeholder="내용을 입력해주세요."></textarea>
							</dl>
						</div>
					</form>
					<!--//상세-->
					
					<!--버튼-->
					<div class="p-btn-group">
						<button type="button" class="p-btn-default" id="btnList">목록</button>
						<button type="button" class="p-btn-modify" id="btnInsert">등록</button>
					</div>
					<!--//버튼-->
				</section>
				<!--//리스트-->
			</div>
			<!--// 컨텐츠-->
		</div>
	</div>

	  <script>
        	$(document).on('click', '#btnInsert', function (e) {
        		
        		if(document.getElementById("faqTitle").value == ""){
        			
        			alert("제목을 입력해주세요!");
        			return;
        		} else if(document.getElementById("faqContent").value == ""){
        			
        			alert("내용을 입력해주세요!");
        			return;
        		}
        		else{
        			
            e.preventDefault();
            $("#form").submit();
            
        		}
    			
      		  });

            $(document).on('click', '#btnList', function (e) {
                e.preventDefault();
                location.href = "${ pageContext.request.contextPath}/FaqAdmin/faqAdminList";
        		
            });
        </script>

	
        <jsp:include page="../common/footer.jsp"/>
</body>
</html>