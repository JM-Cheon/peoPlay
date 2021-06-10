<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>FAQ 목록</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/Community/board.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/common/reset.css">
<script src="${ pageContext.servletContext.contextPath }/resources/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script src="${ pageContext.servletContext.contextPath }/resources/js/board.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
	<div class="p-board-wrapper">
		<div class="p-board-container">
			<!--제목-->
			<div class="p-board-title">
				<h2>FAQ</h2>
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
							<a href="${pageContext.servletContext.contextPath}/Faq/faqList" class="on">FAQ</a>
						</li>
						<li>
							<a href="${pageContext.servletContext.contextPath}/QNA/qnaList">Q&A</a>
						</li>
					</ul>
				</aside>
				<!--//네비-->

				<!--리스트-->
				<section class="p-right-list">
					<!--FAQ-->
					<div class="p-board-faq">
						<!--샘플1-->
						  <c:forEach items="${ faqList }" var="FAQ">	
							<div class="p-faq-item">
								<p class="p-faq-question">
									<span><c:out value="${ FAQ.faqTitle }" /></span>
								</p>
								<p class="p-faq-answer">
									<span><c:out value="${ FAQ.faqContent }" /></span>
								</p>
							</div>
						  </c:forEach>
					</div>
					<!--//FAQ-->
				</section>
				<!--//리스트-->
			</div>
			<!--// 컨텐츠-->
		</div>
	</div>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>