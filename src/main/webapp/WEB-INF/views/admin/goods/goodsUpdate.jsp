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
<link rel="stylesheet" href="/peoplay/resources/css/goods/adminGoodsUpdate.css">

<title>Document</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
<br><br>
	<div id="wrapper">
		<br> <br> <br> <br> <br>
		<section id="sec1">
			<div class="goods_update_delet_div">굿즈 수정 및 삭제</div>
			<hr style="border-color: #008916; font-weight: 800;">
		</section>
		<section id="sec2">
		</section>
		<div class="goods_name">상품 상세 정보</div>
		<section id="sec3">
				<div class="thumbnail-insert-area" style="float: left;">
					<table align="center">
					<tr>
						<td colspan="5">
							<div class="title-img-area" id="titleImgArea">
								<img id="titleImg" width="500" height="450" >
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="content-img-area1" id="contentImgArea1">
								<img id="contentImg1" width="125" height="100">
							</div>
						</td>
						<td>
							<div class="content-img-area2" id="contentImgArea2">
								<img id="contentImg2" width="125" height="100">
							</div>
						</td>
						<td>
							<div class="content-img-area3" id="contentImgArea3">
								<img id="contentImg3" width="125" height="100">
							</div>
						</td>
						<td>
							<div class="content-img-area4" id="contentImgArea4">
								<img id="contentImg4" width="125" height="100">
							</div>
						</td>
					</tr>

				</table>
				</div>
				<div class="info_div">
				<form id="updateData" action="${pageContext.servletContext.contextPath }/admin/goods/updateGoods2" method="post" enctype="multipart/form-data">
							<input type="hidden" name="goodsNum" value="${requestScope.selectGoodsInfoByGoodsNo.goodsNum }">
							<input type="hidden" name="goodsNumber" value="${requestScope.selectGoodsInfoByGoodsNo.goodsNum }">
					<table class="info_tab" style="position: relative; top: -12px;">
						<tr>
							<td class="info_tab_td">상품명 :</td>
							<td class="info_tab_sub"> <input type="text" value="${requestScope.selectGoodsInfoByGoodsNo.goodsName }" name="goodsName"></td>
						</tr>
						<tr>
							<td class="info_tab_td">상품 소속 :</td>
							<td class="info_tab_sub"><input type="text" value="${requestScope.selectGoodsInfoByGoodsNo.goodsCompany }" name="goodsCompany"></td>
						</tr>
						<tr>
							<td class="info_tab_td">상품 가격 :</td>
							<td class="info_tab_sub"><input type="number" step="50" value="${requestScope.selectGoodsInfoByGoodsNo.goodsPrice }" name="goodsPrice"></td>
						</tr>
						<tr>
							<td class="info_tab_td">상품 등록일 :</td>
							<td class="info_tab_sub"><fmt:formatDate var="resultDate" value="${requestScope.selectGoodsInfoByGoodsNo.goodsRegistrationDate}" pattern="yyyy-MM-dd" /> ${resultDate}</td>
						</tr>
						<tr>
							<td class="info_tab_td">남은 재고 수량 :</td>
							<td class="info_tab_sub"><input type="number" readonly="readonly" value="${requestScope.selectGoodsInfoByGoodsNo.goodsStock }" name="goodsStock"></td>
						</tr>
						<tr>
							<td class="info_tab_td">추가 입고 수량 : </td>
							<td class="info_tab_sub"><input min="0" type="number" name="goodsStockIn"></td>
						</tr>
						<tr>
							<td class="info_tab_td">짧은 설명 : </td>
							<td class="info_tab_sub"><input  type="text" value="${requestScope.selectGoodsInfoByGoodsNo.goodsShortInfo }" name="goodsShortInfo"></td>
						</tr>
						<tr>
							<td class="info_tab_td">제조국 :</td>
							<td class="info_tab_sub"><input type="text" value="${requestScope.selectGoodsInfoByGoodsNo.goodsOrigin }" name="goodsOrigin"></td>
						</tr>
						<tr>
							<td class="info_tab_td">상품 판매 상태 :</td>
							<td class="info_tab_sub status">
								<select name="goodsStatus">
									<option value="Y">등록</option>
									<option value="N">미등록</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="info_tab_sub1" colspan="2">
							<input type="file" required="required" id="thumbnailImg1" name="goodsFiles1" onchange="loadImg(this,1)" multiple="multiple">
							 <input type="file"  id="thumbnailImg2" name="goodsFiles2" onchange="loadImg(this,2)" multiple="multiple">
							<input type="file"  id="thumbnailImg3" name="goodsFiles3" onchange="loadImg(this,3)" multiple="multiple">
							<input type="file"  id="thumbnailImg4" name="goodsFiles4" onchange="loadImg(this,4)" multiple="multiple">
							<input type="file"  id="thumbnailImg5" name="goodsFiles5" onchange="loadImg(this,5)" multiple="multiple">
							</td>
						</tr>
						<tr>
							<td class="info_tab_td">상세페이지 : </td>
							<td class="info_tab_sub"><input type="file" id="detailFiles" name="goodsDetailFiles" multiple="multiple"></td>
						</tr>
					</table>
				<button type="button" class="btn_update_delete" id="updateBtn" style="position: relative; top: 80px; left: 36px;">수정하기</button>
				<button type="button" class="btn_update_delete" id="gobackBtn" style="position: relative; top: 80px; left: 54px;">목록으로</button>
			</form>
			</div>
		</section>
			</div>
		<section id="sec4">
			<div class="btn_update_delete_div">
			</div>
		</section>
		
		


</body>
	<script >
	$("#gobackBtn").click(function(){
		
		location.href = "${ pageContext.servletContext.contextPath }/admin/goods";
	});
	

	/* 			 if(document.getElementById("goodsName").value === ""
					|| document.getElementById("goodsCategory").value == ""
					|| document.getElementById("goodsCompany").value == ""
					|| document.getElementById("goodsMoney").value == ""
					|| document.getElementById("goodsMovie").value == ""
					|| document.getElementById("goodsStock").value == ""
					|| document.getElementById("goodsNationality").value == ""
					|| document.getElementById("goodsShortInfo").value == ""
					

				
			}  */
	$("#updateBtn").click(function(){
		
		if(confirm("상품을 수정하시겠습니까?") == true){
			 if(document.getElementById("detailFiles").value == ""
			|| document.getElementById("thumbnailImg1").value == ""
			 ){
					alert("빈칸으로 제출 할 수 없습니다");
				}else{ 
			 
					$("#updateData").submit(); 
		}
		}else{
			return;
		}
		});
	
	function deleteGoods(val1) {
		
		const goodsNum = val1;
		
 		if(confirm("해당 굿즈를 삭제하시겠습니까?") == true){  
			
			$.ajax({
				
				url : "adminDeleteGoods",
				method : "POST",
				data : 
					{
					goodsNum : goodsNum
					
					},
				success : function(data){
					
					/* goodsStatus를 못가져오는 상태 */
					/*  for(var i = 0 ; i < data.length ; i++){
						 console.log(data[i].goodsStatus);
					 } */
					 
					 $(".status").text(data.status);
				},
				
				error : function(error){
					
				}
				
			});
			
		}else{
			
			return;
		} 
	}
	
	const $titleImgArea = document.getElementById("titleImgArea");
	const $contentImgArea1 = document.getElementById("contentImgArea1");
	const $contentImgArea2 = document.getElementById("contentImgArea2");
	const $contentImgArea3 = document.getElementById("contentImgArea3");
	const $contentImgArea4 = document.getElementById("contentImgArea4");

	$titleImgArea.onclick = function() {
		document.getElementById("thumbnailImg1").click();
	}
	$contentImgArea1.onclick = function() {
		document.getElementById("thumbnailImg2").click();
	}
	$contentImgArea2.onclick = function() {
		document.getElementById("thumbnailImg3").click();
	}
	$contentImgArea3.onclick = function() {
		document.getElementById("thumbnailImg4").click();
	}
	$contentImgArea4.onclick = function() {
		document.getElementById("thumbnailImg5").click();
	}
	
	/* 이미지 파일 미리보기 */
		function loadImg(value, num) {
				if(value.files && value.files[0]) {
					const reader = new FileReader();
					
					reader.onload = function(e) {
						switch(num) {
							case 1: document.getElementById("titleImg").src = e.target.result;
									break;
							case 2: document.getElementById("contentImg1").src = e.target.result;
									break;
							case 3: document.getElementById("contentImg2").src = e.target.result;
									break;
							case 4: document.getElementById("contentImg3").src = e.target.result;
									break;
							case 5: document.getElementById("contentImg4").src = e.target.result;
									break;
						}
					}
					/* readAsDataURL은 Blob이나 file에서 읽어오는 역할을 함 */
					/* Blob(Binary Large Object) : 바이너리 형태의 큰 객체(이미지, 사운드, 비디오같은 멀티미디어 객체) */
					/* 우리가 이미지를 브라우저에 뿌려주기 위해서는 base64 encoded string으로 변환해 주어야 한다. */
					reader.readAsDataURL(value.files[0]);
				}
			}
	</script>

</html>