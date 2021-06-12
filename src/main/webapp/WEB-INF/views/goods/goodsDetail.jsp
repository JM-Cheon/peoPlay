<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/peoplay/resources/css/goods/goodsDetail.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>

<body>
<jsp:include page="../common/header.jsp"/>
	<br>
	<br>
	<br>
	<br>
		<div id="wrapper" style="height: 3800px;">
		<section id="sec1">
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
				<p class="name" >
					${selectOneGoodsInfo.goodsName }
				</p>
				<br>
				<hr>
				<table  class="info_tab" style=" position: relative; left: 30px; font-size: 15pt;">
					<tr>
						<td class="info_tab_td">판매가</td>
						<td class="info_tab_td2">${selectOneGoodsInfo.goodsPrice }원</td>
					</tr>
					<tr>
						<td class="info_tab_td">배송구분</td>
						<td class="info_tab_td2">${selectOneGoodsInfo.goodsShipmentClassifyCode.goodsShipmentClassifyName }</td>
					</tr>
					<tr>
						<td class="info_tab_td">수량</td>
						<td class="info_tab_td2">
							<!-- <form action="order" method="post" class="info_tab_td2"> -->
							<input type="hidden" name="userNum"
							<%-- value="${requestScope.loginMember.userNo }"> <input --%>
							value="${requestScope.loginMember }" > <input
							type="hidden" name="goodsNum"
							value="${requestScope.selectOneGoodsInfo.goodsNum}"> <input
							type="number" name="quantities" id="quantities" class="numbering" min="0">
							개 <!-- </form> -->
						</td>
					</tr>
				</table>

			</div>
			<div class="btn_div">
			<input type="hidden" id="likeDislike" value="${goodsLikeList}">
				<button class="wishlist_btn" type="button" onclick="cart(${requestScope.selectOneGoodsInfo.goodsNum}, ${requestScope.loginMember.userNo})">
<%-- 				<button type="button" onclick="cart(${requestScope.selectOneGoodsInfo.goodsNum}, ${requestScope.loginMember.userNo})">
 --%>					장바구니</button>
				<button class="like_btn" id="like_btn"
 					onclick="likebtn(${requestScope.selectOneGoodsInfo.goodsNum}, ${requestScope.loginMember.userNo })">
					좋아요  </button>
				<button class="btn_buy"
					onclick="buyGoods(${requestScope.selectOneGoodsInfo.goodsNum}, ${requestScope.loginMember.userNo })">바로구매</button>
					<%-- onclick="buyGoods(${requestScope.selectOneGoodsInfo.goodsNum}, ${requestScope.loginMember.userNo })">바로구매</button> --%>
			</div>
		</section>
		<section id="sec2">
			<div class="div_describe">
				<h2 class="describe">상품설명</h2>
			</div>

			<div class="div_tab_decsibe">
				<table class="describe_tab">
					<tr>
						<td class="describe_tab_td" style="position: relative; left: -77px; ">상품명 :</td>
						<td class="describe_tab_td2" style="position: relative; left: -77px;">&nbsp;&nbsp;${requestScope.selectOneGoodsInfo.goodsName}</td>
						<td class="describe_tab_td" style="position: relative; right: 54px;">제조국 :</td>
						<td class="describe_tab_td2" style="position: relative; right: 54px;">&nbsp;&nbsp;${requestScope.selectOneGoodsInfo.goodsOrigin}</td>
					</tr>
					<tr>
						<td class="describe_tab_td" style="position: relative; left: -52px;">배송 구분 :</td>
						<td class="describe_tab_td2" style="position: relative; left: -52px;">&nbsp;&nbsp;${requestScope.selectOneGoodsInfo.goodsShipmentClassifyCode.goodsShipmentClassifyName}</td>
						<td class="describe_tab_td" style="position: relative; right: 35px;">제조업체 :</td>
						<td class="describe_tab_td2" style="position: relative; right: 35px;">&nbsp;&nbsp;${requestScope.selectOneGoodsInfo.goodsCompany}
							/
							${requestScope.selectOneGoodsInfo.goodsCategoryNum.goodsCategoryName}</td>
					</tr>
				</table>
			</div>
		</section>
		<section id="sec3">
			<div>
				<c:forEach var="goodsDetailFile"
					items="${ requestScope.selectGoodsDetailFiles.detailFiles}">
					<img class="detailImg" alt=""
						src="/peoplay/resources/images/goods/goodsDetailFiles2/${goodsDetailFile.detailFileSaveName}">
				</c:forEach>

			</div>
		</section>
		<br> <br>
			<hr color="#008916">
<br><br>
				<!-- 댓글 수정  -->
				<div class="w3-container">
				  <div id="id01" class="w3-modal">
				    <div class="w3-modal-content">
				      <div class="w3-container">
				        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright">&times;</span>
				         <form action="${ pageContext.servletContext.contextPath }/goods/updateReply" method="post">
				        <textarea class="textareareply"  cols="5" rows="20" name="updateContent" required="required"></textarea><br>
				        <button type="submit" class="w3-button w3-black btninquiry">수정하기</button>
				        <input type="hidden" id="reviewNum" name="reviewNum">
				        <input type="hidden" id="goodsNum" name="goodsNum" value="${ requestScope.selectOneGoodsInfo.goodsNum}">
				        </form> 
				      </div>
				    </div>
				  </div>
				</div>
				<!-- 신고하기  -->
				<div class="w3-container">
				  <div id="id02" class="w3-modal">
				    <div class="w3-modal-content">
				      <div class="w3-container">
				        <span onclick="document.getElementById('id02').style.display='none'" class="w3-button w3-display-topright">&times;</span>
				         <form action="${ pageContext.servletContext.contextPath }/goods/report" method="post">
				                <select id="reportReason" name="reportReason" style="font-size: 15px; align-content: center;" >
						                <option value="상품품질과 관련없는 내용">상품 품질과 관련 없는 내용</option>
						                <option value="개인 및 판매자의 상업적 홍보">개인 및 판매자의 상업적 홍보</option>
						                <option value="개인정보 누출 위험">개인정보 누출 위험</option>
						                <option value="저작권 불법 도용">저작권 불법 도용(타인이 작성한 글, 사진 등)</option>                
						        </select>
				        <button type="submit" class="w3-button w3-black">신고하기</button>
				        <%-- <input type="hidden" id="userNo" name="userNo" value="${sessionScope.loginMember.userNo }"> --%>
				        <input type="hidden" id="userNo" name="userNo" value="${loginMember.userNo}">
				        <input type="hidden" id="reportedPerson" name="reportedPerson">
				        <input type="hidden" id="placeNo" name="placeNo" value="${requestScope.selectOneGoodsInfo.goodsNum }">
				        <input type="hidden" id="reportReplyNo" name="reportReplyNo" >
				        <input type="hidden" name="goodsNoReport" value="" >
				        </form> 
				      </div>
				    </div>
				  </div>
				</div>
				<!-- 문의 사항 수정 -->
				<div class="w3-container">
				  <div id="id03" class="w3-modal">
				    <div class="w3-modal-content">
				      <div class="w3-container">
				        <span onclick="document.getElementById('id03').style.display='none'" class="w3-button w3-display-topright">&times;</span>
				         <form action="${ pageContext.servletContext.contextPath }/goods/updateInquiry" method="post">
				        <textarea class="textareareply" cols="5" rows="20" name="inquiryUpdateContent" required="required"></textarea><br>
				        <button type="submit" class="w3-button w3-black btninquiry">수정하기</button>
				        <input type="hidden" id="inquiryNum" name="inquiryNum">
				        <input type="hidden" id="goodsNumber" name="goodsNumber" value="${ requestScope.selectOneGoodsInfo.goodsNum}">
				        </form> 
				      </div>
				    </div>
				  </div>
				</div>
				<!-- 문의 사항 답변-->
				<div class="w3-container">
				  <div id="id04" class="w3-modal">
				    <div class="w3-modal-content">
				      <div class="w3-container">
				        <span onclick="document.getElementById('id04').style.display='none'" class="w3-button w3-display-topright">&times;</span>

						<div class="replyHeader">
							문의 답변
						</div>
						<div id="inquiryAnswerDiv" class="quiryBody">
							 
						</div>
						
				        <input type="hidden" id="inquiryReplyNum" name="inquiryReplyNum">
				        <input type="hidden" id="goodsNumber" name="goodsNumber" value="${ requestScope.selectOneGoodsInfo.goodsNum}">
	
				      </div>
				    </div>
				  </div>
				</div>

			<div class="everyday_div" style="height: 100px;">
				<button class="button">
					<p class="everyday_text on" id="replyCounting">상품후기(${requestScope.ReviewCount })</p>
				</button>
				<button class="button">
					<p class="everyday_text">상품 문의</p>
				</button>
				<button class="button">
					<p class="everyday_text">배송/환불 관련</p>
				</button>
			</div>

			<div class="everyday_contents">
				<div class="reply on" id="test">
					<div class="replydiv">
						<textarea name="댓글달기" class="replytext" id="replytext" rows="6"></textarea>
						<p><span id="count">0</span>/50</p>
						<c:if test="${requestScope.paidGoods eq 'Y' }">
						<button type="button" class="repliedbtn" id="repliedbtn">등록하기</button>
						</c:if>
						<c:if test="${requestScope.paidGoods eq 'N' }">
						<button type="button" class="repliedbtn" id="repliedbtnYN">등록하기</button>
						</c:if>
						<!-- 회원 중에서 본인의 것에 대해서 -->
						<div class="reply_div">
							<table
								style="width: 1000px; height: 100px; text-align: center; background-color: #faae5a">
								<tr>
									<td class="no" style="background-color: #faae5a; font-size: 14pt; font-weight: 600;" >번호</td>
									<td class="evaluate" style="background-color: #faae5a; font-size: 14pt; font-weight: 600;">상품평</td>
									<td class="author" style="background-color: #faae5a; font-size: 14pt; font-weight: 600;">작성자</td>
									<td class="date" style="background-color: #faae5a; font-size: 14pt; font-weight: 600;">작성일</td>
									<td class="updatedelete" style="background-color: #faae5a; font-size: 14pt; font-weight: 600;">수정 /
										삭제</td>
									<td class="report" style="background-color: #faae5a;  font-size: 14pt; font-weight: 600;">신고</td>
								</tr>
							</table>
							<c:forEach var="review"
								items="${requestScope.seletReivewByGoodsNo}">
								<c:if test="${review.memNum.userNo == loginMember.userNo}">
									<%-- 								<c:if test="${review.memNum.userNo == loginMember.userNo}"> --%>
									<table
										style="width: 1000px; height: 100px; text-align: center;">
										<tr id="reply_tr">
											<td class="no">${ review.goodsReviewNum}</td>
											<td class="evaluate" id="evaluate">${ review.goodsReviewContent}
											</td>
											<td class="author"><input type="hidden"  value="${ review.memNum.userNo}"> ${ review.memNum.userName}</td>
											<td class="date"><fmt:formatDate var="resultDate"
													value="${ review.reviewDate}" pattern="yyyy-MM-dd" />
												${resultDate}</td>
											<td class="updatedelete">
											 <input type="hidden" id="commentNo" value="${review.goodsReviewNum }">
											 <input	type="hidden" id="reviewGoodsNo" value="${review.goodsNum.goodsNum }">
												<button id="btnUpdateReply" onclick="updateReply(this);" name="btnUpdateReply" class="btnUpdateReply w3-button w3-black">수정하기</button>

												<button id="btnDeleteReply" type="button"
													class="delete_btn w3-button w3-black">삭제하기</button>
											<td class="report"></td>
										</tr>
									</table>
								</c:if>
								<c:if test="${review.memNum.userNo != loginMember.userNo}">
<%-- 								<c:if test="${review.memNum.userNo != loginMember.userNo}">
 --%>									<table
										style="width: 1000px; height: 100px; text-align: center;">
										<tr>
											<td class="no">${ review.goodsReviewNum}</td>
											<td class="evaluate">${ review.goodsReviewContent}</td>
											<td class="author"><input type="hidden"  value="${ review.memNum.userNo}">${ review.memNum.userName}</td>
											<td class="date"><fmt:formatDate var="resultDate"
													value="${ review.reviewDate}" pattern="yyyy-MM-dd" />
												${resultDate}</td>
											<td class="updatedelete"></td>
											<td class="report"><button id="reportReply" onclick="reportReply(this);" class="w3-button w3-black">신고하기</button></td>
										</tr>
									</table>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
				
				<div class="inquery" id="test">
					<div class="inquirydiv" style="position: relative; left: 50px">
						<textarea name="댓글달기" class="replytext" id="inquirytext" rows="6"></textarea>
						<p><span id="count2">0</span>/50</p>
						<button type="button" class="repliedbtn" id="inquirybtn">문의 등록</button>

						<!-- 회원 중에서 본인의 것에 대해서 -->
						<div class="inquiry_div">
							<table
								style="width: 1000px; height: 100px; text-align: center; background-color: #faae5a">
								<tr>
									<td class="no" style="background-color: #faae5a; font-size: 14pt; font-weight: 600;">번호</td>
									<td class="evaluate" style="background-color: #faae5a; font-size: 14pt; font-weight: 600;">문의내용</td>
									<td class="author" style="background-color: #faae5a; font-size: 14pt; font-weight: 600;">작성자</td>
									<td class="date" style="background-color: #faae5a; font-size: 14pt; font-weight: 600;">작성일</td>
									<td class="updatedelete" style="background-color: #faae5a; font-size: 14pt; font-weight: 600;">수정 /
										삭제</td>
									<td class="answer" style="background-color: #faae5a;  font-size: 14pt; font-weight: 600;">답변보기</td>
								</tr>
							</table>
							<c:forEach var="inquiry"
								items="${requestScope.selectInquiryByGoodsNo}">
								<c:if test="${inquiry.userNo.userNo == loginMember.userNo}">
								<%-- <c:if test="${inquiry.userNo.userNo == loginMember.userNo}"> --%>
									<table
										style="width: 1000px; height: 100px; text-align: center;">
										<tr>
											<td class="no">${ inquiry.goodsInquiryNo}</td>
											<td class="evaluate">${ inquiry.goodsInquiryContent}</td>
											<td class="author">${ inquiry.userNo.userName}</td>
											<td class="date"><fmt:formatDate var="resultDate"
													value="${ inquiry.writtenDate}" pattern="yyyy-MM-dd" />
												${resultDate}</td>
											<td class="updatedelete">
											 <input type="hidden" id="inquiryNo" value="${inquiry.goodsInquiryNo }">
											 <input type="hidden" id="goodsNo" value="${inquiry.goodsNumber.goodsNum }">
												<button id="btnUpdateInquiry" onclick="updateInquiry(this);" name="btnUpdateInquiry" class="btnUpdateInquiry w3-button w3-black">수정하기</button>

												<button id="btnDeleteInquiry" type="button" onclick="deleteInquiry(this);"
													class="delete_btn w3-button w3-black">삭제하기</button>
											<td class="report"><button id="viewInquiryReply" onclick="viewInquiryReply(this);"
													class="w3-button w3-black">답변보기</button></td>
										</tr>
									</table>
								</c:if>
								<%-- <c:if test="${inquiry.userNo.userNo != session.loginMember.userNo}"> --%>
								<c:if test="${inquiry.userNo.userNo != loginMember.userNo}">
									<table
										style="width: 1000px; height: 100px; text-align: center;">
										<tr>
											<td class="no">${ inquiry.goodsInquiryNo} <input type="hidden" id="reviewNum"  value="${ review.goodsReviewNum}"> </td>
											<td class="evaluate goinquiry">${ inquiry.goodsInquiryContent}</td>
											<td class="author">${ inquiry.userNo.userName}</td>
											<td class="date"><fmt:formatDate var="resultDate" 
													value="${ inquiry.writtenDate}" pattern="yyyy-MM-dd" />
												${resultDate}</td>
											<td class="updatedelete">
											</td>
											<td class="report">
											</td>
										</tr>
									</table>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="shipment">
					<div>
					<table class="tab_shipment">
                    <tr>
                        <td class="title_shipment">배송 안내</td>
                        <td class="subtitle_shipment"> 
                            <li>배송기간은 택배 배송 상품 기준, 주문일(또는 결제 완료일)로부터 영업일 기준 약 1일~5일 정도 소요됩니다. <br>&nbsp;&nbsp;&nbsp;&nbsp;
                            (※ 가구 등 직배송 상품은 상세페이지에 안내된 배송일정을 참조해 주세요.) </li> 
                            <li>기본 배송료는 2,500원입니다. (아트박스 배송 상품은, 주문금액이 30,000원 이상일 경우 무료배송)</li>
                            <li>업체 조건 배송 상품은 브랜드 별 배송 기준으로 배송비가 부여됩니다.</li>
                            <li>업체 착불 배송 상품은 해당 브랜드 배송 기준 및 고객님의 배송지에 따라 개별적으로 부과됩니다. <br>&nbsp;&nbsp;&nbsp;&nbsp;(가구 등 부피가 큰 상품이나, 도서산간 지역의 경우 추가 배송비용이 발생할 수 있습니다.)
                                <br>&nbsp;&nbsp;&nbsp;&nbsp;택배 배송의 특성상 지정일 배송은 불가합니다.</li>
                            <li>주문 제작 상품의 경우 제작 기간이 별도로 소요되오니 상품설명에 있는 제작 기간 및 배송 시기를 확인해 주세<br>&nbsp;&nbsp;&nbsp;&nbsp; 요.(DIY 상품, 주문 제작 상품 등)</li>
                         </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="shipment_space"> <hr></td>
                    </tr>
                    <tr>
                        <td class="title_shipment"> 교환/반품 정보</td>
                        <td class="subtitle_shipment">	
                            <p> 상품 수령 후 7일 이내에 신청할 수 있으며, 다음의 경우는 교환/반품 신청이 불가할 수 있습니다.</p>
                            <li>반품/교환 가능 기간이 경과된 경우</li>
                            <li>포장을 개봉하였거나 포장이 훼손되어 상품가치가 현저히 감소한 경우</li>
                            <li>고객의 주문을 확인한 후 상품 제작에 들어가는 주문 제작 상품인 경우</li>
                            <li>소비자가 책임 있는 사유로 상품 등이 멸실 또는 훼손된 경우</li>
                            <li>시간의 경과에 의해 재판매가 곤란할 정도로 상품 등의 가치가 현저히 감소한 경우</li>
                            <li>복제가 가능한 재화 등의 포장을 훼손한 경우</li>
                            <p>단순 변심에 의한 반품/교환 택배비는 고객님께서 부담하셔야 하며, 반품 접수 없이 임의로 반송하거나 우편으로 보낼 경우 상품 확인이 어려워 교환 및 환불이 불가할 수 있습니다.</p>

                            </td>
                    </tr>
                </table>
					</div>
				
				</div>
				<br> <br> <br> <br> <br><br> <br> <br> <br> <br>
			</div>


		<br> <br> <br> <br> <br>
		<!-- savePath -->

<input type="hidden" id="cartListCheck" value="${cartList}">
	</div>
	
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
<script type="text/javascript">

	
	$(function(){
		if(document.getElementById("likeDislike").value == '없음'){
			
		$("#like_btn").css({"color" : "#008916","background-color": "white"});
		}else{
			
		$("#like_btn").css({"color" : "white","background-color": "#008916"});
		}
		
	});
	
	function updateReply(Obj){
		
		document.getElementById('id01').style.display='block';		
 		
		document.getElementById("reviewNum").value = $(Obj).parents("tr").find('td').eq(0).html();

 	}
	
	function reportReply(Obj){
		
		document.getElementById('id02').style.display='block';		
 		
		document.getElementById("reportReplyNo").value = $(Obj).parents("tr").find('td').eq(0).html();
		document.getElementById("reportedPerson").value = $(Obj).parents("tr").find('td').eq(2).find('input').val();
		

 	}
	
	function updateInquiry(Obj){
		
		document.getElementById('id03').style.display='block';		
 		
		document.getElementById("inquiryNum").value = $(Obj).parents("tr").find('td').eq(0).html();

 	}
	
	 function viewInquiryReply(Obj){
		 
		document.getElementById("inquiryReplyNum").value = $(Obj).parents("tr").find('td').eq(0).html();
		 
		 var $inquiryReplyList = ${requestScope.selectInquiryReply};
			for(var i = 0; i < $inquiryReplyList.length; i++ ){
				
				if($inquiryReplyList[i].goodsinquiryNo.goodsInquiryNo == document.getElementById("inquiryReplyNum").value){
					
					document.getElementById("inquiryAnswerDiv").innerHTML = $inquiryReplyList[i].goodsReplyContent;
					document.getElementById('id04').style.display='block';		
				} 
			
		}
		
 	}  
	$("#repliedbtnYN").click(function(){
		
		document.getElementById("repliedbtnYN").disabled;
		alert('상품을 구매하신 후에 댓글을 이용하실 수 있습니다.');
	});
	
	
	$(".goinquiry").click(function(){
		
		window.open("", "네이버새창", "width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );

	});
	
	/* 문의사항 등록 */
	$("#inquirybtn").click(function(){
		
		var inquiryText = document.getElementById("inquirytext").value;
		if(inquiryText == ""){
			
			alert("댓글은 빈칸으로 작성할 수 없습니다. 댓글을 작성해주세요");
		} else{
		
		var inquiryText = document.getElementById("inquirytext").value; 
		var goodsNum = '${requestScope.selectOneGoodsInfo.goodsNum}';
		var userNum = '${ requestScope.loginMember.userNo}';
		/* var userNum = '${ session.loginMember.userNo}'; */
		
		$.ajax({
			
			url : "inquiry",
			data : {
					inquiryText : inquiryText,
					goodsNum : goodsNum,
					userNum : userNum
				},
			
			success : function(data) {
				
				 var section = $(".inquiry_div"); 
				 $(".inquiry_div").html(""); 
				var reset = "";
				document.getElementById("inquirytext").value = reset; 
				 $("#count2").html("0");
				
				 var postListdefault =  $("<table>");
	            	var moreListefault =   
               $("<table	style='width: 1000px; height: 100px; text-align: center;'>" +
               "<tr>" + "<td class='no' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"번호</td>" +
               "<td class='evaluate' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"문의내용</td>" +
               "<td class='author' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"작성자</td>" +
               "<td class='date' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"작성일</td>" +
               "<td class='updatedelete' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"수정 / 삭제</td>" +
               "<td class='report' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"답변보기</td>" +
 				"</tr>" + "</table>")
 				postListdefault.append(moreListefault);
	            	section.append(postListdefault);
	            	
                  for(var i = 0 ; i < data.length ; i++){
                 
                   /* 나중에 SESSION으로 바꾸기  */
	             	if(data[i].userNo.userNo == userNum){

	            		var postList =  $("<table>");
	 	            	var moreList = 

	            		$("<table style='width: 1000px; height: 100px; text-align: center;'>" +
	    				"<tr>" + "<td class='no'>" + data[i].goodsInquiryNo + "</td>" +
	    				"<td class='evaluate'>" + data[i].goodsInquiryContent + "</td>" +
	    				"<td class='author'>" + data[i].userNo.userName + "</td>" +
	    				"<td class='date'>" + data[i].writtenDate + "</td>" +
	    				"<td class='updatedelete'>" + 
	    				"<input type='hidden' id='inquiryNo' value='" + data[i].goodsInquiryNo + "'/>" +
	    				"<input type='hidden' id='reviewGoodsNo' value='" + data[i].goodsNumber.goodsNum + "'/>" +
	    				"<button id='btnUpdateInquiry' onclick='updateInquiry(this);' name='btnUpdateInquiry' class='btnUpdateInquiry w3-button w3-black'>" +
						"수정하기" + "</button>" + "  " + "<button type='button' id='btnDeleteInquiry' class='delete_btn w3-button w3-black' onclick='deleteReply(${ review.goodsReviewNum}, ${ review.goodsNum.goodsNum})'>" +
						"삭제하기" + "</button>" +	"<td class=report>" + 
						"<button id='viewInquiryReply' onclick='viewInquiryReply(this);' class='w3-button w3-black'>" + "답변보기" + "</button>" +
						"</td>" + "</tr>" + "</table>" )
						
						$("#btnDeleteInquiry").on('click');
                        $("#btnUpdateInquiry").on('click');

						
	                postList.append(moreList); 
	                section.append(postList);   
	    			
	            	} else {
	            		
	            		var postList =  $("<table>");
	 	            	var moreList = 
	 	            		
	            		$("<table style='width: 1000px; height: 100px; text-align: center;'>" +
   	    				"<tr>" + "<td class='no'>" + data[i].goodsInquiryNo + "</td>" +
   	    				"<td class='evaluate'>" + data[i].goodsInquiryContent + "</td>" +
   	    				"<td class='author'>" + data[i].userNo.userName + "</td>" +
   	    				"<td class='date'>" + data[i].writtenDate + "</td>" +
   	    				"<td class='updatedelete'>" + "</td>" + "<td class=report>" + 
   						"</td>" + "</tr>" + "</table>"  )
						
						$("#btnDeleteInquiry").on('click');
                        $("#btnUpdateInquiry").on('click');;
						
										
	                postList.append(moreList); 
	                section.append(postList); 
	            		
	            	}
                 } 	      
	          }, 	error: function(error, status){
				}
			});
		}
	});
	
	/* 댓글 등록 */
	$("#repliedbtn").click(function(){
		
		var replyText = document.getElementById("replytext").value;
		if(replyText == ""){
			
			alert("댓글은 빈칸으로 작성할 수 없습니다. 댓글을 작성해주세요");
		} else{
		
		var replytext = document.getElementById("replytext").value; 
		var goodsNum = '${requestScope.selectOneGoodsInfo.goodsNum}';
		var userNum = '${ requestScope.loginMember.userNo}';
		var payNum = '${ requestScope.paidNumber[0].paymentNo}';
		/* var userNum = '${ sessionScope.loginMember.userNo}'; */
		
		$.ajax({
			
			url : "reply",
			data : {
					replytext : replytext,
					goodsNum : goodsNum,
					userNum : userNum,
					payNum : payNum
				},
			
			success : function(data) {
				
				 var section = $(".reply_div"); 
				$(".reply_div").html("");  
				var reset = "";
				document.getElementById("replytext").value = reset; 
				 $("#count").html("0");
				 $("#replyCounting").text('상품후기(' + data.length + ')'); 
				 goodsReviewNum = data[0].goodsReviewNum; 
				 goodsNum = data[0].goodsNum.goodsNum;
				 
				 var postListdefault =  $("<table>");
	             var moreListefault =   
               $("<table	style='width: 1000px; height: 100px; text-align: center;'>" +
               "<tr>" + "<td class='no' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"번호</td>" +
               "<td class='evaluate' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"상품평</td>" +
               "<td class='author' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"작성자</td>" +
               "<td class='date' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"작성일</td>" +
               "<td class='updatedelete' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"수정 / 삭제</td>" +
               "<td class='report' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"신고</td>" +
 				"</tr>" + "</table>")
 				postListdefault.append(moreListefault);
	            	section.append(postListdefault);
	            	
                 for(var i = 0 ; i < data.length ; i++){
                 
                   /* 나중에 SESSION으로 바꾸기  */
	            	if(data[i].memNum.userNo == userNum){

	            		var postList =  $("<table>");
	 	            	var moreList = 
	 	            		


	            		$("<table style='width: 1000px; height: 100px; text-align: center;'>" +
	    				"<tr>" + "<td class='no'>" + data[i].goodsReviewNum + "</td>" +
	    				"<td class='evaluate'>" + data[i].goodsReviewContent + "</td>" +
	    				"<td class='author'>" + data[i].memNum.userName + "</td>" +
	    				"<td class='date'>" + data[i].reviewDate + "</td>" +
	    				"<td class='updatedelete'>" + 
	    				"<input type='hidden' id='commentNo' value='" + data[i].goodsReviewNum + "'/>" +
	    				"<input type='hidden' id='reviewGoodsNo' value='" + data[i].goodsNum.goodsNum + "'/>" +
	    				"<button id='btnUpdateReply' onclick='updateReply(this);' name='btnUpdateReply' class='btnUpdateReply w3-button w3-black'>" +
						"수정하기" + "</button>" + "  " + "<button type='button' id='btnDeleteReply' class='delete_btn w3-button w3-black' onclick='deleteReply(${ review.goodsReviewNum}, ${ review.goodsNum.goodsNum})'>" +
						"삭제하기" + "</button>" +	"<td class=report>" + 
						"</td>" + "</tr>" + "</table>" )
						
						$("#btnDeleteReply").on('click');
                        $("#btnUpdateReply").on('click');

						
	                postList.append(moreList); 
	                section.append(postList);   
	    			
	            	} else {
	            		
	            		var postList =  $("<table>");
	 	            	var moreList = 
	 	            		
	            		$("<table style='width: 1000px; height: 100px; text-align: center;'>" +
	    				"<tr>" + "<td class='no'>" + data[i].goodsReviewNum + "</td>" +
	    				"<td class='evaluate'>" + data[i].goodsReviewContent + "</td>" +
	    				"<td class='author'>" + data[i].memNum.userName + "</td>" +
	    				"<td class='date'>" + data[i].reviewDate + "</td>" +
	    				"<td class='updatedelete'>" + 
	    				"<input type='hidden' id='commentNo' value='" + data[i].goodsReviewNum + "'/>" +
	    				"<input type='hidden' id='reviewGoodsNo' value='" + data[i].goodsNum.goodsNum + "'/>" +
	    				"</td>" +
						"<td class='report'>" + "<button id='reportReply' onclick='reportReply(this);' class='w3-button w3-black'>" +
						"신고하기" + "</button>" + "</td>" +	"</tr>" + "</table>" )
						
						$("#btnDeleteReply").on('click');
                        $("#btnUpdateReply").on('click');
						
										
	                postList.append(moreList); 
	                section.append(postList); 
	            		
	            	}
                 }	      
	          }, 	error: function(error, status){
				}
			});
		}
	});
	
	
	
	<%--	 var no = document.getElementById("imgNo0").value;
		 var no = this.parentNode.children[0].value; 


	 function Img() {   
		 var test = "${requestScope.goodsAndFile.goodsFile[document.getElementById('imgNo0').value].savePath}";
	        document.getElementById("img").src = test;
    }--%>
	



    /* 신고 버튼 */


	/* 문의사항 삭제  ajax */
	$(document).on('click', '#btnDeleteInquiry', function() {
   
		
		if(confirm("문의내용을 삭제하시겠습니까?") == true){ 
			
			const $goodsInquiryNum = this.parentNode.children[0].value;
			const $goodsNum = this.parentNode.children[1].value;
			const userNum = ${sessionScope.loginMember.userNo};
			
			$.ajax({
				url : "inquiryDelete",
				method : "POST",
				data : {
					
					goodsInquiryNum : $goodsInquiryNum,
					goodsNum : $goodsNum
					
						},
				success : function(data){
					
					 var section = $(".inquiry_div"); 
					 $(".inquiry_div").html(""); 
					var reset = "";
					document.getElementById("inquirytext").value = reset; 
					 $("#count").html("0");
					
					 var postListdefault =  $("<table>");
		            	var moreListefault =   
	               $("<table	style='width: 1000px; height: 100px; text-align: center;'>" +
	               "<tr>" + "<td class='no' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"번호</td>" +
	               "<td class='evaluate' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"문의내용</td>" +
	               "<td class='author' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"작성자</td>" +
	               "<td class='date' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"작성일</td>" +
	               "<td class='updatedelete' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"수정 / 삭제</td>" +
	               "<td class='report' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"답변보기</td>" +
	 				"</tr>" + "</table>")
	 				postListdefault.append(moreListefault);
		            	section.append(postListdefault);
		            	
	                  for(var i = 0 ; i < data.length ; i++){
	                 
	                   /* 나중에 SESSION으로 바꾸기  */
		             	if(data[i].userNo.userNo == userNum){
		            		var postList =  $("<table>");
		 	            	var moreList = 
		            		$("<table style='width: 1000px; height: 100px; text-align: center;'>" +
		    				"<tr>" + "<td class='no'>" + data[i].goodsInquiryNo + "</td>" +
		    				"<td class='evaluate'>" + data[i].goodsInquiryContent + "</td>" +
		    				"<td class='author'>" + data[i].userNo.userName + "</td>" +
		    				"<td class='date'>" + data[i].writtenDate + "</td>" +
		    				"<td class='updatedelete'>" + 
		    				"<input type='hidden' id='inquiryNo' value='" + data[i].goodsInquiryNo + "'/>" +
		    				"<input type='hidden' id='reviewGoodsNo' value='" + data[i].goodsNumber.goodsNum + "'/>" +
		    				"<button id='btnUpdateInquiry' onclick='updateInquiry(this);' name='btnUpdateInquiry' class='btnUpdateInquiry w3-button w3-black'>" +
							"수정하기" + "</button>" + "  " + "<button type='button' id='btnDeleteInquiry' class='delete_btn w3-button w3-black' onclick='deleteInquiry(this);'>" +
							"삭제하기" + "</button>" +	"<td class=report>" + 
							"<button id='viewInquiryReply' onclick='viewInquiryReply(this);' class='w3-button w3-black'>" + "답변보기" + "</button>" +
							"</td>" + "</tr>" + "</table>" )
							
							$("#btnDeleteInquiry").on('click');
	                        $("#btnUpdateInquiry").on('click');

							
		                postList.append(moreList); 
		                section.append(postList);   
		    			
		            	} else {
		            		
		            		var postList =  $("<table>");
		 	            	var moreList = 
		 	            		
		            		$("<table style='width: 1000px; height: 100px; text-align: center;'>" +
	   	    				"<tr>" + "<td class='no'>" + data[i].goodsInquiryNo + "</td>" +
	   	    				"<td class='evaluate'>" + data[i].goodsInquiryContent + "</td>" +
	   	    				"<td class='author'>" + data[i].userNo.userName + "</td>" +
	   	    				"<td class='date'>" + data[i].writtenDate + "</td>" +
	   	    				"<td class='updatedelete'>" + "</td>" + "<td class=report>" + 
	   						"</td>" + "</tr>" + "</table>"  )
							
							$("#btnDeleteInquiry").on('click');
	                        $("#btnUpdateInquiry").on('click');;
							
											
		                postList.append(moreList); 
		                section.append(postList);
		            	}
	                 }	
				},
				error : function(error){
				}
			});
 		}else {
 		return;
	}
});	        

	 
	/* 댓글 삭제  ajax */
$(document).on('click', '#btnDeleteReply', function() {
   
		
		if(confirm("댓글을 삭제하시겠습니까?") == true){ 
			
			const $goodsReviewNum = this.parentNode.children[0].value;
			const $goodsNum = this.parentNode.children[1].value;
			const userNum = ${sessionScope.loginMember.userNo};
			
			$.ajax({
				url : "replyDelete",
				data : {
					
					goodsReviewNum : $goodsReviewNum,
					goodsNum : $goodsNum
					
						},
				success : function(data){
					
					var section = $(".reply_div"); 
					 $(".reply_div").html(""); 
					var reset = "";
					document.getElementById("replytext").value = reset; 
					 $("#count").html("0");
					  $("#replyCounting").text('상품후기(' + data.length + ')'); 
					 var postListdefault =  $("<table>");
		            	var moreListefault =   
	               $("<table	style='width: 1000px; height: 100px; text-align: center;'>" +
                      "<tr>" + "<td class='no' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"번호</td>" +
                      "<td class='evaluate' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"상품평</td>" +
                      "<td class='author' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"작성자</td>" +
                      "<td class='date' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"작성일</td>" +
                      "<td class='updatedelete' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"수정 / 삭제</td>" +
                      "<td class='report' style='background-color: #faae5a; font-size: 14pt; font-weight: 600;'>" +	"신고</td>" +
        				"</tr>" + "</table>")
	 				postListdefault.append(moreListefault);
		            	section.append(postListdefault);
		            	
	                 for(var i = 0 ; i < data.length ; i++){
	                 
		            	 
		            	if(data[i].memNum.userNo == userNum){

		            		 var postList =  $("<table>");
		 	            	var moreList = 
		 	            		
		 	            		$("<table style='width: 1000px; height: 100px; text-align: center;'>" +
		 	   	    				"<tr>" + "<td class='no'>" + data[i].goodsReviewNum + "</td>" +
		 	   	    				"<td class='evaluate'>" + data[i].goodsReviewContent + "</td>" +
		 	   	    				"<td class='author'>" + data[i].memNum.userName + "</td>" +
		 	   	    				"<td class='date'>" + data[i].reviewDate + "</td>" +
		 	   	    				"<td class='updatedelete'>" + 
		 	   	    				"<input type='hidden' id='commentNo' value='" + data[i].goodsReviewNum + "'/>" +
		 	   	    				"<input type='hidden' id='reviewGoodsNo' value='" + data[i].goodsNum.goodsNum + "'/>" +
		 	   	    				"<button id='btnUpdateReply' onclick='updateReply(this);' name='btnUpdateReply' class='btnUpdateReply w3-button w3-black'>" +
		 	   						"수정하기" + "</button>" + "  " + "<button type='button' id='btnDeleteReply' class='delete_btn w3-button w3-black'>" +
		 	   						"삭제하기" + "</button>" +	"<td class=report>" + 
		 	   						"<button id='reportReply' onclick='reportReply(this);' class='w3-button w3-black'>" + "신고하기" + "</button>" +
		 	   						"</td>" + "</tr>" + "</table>" )
		 	   						
		 	   						postList.append(moreList); 
	                				section.append(postList);  
		 	   						
		 	   						   $("#btnDeleteReply").on('click');
		 	                           $("#btnUpdateReply").on('click');
		    			
		            	} else {
		            		
		            		var postList =  $("<table>");
		 	            	var moreList = 
		 	            		
	 	            		$("<table style='width: 1000px; height: 100px; text-align: center;'>" +
	 	   	    				"<tr>" + "<td class='no'>" + data[i].goodsReviewNum + "</td>" +
	 	   	    				"<td class='evaluate'>" + data[i].goodsReviewContent + "</td>" +
	 	   	    				"<td class='author'>" + data[i].memNum.userName + "</td>" +
	 	   	    				"<td class='date'>" + data[i].reviewDate + "</td>" +
	 	   	    				"<td class='updatedelete'>" + 
	 	   	    				"<input type='hidden' id='commentNo' value='" + data[i].goodsReviewNum + "'/>" +
	 	   	    				"<input type='hidden' id='reviewGoodsNo' value='" + data[i].goodsNum.goodsNum + "'/>" +
	 	   	    				"</td>" +
	 	   						"<td class='report'>" + "<button id='reportReply' onclick='reportReply(this);' class='w3-button w3-black'>" +
	 	   						"신고하기" + "</button>" + "</td>" +	"</tr>" + "</table>" )
	 	   						
	 	   						postList.append(moreList); 
	                			section.append(postList);
	 	   						
	 	   						 $("#btnDeleteReply").on('click');
	 	                        $("#btnUpdateReply").on('click'); 
		            	}
	                 }	
				},
				error : function(error){
				}
			});
 		}else {
 		return;
	}
});	
 	  
    /* 장바구니 버튼 ajax */
    function cart(val1, val2) {
    	
    	if(confirm("장바구니에 등록하시겠습니까?") == true){
    		
    	
    	const goodsNum = val1;
    	const userNum = val2;
    	
    	$.ajax({
			url : "cart",
			method : "GET",
			data : {
				
				goodsNum : goodsNum,
				userNum : userNum
				
					},
			success : function(data){
			 	const message = data.message;
				if(message){
					alert(message);
				}	 
				document.getElementById("cartListCheck").value = data.cart;
			},
			error : function(error){
				
			}
		});
    	} else{
    		return;
    	}
    }

	
    
    /* 바로구매 버튼 */
     function buyGoods(val1, val2) {
    	
    	const goodsNum = val1;
     	const memNum = ${requestScope.loginMember.userNo};
     	const count = document.getElementById("quantities").value;
     	var order =  document.getElementById("cartListCheck").value;
     	/* 이미 주문한 상태인 경우  변수를 다르게 가져오자 */
     	
     	if(count == 0){
     		alert("수량을 선택해주세요!");
     	} else {
     	
    	if(order === "없음"){
    		
    		if(confirm("바로 구매를 하시겠습니까?") == true){
    		
    	location.href = "${ pageContext.servletContext.contextPath }/goods/newOrder?goodsNum=" + goodsNum + "&memNum=" + memNum + "&count=" + count;
    		
    		return;
    		
    	} else {
    		
    		return;
    	}
    	
    	}else{
    		
    		if(confirm("이미 주문 상품에 담겨 있습니다. 주문 상품 페이지로 가시겠습니까?") == true){
    			
    			location.href = "${ pageContext.servletContext.contextPath }/goods/order?goodsNum=" + goodsNum + "&memNum=" + memNum + "&count=" + count;
    	    	
    			return;
    		}else{
    			return;
    		}
    	}
    	
     	}
    } 
    
    /* 후기 100자 초과시 초과되었다고 알림 */
  	$(function(){
	
	  $("#replytext").keyup(function(){
		
		  var inputLength = $(this).val().length;
		  
		  $("#count").text(inputLength);
		  
		  var replyRemain = 50 - inputLength;
		  
		  if(replyRemain >= 0) {
			  
               $("#count").parent().css("color","black");
               
               const target = document.getElementById('repliedbtn');
               target.disabled = false;
           }else{
               $("#count").parent().css("color","red");
               
               const target = document.getElementById('repliedbtn');
               target.disabled = true;
               
            }
	  });
	  
  });
    
    /* 후기 100자 초과시 초과되었다고 알림 */
  	$(function(){
	
	  $("#inquirytext").keyup(function(){
		
		  var inputLength = $(this).val().length;
		  
		  $("#count2").text(inputLength);
		  
		  var replyRemain = 50 - inputLength;
		  
		  if(replyRemain >= 0) {
			  
               $("#count2").parent().css("color","black");
               
               const target = document.getElementById('inquirybtn');
               target.disabled = false;
           }else{
               $("#count2").parent().css("color","red");
               
               const target = document.getElementById('inquirybtn');
               target.disabled = true;
               
            }
	  });
	  
  });
  
  function likebtn(val1, val2){
    	
		const goodsNum = val1;
     	const memNum = val2;
     	var like = document.getElementById("likeDislike").value;
     	
     	if(like === "없음"){
     		
     		alert('좋아요에 추가를 하였습니다.');
			$.ajax({
     			
     			url : "like",
    			method : "GET",
    			data : {
    				
    				goodsNum : goodsNum,
    				memNum : memNum
    				
    					},
    			success : function(data){
    				
    				document.getElementById("likeDislike").value =  "있음";
    				$("#like_btn").css({"color" : "white","background-color": "#008916"});
    				

    			},
    			error : function(error){
    				
    			}
     		});
     	} else if(like === "있음"){
     		
     		alert('좋아요를 취소하였습니다');

		$.ajax({
     			
     			url : "dislike",
    			method : "GET",
    			data : {
    				
    				goodsNum : goodsNum,
    				memNum : memNum
    				
    					},
    			success : function(data){
    				document.getElementById("likeDislike").value =  "없음";
    				$("#like_btn").css({"color" : "#008916","background-color": "white"});
    			},
    			error : function(error){
    				
    			}
     		});
     		
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
    </script>
    <jsp:include page="../common/footer.jsp"/>
</body>
</html>

