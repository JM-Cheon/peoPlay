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
            <div class="search_main">
                <div class="searchId_box">
                    <div class="welcome">
						아이디 찾기
                    </div>
                    <div>
                        <p class="search_comment_title">아이디를 잊으셨나요?</p>
                        <p class="search_comment_body">가입 시 입력하신 이름과 이메일을 입력해주세요.</p>
                        <p class="search_comment_body">가입 시 입력하신 이메일로 아이디를 전송해드립니다.</p>
                    </div>
                    <form action="${ pageContext.servletContext.contextPath }/member/searchId" method="post">
                        <div class="search_input_box">
							이름 :
                            <input type="text" name="userName">
                        </div>
                        <div class="search_email_input_box">
							이메일 :
                            <input type="text" name="email1" required>
                             @ 
                            <select name="email2">
                                <option value="naver.com">naver.com</option>
                                <option value="gmail.com">gmail.com</option>
                            </select>
                        </div>
                        <div class="search_input_box">
                            <button type="submit">SEARCH</button>
                        </div>
                        <div class="search_input_box">
                            <button type="button" onclick="location.href='${ pageContext.servletContext.contextPath }'">메인으로 돌아가기</button>
                        </div>
                    </form>
                </div>
            </div>
        </main>
    <jsp:include page="../common/footer.jsp"/>
    </div>
</body>
</html>