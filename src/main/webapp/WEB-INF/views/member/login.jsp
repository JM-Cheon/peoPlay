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
            <div class="login_main">
                <div class="login_box">
                    <div class="welcome">
                        WELCOME
                    </div>
                    <form action="${ pageContext.servletContext.contextPath }/member/login" method="post">
                        <div class="login_input_box">
                            USER ID
                            <input type="text" name="userId">
                        </div>
                        <div class="login_input_box">
                            PASSWORD
                            <input type="password" name="userPwd">
                        </div>
                        <div class="id_pw_search">
                            <a href="${ pageContext.servletContext.contextPath }/member/searchId">아이디 찾기</a>
                            / <a href="${ pageContext.servletContext.contextPath }/member/searchPwd">비밀번호 찾기</a>
                        </div>
                        <div class="login_input_box">
                            <button type="submit">LOGIN</button>
                        </div>
                        <div class="login_input_box">
                            <button type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/member/agreeToS'">SIGN UP</button>
                        </div>
                    </form>
                </div>
            </div>
        </main>
	<jsp:include page="../common/footer.jsp"/>
    </div>
    <script>
    </script>
</body>
</html>