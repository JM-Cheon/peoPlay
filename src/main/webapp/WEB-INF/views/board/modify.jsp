<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/common/reset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board/board.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/summernote/lang/summernote-ko-KR.js">

<!-- include libraries(jQuery, bootstrap) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

</head>
<body>

	<jsp:include page="../common/header.jsp" />


	<section>
		<div id="wrap">

			<div class="title" id="board-name">자유게시판</div>
			<form action="${ pageContext.servletContext.contextPath}/board/modifyUpdate" method="post">
				
				
				<div class="page">
					<input type="hidden" name="userNo" value="${sessionScope.loginMember.userNo }">
					<input type="hidden" name="no" value="${requestScope.modify.no }">
					<table>
						<tr>
							<td class="title-td">제목 :</td>
							<td class="title-td-input" colspan="4">
							<input name="title" class="title-input" type="text" value="${requestScope.modify.title }"
							 style="width: 600px;"></td>
								<td class="title-category">카테고리</td>
							<td class="select-td" style="color: black"><select
								name="category" class="select-category">
									<option value="[스포주의]">[스포주의]</option>
									<option value="[영화추천]">[영화추천]</option>
									<option value="[잡담]">[잡담]</option>
							</select></td>
						</tr>

						
					</table>
					<div style="height: 30px;"></div>
					<div>

						<textarea  id="summernote"  name="content" >${requestScope.modify.content }</textarea>

					</div>

					<div style="height: 30px;">
						<table>
							<tr>
								<td style="width: 740px;"></td>
								<td><button type="button" onclick="" class="cancel-button">취소</button></td>
								<td style="width: 60px;"></td>
								<td><button type="submit" class="submit-button">등록</button></td>
								<td></td>
							</tr>
						</table>

					</div>
				</div>
			</form>
		</div>
	</section>


	<jsp:include page="../common/footer.jsp" />





	<script>
	
		$('#summernote').summernote(
				{
					placeholder : '내용을 입력하세요',
					height : 350,
					lang : "ko-KR",
					toolbar : [
							[ 'fontname', [ 'fontname' ] ],
							[ 'fontsize', [ 'fontsize' ] ],
							[ 'backcolor',[ '##2C2C2C']]
							[
									'style',
									[ 'bold', 'italic', 'underline',
											'strikethrough', 'clear' ] ],
							[ 'color', [ 'forecolor', 'color' ] ],
							[ 'table', [ 'table' ] ],
							[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
							[ 'height', [ 'height' ] ],
							[ 'insert', [ 'picture', 'link', 'video' ] ],
							[ 'view', [ 'fullscreen', 'help' ] ] ],
					fontNames : [ 'Arial', 'Arial Black', 'Comic Sans MS',
							'Courier New', '맑은 고딕', '궁서', '굴림체', '굴림', '돋움체',
							'바탕체' ],
					fontSizes : [ '8', '9', '10', '11', '12', '14', '16', '18',
							'20', '22', '24', '28', '30', '36', '50', '72' ]

				});
		
	</script>




</body>
</html>