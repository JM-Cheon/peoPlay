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
<link rel="stylesheet" href="/peoplay/resources/css/goods/goodsMain.css">
<link rel="stylesheet" href="/peoplay/resources/css/goods/payment.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>

<body>
<jsp:include page="../../common/header.jsp"/>
    <br><br><br><br><br><br>
    <div id="wrapper">
        <div class="headerPayment">
            결제 관리 
        </div>
         <div class="searchingDiv">
            <form id="searchForm" action="${ pageContext.servletContext.contextPath }/admin/goods/paymentSearch" method="post" class="searchingForm move">
                <div class="search-area" align="center">
                    <select id="searchCondition" name="searchCondition">
                        <option value="totalPrice">높은 가격순 검색</option>
                        <option value="date">날짜 순 검색</option>
                        <option value="goodsName">상품명 검색</option>
                    </select> <input style="border: 1px solid" type="search" id="searchValue" name="searchValue" style="position: relative;">
                    <button  type="submit" class="searhchingBtn">검색하기</button>
                </div>
            </form>
                <button class="searhchingBtn back" id="gobackAdmin" >뒤로가기</button>     
        </div> 
        <div class="ListDiv">
            <table class="tab_list" >
                <tr>
                    <td class="goodsNo thead">
                        결제번호
                    </td>
                    <td class="goodsName thead">
                        상품이름
                    </td>
                    <td class="goodsPrice thead">
                        상품가격
                    </td>
                    <td class="orderQuantities thead">
                        주문 수량
                    </td>
                    <td class="totalPrice thead">
                        총 결제 금액
                    </td>
                    <td class="paymentDate thead">
                        결제일
                    </td>
                </tr>
               
          <c:forEach var="payment" items="${requestScope.paymentList }">
                <tr>
                    <td class="goodsNo">
                    <c:out value=" ${payment.orderNo}"></c:out>   
                    </td>
                    <td class="goodsName">
                       <c:out value=" ${payment.goodsNo.goodsName}"></c:out>  
                    </td>
                    <td class="goodsPrice">
                       <c:out value=" ${payment.goodsNo.goodsPrice}"></c:out>   
                    </td>
                    <td class="orderQuantities">
                       <c:out value=" ${payment.orderCount}"></c:out>   
                    </td>
                    <td class="totalPrice">
						  <c:out value=" ${payment.orderCount * payment.goodsNo.goodsPrice}"></c:out>   
                    </td>
                    <td class="paymentDate">
                       <fmt:formatDate var="resultDate" value="${ payment.orderDate}" pattern="yyyy-MM-dd" />  
                       ${ resultDate}
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
</body>
<script type="text/javascript">

$("#gobackAdmin").click(function(){
	console.log('dd');
	location.href = "${ pageContext.servletContext.contextPath }/admin/goods";
});

const link = "${ pageContext.servletContext.contextPath }/admin/goods/Payment";
const searchlink = "${ pageContext.servletContext.contextPath }/admin/goods/paymentSearch";
		
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

</html>