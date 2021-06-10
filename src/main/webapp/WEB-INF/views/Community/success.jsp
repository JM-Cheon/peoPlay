<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		(function(){
			const successCode = "${ requestScope.successCode }";
			
			var successMessage = "";
			var movePath = "";
			
			switch(successCode){
			
					// Notice 성공 처리
				case "search" :
					successMessage = "게시글이 없습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/notice/ntclist";
					break;
				case "search" :
					successMessage = "게시글이 없습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/noticeAdmin/ntclist";
					break;
				case "ntcInsertWrite" :
					successMessage = "게시글 작성에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/noticeAdmin/ntclist";
					break;
				case "ntcUpdate" :
					successMessage = "게시글 수정에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/noticeAdmin/ntclist";
					break;
				
					// Notice 실패 처리
				case "ntcInsertFailure" :
					successMessage = "게시글 작성에 실패하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/noticeAdmin/ntclist";
					break;
				case "ntcUpdateFailure" :
					successMessage = "게시글 수정에 실패하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/noticeAdmin/ntclist";
					break;
					
					
					// Q&A 성공 처리
				case "qnaSearch" :
					successMessage = "게시글이 없습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/QNA/qnaList";
					break;
				case "qnaInsertWrite" :
					successMessage = "게시글 작성에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/QNA/qnaList";
					break;
				case "qnaUpdateWrite" :
					successMessage = "게시글 수정에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/QNA/qnaList";
					break;
				case "commentUpdateResult" :
					successMessage = "답변 수정에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/QNA/qnaList";
					break;
					
					// Q&A 실패 처리
				case "qnaInsertFailure" :
					successMessage = "게시글 작성에 실패하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/QNA/qnaList";
					break;
				case "qnaUpdateFailure" :
					successMessage = "게시글 수정에 실패하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/QNA/qnaList";
					break;
					
					// Q&A 관리자
				case "commentUpdateFailure" :
					successMessage = "답변 수정에 실패하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/QNAadmin/qnaList";
					break;
					
					
		
					
					//FAQ 성공 처리
				case "FaqAdminSearch" :
					successMessage = "게시글이 없습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/FaqAdmin/faqAdminList";
					break;
				case "faqInsertWrite" :
					successMessage = "게시글 작성에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/FaqAdmin/faqAdminList";
					break;
				case "faqUpdateWrite" :
					successMessage = "게시글 수정에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/FaqAdmin/faqAdminList";
					break;
					
					//FAQ 실패 처리
				case "faqInsertFailure" :
					successMessage = "게시글 작성에 실패하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/FaqAdmin/faqAdminList";
					break;
				case "faqUpdateFailure" :
					successMessage = "게시글 수정에 실패하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/FaqAdmin/faqAdminList";
					break;
					
			}
			
			alert(successMessage);
			
			location.replace(movePath);
		})();
	</script>
	
</body>
</html>