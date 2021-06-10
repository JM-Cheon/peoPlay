<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>공지사항 상세페이지</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/Community/board.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/common/reset.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/member.css">
</head>
<body>
<jsp:include page="../common/header.jsp"/>
   <div class="p-board-wrapper">
		<div class="p-board-container">
			<!--제목-->
			<div class="p-board-title">
				<h2>공지사항</h2>
			</div>
			<!--//제목-->
			
			<!--컨텐츠-->
			<div class="p-board-panel">
				<!--네비-->
				<aside class="p-left-snb">
					<ul>
						<li>
							<a href="${pageContext.servletContext.contextPath}/notice/ntclist" class="on">공지사항</a>
						</li>
						<li>
							<a href="${pageContext.servletContext.contextPath}/Faq/faqList">FAQ</a>
						</li>
						<li>
							<a href="${pageContext.servletContext.contextPath}/QNA/qnaList">Q&A</a>
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
							<dd>${ requestScope.ntcdetail.ntcTitle }</dd>
						</dl>
						<dl>
							<dt>작성일</dt>
							<dd>${ requestScope.ntcdetail.ntcDrawipDate }</dd>
							<dt>회원 이름</dt>
							<dd>${ requestScope.ntcdetail.writer.nickname }</dd>
							
						</dl>
						<section class="p-board-view">
							${ requestScope.ntcdetail.ntcContent }
						</section>
					</div>
					<!--//상세-->
					
					<!--버튼-->
					<div class="p-btn-group">
						<button type="button" class="p-btn-default" id="btnList">목록으로</button>
						<c:if test="${ sessionScope.loginMember.userRole eq 'ADMIN'}">
							<button type="button" class="p-btn-delete" id="delete">삭제</button>
							<button type="button" class="p-btn-modify" id="update" onclick="location.href='${ pageContext.servletContext.contextPath}/noticeAdmin/update/${ requestScope.ntcdetail.ntcNo }'">수정</button>
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
	 var admin = ${sessionScope.loginMember.userRole == 'ADMIN'};
	 
        	$(document).on('click','#delete',function (e) {
                        
            	var con = confirm("게시글을 삭제하시겠습니까?");
            		if(con){
            			alert("삭제되었습니다.");
            			location.href='${ pageContext.servletContext.contextPath}/noticeAdmin/delete/${ requestScope.ntcdetail.ntcNo }';
            		}else{
            			alert("취소 되었습니다..");
            		}
      		  });
            $(document).on('click', '#btnList', function (e) {
                e.preventDefault();
                
                if(admin){
                	
                    location.href = "${ pageContext.request.contextPath}/noticeAdmin/ntclist";
                    	
                    }else{
                    	
                    location.href = "${ pageContext.request.contextPath}/notice/ntclist";
                    }
            });
        </script>
        <jsp:include page="../common/footer.jsp"/>
</body>
</html>