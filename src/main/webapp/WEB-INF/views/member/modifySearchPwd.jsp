<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PeoPlay</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/member/member.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <div id="wrap">
    <jsp:include page="../common/header.jsp"/>
        <main class="main">
            <div class="search_main">
                <div class="modifySearchPwd_box">
                    <div class="welcome">
						비밀번호 변경
                    </div>
                    <div>
                        <p class="search_comment_title">변경하실 비밀번호를 입력해주세요.</p>
                        <p class="search_comment_body">이메일 인증에 성공하여 비밀번호 수정으로 이동했습니다.</p>
                    </div>
                    <form action="${ pageContext.servletContext.contextPath }/member/modifySearchPwd" method="post">
                        <div class="join_input_box">
							아이디 :
                            <input type="text" name="userId" required>
                        </div>
                        <div class="join_input_box">
							비밀번호 :
                            <input type="password" id="userPwd" name="userPwd">
                        </div>
                        <div class="join_input_box">
							비밀번호확인 :
                            <input type="password" id="userPwdYN">
                        </div>
                        <p id="pwCheckResult" class="pRight">비밀번호는 영문, 숫자, 특수문자 포함 6~12자리로 작성해주세요.</p>
                        <div class="join_input_box">
                            <button type="submit" onclick="return check();">변경하기</button>
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
    <script>
    	const pwExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,12}$/;
    	var pwYn = "N";
    	
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