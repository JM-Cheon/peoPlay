<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ 관리자 목록</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/Community/board.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/common/reset.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../common/header.jsp"/>
	
	<div class="p-board-wrapper">
		<div class="p-board-container">
		<!-- 관리자 탭 -->
		<jsp:include page="../admin/common/adminMenu.jsp"/>
			<br><br><br><br><br>
			<!--제목-->
			<div class="p-board-title">
				<h2>FAQ 관리자</h2>
			</div>
			<!--//제목-->
			
			<!--컨텐츠-->
			<div class="p-board-panel">
		
				<!--리스트-->
				<section class="p-center-list">
					<!--테이블-->
					<table class="p-board-table">
						<colgroup>
							<col width="80px" /><!--번호-->
							<col width="*" /><!--글제목-->
							<col width="120px" /><!--날짜-->
						</colgroup>
						<thead>
							<tr>
								<th>번호</th>
								<th>글제목</th>
								<th>날짜</th>
							</tr>
						</thead>
							<tbody>
								<c:forEach items="${ faqAdminList }" var="FAQ">
									<tr>
										<td><c:out value="${ FAQ.faqNo }" /></td>
										<td><c:out value="${ FAQ.faqTitle }" /></td>
										<td><c:out value="${ FAQ.faqDrawupDate }" /></td>
									</tr>
								</c:forEach>
								<c:forEach items="${ searchList }" var="FAQ">
									<tr>
										<td><c:out value="${ FAQ.faqNo }" /></td>
										<td><c:out value="${ FAQ.faqTitle }" /></td>
										<td><c:out value="${ FAQ.faqDrawupDate }" /></td>
									</tr>
								</c:forEach> 
						</tbody>
					</table>
					<!--//테이블-->

					 <!-- 페이지 처리 --> 
								<div class="p-board-paging" align="center"
									style="padding-top: 10px;">
									<ul>
									<c:choose>
										<c:when test="${ !empty requestScope.searchValue }">
											<li>
											<button id="searchStartPage"><<</button>
											</li>

											<c:if test="${ requestScope.pageInfo.pageNo == 1 }">
												<button disabled><i class="fas fa-angle-left"><!--이전--></i></button>
											</c:if>
											<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
											<li>
												<button id="searchPrevPage"><i class="fas fa-angle-left"><!--이전--></i></button>
												</li>
											</c:if>

											<c:forEach var="p"
												begin="${ requestScope.pageInfo.startPage }"
												end="${ requestScope.pageInfo.endPage }" step="1">
												<c:if test="${ requestScope.pageInfo.pageNo eq p }">
												<li>
													<button disabled>
														<c:out value="${ p }" />
													</button>
													</li>
												</c:if>
												<c:if test="${ requestScope.pageInfo.pageNo ne p }">
												<li>
													<button onclick="searchPageButtonAction(this.innerText);">
														<c:out value="${ p }" />
													</button>
													</li>
												</c:if>
											</c:forEach>

											<c:if
												test="${ requestScope.pageInfo.pageNo == requestScope.pageInfo.maxPage }">
												<li>
												<button disabled><i class="fas fa-angle-right"><!--다음--></i></button>
												</li>
											</c:if>
											<c:if
												test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
												<li>
												<button id="searchNextPage"><i class="fas fa-angle-right"><!--다음--></i></button>
												</li>
											</c:if>
											<li>
											<button id="searchMaxPage">>></button>
											<li>
										</c:when>
										
										<c:otherwise>
											<li>
											<button id="startPage"><<</button>
											</li>
											<c:if test="${ requestScope.pageInfo.pageNo == 1 }">
												<button disabled><i class="fas fa-angle-left"><!--이전--></i><</button>
											</c:if>
											<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
											<li>
												<button id="prevPage"><i class="fas fa-angle-left"><!--이전--></i><</button>
												</li>
											</c:if>

											<c:forEach var="p"
												begin="${ requestScope.pageInfo.startPage }"
												end="${ requestScope.pageInfo.endPage }" step="1">
												<c:if test="${ requestScope.pageInfo.pageNo eq p }">
												<li>
													<button disabled>
														<c:out value="${ p }" />
													</button>
												</li>	
												</c:if>
												<c:if test="${ requestScope.pageInfo.pageNo ne p }">
												<li>
													<button onclick="pageButtonAction(this.innerText);">
														<c:out value="${ p }" />
													</button>
												</li>
												</c:if>
											</c:forEach>

											<c:if
												test="${ requestScope.pageInfo.pageNo == requestScope.pageInfo.maxPage }">
												<li>
												<button disabled><i class="fas fa-angle-right"><!--다음--></i>></button>
												<li>
											</c:if>
											<c:if
												test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
												<li>
												<button id="nextPage"><i class="fas fa-angle-right"><!--다음--></i>></button>
												</li>
											</c:if>
											<li>
											<button id="maxPage">>></button>
											</li>
										</c:otherwise>
									</c:choose>
									</ul>
								</div>
								<!-- 페이징 처리 끝 -->
					
					<!--검색-->
					<form id="searchForm"  action="${ pageContext.servletContext.contextPath }/FaqAdmin/search"
						method="get" style="padding-top: 20px">
						<div class="p-board-search">
							<c:choose>
								<c:when test="${ !empty requestScope.searchValue }">
								<div class="p-board-category">
									 <select id="searchCondition" name="searchCondition">	
										<option value="faqTitle"
											<c:if test="${requestScope.searchCondition eq 'faqTitle' }">selected</c:if>>제목</option>
										<option value="faqContent"
											<c:if test="${requestScope.searchCondition eq 'faqContent' }">selected</c:if>>내용</option>
									</select> 
									</div>		
										<div class="p-board-keyword">
											<input type="search" id="searchValue" name="searchValue" value="${requestScope.searchValue}">
											<button type="submit"><i class="fas fa-search"><!--검색--></i></button>
										 </div>	
								</c:when>
									<c:otherwise>
										<div class="p-board-category">
											<select id="searchCondition" name="searchCondition">
												<option value="faqTitle">제목</option>
												<option value="faqContent">내용</option>
											</select>
										</div>		
									<div class="p-board-keyword">
										<input type="search" id="searchValue" name="searchValue" placeholder="검색어를 입력해주세요.">
											<button type="submit"><i class="fas fa-search"><!--검색--></i></button>
									</div>	
								</c:otherwise>
							 </c:choose>
								<div class="p-board-write">
									<button type="button" id="faqAdminListWrite">글 작성</button>
								</div>
						 </div>
					 </form>
					<!--//검색-->
				</section>
				<!--//리스트-->
			</div>
			<!--// 컨텐츠-->
		</div>
	</div>
	
<script>
	
const link = "${ pageContext.servletContext.contextPath }/FaqAdmin/faqAdminList";
const searchLink = "${ pageContext.servletContext.contextPath }/FaqAdmin/search";

		/* 원하는 페이지 클릭시 실행되는 콜백 함수 */
		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text;
		}
		
		function searchPageButtonAction(text) {
			location.href = searchLink + "?currentPage=" + text + "&searchCondition=${requestScope.searchCondition}&searchValue=${requestScope.searchValue}";
		}
		
		if(document.getElementById("searchStartPage")){
			const $searchStartPage = document.getElementById("searchStartPage");
			$searchStartPage.onclick = function(){
				location.href = searchLink + "?currentPage=1&searchCondition=${requestScope.searchCondition}&searchValue=${requestScope.searchValue}";
			}
		}
		
		if(document.getElementById("searchMaxPage")){
			const $searchMaxPage = document.getElementById("searchMaxPage");
			$searchMaxPage.onclick = function(){
				location.href = searchLink + "?currentPage=${ requestScope.pageInfo.maxPage }&searchCondition=${requestScope.searchCondition}&searchValue=${requestScope.searchValue}";
			}
		}
		
		if(document.getElementById("searchPrevPage")){
			const $searchPrevPage = document.getElementById("searchPrevPage");
			$searchPrevPage.onclick = function(){
				location.href = searchLink + "?currentPage=${ requestScope.pageInfo.pageNo - 1 }&searchCondition=${requestScope.searchCondition}&searchValue=${requestScope.searchValue}";
			}
		}
		
		if(document.getElementById("searchNextPage")){
			const $searchNextPage = document.getElementById("searchNextPage");
			$searchNextPage.onclick = function(){
				location.href = searchLink + "?currentPage=${ requestScope.pageInfo.pageNo + 1 }&searchCondition=${requestScope.searchCondition}&searchValue=${requestScope.searchValue}";
			}
		}
		
		if(document.getElementById("startPage")){
			const $startPage = document.getElementById("startPage");
			$startPage.onclick = function(){
				location.href = link + "?currentPage=1";
			}
		}
		
		if(document.getElementById("maxPage")){
			const $maxPage = document.getElementById("maxPage");
			$maxPage.onclick = function(){
				location.href = link + "?currentPage=${ requestScope.pageInfo.maxPage }";
			}
		}
		
		if(document.getElementById("prevPage")){
			const $prevPage = document.getElementById("prevPage");
			$prevPage.onclick = function(){
				location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo - 1 }";
			}
		}
		
		if(document.getElementById("nextPage")){
			const $nextPage = document.getElementById("nextPage");
			$nextPage.onclick = function(){
				location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo + 1 }";
			}
		}
		
		
		if(document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");
			for(var i = 0 ; i < $tds.length ; i++) {
				$tds[i].onclick = function() {
					const faqNo = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/FaqAdmin/faqDetail/" + parseInt(faqNo);   
				}
			}
		}
		
		if(document.getElementById("faqAdminListWrite")){
			const $faqAdminListWrite = document.getElementById("faqAdminListWrite");
			$faqAdminListWrite.onclick = function(){
				location.href = "${ pageContext.servletContext.contextPath }/FaqAdmin/insert";
			}
		}
	
</script>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>