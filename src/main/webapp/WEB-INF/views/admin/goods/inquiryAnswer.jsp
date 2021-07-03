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
    <title>PeoPlay : 굿즈 문의사항 관리 페이지</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/goods/inquiryAnswer.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>

<body>
<jsp:include page="../../common/header.jsp"/>
    <br><br><br><br><br><br>
    <div id="wrapper">
        <div class="headerPayment">
               문의 내역 관리
        </div>
         <div class="searchingDiv">
            <form id="searchForm" action="${ pageContext.servletContext.contextPath }/admin/goods/InquirySearch" method="post" class="searchingForm">
                <div class="search-area" align="center" style="position: relative; left: 300px;">
                    <select id="searchCondition" name="searchCondition">
                        <option value="member">회원</option>
                        <option value="question">문의 내용 </option>
                        <option value="goodsName">상품명 검색</option>
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
                    	문의번호
                    </td>
                    <td class="goodsName thead">
                                                     문의한 회원
                    </td>
                    <td class="goodsPrice thead">
                                                     문의내용
                    </td>
                    <td class="orderQuantities thead">
                                                       상품명
                    </td>
                    <td class="totalPrice thead">
                                                      문의 날짜
                    </td>
                    <td class="paymentDate thead">
                                                  문의 답변 유무
                    </td>
                    <td class="paymentDate thead">
                                                  답변 내용 확인하기
                    </td>
                    
                </tr>
               
          <c:forEach var="inquiryAnswer" items="${requestScope.inquiryListPaging }">
                <tr>
                    <td class="goodsNo">
                    <input type="hidden" value="${inquiryAnswer.goodsInquiryNo}">
                    <c:out value=" ${inquiryAnswer.goodsInquiryNo}"></c:out>   
                    </td>
                    <td class="goodsName">
                       <input type="hidden" value="${inquiryAnswer.goodsNumber.goodsNum}">
                       <c:out value=" ${inquiryAnswer.userNo.userName}"></c:out>  
                    </td>
                    <td class="goodsPrice" id="answer" onclick="viewInquiryReply(this);">
                       <input type="hidden" value="${inquiryAnswer.userNo.userNo}">
                       <c:out value=" ${inquiryAnswer.goodsInquiryContent}"></c:out>   
                    </td>
                    <td class="orderQuantities">
                       <c:out value=" ${inquiryAnswer.goodsNumber.goodsName}"></c:out>   
                    </td>
                    <td class="totalPrice">
						<c:out value=" ${inquiryAnswer.writtenDate}"></c:out>   
                    </td>
                    <td class="paymentDate">
						<c:out value=" ${inquiryAnswer.goodsInquiryYn}"></c:out>   
                    </td>
                    <td class="paymentDate">
						 <button id="checkAnswer" onclick="checkAnswer(this);" name="checkAnswer" class="checkAnswer w3-button w3-black">답변확인</button>
                    </td>
                </tr>
               <%--  <tr>
                    <td class="goodsNo">
                      ㄴ
                    </td>
                    <td class="goodsName">
                       답변 내용 : <c:out value=" ${inquiryAnswer.goodsReply[0].goodsInquiryContent}"></c:out>  
                    </td>
                    <td class="goodsPrice" id="answer">
                       답변 일자 : 
                       <c:out value=" ${inquiryAnswer.goodsReply[0] }"></c:out>   
                    </td>
                    <td class="orderQuantities">
                      
                    </td>
                    <td class="totalPrice">
						 
                    </td>
                    <td class="paymentDate">
						  
                    </td>
                </tr> --%>
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
    
    <!-- 문의 사항 답변-->
				<div class="w3-container">
				  <div id="id01" class="w3-modal">
				    <div class="w3-modal-content">
				      <div class="w3-container">
				        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright">&times;</span>
				         <form action="${ pageContext.servletContext.contextPath }/admin/goods/inquiryAnswerAdmin" method="post">
						<div class="replyHeader">
							문의 답변
						</div>
						<div id="inquiryAnswerDiv" class="quiryBody">
						<textarea class="textareareply" cols="5" rows="20" name="inquiryAnswer" required="required"></textarea><br>
				        <button type="submit" class="w3-button w3-black btninquiry">답변하기</button>	 
						</div>
				        <input type="hidden" id="inquiryReplyNum" name="inquiryReplyNum">
				        <input type="hidden" id="goodsNum" name="goodsNum">
				        <input type="hidden" id="userNo" name="userNo">
				        </form> 
				      </div>
				    </div>
				  </div>
				</div>
				
				<!-- 문의 사항 답변한 내용-->
				<div class="w3-container">
				  <div id="id02" class="w3-modal">
				    <div class="w3-modal-content">
				      <div class="w3-container">
				        <span onclick="document.getElementById('id02').style.display='none'" class="w3-button w3-display-topright">&times;</span>
						<div class="replyHeader">
							문의 답변
						</div>
						<div id="answerDiv" class="answerDiv">
						
						</div>
				        <input type="hidden" id="questionNum" name="questionNum">
				      </div>
				    </div>
				  </div>
				</div>
        <jsp:include page="../../common/footer.jsp"/>

<script>
function viewInquiryReply(Obj){
	
	document.getElementById('id01').style.display='block';
	
	console.log($(Obj).parents("tr").find('td').eq(1).find('input').val());
	console.log($(Obj).parents("tr").find('td').eq(2).find('input').val());

	document.getElementById("inquiryReplyNum").value = $(Obj).parents("tr").find('td').eq(0).find('input').val();
	document.getElementById("goodsNum").value = $(Obj).parents("tr").find('td').eq(1).find('input').val();
	document.getElementById("userNo").value = $(Obj).parents("tr").find('td').eq(2).find('input').val();
	 
} 

function checkAnswer(Obj){
	
	console.log($(Obj).parents("tr").find('td').eq(0).find('input').val())
		
	document.getElementById("questionNum").value = $(Obj).parents("tr").find('td').eq(0).find('input').val();
	
	var $inquiryReplyList = ${requestScope.selectInquiryReply};
	for(var i = 0; i < $inquiryReplyList.length; i++ ){
		
		if($inquiryReplyList[i].goodsinquiryNo.goodsInquiryNo == document.getElementById("questionNum").value){
			
			document.getElementById("answerDiv").innerHTML = $inquiryReplyList[i].goodsReplyContent;
			document.getElementById('id02').style.display='block';		
		} 
	


	}


}
const link = "${ pageContext.servletContext.contextPath }/admin/goods/InquiryAnswer";
const searchlink = "${ pageContext.servletContext.contextPath }/admin/goods/DeliverySearch";
		
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
$("#gobackAdmin").click(function(){
	location.href = "${ pageContext.servletContext.contextPath }/admin/goods";
});
</script>
</body>
</html>