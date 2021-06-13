<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Q&A 목록</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/Community/board.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/common/reset.css">
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
					<!--테이블-->
					<table class="p-board-table">
						<colgroup>
							<col width="80px" /><!--번호-->
							<col width="*" /><!--글제목-->
							<col width="120px" /><!--작성자-->
							<col width="120px" /><!--날짜-->
							<col width="100px" /><!--조회-->
						</colgroup>
						<thead>
							<tr>
								<th>번호</th>
								<th>글제목</th>
								<th>작성자</th>
								<th>날짜</th>
								<th>공개 여부</th>
							</tr>
						</thead>
							<tbody>
							<c:forEach items="${ list }" var="QNA">
									<tr>
										<td><c:out value="${ QNA.inquiryNo }" /></td>
										<td> <c:if test="${QNA.disclosureStatus eq 'N'}" >
							            <c:choose>
							                <c:when test="${ sessionScope.loginMember.userRole eq 'ADMIN' || sessionScope.loginMember.nickname eq QNA.writer.nickname }">
							                    <c:out value="${QNA.inquiryTitles}"/>
							                </c:when>
							                <c:otherwise>비밀글은 작성자와 관리자만 볼 수 있습니다.</c:otherwise>
							            </c:choose>
							        </c:if>
							        <c:if test="${QNA.disclosureStatus eq 'Y'}" >
							            <c:out value="${QNA.inquiryTitles}"/>
							        </c:if>
							        </td>
										<td><c:out value="${ QNA.writer.nickname }" /></td>
										<td><c:out value="${ QNA.creationDate }" /></td>
										<td><c:if test="${QNA.disclosureStatus eq 'N'}" >
							            <c:choose>
							                <c:when test="${QNA.writer.userRole eq 'ADMIN' }">
							                   <c:out value="${ QNA.disclosureStatus }" />
							                </c:when>
							                <c:otherwise>비공개</c:otherwise>
							            </c:choose>
							        </c:if>
							        <c:if test="${QNA.disclosureStatus eq 'Y'}" >공개</c:if></td>
									</tr>
								</c:forEach>
								
								
								<c:forEach items="${ searchList }" var="QNA">
										<tr>
										<td><c:out value="${ QNA.inquiryNo }" /></td>
										<td> <c:if test="${QNA.disclosureStatus eq 'N'}" >
							            <c:choose>
							                <c:when test="${ sessionScope.loginMember.userRole eq 'ADMIN' || sessionScope.loginMember.nickname eq QNA.writer.nickname }">
							                    <c:out value="${QNA.inquiryTitles}"/>
							                </c:when>
							                <c:otherwise>비밀글은 작성자와 관리자만 볼 수 있습니다.</c:otherwise>
							            </c:choose>
							        </c:if>
							        <c:if test="${QNA.disclosureStatus eq 'Y'}" >
							            <c:out value="${QNA.inquiryTitles}"/>
							        </c:if>
							        </td>
										<td><c:out value="${ QNA.writer.nickname }" /></td>
										<td><c:out value="${ QNA.creationDate }" /></td>
										<td><c:if test="${QNA.disclosureStatus eq 'N'}" >
							            <c:choose>
							                <c:when test="${QNA.writer.userRole eq 'ADMIN' }">
							                   <c:out value="${ QNA.disclosureStatus }" />
							                </c:when>
							                <c:otherwise>비공개</c:otherwise>
							            </c:choose>
							        </c:if>
							        <c:if test="${QNA.disclosureStatus eq 'Y'}" >공개</c:if></td>
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
												<button disabled><i class="fas fa-angle-left"><!--이전--></i>></button>
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
					<form id="searchForm"  action="${ pageContext.servletContext.contextPath }/QNA/search"
						method="get" style="padding-top: 20px">
						<div class="p-board-search">
							<c:choose>
								<c:when test="${ !empty requestScope.searchValue }">
								<div class="p-board-category">
									 <select id="searchCondition" name="searchCondition">
										<option value="writer"
											<c:if test="${requestScope.searchCondition eq 'writer' }">selected</c:if>>작성자</option>
										<option value="inquiryTitles"
											<c:if test="${requestScope.searchCondition eq 'inquiryTitles' }">selected</c:if>>제목</option>
										<option value="inquiryContent"
											<c:if test="${requestScope.searchCondition eq 'inquiryContent' }">selected</c:if>>내용</option>
									</select> 
									</div>		
										<div class="p-board-keyword">
											<input type="search" id="searchValue" name="searchValue" value="${requestScope.searchValue}">
											<button type="submit"><i class="fas fa-search"><!--검색--></i>검색</button>
										 </div>	
								</c:when>
									<c:otherwise>
										<div class="p-board-category">
											<select id="searchCondition" name="searchCondition">
												<option value="writer">작성자</option>
												<option value="inquiryTitles">제목</option>
												<option value="inquiryContent">내용</option>
											</select>
										</div>		
									<div class="p-board-keyword">
										<input type="search" id="searchValue" name="searchValue" placeholder="검색어를 입력해주세요.">
											<button type="submit"><i class="fas fa-search"><!--검색--></i>검색</button>
									</div>	
								</c:otherwise>
							 </c:choose>
								<div class="p-board-write">
									<button type="button" id="FaqWrite">글 작성</button>
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
	
const link = "${ pageContext.servletContext.contextPath }/QNA/qnaList";
const searchLink = "${ pageContext.servletContext.contextPath }/QNA/search";

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
					var nick = this.parentNode.children[2].innerText;
					var yn = this.parentNode.children[4].innerText;
					var am = ${ sessionScope.loginMember.userRole == 'ADMIN'};
					if(yn == "비공개"){						
						if(nick == "${ sessionScope.loginMember.nickname }" || am){
							const inquiryNo = this.parentNode.children[0].innerText;
							location.href = "${ pageContext.servletContext.contextPath }/QNA/qnaDetail/" + parseInt(inquiryNo);   
						} else {
							alert("비공개 글은 작성자만 확인할 수 있습니다.");
						}
					} else {
						const inquiryNo = this.parentNode.children[0].innerText;
						location.href = "${ pageContext.servletContext.contextPath }/QNA/qnaDetail/" + parseInt(inquiryNo);   
					}
				}
			}
		}
		
		
		if(document.getElementById("FaqWrite")){
			const $FaqWrite = document.getElementById("FaqWrite");
			$FaqWrite.onclick = function(){
				location.href = "${ pageContext.servletContext.contextPath }/QNA/insert";
			}
		}
	
</script>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>