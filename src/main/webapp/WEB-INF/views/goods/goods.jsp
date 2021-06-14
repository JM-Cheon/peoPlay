<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/goods/goodsMain.css">
</head>

<style>

</style>
<body>

		<jsp:include page="../common/header.jsp"/>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div id="wrapper">

		<div class="everyday_div everyday_div2">
			<button class="button">
				<p class="everyday_text">MARVEL</p>
			</button>
			<button class="button">
				<p class="everyday_text">DC</p>
			</button>
			<button class="button">
				<p class="everyday_text">GHIBRI</p>
			</button>
			<button class="button">
				<p class="everyday_text">PIXAR</p>
			</button>
			<button class="button">
				<p class="everyday_text">WB</p>
			</button>
		</div>

		<section id="popularGoods">
			<div class="popular">
				<p class="popular_word">인기 상품</p>
			</div>
			<div class="space"></div>
			<div class="everyday_contents">
				<div class="marvel on">
					<c:forEach var="marvelpopularList"	items="${ requestScope.marvelpopularList }">
						<div class="div_pic">
							<button type="button"
								onclick="buyGoods(${ marvelpopularList.goodsNum },'${marvelpopularList.goodsStatus }')">
								<img src="/peoplay/resources/images/goods/goodsImageFiles/${ marvelpopularList.goodsFiles[0].fileSaveName }">
								<p>
									${marvelpopularList.goodsShortInfo }<br>
									${marvelpopularList.goodsPrice } 원
								</p>
							</button>
						</div>
					</c:forEach>
				</div>
				<div class="dc">
					<c:forEach var="dcpopularList"
						items="${ requestScope.dcpopularList }">
						<div class="div_pic">
							<button type="button"
								onclick="buyGoods(${ dcpopularList.goodsNum },'${dcpopularList.goodsStatus }')">
								<img src="/peoplay/resources/images/goods/goodsImageFiles/${ dcpopularList.goodsFiles[0].fileSaveName }">
								<p>
									${dcpopularList.goodsShortInfo }<br>
									${dcpopularList.goodsPrice } 원
								</p>
							</button>
						</div>
					</c:forEach>
				</div>
				<div class="ghibri">
					<c:forEach var="ghibripopularList"
						items="${ requestScope.ghibripopularList }">
						<div class="div_pic">
							<button type="button"
								onclick="buyGoods(${ ghibripopularList.goodsNum },'${ghibripopularList.goodsStatus }')">
								<img src="/peoplay/resources/images/goods/goodsImageFiles/${ ghibripopularList.goodsFiles[0].fileSaveName }">
								<p>
									${ghibripopularList.goodsShortInfo }<br>
									${ghibripopularList.goodsPrice } 원
								</p>
							</button>
						</div>
					</c:forEach>
				</div>
				<div class="pixar">
					<c:forEach var="pixarpopularList"
						items="${ requestScope.pixarpopularList }">
						<div class="div_pic">
							<button type="button"
								onclick="buyGoods(${ pixarpopularList.goodsNum },'${pixarpopularList.goodsStatus }')">
								<img src="/peoplay/resources/images/goods/goodsImageFiles/${ pixarpopularList.goodsFiles[0].fileSaveName }">
								<p>
									${pixarpopularList.goodsShortInfo }<br>
									${pixarpopularList.goodsPrice } 원
								</p>
							</button>
						</div>
					</c:forEach>
				</div>
				<div class="wb">
					<c:forEach var="wbpopularList"
						items="${ requestScope.wbpopularList }">
						<div class="div_pic">
							<button type="button"
								onclick="buyGoods(${ wbpopularList.goodsNum },'${wbpopularList.goodsStatus }')">
								<img src="/peoplay/resources/images/goods/goodsImageFiles/${ wbpopularList.goodsFiles[0].fileSaveName }">
								<p>
									${wbpopularList.goodsShortInfo }<br>
									${wbpopularList.goodsPrice } 원
								</p>
							</button>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>

		<section id="newGoods">
			<div class="newGoods">
				<p class="newGoods_word">GOODS</p>
			</div>
			<div class="search">
				<!-- 검색하기  -->
				<form id="searchForm"
					action="${ pageContext.servletContext.contextPath }/goods/search"
					method="get">
					<div class="search-area" align="center" style="position: relative; left: 300px;">
						<select id="searchCondition" name="searchCondition" style="position: relative; left: 22px;">
							<option value="searchAll">이름 검색</option>
							<option value="latest">최신순</option>
							<option value="famous">높은 인기순</option>
							<option value="price">높은 가격순</option>
						</select> <input type="search" id="searchValue" name="searchValue" style="left : 28px; border: 0.5px solid; position: relative;">
						<button type="submit" style="position: relative; left: 34px;" class="searhchingBtn">검색하기</button>
					</div>
				</form>
			</div>
			 <div class="newgoods_contents">
				<div class="marvel2 on">
					<c:forEach var="selectAllGoods"
						items="${ requestScope.selectAllGoods }">
						<c:if
							test="${ selectAllGoods.goodsCategoryNum.goodsCategoryNum eq '1' }">
							<div class="div_pic">
								<button type="button"
									onclick="buyGoods(${ selectAllGoods.goodsNum },'${selectAllGoods.goodsStatus }')">
									<img src="/peoplay/resources/images/goods/goodsImageFiles/${ selectAllGoods.goodsFiles[0].fileSaveName }">
									<p>
										${selectAllGoods.goodsShortInfo }<br>
										${selectAllGoods.goodsPrice } 원
									</p>
								</button>
							</div>
						</c:if>
					</c:forEach>
					<section class="marvel2 on p-board-paging" align="center" style="width: 350px; position: relative; bottom: -14px;left: 394px;">
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
				</section>
				</div>
				
				
				<div class="dc2">
					<c:forEach var="selectdcGoods" items="${ requestScope.selectdcGoods }">
						<c:if test="${ selectdcGoods.goodsCategoryNum.goodsCategoryNum eq '2' }">
							<div class="div_pic">
								<button type="button"
									onclick="buyGoods(${ selectdcGoods.goodsNum },'${selectdcGoods.goodsStatus }')">
									<img src="/peoplay/resources/images/goods/goodsImageFiles/${ selectdcGoods.goodsFiles[0].fileSaveName }">
									<p>
										${selectdcGoods.goodsShortInfo }<br>
										${selectdcGoods.goodsPrice } 원
									</p>
								</button>
							</div>
						</c:if>
					</c:forEach>
				</div>
				<div class="ghibri2">
					<c:forEach var="selectghibriGoods"
						items="${ requestScope.selectghibriGoods }">
						<c:if
							test="${ selectghibriGoods.goodsCategoryNum.goodsCategoryNum eq '3' }">
							<div class="div_pic">
								<button type="button"
									onclick="buyGoods(${ selectghibriGoods.goodsNum },'${selectghibriGoods.goodsStatus }')">
									<img src="/peoplay/resources/images/goods/goodsImageFiles/${ selectghibriGoods.goodsFiles[0].fileSaveName }">
									<p>
										${selectghibriGoods.goodsShortInfo }<br>
										${selectghibriGoods.goodsPrice } 원
									</p>
								</button>
							</div>
						</c:if>
					</c:forEach>
				</div>
				
				<div class="pixar2">
					<c:forEach var="selectpixarGoods"
						items="${ requestScope.selectpixarGoods }">
						<c:if
							test="${ selectpixarGoods.goodsCategoryNum.goodsCategoryNum eq '4' }">
							<div class="div_pic">
								<button type="button"
									onclick="buyGoods(${ selectpixarGoods.goodsNum },'${selectpixarGoods.goodsStatus }')">
									<img src="/peoplay/resources/images/goods/goodsImageFiles/${ selectpixarGoods.goodsFiles[0].fileSaveName }">
									<p>
										${selectpixarGoods.goodsShortInfo }<br>
										${selectpixarGoods.goodsPrice } 원
									</p>
								</button>
							</div>
						</c:if>
					</c:forEach>
				</div>
				<div class="wb2">
					<c:forEach var="selectwbGoods"
						items="${ requestScope.selectwbGoods }">
						<c:if
							test="${ selectwbGoods.goodsCategoryNum.goodsCategoryNum eq '5' }">
							<div class="div_pic">
								<button type="button"
									onclick="buyGoods(${ selectwbGoods.goodsNum },'${selectwbGoods.goodsStatus }')">
									<img src="/peoplay/resources/images/goods/goodsImageFiles/${ selectwbGoods.goodsFiles[0].fileSaveName }">
									<p>
										${selectwbGoods.goodsShortInfo }<br>
										${selectwbGoods.goodsPrice } 원
									</p>
								</button>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</section>
	</div> 

	<script>
		/* 상품을 눌렀을 때 */
		function buyGoods(val1, val2) {
			var goodsNum = val1;
			var goodsStatus = val2;

			/* 선택한 상품이 조회된 경우 */
			if (goodsStatus == 'Y') {

				location.href = "${ pageContext.servletContext.contextPath }/goods/"
						+ parseInt(goodsNum);

				/* 선택한 상품이 조회되지 않는경우 */
			} else if (goodsStatus == 'N') {
				alert("해당 상품은 현재 준비 중에 있습니다.");

			}

		}
		
		
		
		$(document).ready(function() {
			$(".everyday_div > .button > p").click(function() {
				var idx = $(".everyday_div > .button > p").index($(this));
				$(".everyday_div > .button > p").removeClass("on");
				$(".everyday_div > .button > p").eq(idx).addClass("on");
				$(".everyday_contents > div").hide();
				$(".everyday_contents > div").eq(idx).show();
				$(".newgoods_contents > div").hide();
				$(".newgoods_contents > div").eq(idx).show();
			});
		});
		
		
		
const link = "${ pageContext.servletContext.contextPath }/goods/goodslist";
const searchlink = "${ pageContext.servletContext.contextPath }/goods/search";
		
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


		
	</script>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>