<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <div class="adminMember">
                <div class="adminMember_contents">
				<jsp:include page="../common/adminMenu.jsp"/>
                    <div class="adminMember_list">
                        <div class="memberList_title">
                            <p>회원관리</p>
                        </div>
                        <hr class="adminLine">
                        <div class="memberList_body">
                        	<div class="searchDiv">
	                        	<select id="searchCategory">
	                        		<option value="all">전체</option>
	                        		<option value="no">번호</option>
	                        		<option value="name">이름</option>
	                        		<option value="nick">닉네임</option>
	                        		<option value="report">신고</option>
	                        		<option value="status">상태</option>
	                        		<option value="black">블랙</option>
	                        	</select>
	                        	<input type="text" name="searchArea" id="searchArea">
                        	</div>
                            <table>
                                <thead>
                                    <tr>
                                        <th class="memberTable_title">번호</th>
                                        <th class="memberTable_nameTitle">이름</th>
                                        <th class="memberTable_nameTitle">닉네임</th>
                                        <th class="memberTable_emailTitle">이메일</th>
                                        <th class="memberTable_dateTitle">가입일</th>
                                        <th class="memberTable_title">등급</th>
                                        <th class="memberTable_title">신고</th>
                                        <th class="memberTable_title">상태</th>
                                        <th class="memberTable_title">블랙</th>
                                    </tr>
                                </thead>
                                <tbody id="tableBody">
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </main>
	<jsp:include page="../../common/footer.jsp"/>
	</div>
	<script>
	$(function(){
		
		defaltList();
		$("#searchArea").attr("readonly",true);
		
		$('#searchCategory').change(function() {
			var value = $('#searchCategory option:selected').val();
			
			switch(value){
				case "all" : 
					defaltList();
					$("#searchArea").attr("readonly",true);
					break;
					
				case "no" :
					$("#searchArea").removeAttr("readonly");
					$("#searchArea").prop("type", "number");
					defaltList();
					$("#searchArea").keyup(function(){
						var no = $("#searchArea").val();
						noList(no);
					});
					break;
					
				case "name" :
					$("#searchArea").removeAttr("readonly");
					$("#searchArea").prop("type", "text");
					nameList("");
					$("#searchArea").keyup(function(){
						var name = $("#searchArea").val();
						nameList(name);
					});
					break;

				case "nick" :
					$("#searchArea").removeAttr("readonly");
					$("#searchArea").prop("type", "text");
					nickList("");
					$("#searchArea").keyup(function(){
						var nick = $("#searchArea").val();
						nickList(nick);
					});
					break;

				case "report" :
					$("#searchArea").removeAttr("readonly");
					$("#searchArea").prop("type", "number");
					reportList(0);
					$("#searchArea").keyup(function(){
						var report = $("#searchArea").val();
						reportList(report);
					});
					break;

				case "status" :
					$("#searchArea").removeAttr("readonly");
					$("#searchArea").prop("type", "checkbox");
					statusList("Y");
					$("#searchArea").click(function(){
						if($("#searchArea").is(":checked") == true){
							statusList("N");
						} else {
							statusList("Y");
						}
					})
					break;

				case "black" :
					$("#searchArea").removeAttr("readonly");
					$("#searchArea").prop("type", "text");
					blackList("");
					$("#searchArea").keyup(function(){
						var black = $("#searchArea").val();
						blackList(black);
					});
					break;
			}
		});
	});
	
	function defaltList() {
		$.ajax({
			url: "${pageContext.servletContext.contextPath}/admin/member/list",
			type: "post",
			success: function(data){
				
				const $table = $("#tableBody");
				$table.html("");
				
				if(data != null){
					for(var index in data){
						$tr = $("<tr class=\"memberTable_body\">");
						$noTd = $("<td>").text(data[index].userNo);
						$nameTd = $("<td>").text(data[index].userName);
						$nickTd = $("<td>").text(data[index].nickname);
						$emailTd = $("<td>").text(data[index].email);
						$registerTd = $("<td>").text(data[index].userRegister);
						$roleTd = $("<td>").text(data[index].userRole);
						$reportTd = $("<td>").text(data[index].reportCumulative);
						$statusTd = $("<td>").text(data[index].userStatus);
						if(data[index].userRole == "BLACK"){
							$blackTd = $("<td>").append("<button id=\"black\" class=\"blackY\">블랙</button>");
						} else if(data[index].userRole == "ADMIN"){
							$blackTd = $("<td>")
						} else {
							$blackTd = $("<td>").append("<button id=\"black\" class=\"blackN\">블랙</button>");
						}
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nickTd);
						$tr.append($emailTd);
						$tr.append($registerTd);
						$tr.append($roleTd);
						$tr.append($reportTd);
						$tr.append($statusTd);
						$tr.append($blackTd);
						
						$table.append($tr);
					}
				} else {
					$("#tableBody").append("<tr><td class=\"memberTable_body\" colspan=\"8\">회원이 존재하지 않습니다.</td></tr>");
				}
			},
			error: function(request, status, error){
				alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	}

	function noList(no) {
		
		if(no == null || no == ""){
			no = 0;
		}
		
		$.ajax({
			url: "${pageContext.servletContext.contextPath}/admin/member/noList",
			type: "post",
			data: { no : no },
			success: function(data){
				
				const $table = $("#tableBody");
				$table.html("");
				
				if(data != null){
					for(var index in data){
						$tr = $("<tr class=\"memberTable_body\">");
						$noTd = $("<td>").text(data[index].userNo);
						$nameTd = $("<td>").text(data[index].userName);
						$nickTd = $("<td>").text(data[index].nickname);
						$emailTd = $("<td>").text(data[index].email);
						$registerTd = $("<td>").text(data[index].userRegister);
						$roleTd = $("<td>").text(data[index].userRole);
						$reportTd = $("<td>").text(data[index].reportCumulative);
						$statusTd = $("<td>").text(data[index].userStatus);
						if(data[index].userRole == "BLACK"){
							$blackTd = $("<td>").append("<button id=\"black\" class=\"blackY\">블랙</button>");
						} else if(data[index].userRole == "ADMIN"){
							$blackTd = $("<td>")
						} else {
							$blackTd = $("<td>").append("<button id=\"black\" class=\"blackN\">블랙</button>");
						}
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nickTd);
						$tr.append($emailTd);
						$tr.append($registerTd);
						$tr.append($roleTd);
						$tr.append($reportTd);
						$tr.append($statusTd);
						$tr.append($blackTd);
						
						$table.append($tr);
					}
				} else {
					$("#tableBody").append("<tr><td class=\"memberTable_body\" colspan=\"8\">회원이 존재하지 않습니다.</td></tr>");
				}
			},
			error: function(request, status, error){
				alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	}

	function nameList(name) {
		$.ajax({
			url: "${pageContext.servletContext.contextPath}/admin/member/nameList",
			type: "post",
			data: { name : name },
			success: function(data){
				
				const $table = $("#tableBody");
				$table.html("");
				
				if(data != null){
					for(var index in data){
						$tr = $("<tr class=\"memberTable_body\">");
						$noTd = $("<td>").text(data[index].userNo);
						$nameTd = $("<td>").text(data[index].userName);
						$nickTd = $("<td>").text(data[index].nickname);
						$emailTd = $("<td>").text(data[index].email);
						$registerTd = $("<td>").text(data[index].userRegister);
						$roleTd = $("<td>").text(data[index].userRole);
						$reportTd = $("<td>").text(data[index].reportCumulative);
						$statusTd = $("<td>").text(data[index].userStatus);
						if(data[index].userRole == "BLACK"){
							$blackTd = $("<td>").append("<button id=\"black\" class=\"blackY\">블랙</button>");
						} else if(data[index].userRole == "ADMIN"){
							$blackTd = $("<td>")
						} else {
							$blackTd = $("<td>").append("<button id=\"black\" class=\"blackN\">블랙</button>");
						}
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nickTd);
						$tr.append($emailTd);
						$tr.append($registerTd);
						$tr.append($roleTd);
						$tr.append($reportTd);
						$tr.append($statusTd);
						$tr.append($blackTd);
						
						$table.append($tr);
					}
				} else {
					$("#tableBody").append("<tr><td class=\"memberTable_body\" colspan=\"8\">회원이 존재하지 않습니다.</td></tr>");
				}
			},
			error: function(request, status, error){
				alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	}

	function nickList(nick) {
		$.ajax({
			url: "${pageContext.servletContext.contextPath}/admin/member/nickList",
			type: "post",
			data: { nick : nick },
			success: function(data){
				
				const $table = $("#tableBody");
				$table.html("");
				
				if(data != null){
					for(var index in data){
						$tr = $("<tr class=\"memberTable_body\">");
						$noTd = $("<td>").text(data[index].userNo);
						$nameTd = $("<td>").text(data[index].userName);
						$nickTd = $("<td>").text(data[index].nickname);
						$emailTd = $("<td>").text(data[index].email);
						$registerTd = $("<td>").text(data[index].userRegister);
						$roleTd = $("<td>").text(data[index].userRole);
						$reportTd = $("<td>").text(data[index].reportCumulative);
						$statusTd = $("<td>").text(data[index].userStatus);
						if(data[index].userRole == "BLACK"){
							$blackTd = $("<td>").append("<button id=\"black\" class=\"blackY\">블랙</button>");
						} else if(data[index].userRole == "ADMIN"){
							$blackTd = $("<td>")
						} else {
							$blackTd = $("<td>").append("<button id=\"black\" class=\"blackN\">블랙</button>");
						}
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nickTd);
						$tr.append($emailTd);
						$tr.append($registerTd);
						$tr.append($roleTd);
						$tr.append($reportTd);
						$tr.append($statusTd);
						$tr.append($blackTd);
						
						$table.append($tr);
					}
				} else {
					$("#tableBody").append("<tr><td class=\"memberTable_body\" colspan=\"8\">회원이 존재하지 않습니다.</td></tr>");
				}
			},
			error: function(request, status, error){
				alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	}

	function reportList(report) {
		
		if(report == null || report == ""){
			report = 0;
		}
		
		$.ajax({
			url: "${pageContext.servletContext.contextPath}/admin/member/reportList",
			type: "post",
			data: { report : report },
			success: function(data){
				
				const $table = $("#tableBody");
				$table.html("");
				
				if(data != null){
					for(var index in data){
						$tr = $("<tr class=\"memberTable_body\">");
						$noTd = $("<td>").text(data[index].userNo);
						$nameTd = $("<td>").text(data[index].userName);
						$nickTd = $("<td>").text(data[index].nickname);
						$emailTd = $("<td>").text(data[index].email);
						$registerTd = $("<td>").text(data[index].userRegister);
						$roleTd = $("<td>").text(data[index].userRole);
						$reportTd = $("<td>").text(data[index].reportCumulative);
						$statusTd = $("<td>").text(data[index].userStatus);
						if(data[index].userRole == "BLACK"){
							$blackTd = $("<td>").append("<button id=\"black\" class=\"blackY\">블랙</button>");
						} else if(data[index].userRole == "ADMIN"){
							$blackTd = $("<td>")
						} else {
							$blackTd = $("<td>").append("<button id=\"black\" class=\"blackN\">블랙</button>");
						}
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nickTd);
						$tr.append($emailTd);
						$tr.append($registerTd);
						$tr.append($roleTd);
						$tr.append($reportTd);
						$tr.append($statusTd);
						$tr.append($blackTd);
						
						$table.append($tr);
					}
				} else {
					$("#tableBody").append("<tr><td class=\"memberTable_body\" colspan=\"8\">회원이 존재하지 않습니다.</td></tr>");
				}
			},
			error: function(request, status, error){
				alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	}
	
	function statusList(status) {
		$.ajax({
			url: "${pageContext.servletContext.contextPath}/admin/member/statusList",
			type: "post",
			data: { status : status },
			success: function(data){
				
				const $table = $("#tableBody");
				$table.html("");
				
				if(data != null){
					for(var index in data){
						$tr = $("<tr class=\"memberTable_body\">");
						$noTd = $("<td>").text(data[index].userNo);
						$nameTd = $("<td>").text(data[index].userName);
						$nickTd = $("<td>").text(data[index].nickname);
						$emailTd = $("<td>").text(data[index].email);
						$registerTd = $("<td>").text(data[index].userRegister);
						$roleTd = $("<td>").text(data[index].userRole);
						$reportTd = $("<td>").text(data[index].reportCumulative);
						$statusTd = $("<td>").text(data[index].userStatus);
						if(data[index].userRole == "BLACK"){
							$blackTd = $("<td>").append("<button id=\"black\" class=\"blackY\">블랙</button>");
						} else if(data[index].userRole == "ADMIN"){
							$blackTd = $("<td>")
						} else {
							$blackTd = $("<td>").append("<button id=\"black\" class=\"blackN\">블랙</button>");
						}
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nickTd);
						$tr.append($emailTd);
						$tr.append($registerTd);
						$tr.append($roleTd);
						$tr.append($reportTd);
						$tr.append($statusTd);
						$tr.append($blackTd);
						
						$table.append($tr);
					}
				} else {
					$("#tableBody").append("<tr><td class=\"memberTable_body\" colspan=\"8\">회원이 존재하지 않습니다.</td></tr>");
				}
			},
			error: function(request, status, error){
				alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	}

	function blackList(black) {
		$.ajax({
			url: "${pageContext.servletContext.contextPath}/admin/member/blackList",
			type: "post",
			data: { black : black },
			success: function(data){
				
				const $table = $("#tableBody");
				$table.html("");
				
				if(data != null){
					for(var index in data){
						$tr = $("<tr class=\"memberTable_body\">");
						$noTd = $("<td>").text(data[index].userNo);
						$nameTd = $("<td>").text(data[index].userName);
						$nickTd = $("<td>").text(data[index].nickname);
						$emailTd = $("<td>").text(data[index].email);
						$registerTd = $("<td>").text(data[index].userRegister);
						$roleTd = $("<td>").text(data[index].userRole);
						$reportTd = $("<td>").text(data[index].reportCumulative);
						$statusTd = $("<td>").text(data[index].userStatus);
						if(data[index].userRole == "BLACK"){
							$blackTd = $("<td>").append("<button id=\"black\" class=\"blackY\">블랙</button>");
						} else if(data[index].userRole == "ADMIN"){
							$blackTd = $("<td>")
						} else {
							$blackTd = $("<td>").append("<button id=\"black\" class=\"blackN\">블랙</button>");
						}
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nickTd);
						$tr.append($emailTd);
						$tr.append($registerTd);
						$tr.append($roleTd);
						$tr.append($reportTd);
						$tr.append($statusTd);
						$tr.append($blackTd);
						
						$table.append($tr);
					}
				} else {
					$("#tableBody").append("<tr><td class=\"memberTable_body\" colspan=\"8\">회원이 존재하지 않습니다.</td></tr>");
				}
			},
			error: function(request, status, error){
				alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	}
	$(document).on("click", "#black", function(){
		var no = $(this).parent().parent().children().eq(0).text();
		
		if($(this).attr("class") == "blackN"){
			$(this).removeClass();
			$(this).addClass("blackY");
		} else {
			$(this).removeClass();
			$(this).addClass("blackN");
		}

		$.ajax({
			url: "${pageContext.servletContext.contextPath}/admin/member/black",
			type: "post",
			data: { no : no},
			success: function(data){
				if(data == 0){
					alert("실패!");
				}
			},
			error: function(request, status, error){
				alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
    	
    	});
    });
	</script>
</body>
</html>