<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/board/board.css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>


</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<section>

		<div class="wrap-back">
			<div class="center">
				<div style="height: 400px;"></div>
				<div class="title">자유게시판</div>
				<div class="board">
					<table id="listArea">
						<thead class="board-head">
							<tr style="height: 70px; font-size: 25px; text-align: center;">
								<th style="width: 100px;">번호</th>
								<th style="width: 550px;">제목</th>
								<th style="width: 200px;">작성자</th>
								<th style="width: 150px;">날짜</th>
								<th style="width: 100px;">조회</th>
							</tr>
						</thead>

						<tbody>
							<c:choose> 
								<c:when test="${empty list }">
									<tr>
										<td colspan="5" align="center" style="color: white; font-size: 20px" >데이터가 없습니다.</td>
									</tr>
								</c:when>
								<c:when test="${!empty list}">
									<c:forEach items="${requestScope.list}" var="board">
										<tr
											style="height: 60px; font-size: 17px; color: white; text-align: center;">
											<td><c:out value="${board.no}" /></td>
											<td><c:out value="${board.title}" />
												
												<c:if test="${ board.commentCount ne 0 }">
													<c:out value="(${ board.commentCount })" />
												</c:if> 
												</td>
											<td><c:out value="${board.memberDTO.nickname}" /></td>
											<td><c:out value="${board.creationDate}" /></td>
											<td><c:out value="${board.view}" /></td>
										</tr>
									</c:forEach>
								</c:when>
							</c:choose>
						</tbody>

					</table>
					<div style="height: 200px;">
						<div style="height: 60px;"></div>
						<div>
							<table style="margin: auto;">
								<tr style="color: white; text-align: center; font-size: 20px;">
									<td class="board-paging"><a href="">◀</a></td>
									<td class="board-paging"><a href="">1</a></td>
									<td class="board-paging"><a href="">2</a></td>
									<td class="board-paging"><a href="">3</a></td>
									<td class="board-paging"><a href="">4</a></td>
									<td class="board-paging"><a href="">5</a></td>
									<td class="board-paging"><a href="">▶</a></td>

								</tr>
							</table>
						</div>
						<div style="height: 45px;"></div>
						<div style="height: 40px;">
							<table style="margin: auto;">
								<tr style="height: 40px;">
									<td class="select"><select class="select-content">
											<option value="">제목</option>
											<option value="">작성자</option>
											<option value="">내용</option>
									</select></td>
									<td style="width: 10px;"></td>
									<td class="td-search"><input type="text"
										value="검색어를 입력하세요" class="td-search-input"></td>
									<td style="width: 10px;"></td>
									<td style="width: 110px;"><button class="btn-search">검색</button></td>
									<td style="width: 10px;"></td>
									<td style="width: 110px;">
										<button class="btn-write">작성하기</button>
									</td>
								</tr>
							</table>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
	<jsp:include page="../common/footer.jsp" />

<script type="text/javascript">
$(function(){
	$("#listArea td").hover(function(){
		$(this).parent().css({"background" : "#008916", "cursor":"pointer"});
	},function(){
		$(this).parent().css("background", "#2C2C2C");
	}).click(function(){
		const no = $(this).parent().children(":eq(0)").text();
		location.href = "${ pageContext.servletContext.contextPath }/notice/detail?no=" + no;
	})
})

</script>

</body>
</html>