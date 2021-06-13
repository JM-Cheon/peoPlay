<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css"><head>
<link rel="stylesheet" href="/peoplay/resources/css/goods/adminGoodsList.css"><head>
    <meta charset="UTF-8">
    <title>관리자 - 굿즈관리</title>
</head>

<body>
<jsp:include page="../../common/header.jsp"/>
<br><br><br><br>

    <section class="sec1">
       
<h2 class="head">굿즈 관리</h2>
	<div class="adminBtn"> 
		  <button id="admin" class="admin">입출고 내역</button>  
		  <button id="adminStock" class="adminStock">상품 문의 답변</button>  
		  <button id="adminPayment" class="adminPayment">결제관리</button> 
		  <button id="adminDelivery" class="adminDelivery">배송관리</button>
	 </div>
	<div>
	<form id="searchForm" action="${ pageContext.servletContext.contextPath }/admin/goods/search" method="post" class="searchingForm">
		<div class="search-area" align="center" style="position: relative; left: 300px;">
			<select id="searchCondition" name="searchCondition">
				<option value="famous">인기 높은 순 정렬</option>
				<option value="latest">최신순 정렬</option>
				<option value="price">높은 가격순 정렬</option>
			</select> <input type="search" id="searchValue" name="searchValue" style="position: relative;">
			<button  type="submit" class="searhchingBtn">검색하기</button>
		</div>
	</form>
 	</div>

</section>
<hr>
    <!--굿즈 아이템 들어가는 섹션-->
    <section id="sec2">
    	<div class="div_enroll">
		<button class="addNewGoods" type="button" onclick="enroll();"> + </button>
        </div>
        <c:forEach var="selectAllGoods"	items="${ requestScope.selectAllGoodslist }">
		<div class="div_pic">
			<button type="button" onclick="chooseGoods(${ selectAllGoods.goodsNum },'${selectAllGoods.goodsStatus }')">
				<img src="/peoplay/resources/images/goods/goodsImageFiles/${selectAllGoods.goodsFiles[0].fileSaveName}">
				<p>
					${selectAllGoods.goodsShortInfo }<br>
					 ${selectAllGoods.goodsPrice } 원
				</p>
			</button>
		</div>
		</c:forEach>
		
	</section>
	 <section style="text-align: center;">
	<div class="marvel2 on p-board-paging" align="center" >
					<ul>
					<c:choose>
						<c:when test="${ !empty requestScope.searchValue }">
							<li>
							<button id="searchStartPage"><<</button>
							</li>

							<c:if test="${ requestScope.pageInfo.pageNo == 1 }">
								<button disabled><i class="fas fa-angle-left"><!--이전--> < </i></button>
							</c:if>
							<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
							<li>
								<button id="searchPrevPage"><i class="fas fa-angle-left"><!--이전--> < </i></button>
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
								<button disabled><i class="fas fa-angle-right"><!--다음--> > </i></button>
								</li>
							</c:if>
							<c:if
								test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
								<li>
								<button id="searchNextPage"><i class="fas fa-angle-right"><!--다음--> > </i></button>
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
								<button disabled><i class="fas fa-angle-left"><!--이전-->  </i></button>
							</c:if>
							<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
							<li>
								<button id="prevPage"><i class="fas fa-angle-left"><!--이전--> < </i></button>
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
								<button disabled><i class="fas fa-angle-right"><!--다음--> > </i></button>
								<li>
							</c:if>
							<c:if
								test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
								<li>
								<button id="nextPage"><i class="fas fa-angle-right"><!--다음--> > </i></button>
								</li>
							</c:if>
							<li>
							<button id="maxPage">>></button>
							</li>
						</c:otherwise>
					</c:choose>
					</ul>
				</div>

   


        <br>
        <br>

    </section>
 <script type="text/javascript">
 
 /* 결제 관리 */
$('#adminPayment').on("click",function() {
	 
	 location.href = "${ pageContext.servletContext.contextPath }/admin/goods/Payment";
	 
 });
 
 /* 배송조회 */
$('#adminDelivery').on("click",function() {
	 
	 location.href = "${ pageContext.servletContext.contextPath }/admin/goods/Delivery";
	 
 });
 
 /* 상품 문의 답글 */
$('#adminStock').on("click",function() {
	 
	 location.href = "${ pageContext.servletContext.contextPath }/admin/goods/InquiryAnswer";
	 
 });
 
 /* 입출고 내역 */
$('#admin').on("click",function() {
	 
	 location.href = "${ pageContext.servletContext.contextPath }/admin/goods/Stock";
	 
 });
 
 const link = "${ pageContext.servletContext.contextPath }/admin/goods";
 const searchlink = "${ pageContext.servletContext.contextPath }/admin/goods/search";
 		
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
 
 
 function chooseGoods(val1, val2){
	 
		location.href = "${ pageContext.servletContext.contextPath }/admin/goods/" + parseInt(val1);

 }
 
 function enroll(){
	 
		location.href = "${ pageContext.servletContext.contextPath }/admin/goods/enroll";
 }
 </script>
 <jsp:include page="../../common/footer.jsp"/>
</body>
</html>