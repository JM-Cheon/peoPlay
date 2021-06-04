<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/member/member.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
	const message = '${ requestScope.message }';
	if(message != null && message !== '') {
		alert(message);
	}
</script>
</head>
<body>
	<div id="wrap">
	<jsp:include page="../common/header.jsp"/>
        <main class="main">
            <div class="subscribe_main">
                <div class="subscribe_box">
                    <div class="welcome">
                        SUBSCRIBE PAYMENT
                    </div>
                    <div class="subscribe_contents">
                        <div class="subscribe_content" id="oneMonth">
                            <p class="subscribe_month">1개월 구독권</p>
                            <p class="subscribe_price">₩12,000원/월</p>
                            <form name="oneMonthForm" action="${ pageContext.servletContext.contextPath }/member/subscribe" method="POST">
								<input type="hidden" name="subscriptionNumber" value="1" />
								<input type="hidden" name="userNo" value="${ sessionScope.loginMember.userNo }" />
								<input type="hidden" name="subscribeValidity" value="${ sessionScope.loginMember.subscribeValidity }" />
							</form>
                        </div>
                        <div class="subscribe_content" id="threeMonth">
                            <p class="subscribe_month">3개월 구독권</p>
                            <p class="subscribe_price">₩11,500원/월</p>
                            <form name="threeMonthForm" action="${ pageContext.servletContext.contextPath }/member/subscribe" method="POST">
								<input type="hidden" name="subscriptionNumber" value="2" />
								<input type="hidden" name="userNo" value="${ sessionScope.loginMember.userNo }" />
								<input type="hidden" name="subscribeValidity" value="${ sessionScope.loginMember.subscribeValidity }" />
							</form>
                        </div>
                        <div class="subscribe_content" id="oneYear">
                            <p class="subscribe_month">12개월 구독권</p>
                            <p class="subscribe_price">₩10,000원/월</p>
                            <form name="oneYearForm" action="${ pageContext.servletContext.contextPath }/member/subscribe" method="POST">
								<input type="hidden" name="subscriptionNumber" value="3" />
								<input type="hidden" name="userNo" value="${ sessionScope.loginMember.userNo }" />
								<input type="hidden" name="subscribeValidity" value="${ sessionScope.loginMember.subscribeValidity }" />
							</form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
	<jsp:include page="../common/footer.jsp"/>
	</div>
	<script>
		var msg = "";
	    $(function(){
	        IMP.init('imp78469933');
	    });
	    
	    $("#oneMonth").click(function(){
	        IMP.request_pay({
	            pg : 'kakaopay',
	            pay_method : 'card',
	            merchant_uid : 'merchant_' + new Date().getTime(),
	            name : '1개월 구독권 결제',
	            amount : 12000,
	            buyer_userNo : '${sessionScope.loginMember.userNo}'
	        }, function(rsp) {
	        	if ( rsp.success ) {
	                document.oneMonthForm.submit();
	            } else {
	            	msg = '결제에 실패하였습니다.\n';
	                msg += '에러내용 : ' + rsp.error_msg;
		            alert(msg);
	                location.href='${pageContext.servletContext.contextPath}/member/subscribe';
	            }
	        });
	    });

	    $("#threeMonth").click(function(){
	        IMP.request_pay({
	            pg : 'kakaopay',
	            pay_method : 'card',
	            merchant_uid : 'merchant_' + new Date().getTime(),
	            name : '3개월 구독권 결제',
	            amount : 34500,
	            buyer_userNo : '${sessionScope.loginMember.userNo}'
	        }, function(rsp) {
	        	if ( rsp.success ) {
	                document.threeMonthForm.submit();
	            } else {
	            	msg = '결제에 실패하였습니다.\n';
	                msg += '에러내용 : ' + rsp.error_msg;
		            alert(msg);
	                location.href='${pageContext.servletContext.contextPath}/member/subscribe';
	            }
	        });
	    });

	    $("#oneYear").click(function(){
	        IMP.request_pay({
	            pg : 'kakaopay',
	            pay_method : 'card',
	            merchant_uid : 'merchant_' + new Date().getTime(),
	            name : '12개월 구독권 결제',
	            amount : 120000,
	            buyer_userNo : '${sessionScope.loginMember.userNo}'
	        }, function(rsp) {
	        	if ( rsp.success ) {
	        		document.oneYearForm.submit();
	            } else {
	            	msg = '결제에 실패하였습니다.\n';
	                msg += '에러내용 : ' + rsp.error_msg;
		            alert(msg);
	                location.href='${pageContext.servletContext.contextPath}/member/subscribe';
	            }
	        });
	    });
    </script>
</body>
</html>