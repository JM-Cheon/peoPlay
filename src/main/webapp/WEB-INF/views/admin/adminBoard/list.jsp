<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Peoplay : 자유게시판(관리자)</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/board/board.css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>


</head>
<body>
	<jsp:include page="../../common/header.jsp"/>
	<section>

		<div class="wrap-back">
			<div class="center">
				<div style="height: 300px;"></div>
				<div class="title">자유게시판(관리자 모드)</div>
				<div class="board" style="height: auto;">
					<table id="listArea">
						<thead class="board-head">
							<tr style="height: 70px; font-size: 25px; text-align: center;">
								<th style="width: 100px;">번호</th>
								<th style="width: 550px;">제목</th>
								<th style="width: 100px;">작성자</th>
								<th style="width: 150px;">날짜</th>
								<th style="width: 100px;">조회</th>
								<th style="width: 100px;">신고수</th>
								 
							</tr>
						</thead>
						<tbody>
						
							<c:choose> 
								<c:when test="${empty list }">
									<tr>
										<td colspan="5" align="center" style="color: white; font-size: 20px" >데이터가 없습니다.</td>
									</tr>
								</c:when>
								<c:when test="${!empty list}">
									<c:forEach items="${requestScope.list}" var="board">
								<c:if test="${sessionScope.loginMember.spoilerYN eq 'Y' }">
								
									 
									 <tr
											style="height: 60px; font-size: 17px; color: white; text-align: center; back">
											
											<td><c:out value="${board.no}" /></td>
											
											<td><c:out value="${board.category}"/> <c:out value="${board.title}" />
												
												<c:if test="${ board.commentCount ne 0 }">
												<c:out value="(${ board.commentCount })" />
												</c:if> 
												</td>
											<c:if test="${board.memberDTO.reportCumulative ge 3 }">
											<td style="color: red;"><c:out value="${board.memberDTO.nickname}" /></td>
											</c:if>
											
											<c:if test="${board.memberDTO.reportCumulative lt 3 }">
											<td><c:out value="${board.memberDTO.nickname}" /></td>
											</c:if>
											<td><c:out value="${board.creationDate}" /></td>
											<td><c:out value="${board.view}" /></td>
								 		 <c:if test="${board.reportCount ge 10 }">			
											<td style="color: red;"><c:out value="${board.reportCount }"/></td>
										    	</c:if>
										    	 <c:if test="${board.reportCount lt 10 }">			
											<td ><c:out value="${board.reportCount }"/></td>
										    	</c:if>
										</tr>
									
								</c:if>
										<c:if test='${sessionScope.loginMember.spoilerYN eq "N" && board.category ne"[스포주의]" }'>
									
										<tr
											style="height: 60px; font-size: 17px; color: white; text-align: center;">
											
											<td><c:out value="${board.no}" /></td>
											
											<td><c:out value="${board.category}"/> <c:out value="${board.title}" />
												
												<c:if test="${ board.commentCount ne 0 }">
												<c:out value="(${ board.commentCount })" />
												</c:if> 
												</td>
											
											<td><c:out value="${board.memberDTO.nickname}" /></td>
											<td><c:out value="${board.creationDate}" /></td>
											<td><c:out value="${board.view}" /></td>
										
										</tr>
								</c:if>
									</c:forEach>
								</c:when>
							</c:choose>
						</tbody>
					</table>
					<div style="height: 200px;">
						<div style="height: 60px;"></div>
						<div align="center" style="padding-top:10px; color: white">
									<button style="width: 40px; height:40px; border-style: solid; border-color: #585858; border-width: 1px; color: white;" id="searchStartPage"><<</button>

									<c:if test="${requestScope.pageInfo.pageNo == 1 }">
										<button style="width: 40px; height:40px; border-style: solid; border-color: #585858; border-width: 1px; color: white;" disabled><</button>
									</c:if>
									<c:if test="${requestScope.pageNo > 1 }">
										<button style="width: 40px; height:40px; border-style: solid; border-color: #585858; border-width: 1px; color: white;" id="searchPrevPage"><</button>

									</c:if>

									<c:forEach var="p" begin="${requestScope.pageInfo.startPage }"
										end="${requestScope.pageInfo.endPage }" step="1">
										<c:if test="${requestScope.pageInfo.pageNo eq p }">
											<button style="width: 40px; height:40px; border-style: solid; border-color: #585858; border-width: 1px; color: white;"  disabled>
												<c:out value="${p }" />
											</button>
										</c:if>
										<c:if test="${requestScope.pageInfo.pageNo ne p }">

											<button style="width: 40px; height:40px; border-style: solid; border-color: #585858; border-width: 1px; color: white;" onclick="pageButtonAction(this.innerText);">
												<c:out value="${p }" />
											</button>
										</c:if>

									</c:forEach>

									<c:if
										test="${requestScope.pageInfo.pageNo == requestScope.pageInfo.maxPage }">
										<button style="width: 40px; height:40px; border-style: solid; border-color: #585858; border-width: 1px; color: white;" disabled>></button>
									</c:if>
									<c:if
										test="${requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
										<button style="width: 40px; height:40px; border-style: solid; border-color: #585858; border-width: 1px; color: white;" id="searchNextPage">></button>

									</c:if>

									<button style="width: 40px; height:40px; border-style: solid; border-color: #585858; border-width: 1px; color: white;" id="searchMaxPage">>></button>

								</div>
						<div style="height: 40px;"></div>
						<div style="height: 40px;">
						<form action="${ pageContext.servletContext.contextPath }/board/search" method="get">
							<table style="margin: auto;">
								<tr style="height: 40px;">
									<td class="select"><select name="searchCondition" style="width: 150px; font-size: 20px; height: 50px; text-align: center; background: #585858; color: white; text-align-last: center; ">
											<option value="title"
											<c:if test="${requestScope.searchCondition eq 'title' }">selected </c:if>> 제목</option>
											<option value="writer"
											<c:if test="${requestScope.searchCondition eq 'writer' }">selected</c:if>>작성자</option>
											<option value="content"
											<c:if test="${requestScope.searchCondition eq 'content' }">selected</c:if>>내용</option>
									</select></td>
									<td style="width: 10px;"></td>
									<td class="td-search"><input type="text" placeholder="검색어를 입력하세요" class="td-search-input" name="searchValue" value="${requestScope.searchValue}"></td>
									<td style="width: 10px;"></td>
									<td style="width: 110px;"><button type="submit" class="btn-search" >검색</button></td>
									<td style="width: 10px;"></td>
									<td style="width: 110px;">
										<button class="btn-write" type="button" onclick="location.href='${pageContext.servletContext.contextPath}/board/write'">작성하기</button>
									</td>
								</tr>
							</table>
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp"/>

<script>
		const link = "${pageContext.servletContext.contextPath}/board/list"
		const searchLink = "${ pageContext.servletContext.contextPath }/board/search";

		/* 페이지 번호 클릭시 실행되는 함수 */
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
		
	
		
	</script>



<script type="text/javascript">
$(function(){
	$("#listArea td").hover(function(){
		$(this).parent().css({"background" : "#4F4F4F", "cursor":"pointer"});
	},function(){
		$(this).parent().css("background", "#2C2C2C");
	}).click(function(){
		const no = $(this).parent().children(":eq(0)").text();
		location.href = "${ pageContext.servletContext.contextPath }/admin/adminBoard/detail?no=" + no;
	})
})

</script>

</body>
</html>