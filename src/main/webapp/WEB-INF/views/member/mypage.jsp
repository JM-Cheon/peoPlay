<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PeoPlay</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/member/member.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
            <div class="mypage_main">
                <div class="mypage_box">
                    <div class="my_nav">
                        <ul>
                            <li class="my_nav_line on">홈</li>
                        </ul>
                        <p class="my_nav_line">회원</p>
                        <ul>
                            <li>회원정보수정</li>
                            <li>구독권 결제내역</li>
                            <li>문의내역</li>
                            <li>내가 쓴 게시글</li>
                            <li>비밀번호변경</li>
                            <li>회원탈퇴</li>
                        </ul>
                        <p class="my_nav_line">영화</p>
                        <ul>
                            <li>내가 찜한 콘텐츠</li>
                            <li>시청내역</li>
                        </ul>
                        <p class="my_nav_line">굿즈</p>
                        <ul>
                            <li>장바구니</li>
                            <li>내가 찜한 상품</li>
                            <li>상품주문내역</li>
                        </ul>
                    </div>
                    <div class="my_contents">
                        <div class="my_home on">
                            <div>
                            	<c:set var="today" value="<%=new java.util.Date()%>" />
                            	<c:if test="${ sessionScope.loginMember.subscribeValidity != null && sessionScope.loginMember.subscribeValidity >= today }">
	                                <p>구독만료일 : ${ sessionScope.loginMember.subscribeValidity }</p>
                            	</c:if>
                            	<c:if test="${ sessionScope.loginMember.subscribeValidity == null || sessionScope.loginMember.subscribeValidity < today }">
	                                <p>구독만료일 : 구독권 없음 </p>
                            	</c:if>
                                <button id="movie"></button>
                                <button id="board"></button>
                                <hr>
                                <div>
                                    <p>시청 내역</p>
                                	<c:forEach var="watch" items="${ requestScope.watchList }" begin="0" end="5">
			                            <div class="movie" onClick="location.href='${pageContext.servletContext.contextPath}/movie/${ watch.no }'">
			                                <c:forEach var="movieImg" items="${ watch.movieFile }">
										        <c:if test="${ movieImg.fileType == 'SUB' }">
											        <img src="${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/${ movieImg.saveName }">
										        </c:if>
									        </c:forEach>
			                            	<p>${ watch.name }</p>
			                        	</div>
	                                </c:forEach>
                                </div>
                                <hr>
                                <div>
                                    <p>내가 찜한 컨텐츠</p>
                                    <c:forEach var="zzim" items="${ requestScope.zzimList }" begin="0" end="5">
			                            <div class="movie" onClick="location.href='${pageContext.servletContext.contextPath}/movie/${ zzim.no }'">
			                                <c:forEach var="movieImg" items="${ zzim.movieFile }">
										        <c:if test="${ movieImg.fileType == 'SUB' }">
											        <img src="${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/${ movieImg.saveName }">
										        </c:if>
									        </c:forEach>
			                            	<p>${ zzim.name }</p>
			                        	</div>
	                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="my_modify">
                            <div>
                                <p>회원정보수정</p>
                                <hr>
                                <form action="${ pageContext.servletContext.contextPath }/member/modifyMember" method="post">
                                    <table>
                                        <tr>
                                            <td width="100">아이디 : </td>
                                            <td width="300"><input type="text" name="userId" class="my_modify_input" value="${ sessionScope.loginMember.userId }" readonly></td>
                                            <td width="100"></td>
                                        </tr>
                                        <tr>
                                            <td width="100">비밀번호 : </td>
                                            <td width="300"><input type="password" name="userPwd" class="my_modify_input" required></td>
                                            <td width="100"></td>
                                        </tr>
                                        <tr>
                                            <td width="100">이름 : </td>
                                            <td width="300"><input type="text" name="userName" class="my_modify_input" value="${ sessionScope.loginMember.userName }" required></td>
                                            <td width="100"></td>
                                        </tr>
                                        <tr>
                                            <td width="100">닉네임 : </td>
                                            <td width="300"><input type="text" name="nickname" class="my_modify_input" value="${ sessionScope.loginMember.nickname }" readonly></td>
                                            <td width="100"></td>
                                        </tr>
                                        <tr>
                                            <td width="100">이메일 : </td>
                                            <td width="300">
                                                <input type="text" class="my_modify_email_input" name="email1" value="${ fn:split(sessionScope.loginMember.email,'@')[0] }" required>
                                                @  
                                                <select name="email2" class="my_modify_email_select">
                                                    <option value="naver.com"<c:if test="${ fn:split(sessionScope.loginMember.email,'@')[1] eq 'naver.com' }">selected</c:if>>naver.com</option>
                                                    <option value="gmail.com"<c:if test="${ fn:split(sessionScope.loginMember.email,'@')[1] eq 'gmail.com' }">selected</c:if>>gmail.com</option>
                                                </select>
                                            </td>
                                            <td width="100"></td>
                                        </tr>
                                        <tr>
                                            <td width="100">생년월일 : </td>
                                            <td width="300"><input type="date" name="birthday" class="my_modify_input" value="${ sessionScope.loginMember.birthday }" required></td>
                                            <td width="100"></td>
                                        </tr>
                                        <tr>
                                            <td width="100">전화번호 : </td>
                                            <td width="300"><input type="tel" name="phone" class="my_modify_input" value="${ sessionScope.loginMember.phone }" required></td>
                                            <td width="100"></td>
                                        </tr>
                                        <tr>
                                            <td width="100">우편번호 : </td>
                                            <td width="300"><input type="text" name="zipCode" class="my_modify_input" value="${ fn:split(sessionScope.loginMember.userAddress,'$')[0] }" readonly></td>
                                            <td width="100"><button id="searchAddress" id="zipCode" class="my_modify_button" type="button">검색</button></td>
                                        </tr>
                                        <tr>
                                            <td width="100">주소 : </td>
                                            <td width="300"><input type="text" name="address" id="address" class="my_modify_input" value="${ fn:split(sessionScope.loginMember.userAddress,'$')[1] }" readonly></td>
                                            <td width="100"></td>
                                        </tr>
                                        <tr>
                                            <td width="100">상세주소 : </td>
                                            <td width="300"><input type="text" name="detailAddress" id="detailAddress" class="my_modify_input" value="${ fn:split(sessionScope.loginMember.userAddress,'$')[2] }" required></td>
                                            <td width="100"></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3" width="550"><button class="my_modify_submit_button" type="submit">수정하기</button></td>
                                        </tr>
                                    </table>
                                </form>
                            </div>
                        </div>
                        <div class="my_subscribeHistory">
                            <div>
                                <p>구독권 결제내역</p>
                                <hr>
                                <div>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th class="my_subscribeHistory_title">구독권명</th>
                                                <th class="my_subscribeHistory_title">결제일시</th>
                                                <th class="my_subscribeHistory_title">구독만료일</th>
                                                <th class="my_subscribeHistory_title">결제금액</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach var="payment" items="${ requestScope.paymentList }">
                                            <tr>
                                                <td class="my_subscribeHistory_body">${ payment.subscription.name }</td>
                                                <td class="my_subscribeHistory_body">${ payment.paymentDate }</td>
                                                <td class="my_subscribeHistory_body">${ payment.paymentValidity }</td>
                                                <td class="my_subscribeHistory_body">${ payment.paymentPrice }</td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="my_askHistory">
                            <div>
                                <p>문의내역</p>
                                <hr>
                                <div>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th class="my_askHistory_title">번호</th>
                                                <th class="my_askHistory_titleoftitle">제목</th>
                                                <th class="my_askHistory_title">작성일자</th>
                                                <th class="my_askHistory_title">공개여부</th>
                                                <th class="my_askHistory_title">답변여부</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="ask" items="${ requestScope.askList }">
                                            <tr onClick="location.href='${ pageContext.servletContext.contextPath }/QNA/qnaDetail/' + ${ ask.inquiryNo }">
                                                <td class="my_subscribeHistory_body">${ ask.inquiryNo }</td>
                                                <td class="my_subscribeHistory_body">${ ask.inquiryTitles }</td>
                                                <td class="my_subscribeHistory_body">${ ask.creationDate }</td>
                                                <c:if test="${ ask.disclosureStatus == 'Y' }">
                                                	<td class="my_subscribeHistory_body">공개</td>
                                                </c:if>
                                                <c:if test="${ ask.disclosureStatus == 'N' }">
                                                	<td class="my_subscribeHistory_body">비공개</td>
                                                </c:if>
                                                <c:if test="${ ask.inquiryYn == 'Y' }">
                                                	<td class="my_subscribeHistory_body">답변완료</td>
                                                </c:if>
                                                <c:if test="${ ask.inquiryYn == 'N' }">
                                                	<td class="my_subscribeHistory_body">미답변</td>
                                                </c:if>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="my_board">
                            <div>
                                <p>내가 쓴 게시글</p>
                                <hr>
                                <div>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th class="my_board_title">번호</th>
                                                <th class="my_board_titleoftitle">제목</th>
                                                <th class="my_board_title">조회수</th>
                                                <th class="my_board_title">작성일자</th>
                                                <th class="my_board_title">댓글수</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="board" items="${ requestScope.memberBoardList }">
                                            <tr onClick="location.href='${ pageContext.servletContext.contextPath }/board/detail?no=' + ${ board.no }">
                                                <td class="my_subscribeHistory_body">${ board.no }</td>
                                                <td class="my_subscribeHistory_body">${ board.title }</td>
                                                <td class="my_subscribeHistory_body">${ board.view }</td>
                                                <td class="my_subscribeHistory_body">${ board.creationDate }</td>
                                                <td class="my_subscribeHistory_body">${ board.commentCount }</td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="my_modifyPwd">
                            <div>
                                <p>비밀번호변경</p>
                                <hr>
                                <div>
                                    <div>
                                        <p>
											기존 비밀번호를 입력하셔야 비밀번호 변경이 가능합니다.
                                        </p>
                                        <form action="${ pageContext.servletContext.contextPath }/member/modifyPwd" method="post">
                                            <input type="hidden" name="userId" value="${ sessionScope.loginMember.userId }">
                                            <div>
												기존비밀번호 : <input type="password" name="nowUserPwd" required>
                                            </div>
                                            <div>
												변경하실 비밀번호 : <input type="password" id="userPwd" name="userPwd" required>
                                            </div>
                                            <div>
												비밀번호확인 : <input type="password" id="userPwdYN" name="userPwdYN" required>
                                            </div>
                                            <p id="pwCheckResult" class="pRight">비밀번호는 영문, 숫자, 특수문자 포함 6~12자리로 작성해주세요.</p>
                                            <div>
                                                <button type="submit" onclick="return check()">비밀번호변경</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="my_delete">
                            <div>
                                <p>회원탈퇴</p>
                                <hr>
                                <div>
                                    <div>
                                        <p>
											정말 탈퇴하시겠다면<br>
											비밀번호를 입력해주세요
                                        </p>
                                        <form action="${ pageContext.servletContext.contextPath }/member/removeMember" method="post">
                                        	<input type="hidden" name="userId" value="${ sessionScope.loginMember.userId }">
                                            <input type="password" name="userPwd" required>
                                            <button type="submit">Destroy</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="my_wishlist">
                            <div>
                                <p>내가 찜한 컨텐츠</p>
                                <hr>
                                <div>
                                	<c:forEach var="zzim" items="${ requestScope.zzimList }">
			                            <div class="movie" onClick="location.href='${pageContext.servletContext.contextPath}/movie/${ zzim.no }'">
			                                <c:forEach var="movieImg" items="${ zzim.movieFile }">
										        <c:if test="${ movieImg.fileType == 'SUB' }">
											        <img src="${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/${ movieImg.saveName }">
										        </c:if>
									        </c:forEach>
			                            	<p>${ zzim.name }</p>
			                        	</div>
	                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="my_watchList">
                            <div>
                                <p>시청내역</p>
                                <hr>
                                <div>
                                	<c:forEach var="watch" items="${ requestScope.watchList }">
			                            <div class="movie" onClick="location.href='${pageContext.servletContext.contextPath}/movie/${ watch.no }'">
			                                <c:forEach var="movieImg" items="${ watch.movieFile }">
										        <c:if test="${ movieImg.fileType == 'SUB' }">
											        <img src="${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/${ movieImg.saveName }">
										        </c:if>
									        </c:forEach>
			                            	<p>${ watch.name }</p>
			                        	</div>
	                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="my_basket">
                            <div>
                                <p>장바구니</p>
                                <hr>
                                <div>
                                	<c:forEach var="basket" items="${ requestScope.basketList }">
			                            <div class="movie" onClick="location.href='${pageContext.servletContext.contextPath}/goods/order?goodsNum=' + ${ basket.goodsNum.goodsNum } + '&memNum=' + ${ basket.userNum.userNo } + '&count=' + ${ basket.cartCount }">
											<img src="/peoplay/resources/images/goods/goodsImageFiles/${basket.goodsNum.goodsFiles[0].fileSaveName}">
			                            	<p>${ basket.goodsNum.goodsName }</p>
			                        	</div>
	                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="my_goods">
                            <div>
                                <p>내가 찜한 상품</p>
                                <hr>
                                <div>
                               		<c:forEach var="goods" items="${ requestScope.goodsLikeList }">
			                            <div class="movie" onClick="location.href='${pageContext.servletContext.contextPath}/goods/' + ${ goods.goodsNum.goodsNum }">
											<img src="/peoplay/resources/images/goods/goodsImageFiles/${goods.goodsNum.goodsFiles[0].fileSaveName}">
			                            	<p>${ goods.goodsNum.goodsName }</p>
			                        	</div>
	                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="my_productHistory">
							<div>
                                <p>상품 주문 내역</p>
                                <hr>
                                <div>
                                	<%-- 
                                    <c:forEach var="basket" items="${ requestScope.paymentList }">
	                                	<div><img src=""><p></o></div>
                                    </c:forEach>
                                    --%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    <jsp:include page="../common/footer.jsp"/>
    </div>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
    	const pwExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,12}$/;
    	var pwYn = "N";
    	
        $(document).ready(function() {
            $(".my_nav > ul > li").click(function() {
                var idx = $(".my_nav > ul > li").index($(this));
                $(".my_nav > ul > li").removeClass("on");
                $(".my_nav > ul > li").eq(idx).addClass("on");
                $(".my_contents > div").hide();
                $(".my_contents > div").eq(idx).show();
            });
            
            if("${sessionScope.loginMember.movieReviewYN}" == "Y"){
            	$("#movie").addClass("my_on");
            	$("#movie").text("영화 후기 ON");
            } else {
            	$("#movie").addClass("my_off");
            	$("#movie").text("영화 후기 OFF");
            }

            if("${sessionScope.loginMember.spoilerYN}" == "Y"){
            	$("#board").addClass("my_on");
            	$("#board").text("게시판 스포 ON");
            } else {
            	$("#board").addClass("my_off");
            	$("#board").text("게시판 스포 OFF");
            }
        });
        
        $("#movie").click(function() {
        	$.ajax({
				url: "${pageContext.servletContext.contextPath}/member/modifyMovieOnOff",
				type: "post",
				success: function(data){
					if(data != null){
						if(data == "on"){
							$("#movie").removeClass();
							$("#movie").addClass("my_on");
							$("#movie").text("영화 후기 ON");
						} else {
							$("#movie").removeClass();
							$("#movie").addClass("my_off");
							$("#movie").text("영화 후기 OFF");
						}
					} else {
						alert("실패!");
					}
				},
				error: function(request, status, error){
					alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
				}
        	
        	});
        });

        $("#board").click(function() {
        	$.ajax({
				url: "${pageContext.servletContext.contextPath}/member/modifyBoardOnOff",
				type: "post",
				success: function(data){
					if(data != null){
						if(data == "on"){
							$("#board").removeClass();
							$("#board").addClass("my_on");
							$("#board").text("게시판 스포 ON");
						} else {
							$("#board").removeClass();
							$("#board").addClass("my_off");
							$("#board").text("게시판 스포 OFF");
						}
					} else {
						alert("실패!");
					}
				},
				error: function(request, status, error){
					alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
				}
        	
        	});
        });
        
    	const $searchAddress = document.getElementById("searchAddress");
		$searchAddress.onclick = function(){
			new daum.Postcode({
				oncomplete : function(data){
					document.getElementById("zipCode").value = data.zonecode;
					document.getElementById("address").value = data.address;
					document.getElementById("detailAddress").focus();
				}
			}).open();
		}
		
		$("#userPwd").keyup(function(){
			var userPwd = $("#userPwd").val();
			var userPwdYN = $("#userPwdYN").val();
			if(pwExp.test(userPwd)) {
				if(userPwd == userPwdYN){
					$("#pwCheckResult").text("비밀번호가 일치합니다.");
					pwYN = "Y"
				} else {
					$("#pwCheckResult").text("비밀번호가 일치하지않습니다.");
					pwYN = "N"
				}
			} else {
				$("#pwCheckResult").text("비밀번호는 영문, 숫자, 특수문자 포함 6~12자리로 작성해주세요.");
				pwYN = "N"
			}	
		});
		
		$("#userPwdYN").keyup(function(){
			var userPwd = $("#userPwd").val();
			var userPwdYN = $("#userPwdYN").val();
			if(pwExp.test(userPwdYN)) {
				if(userPwd == userPwdYN){
					$("#pwCheckResult").text("비밀번호가 일치합니다.");
					pwYN = "Y"
				} else {
					$("#pwCheckResult").text("비밀번호가 일치하지않습니다.");
					pwYN = "N"
				}
			} else {
				$("#pwCheckResult").text("비밀번호는 영문, 숫자, 특수문자 포함 6~12자리로 작성해주세요.");
				pwYN = "N"
			}	
		});
		
		function check() {
			if(pwYN=="Y"){
				return true;
			} else {
				alert("비밀번호확인이 완료되지 않았습니다.");
				return false;
			}
		}
    </script>
</body>
</html>