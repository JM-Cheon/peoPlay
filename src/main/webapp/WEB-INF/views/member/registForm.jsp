<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/member/member.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <div id="wrap">
	<jsp:include page="../common/header.jsp"/>
        <main class="main">
            <div class="join_main">
                <div class="join_box">
                    <div class="welcome">
                        	회원 정보 입력
                    </div>
                    <form action="${ pageContext.servletContext.contextPath }/member/regist" method="post">
                    	<input type="hidden" name="action" value="${ requestScope.member.action }">
                    	<input type="hidden" name="fantasy" value="${ requestScope.member.fantasy }">
                    	<input type="hidden" name="romance" value="${ requestScope.member.romance }">
                    	<input type="hidden" name="comedy" value="${ requestScope.member.comedy }">
                    	<input type="hidden" name="horror" value="${ requestScope.member.horror }">
						<div class="join_input_box">
                          	  아이디 : 
							<input type="text" id="userId" name="userId" required>
                        </div>
                        <p id="idCheckResult">아이디는 영문, 숫자 포함 4~12자리로 작성해주세요.</p>
                        <div class="join_input_box">
                        	비밀번호 : 
                            <input type="password" id="userPwd" name="userPwd" required>
                        </div>
                        <div class="join_input_box">
							비밀번호확인 :
                            <input type="password" id="userPwdYN" name="userPwdYN" required>
                        </div>
                        <p id="pwCheckResult">비밀번호는 영문, 숫자, 특수문자 포함 6~12자리로 작성해주세요.</p>
                        <div class="join_input_box">
							이름 :
                            <input type="text" name="userName" required>
                        </div>
                        <div class="join_input_box">
							닉네임 :
                            <input type="text" id="nickname" name="nickname" required>
                        </div>
                        <p id="nicknameCheckResult">닉네임은 한글, 영문, 숫자 포함 2~8자리로 작성해주세요.</p>
                        <div class="email_input_box">
							이메일 :
                            <input type="text" id="email" name="email1" required>
                             @ 
                            <select name="email2">
                                <option value="naver.com">naver.com</option>
                                <option value="gmail.com">gmail.com</option>
                            </select>
                        </div>
                        <p id="emailCheckResult">이메일을 입력해주세요.</p>
                        <div class="join_input_box">
							생년월일 :
                            <input type="date" name="birthday" required>
                        </div>
                        <div class="join_input_box">
							전화번호 :
                            <input type="tel" id="phone" name="phone" required>
                        </div>
                        <p id="phoneCheckResult">전화번호를 입력해주세요. ex(010-0000-0000)</p>
                        <div class="join_input_box">
                            <button type="button" id="searchAddress">주소검색</button>
                        </div>
                        <div class="join_input_box">
							우편번호 :
                            <input type="text" name="zipCode" id="zipCode" readonly>
                        </div>
                        <div class="join_input_box">
							주소 :
                            <input type="text" name="address" id="address" readonly>
                        </div>
                        <div class="join_input_box">
							상세주소 :
                            <input type="text" name="detailAddress" id="detailAddress" required>
                        </div>
                        <div class="join_input_box">
                            <button type="submit" onclick="return check();">회원가입</button>
                        </div>
                        <div class="join_input_box">
                            <button type="button" onclick="location.href='${ pageContext.servletContext.contextPath }'">메인으로 돌아가기</button>
                        </div>
                    </form>
                </div>
            </div>
        </main>
	<jsp:include page="../common/footer.jsp"/>
    </div>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
    	const idExp = /^[a-zA-z0-9]{4,12}$/;
    	const pwExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,12}$/;
    	const nickExp = /^[가-힣ㄱ-ㅎa-zA-Z0-9._-]{2,8}$/;
    	const emailExp = /^[A-Za-z0-9_]+[A-Za-z0-9]$/;
    	const phoneExp = /^\d{3}-\d{3,4}-\d{4}$/;
    	var idYN = "N";
    	var pwYN = "N";
    	var nicknameYN = "N";
    	var emailYN = "N";
    	var phoneYN = "N";
    	
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
		
		$("#userId").keyup(function(){
			var userId = $("#userId").val();
			if(idExp.test(userId)) {
					
				$.ajax({
					url: "${pageContext.servletContext.contextPath}/member/idCheck",
					type: "post",
					data: {userId : userId},
					success: function(data){
						if(data == null){
							$("#idCheckResult").text("사용가능한 아이디 입니다.");
							idYN = "Y";
						} else {
							$("#idCheckResult").text("이미 사용중인 아이디 입니다.");
							idYN = "N"
						}
					},
					error: function(request, status, error){
						alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
					}
				});
			} else {
				$("#idCheckResult").text("아이디는 영문, 숫자 포함 4~12자리로 작성해주세요.");
				idYN = "N"
			}	
		});
		
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
		
		$("#nickname").keyup(function(){
			var nickname = $("#nickname").val();
			if(nickExp.test(nickname)) {
					
				$.ajax({
					url: "${pageContext.servletContext.contextPath}/member/nicknameCheck",
					type: "post",
					data: {nickname : nickname},
					success: function(data){
						if(data == null){
							$("#nicknameCheckResult").text("사용가능한 닉네임 입니다.");
							nicknameYN = "Y";
						} else {
							$("#nicknameCheckResult").text("이미 사용중인 닉네임 입니다.");
							nicknameYN = "N"
						}
					},
					error: function(request, status, error){
						alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
					}
				});
			} else {
				$("#nicknameCheckResult").text("닉네임은 한글, 영문, 숫자 포함 2~8자리로 작성해주세요.");
				nicknameYN = "N"
			}	
		});
		
		$("#email").keyup(function(){
			var email = $("#email").val();
			if(emailExp.test(email)) {
				$("#emailCheckResult").text("이메일이 올바르게 입력되었습니다.");
				emailYN = "Y"
			} else {
				$("#emailCheckResult").text("이메일은 특수문자 사용이 불가능합니다.");
				emailYN = "N"
			}	
		});

		$("#phone").keyup(function(){
			var phone = $("#phone").val();
			if(phoneExp.test(phone)) {
				$("#phoneCheckResult").text("전화번호가 올바르게 입력되었습니다.");
				phoneYN = "Y"
			} else {
				$("#phoneCheckResult").text("전화번호 형식이 올바르지 않습니다. ex(010-0000-0000)");
				phoneYN = "N"
			}	
		});
		
		function check() {
			if(idYN == "N"){
				alert("아이디 중복확인이 완료되지 않았습니다.");
				return false;
			} else if(pwYN == "N") {
				alert("비밀번호확인이 완료되지 않았습니다.");
				return false;
			} else if(nicknameYN == "N") {
				alert("닉네임 중복확인이 완료되지 않았습니다.");
				return false;
			} else if(emailYN == "N") {
				alert("이메일 형식이 올바르지 않습니다.");
				return false;
			} else if(phoneYN == "N") {
				alert("전화번호 형식이 올바르지 않습니다.");
				return false;
			} else if($("#zipCode").val() == "") {
				alert("빈칸 없이 입력해주세요.");
				return false;
			} else {
				return true;
			}
		}
    </script>
</body>
</html>