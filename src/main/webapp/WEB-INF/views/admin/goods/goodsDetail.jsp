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
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/goods/admingoodsDetail.css">

<title>Document</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
<jsp:include page="../../common/header.jsp"/>
<br><br><br><br>
	<div id="wrapper">
		<br> <br> <br> <br> <br>
		<section id="sec1">
			<div class="goods_update_delet_div">굿즈 수정 및 삭제</div>
			<hr style="border-color: #008916; font-weight: 800;">
		</section>
		<section id="sec2">
			<div class="goods_name">상품 상세 정보</div>
		</section>
		<section id="sec3">
			<div class="all_info_div">
				<div class="sec1_1">
					<div class="img_div">
						<img alt=""
							src="/peoplay/resources/images/goods/goodsImageFiles/${requestScope.goodsAndFile.goodsFile[0].fileSaveName}"
							width="540px" class="img" id="img">
					</div>
					<div class="thumbnail_div">
						<c:forEach var="goodsFiles"
							items="${requestScope.goodsAndFile.goodsFile}">
							<button onclick="Img${goodsFiles.number}()">
								<img alt="" src="/peoplay/resources/images/goods/goodsImageFiles/${goodsFiles.fileSaveName}" class="thumbnail-img">
							</button>
						</c:forEach>
					</div>
				</div>
				<div class="info_div">
					<table class="info_tab">
						<tr>
							<td class="info_tab_td">상품명 :</td>
							<td class="info_tab_sub">${requestScope.selectGoodsInfoByGoodsNo.goodsName }</td>
						</tr>
						<tr>
							<td class="info_tab_td">상품 소속 :</td>
							<td class="info_tab_sub">${requestScope.selectGoodsInfoByGoodsNo.goodsCompany }</td>
						</tr>
						<tr>
							<td class="info_tab_td">상품 가격 :</td>
							<td class="info_tab_sub">${requestScope.selectGoodsInfoByGoodsNo.goodsPrice }원</td>
						</tr>
						<tr>
							<td class="info_tab_td">상품 등록일 :</td>
							<td class="info_tab_sub"><fmt:formatDate var="resultDate" value="${requestScope.selectGoodsInfoByGoodsNo.goodsRegistrationDate}" pattern="yyyy-MM-dd" /> ${resultDate}</td>
						</tr>
						<tr>
							<td class="info_tab_td">남은 재고 수량 :</td>
							<td class="info_tab_sub">${requestScope.selectGoodsInfoByGoodsNo.goodsStock }</td>
						</tr>
						<tr>
							<td class="info_tab_td">제조국 :</td>
							<td class="info_tab_sub">${requestScope.selectGoodsInfoByGoodsNo.goodsOrigin }</td>
						</tr>
						<tr>
							<td class="info_tab_td">좋아요 수 :</td>
							<td class="info_tab_sub">${requestScope.selectGoodsInfoByGoodsNo.goodsLikeCount }</td>
						</tr>
						<tr>
							<td class="info_tab_td">상품 판매 상태 :</td>
							<td class="info_tab_sub status">${requestScope.selectGoodsInfoByGoodsNo.goodsStatus }</td>
						</tr>
					</table>
				</div>
			</div>
		</section>
		<section id="sec4">
			<div class="btn_update_delete_div">
				<button type="button" id="YNBtn" class="btn_update_delete" onclick="deleteGoods(${requestScope.selectGoodsInfoByGoodsNo.goodsNum})">삭제하기</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn_update_delete" onclick="updateGoods(${requestScope.selectGoodsInfoByGoodsNo.goodsNum})">수정하기</button>
			</div>
		</section>
		
		<section id="sec5">
			<div>
				<c:forEach var="goodsDetailFile"
					items="${ goodsAndDetailFile.detailFiles}">
					<img class="detailImg" alt=""
						src="/peoplay/resources/images/goods/goodsDetailFiles2/${goodsDetailFile.detailFileSaveName}">
				</c:forEach>
			</div>
		</section>
	</div>
	<br><br>
	<input type="hidden" value="${requestScope.goodsStatus }" id="goodsStatusYN">
 <jsp:include page="../../common/footer.jsp"/>
</body>
<script type="text/javascript">
function Img${requestScope.goodsAndFile.goodsFile[0].number}() {    	
    document.getElementById("img").src = "/peoplay/resources/images/goods/goodsImageFiles/${requestScope.goodsAndFile.goodsFile[0].fileSaveName}";
}
    
function Img${requestScope.goodsAndFile.goodsFile[1].number}() {
    document.getElementById("img").src ="/peoplay/resources/images/goods/goodsImageFiles/${requestScope.goodsAndFile.goodsFile[1].fileSaveName}";
}
function Img${requestScope.goodsAndFile.goodsFile[2].number}() {
    document.getElementById("img").src = "/peoplay/resources/images/goods/goodsImageFiles/${requestScope.goodsAndFile.goodsFile[2].fileSaveName}";
}
 function Img${requestScope.goodsAndFile.goodsFile[3].number}() {
    document.getElementById("img").src = "/peoplay/resources/images/goods/goodsImageFiles/${requestScope.goodsAndFile.goodsFile[3].fileSaveName}";
}
function Img${requestScope.goodsAndFile.goodsFile[4].number}() {
    document.getElementById("img").src = "/peoplay/resources/images/goods/goodsImageFiles/${requestScope.goodsAndFile.goodsFile[4].fileSaveName}";
}  
</script>
	<script >
	
	function updateGoods(val1) {
		const goodsNum	= val1;
		location.href = "${ pageContext.servletContext.contextPath }/admin/goods/update?goodsNum=" + goodsNum;

	}
	
	function deleteGoods(val1) {
		
		const goodsNum = val1;
		var goodsStatusYN = document.getElementById("goodsStatusYN").value;
		
			
 			if(goodsStatusYN == "판매가능"){
 				
 				$.ajax({
 					
 					url : "adminDeleteGoods",
 					method : "POST",
 					data : 
 						{
 						goodsNum : goodsNum
 						},
 					success : function(data){
 						
 						 $(".status").text(JSON.parse(data).goodsStatus);
 						document.getElementById("goodsStatusYN").value = "판매불가능";
 						$("#YNBtn").text('판매하기');
 					},
 					
 					error : function(error){
 						
 					}
 					
 				});
 				
 			}else if(goodsStatusYN == "판매불가능"){
 				
				$.ajax({
 					
 					url : "adminliveGoods",
 					method : "POST",
 					data : 
 						{
 						goodsNum : goodsNum
 						},
 					success : function(data){
 						
 						 $(".status").text(JSON.parse(data).goodsStatus);
 						document.getElementById("goodsStatusYN").value = "판매가능";
 						$("#YNBtn").text('삭제하기');
 						
 						
 					},
 					
 					error : function(error){
 						
 					}
 					
 				});
 				
 				
 			} 
	}
	$(function(){
		if(document.getElementById("goodsStatusYN").value == '판매가능'){
			
			$("#YNBtn").text('삭제하기');
		}else{
			
			$("#YNBtn").text('판매하기');
		}
	});
	

	</script>

</html>