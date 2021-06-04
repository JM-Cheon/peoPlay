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
</head>
<body>
	<div id="wrap">
	<jsp:include page="../common/header.jsp"/>
		<main class="main">
            <div class="check_main">
                <div class="check_contents">
                    <div class="check_title">
                        <p class="check_title_top">좋아하는 콘텐츠를 3개 선택하세요.</p>
                        <p class="check_title_bottom">회원님이 좋아하실 만한 영화를 더 많이 추천해 드릴 수 있습니다. 마음에 드는 콘텐츠를 선택하세요.</p>
                        <form action="${ pageContext.servletContext.contextPath }/member/registForm" method="post">
                        	<input type="hidden" class="action" name="action" value=0>
                        	<input type="hidden" class=fantasy name="fantasy" value=0>
                        	<input type="hidden" class="romance" name="romance" value=0>
                        	<input type="hidden" class="comedy" name="comedy" value=0>
                        	<input type="hidden" class="horror" name="horror" value=0>
	                        <button type="submit" onClick="return check();">다음</button>
                        </form>
                    </div>
                    <div class="check_body">
                    	<%-- 
                    	<c:forEach var="" items="">
                    		<img src="">
                    	</c:forEach> 
                    	--%>
                    	<img src="" id="action">
                    	<img src="" id="action">
                    	<img src="" id="fantasy">
                    	<img src="" id="fantasy">
                    	<img src="" id="horror">
                    	<img src="" id="horror">
                    	<img src="" id="romance">
                    	<img src="" id="romance">
                    	<img src="" id="comedy">
                    	<img src="" id="comedy">
                    </div>
                </div>
            </div>
        </main>
	<jsp:include page="../common/footer.jsp"/>
	</div>
	<script>
		$('.check_body img').click(function(){
			var id = $(this).attr('id');
				
			if($(this).attr('class') != 'clickImg'){
				if($('.clickImg').length < 3) {
					$("." + id).val(parseInt($("." + id).val()) + 1);
					$(this).addClass('clickImg');
				} else {
					alert("선택은 3개까지만 가능합니다.");
				}
			} else {
				$("." + id).val(parseInt($("." + id).val()) - 1);
				$(this).removeClass('clickImg');
			}
		});
		
		function check() {
			if($('.clickImg').length == 0) {
				alert("최소 1개 이상의 콘텐츠를 선택해주세요.");
				return false;
			} else {
				return true;
			}
		}
	</script>
</body>
</html>