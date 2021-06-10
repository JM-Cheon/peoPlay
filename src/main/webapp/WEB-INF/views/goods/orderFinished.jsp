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
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/goods/goodsOrderFinished.css">

</head>

<body>
<jsp:include page="../common/header.jsp"/>
    <br><br><br><br><br><br>
    <div id="wrapper">
    <p style="font-size: 16pt; font-weight: 800; color: #008916;">주문 결제 </p>
    <br>
<hr style=" border-color: #008916; font-weight: 800;">
        <section id="sec1">
            <div class="order">
                <div class="order_message1">
                    주문이 확인되었습니다.
                </div>
                <div class="order_message2">	
                    <p>
결제가 확인이 되는대로 배송이 시작됩니다. <br>
정확한 배송 일정은 문의주시기 바랍니다.
                    </p>
                    
                </div>
                <div id="order_table">
                    <table class="order_table">
                        <tr>
                            <td class="order_table_title">주문 번호 : </td>
                            <td class="order_table_sub_title">${requestScope.selectDeliveryInfo.paymentNum.paymentNo }</td>
                        </tr>
                        <tr >
                            <td class="order_table_title" >배송지 정보 : </td>
                            <td class="order_table_sub_title">${requestScope.selectDeliveryInfo.userNo.userAddress }</td>
                        </tr>
                        <tr>
							<td></td>
                            <td class="order_table_sub_title">${requestScope.selectDeliveryInfo.userNo.userName } </td>
                        </tr>
                        <tr>
							<td></td>
                            <td class="order_table_sub_title"> ${requestScope.selectDeliveryInfo.userNo.phone }</td>
                        </tr>
                        <tr>
                            <td class="order_table_title">배송 메모 : </td>
                            <td class="order_table_sub_title">${deliveryCode }</td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="order_list">
                <div class="order_list2">
                    <table class="order_table">
                        <tr>
                            <td rowspan="3" class="order_tab_img_td"><img src="../front/imgsample/재활용.PNG" alt="" class="order_tab_img"></td>
                            <td class="order_product" style="font-family: '맑은 고딕'">${requestScope.selectDeliveryInfo.goodsNum.goodsName }</td>
                        </tr>
                        <tr> 
                            <td class="order_product_price" style="font-family: '맑은 고딕'">상품 금액 : ${requestScope.selectDeliveryInfo.paymentNum.paymentPrice } 원</td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="total_price">
                <div class="total_price_div">
                    <table  class="total_price_tab">
                        <tr>
                            <td class="total_price_title">상품 금액 : </td>
                            <td class="total_price_sub_title">${requestScope.selectDeliveryInfo.paymentNum.paymentPrice } 원</td>
                        </tr>
                        <tr>
                            <td colspan="2" class="total_price_space"></td>
                        </tr>
                        <tr>
                            <td colspan="2"> <hr class="hr2"> </td>

                        </tr>
                        <tr>
                            <td colspan="2" class="total_price_space"></td>
                        </tr>
                        <tr>
                            <td class="total_price_title">최종 결제 금액 : </td>
                            <td class="total_price_sub_title">${requestScope.selectDeliveryInfo.paymentNum.paymentPrice } 원</td>
                        </tr>
                    </table>
                </div>
            </div>
        </section>

        <hr style=" border-color: #008916; font-weight: 800;">

        
            <br><br><br><br>

    </div>
    <jsp:include page="../common/footer.jsp"/>
</body>

</html>