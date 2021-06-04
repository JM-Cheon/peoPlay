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
                <div class="login_box">
                    <div class="welcome">
						아이디 찾기
                    </div>
                    <div>
                        <p class="search_comment_title">인증번호 전송 완료!</p>
                        <p class="search_comment_body" id="timer"></p>
                        <p class="search_comment_body">위 시간동안 입력이 되지 않을 경우 아이디 찾기가 취소됩니다.</p>
                    </div>
                    <div class="search_input_box">
						인증번호 :
                        <input type="text" id="key">
                    </div>
                    <div class="search_input_box">
                        <button type="button" id="showResult">확인하기</button>
                    </div>
                    <div class="search_input_box">
                        <button type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/member/login'">취소하기</button>
                    </div>
                </div>
            </div>
        </main>
    <jsp:include page="../common/footer.jsp"/>
    </div>
    <script>
		
		$(function() {
			var time = 10*60;
			var min = parseInt(time / 60);
			var second = time % 60;
			
			$("#timer").text(min + "분" + second + "초");
			
			var timer = setInterval(function() {
				time --;
				var min = parseInt(time / 60);
				var second = time % 60;
				$("#timer").empty();
				$("#timer").text(min + "분" + second + "초");
				if(time == 0){
					alert("제한 시간이 초과되었습니다.");
					location.href = "${ pageContext.servletContext.contextPath }";
				}
			}, 1000)
		});
    
    	$("#showResult").click(function() {
    		const emailKey = "${ requestScope.emailKey }";
    		var key = $("#key").val();
    		
    		if(emailKey == key){
    			alert("회원님의 아이디는 ${ requestScope.userId } 입니다.");
    			location.href = "${ pageContext.servletContext.contextPath }";
    		} else {
    			alert("일치하지 않습니다.");
    		}
    	});
    </script>
</body>
</html>