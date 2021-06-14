<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/goods/stock.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>

<body>
<jsp:include page="../../common/header.jsp"/>
    <br><br><br><br><br><br>
    <div id="wrapper">
        <div class="headerPayment">
                 입출고 내역 관리 
        </div>
         <div class="searchingDiv">
            <form id="searchForm" action="${ pageContext.servletContext.contextPath }/admin/goods/StockSearch" method="post" class="searchingForm move">
                <div class="search-area" align="center" style="position: relative; left: 337px;">
                    <select id="searchCondition" name="searchCondition">
                        <option value="in">입고</option>
                        <option value="out">출고 </option>
                        <option value="date">날짜별</option>
                        <option value="goodsName">상품명</option>
                    </select> <input style="border: 1px solid" type="search" id="searchValue" name="searchValue" style="position: relative;">
                    <button  type="submit" class="searhchingBtn">검색하기</button>
                </div>
            </form>
            <button  type="button" class="searhchingBtn back" id="gobackAdmin">뒤로가기</button>
           </div>
        <div class="ListDiv">
            <table class="tab_list">
                <tr>
                    <td class="goodsNo thead">
                    	입출고 번호
                    </td>
                    <td class="goodsName thead">
                                                     상품 이름
                    </td>
                    <td class="goodsPrice thead">
                                                     입출고 수량
                    </td>
                    <td class="orderQuantities thead">
                                                       입출고 구분
                    </td>
                    <td class="totalPrice thead">
                                                  입출고 날짜
                    </td>
                </tr>
               
          <c:forEach var="selectGoodsList" items="${requestScope.selectGoodsList }">
                <tr>
                    <td class="goodsNo">
                       <c:out value=" ${selectGoodsList.inAndOutCode}"></c:out>  
                    </td>
                    <td class="goodsName">
                       <c:out value=" ${selectGoodsList.goodsNum.goodsName}"></c:out>  
                    </td>
                    <td class="goodsPrice">
                       <c:out value=" ${selectGoodsList.goodsCount}"></c:out>   
                    </td>
                    <td class="orderQuantities">
                       <c:out value=" ${selectGoodsList.inAndOutStatus}"></c:out>   
                    </td>
                    <td class="totalPrice">
						<c:out value=" ${selectGoodsList.goodsInOutDate}"></c:out>   
                    </td>
                </tr>
          </c:forEach>        
            </table>
        </div>
		<div class="p-board-paging" align="center">
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
		</div>
        <jsp:include page="../../common/footer.jsp"/>

<script>
$('.AjaxdeliveryStatus').change(function() {
	
	/* var deliveryNum = this.parentsNode.parentNode;  */
	const deliveryNum = $(this).parents("tr").find('td').eq(0).find('input').val();
	const status = this.value;
	
	$.ajax({
		
		url : "deliveryStatus",
		method : "POST",
		data : 
			{
			status : parseInt(status),
			deliveryNum : parseInt(deliveryNum)
			},
	    success : function(data){
	    	
	    },
		
	    error : function(error){
	    	
	    }
		
	});
	
});



const link = "${ pageContext.servletContext.contextPath }/admin/goods/Stock";
const searchlink = "${ pageContext.servletContext.contextPath }/admin/goods/StockSearch";
		
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
</body>
</html>