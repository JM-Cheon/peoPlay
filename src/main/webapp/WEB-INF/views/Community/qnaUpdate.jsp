<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Q&A 글 수정</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/Community/board.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/common/reset.css">
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

</head>
<body>
	<div class="p-board-wrapper">
		<div class="p-board-container">
			<!--제목-->
			<div class="p-board-title">
				<h2>수정하기</h2>
			</div>
			<!--//제목-->
			
			<!--컨텐츠-->
			<div class="p-board-panel">
				<!--리스트-->
				<section class="p-right-write">
				<form action="${ pageContext.servletContext.contextPath }/QNA/updateWrite" id="form" name="form" method="post">
				 <input type="hidden" name="inquiryNo" value="${requestScope.update.inquiryNo }"> 
					<!--상세-->
					<div class="p-board-detail">
						<dl>
							<dt>제목</dt>
							<dd>
								<input type="text" class="p-input-box" name="inquiryTitles" id="inquiryTitles" placeholder="글 제목을 입력해주세요." value="${ requestScope.update.inquiryTitles }">
							</dd>
						</dl>
							<textarea id="summernote" name="inquiryContent">${ requestScope.update.inquiryContent }</textarea>
						<dl>
							<dt>공개 여부</dt>
							<dd id="">
								<div class="p-rd-group">
									<input 
							    		type="radio" 
							    		name="disclosureStatus" 
							    		id="post-open" 
							    		value="Y" ${ disclosureStatus eq 'Y'}
							    		class="p-rd-default" 
						    		/>
						    		<label for="post-open"><span></span>공개</label>
					    		</div>
					    		<div class="p-rd-group">
					    			<input 
					    				type="radio" 
					    				name="disclosureStatus" 
					    				id="post-none" 
					    				value="N" ${ disclosureStatus eq 'N'}
					    				class="p-rd-default" 
			    					/>
			    					<label for="post-none"><span></span>비공개</label>
					    		</div>
							</dd>
						</dl>
						</div>
					</form>
					<!--//상세-->
					
					<!--버튼-->
					<div class="p-btn-group">
						<button type="button" class="p-btn-default" id="btnList">목록</button>
						<button type="button" class="p-btn-modify" id="updateWrite">수정</button>
					</div>
					<!--//버튼-->
				</section>
				<!--//리스트-->
			</div>
			<!--// 컨텐츠-->
		</div>
	</div>
	 <script>
	 var admin = ${sessionScope.loginMember.userRole == 'ADMIN'};
	 
	 $(document).on('click', '#updateWrite', function (e) {
 		
		 if(document.getElementById("inquiryTitles").value == ""){
 			
 			alert("제목을 입력해주세요!");
 			return;
 		} else if(document.getElementById("summernote").value == ""){
 			
 			alert("내용을 입력해주세요!");
 			return;
 		} else if($(':radio[name="disclosureStatus"]:checked').length < 1){
 			
 			    alert('공개 여부를 선택해주세요.');                        
 			    postopen.focus();
 			    event.preventDefault();
 			
 			
 		}
 		else{
 			
     e.preventDefault();
     $("#form").submit();
     
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
        </script>
        <script>
   // onImageLinkInsert callback
      $('#summernote').summernote({
    	  	height: 300,                 // 에디터 높이
			minHeight: null,             // 최소 높이
			maxHeight: null,             // 최대 높이
			focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
			lang: "ko-KR",					// 한글 설정
			placeholder: '내용을 입력해주세요.',	//placeholder 설정
        callbacks: {
          onImageLinkInsert: function(url) {
            // url is the image url from the dialog
            $img = $('<img>').attr({ src: url })
            $summernote.summernote('insertNode', $img[0]);
          }
        }
      });

      // summernote.image.link.insert
      $('#summernote').on('summernote.image.link.insert', function(we, url) {
        // url is the image url from the dialog
        $img = $('<img>').attr({ src: url })
        $summernote.summernote('insertNode', $img[0]);
      });
      
				
    
	</script> 
</body>
</html>