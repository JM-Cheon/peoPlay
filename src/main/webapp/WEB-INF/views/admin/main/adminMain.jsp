<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/admin/admin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<div id="wrap">
	<jsp:include page="../../common/header.jsp"/>
		<main class="main">
			<div class="adminMain">
                <div class="adminMain_contents">
				<jsp:include page="../common/adminMenu.jsp"/>
                    <div class="admin_graph_box">
                        <div class="admin_graph_box_title">
                            <select id="admin">
                                <option value="member">회원 통계</option>
                                <option value="movie">영화 통계</option>
                                <option value="goods">굿즈 통계</option>
                                <option value="board">게시판 통계</option>
                            </select>
                            <p id="title">회원 통계</p>
                        </div>
                        <div class="admin_graph_box_body">
                            
                        </div>
                    </div>
                </div>
            </div>
        </main>
	<jsp:include page="../../common/footer.jsp"/>
	
	</div>
	<script>
		$('#admin').change(function() {
			var value = $('#admin option:selected').text();
			$("#title").text(value);
		});
	</script>
</body>
</html>