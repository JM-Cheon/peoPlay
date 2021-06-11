<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<head>
    <meta charset="UTF-8">
    <title>peoPlay</title>
	<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
	<link rel="stylesheet" href="/peoplay/resources/css/goods/goodsOrder.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
	
    <style>
    </style>
</head>
<jsp:include page="../common/header.jsp"/>
	
<body>

    <br><br><br><br><br>
    <div id="wrapper">
    <div class="mainText">주문 결제</div>
    <br>
    <hr color = #008916>
    <br>
    <section id="sec">
        <div id="div">   
            <article id="article1">
	                		<div class="mainText">주문자 정보</div>
                <fieldset class="fd_All fdInfo" style="position: relative; top: 17px;">
                        <div class="order_info">
                            <div class="spaceInfo"> 이름 : ${ orderInfo.userNo.userName}
                            </div>
                            <div class="spaceInfo">전화번호 : ${ orderInfo.userNo.phone}
                            </div>
                            <div class="spaceInfo"> 배송지 : ${ fn:split(orderInfo.userNo.userAddress, '$')[1]}
                            </div>
                        </div>
                </fieldset>
            </article>
            <br>
            <article id="article2">
                    <div class="mainText order">주문 상품</div>
                    <fieldset class="fd_All orderfd">
                        <div class="order_product">
                            <img class="prd1" align="left" src="/peoplay/resources/images/goods/goodsImageFiles/${requestScope.goodsAndFile.goodsFile[0].fileSaveName}">
                        </div>
                        <div class="orderInfo">
                               <p class="contentsInfo"> 이름 : ${ orderInfo.goodsNo.goodsName}</p> 
				               <p class="contentsInfo"> 종류 : ${ orderInfo.goodsNo.goodsCompany}</p> 
				               <p class="contentsInfo"> 수량 : <input min="1" type="number" value="${ orderInfo.orderCount}" id="counts" class="counts" style="border: 1px solid; width: 30px;"></p> 
                        </div>
                        <div class="orderTotalPrice"> <p class="priceTag" id="subReTotalPrice">가격 : ${totalPrice }원 </p>
                        </div>
                    </fieldset>
            </article>
            <br>

            <br>

            <article>
                <div class="mainText payment">결제수단</div>
                <fieldset class="fd_All paymentway">
                    <div align="center" class="div_kakao">
                    <img alt="" src="/peoplay/resources/images/goods/카카오사진.PNG" class="img_kakako">
                    </div>
                </fieldset>
            </article>
        </div>


        <aside>
            <div class="mainText">결제예정금액</div>
            <fieldset class="orderfied">
                <div style="position: relative; top: 26px;">
                    <table>
                        <tr>
                            <td class="payment_title">상품 금액</td>
                            <td id="rePrice" class="payment_sub_title">${ orderInfo.goodsNo.goodsPrice} 원</td>
                        </tr>
                        
                        <tr>
                            <td class="payment_title">할인 금액</td>
                            <td id="rePrice" class="payment_sub_title"> 원</td>
                        </tr>
                        <tr>
                            <td class="payment_title">최종 결제</td>
                            <td id="reTotalPrice" class="payment_sub_title"> ${totalPrice } 원</td>
                        </tr>
                    </table>
                  
                    <br>
                    <div align="right" class="agreement" >
                        		주문/결제 이용 동의 <input type="checkbox" id="agreement" class="agreementCheck">
                    </div>
                    <div align="center"><br>
                    	<form id="payGoods" action="${ pageContext.servletContext.contextPath }/goods/payGoods" method="post">
						 	<div class="delivery">배송구분</div><br>
                             <select id="deliveryCode" name="deliveryCode" style="font-size: 15px; align-content: center; position: relative;
    left: -8px;" >
				                <option value="1" >집 앞에 놓아주세요.</option>
				                <option value="2">경비실에 맡겨주세요.</option>
				                <option value="3">부재시 문 앞에 놓아주세요.</option>
				                <option value="4">택배함에 넣어주세요.</option>                
				       		 </select>                        
				       	<input type="hidden" value="${ orderInfo.goodsNo.goodsName}" id="goodsName" name="goodsName">
				       	<input type="hidden" value="${ orderInfo.goodsNo.goodsNum}" id=goodsNum name="goodsNum">
                    	<input type="hidden" value="${ orderInfo.orderNo}" id="orderNo" name="orderNo">
                    	<input type="hidden" value="${ orderInfo.userNo.userName}" id="userName" name="userName">
                    	<input type="hidden" value="${ orderInfo.userNo.email}" id="email" name="email">
                    	<input type="hidden" value="${ orderInfo.userNo.userNo}" id="userNo" name="userNo">
                    	<input type="hidden" value="${ orderInfo.userNo.phone}" id="phone" name="phone">
                    	<input type="hidden" value="${ orderInfo.userNo.userAddress}" id="userAddress" name="userAddress">
                    	<input type="hidden" value="${ orderInfo.goodsNo.goodsPrice}" id="goodsPrice" name="goodsPrice">
                    	<input type="hidden" value="${ totalPrice}" id="totalPrice" name="totalPrice">
                    	<input type="hidden" value="${ totalPrice}" id="totalPrice2" name="totalPrice2">
                    	<input type="hidden" value="${ orderInfo.orderCount}" id="quantities" name="quantities">
                        <button id="payKakao" class="payKakao" type="button" style="position: relative; bottom: 30px;" >주문하기</button>
                   	</form>
                   	<br>
                       <!--  <button id="cancel" class="cancel" type="button" style="position: relative; bottom: 30px;">주문취소 또는 메인으로</button> -->
                    </div>
                </div>
            </fieldset>
        </aside>
    </section>
    
</div>
<br><br><br><br><br>
<br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br>
<br><br><br><br><br>

<script type="text/javascript">
$(document).on('click', '.cancel', function() {
	
	const orderNum = document.getElementById("orderNo").value;
	const goodsNo = document.getElementById("goodsNum").value;
	
	if(confirm("주문을 취소하시겠습니까?") == true){
    	location.href = "${ pageContext.servletContext.contextPath }/goods/cancel?orderNum=" + parseInt(orderNum) + "&goodsNo=" + parseInt(goodsNo);
	} else {
		return;
	}
});


	$('.counts').on("click",function() {

		const count = document.getElementById("counts").value;

		const orderNo = document.getElementById("orderNo").value;

		$.ajax({

			url : "recalculate",
			method : "GET",
			data : {

				orderNo : orderNo,
				count : count

			},
			success : function(data) {

				document.getElementById("rePrice").innerHTML = "";
				document.getElementById("rePrice").innerHTML = data.goodsNo.goodsPrice + '원';
				
				document.getElementById("reTotalPrice").innerHTML = "";
				document.getElementById("reTotalPrice").innerHTML = (data.goodsNo.goodsPrice * data.orderCount) + '원';
				document.getElementById("totalPrice2").value = (data.goodsNo.goodsPrice * data.orderCount);
				document.getElementById("totalPrice").value = document.getElementById("reTotalPrice").innerHTML;
				
				document.getElementById("subReTotalPrice").innerHTML = "";
				document.getElementById("subReTotalPrice").innerHTML = '가격 : ' + (data.goodsNo.goodsPrice * data.orderCount) + '원';
				document.getElementById("totalPrice2").value = (data.goodsNo.goodsPrice * data.orderCount);
				document.getElementById("totalPrice").value = document.getElementById("reTotalPrice").innerHTML;
			
			},
			error : function(error){
				
			}

		});

	});

	$(document).on('click', '.payKakao', function() {
		/* var a = 0;
		if (a == 0){
			a = 1;
		} */
		
		var $checkbox = $('#agreement'); 

		if($checkbox.prop('checked') == false){
			
			alert("약관에 동의해 주세요");
			return;
		}
		
		$(function() {
			IMP.init('imp66805185');

			IMP.request_pay({
				pg : 'kakaopay',
				pay_method : 'card',
				merchant_uid : 'merchant_' + new Date().getTime(),
				name : document.getElementById("goodsName").value,
				amount : document.getElementById("totalPrice2").value,
				buyer_email : document.getElementById("email").value,
				buyer_name : document.getElementById("userName").value,
				buyer_tel : document.getElementById("phone").value,
				buyer_addr : document.getElementById("userAddress").value,
			}, function(rsp) {
				if (rsp.success) {

					document.getElementById("payGoods").submit();
				} else {
					alert('실패');
				}

			});

		});
	});
</script>

<jsp:include page="../common/footer.jsp"/>
</body>

</html>