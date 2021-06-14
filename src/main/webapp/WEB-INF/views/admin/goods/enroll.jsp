<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css"><head>
<link rel="stylesheet" href="/peoplay/resources/css/goods/enroll.css"><head>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>

</head>
<body>
<section id="sec1">
			<div class="goods_update_delet_div">굿즈 등록</div>
			<hr style="border-color: #008916; font-weight: 800;">
		</section>
		<section id="sec2">
			<div class="goods_name">상품 상세 정보</div>
		</section>
		<section id="sec3">
			<div class="all_info_div">
				<div class="thumbnail-insert-area">
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
					<form id="enrollData" action="${pageContext.servletContext.contextPath }/admin/goods/enrollGoodsData" method="post" enctype="multipart/form-data">
					<table class="info_tab">
						<tr>
							<td class="info_tab_td">상품명 :</td>
							<td class="info_tab_sub"> <input type="text" id="goodsName" name="goodsName"> </td>
						</tr>
						<tr>
							<td class="info_tab_td">상품 소속 :</td>
							<td class="info_tab_sub"><input type="text" id="goodsCompany" name="goodsCompany"></td>
						</tr>
						<tr>
							<td class="info_tab_td">상품 소속 :</td>
							<td class="info_tab_sub">
							<select name="goodsCategory" id="goodsCategory">
								<option value="1" selected="selected">마블</option>
								<option value="2">DC</option>
								<option value="3">지브리</option>
								<option value="4">PIXAR</option>
								<option value="5">WB</option>
							</select>
							</td>
						</tr>
						<tr>
							<td class="info_tab_td">상품 가격 :</td>
							<td class="info_tab_sub"><input min="0" step="100" type="number" id="goodsMoney" name="goodsMoney"></td>
						</tr>
						<!-- <tr>
							<td class="info_tab_td">관련 영화 :</td>
							<td class="info_tab_sub"><input type="text" id="goodsMovie" name="goodsMovie"></td>
						</tr> -->
						<tr>
							<td class="info_tab_td">배송 구분 :</td>
							<td class="info_tab_sub">
							<select name="goodsClassifyCode" id="goodsClassifyCode">
								<option value="1" selected="selected">우체국</option>
								<option value="2">대한 통운</option>
							</select>
							</td>
						</tr>
						<tr>
							<td class="info_tab_td">현재 재고 수량 :</td>
							<td class="info_tab_sub"><input min="1" type="number" id="goodsStock" name="goodsStock"></td>
						</tr>
						<tr>
							<td class="info_tab_td">제조국 :</td>
							<td class="info_tab_sub"><input type="text" id="goodsNationality" name="goodsNationality"></td>
						</tr>
						<tr>
							<td class="info_tab_td">짧은 설명 :</td>
							<td class="info_tab_sub shortinfo"><textarea required="required"  id="goodsShortInfo" name="goodsShortInfo" class="goodsShortInfo"></textarea></td>
						</tr>
						<tr>
							<td class="info_tab_sub1 subImg" colspan="2">
							<input type="file" required="required" id="thumbnailImg1" name="goodsFiles1" onchange="loadImg(this,1)" multiple="multiple">
							 <input type="file"  id="thumbnailImg2" name="goodsFiles2" onchange="loadImg(this,2)" multiple="multiple">
							<input type="file"  id="thumbnailImg3" name="goodsFiles3" onchange="loadImg(this,3)" multiple="multiple">
							<input type="file"  id="thumbnailImg4" name="goodsFiles4" onchange="loadImg(this,4)" multiple="multiple">
							<input type="file"  id="thumbnailImg5" name="goodsFiles5" onchange="loadImg(this,5)" multiple="multiple">
							</td>
						</tr>
						<tr>
							<td class="info_tab_td">상세페이지 : </td>
							<td class="info_tab_sub"><input type="file" id="multiFilesImg" name="goodsDetailFiles" multiple="multiple"></td>
						</tr>
					</table> 
					<button class="enrollBtn" type="button" id="enrollBtn">상품 등록하기</button>
					</form>
				</div>
			</div>
			
			
		</section>
</body>
<script type="text/javascript">

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

$("#enrollBtn").click(function(){
	
	if(confirm("상품을 등록하시겠습니까?") == true){
		
		
		if(document.getElementById("goodsName").value == ""
				|| document.getElementById("goodsCategory").value == ""
				|| document.getElementById("goodsCompany").value == ""
				|| document.getElementById("goodsMoney").value == ""
				|| document.getElementById("goodsMovie").value == ""
				|| document.getElementById("goodsStock").value == ""
				|| document.getElementById("goodsNationality").value == ""
				|| document.getElementById("goodsShortInfo").value == ""
				|| document.getElementById("thumbnailImg1").value == ""
				|| document.getElementById("multiFilesImg").value == "" 
				){
			alert("빈칸으로 제출 할 수 없습니다");
		}else{
			
		 $("#enrollData").submit(); 
		}
	} else {
		return;
	}
});
</script>
</html>