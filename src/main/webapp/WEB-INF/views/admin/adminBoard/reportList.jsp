<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/board/board.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>




</head>
<body>
	<jsp:include page="../../common/header.jsp"/>
  <section>
        <div class="reportWrap">
            <div class="center">
                <div style="height: 400px;"> </div>
                <div class = "title" >신고관리</div>
                
                <div style="height: 100px;"></div>

                <div >
                    	<form action="${pageContext.servletContext.contextPath}/admin/adminBoard/selectReportList" method="get">
                <table>                
                    <tr class="reportCategory"> 
                        <td class="td-reportCategory"> <button class="btnNo" type="submit" name="no" value=1>자유게시판</button></td>
                        <td class="td-reportCategory"> <button class="btnNo" type="submit" name="no" value=2>굿즈</button></td>
                        <td class="td-reportCategory"> <button class="btnNo" type="submit" name="no" value=3>댓글</button></td>
                        <td class="td-reportCategory"> <button class="btnNo" type="submit" name="no" value=4>대댓글</button></td>
                        <td class="td-reportCategory"> <button class="btnNo" type="submit" name="no" value=5>영화후기</button></td>
                    
                    </tr>
                </table>
                       
                 </form>
                    
                 	
                <div style="height: 100px;"></div>
                </div>

                <div class="reportContentDiv" style="height: auto;">
                
                
					<form name="myform" method="get">
                   	
                    <table >
                        <thead class="board-head">
                            <tr style="height: 70px; font-size: 25px ; text-align: center;">
                                <td style="width: 157px; " >신고번호</td>
                                <td style="width: 157px;" >사유</td>
                                <td style="width: 157px;" >장소</td>
                                <td style="width: 157px;">날짜</td>
                                <td style="width: 157px;">피신고자</td>
                                <td style="width: 157px;">신고자</td>
                                <td style="width: 157px;"> 처리</td>
                                
                            </tr>
                        </thead>
                        
                       
                        
                        <c:forEach items="${requestScope.list }" var="list">
                         
                         
                        <input type="hidden" name="no" value="${requestScope.no }">
                        <input type="hidden" name="reportedPersonNo" value="${list.reportedPerson }">
                        <input type="hidden" name="placeNo" value="${list.placeNo }">
                        <input type="hidden" name="reportNo" value="${list.no }">
                        <input type="hidden" name="refBoardNo" value="${list.refBoardNo }">
                        <input type="hidden" name="refGoodsNo" value="${list.refGoodsNo }">
                        <input type="hidden" name="refMovieNo" value="${list.refMovieNo }">
                       
                       <c:choose> 
                       <c:when test="${requestScope.no eq 1}">
                        <tr class="reportContent" id="listArea">
                        	<td style="display: none;"><c:out value="${list.refBoardNo }"></c:out> </td>
                        	<td style="width: 220px; height: 30px; "><c:out value="${list.no }"/></td>
                            <td style="width: 220px; height: 30px;" ><c:out value="${list.reason }"/></td>
                            <td style="width: 220px; height: 30px;" ><c:out value="${list.reportPlaceDTO.name }"/>-<c:out value="${list.placeNo }"/>  </td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reportDate }"/></td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reported.nickname }"/></td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reporter.nickname }"/></td>
                            <td> <button style="color: red; " type="submit" formaction="${ pageContext.servletContext.contextPath }/admin/adminBoard/reportConfirm ">신고확정</button>
                             <button style="color: blue;" type="submit" formaction="${ pageContext.servletContext.contextPath }/admin/adminBoard/reportCancle ">신고취소</button> </td>

                        </tr>
                    </c:when>
                    
                    <c:when test="${requestScope.no eq 2}">
                       <tr class="reportContent" id="listArea">
                        	<td style="display: none;" ><c:out value="${list.placeNo }"/> </td>
                        	<td style="width: 220px; height: 30px; "><c:out value="${list.no }"/></td>
                            <td style="width: 220px; height: 30px;" ><c:out value="${list.reason }"/></td>
                            <td style="width: 220px; height: 30px;" ><c:out value="${list.reportPlaceDTO.name }"/>-<c:out value="${list.placeNo }"/>  </td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reportDate }"/></td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reported.nickname }"/></td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reporter.nickname }"/></td>
                           <td> <button style="color: red; " type="submit" formaction="${ pageContext.servletContext.contextPath }/admin/adminBoard/reportConfirm ">신고확정</button>
                             <button style="color: blue;" type="submit" formaction="${ pageContext.servletContext.contextPath }/admin/adminBoard/reportCancle ">신고취소</button> </td>

                    
                    </c:when>
                    
                    
                     <c:when test="${requestScope.no eq 3}">
                        <tr class="reportContent" id="listArea">
                        	<td style="display: none;"><c:out value="${list.refBoardNo }"></c:out> </td>
                        	<td style="width: 220px; height: 30px; "><c:out value="${list.no }"/></td>
                            <td style="width: 220px; height: 30px;" ><c:out value="${list.reason }"/></td>
                            <td style="width: 220px; height: 30px;" ><c:out value="${list.reportPlaceDTO.name }"/>-<c:out value="${list.placeNo }"/>  </td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reportDate }"/></td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reported.nickname }"/></td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reporter.nickname }"/></td>
                            <td> <button style="color: red; " type="submit" formaction="${ pageContext.servletContext.contextPath }/admin/adminBoard/reportConfirm ">신고확정</button>
                             <button style="color: blue;" type="submit" formaction="${ pageContext.servletContext.contextPath }/admin/adminBoard/reportCancle ">신고취소</button> </td>

                     
                    </c:when>
                    
                    
                     <c:when test="${requestScope.no eq 4}">
                        <tr class="reportContent" id="listArea">
                        	<td style="display: none;"><c:out value="${list.refBoardNo }"></c:out> </td>
                        	<td style="width: 220px; height: 30px; "><c:out value="${list.no }"/></td>
                            <td style="width: 220px; height: 30px;" ><c:out value="${list.reason }"/></td>
                            <td style="width: 220px; height: 30px;" ><c:out value="${list.reportPlaceDTO.name }"/>-<c:out value="${list.placeNo }"/>  </td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reportDate }"/></td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reported.nickname }"/></td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reporter.nickname }"/></td>
                            <td> <button style="color: red; " type="submit" formaction="${ pageContext.servletContext.contextPath }/admin/adminBoard/reportConfirm ">신고확정</button>
                             <button style="color: blue;" type="submit" formaction="${ pageContext.servletContext.contextPath }/admin/adminBoard/reportCancle ">신고취소</button> </td>

                     
                    </c:when>
                    
                    
                     <c:when test="${requestScope.no eq 5}">
                        <tr class="reportContent" id="listArea">
                        	<td style="display: none;"><c:out value="${list.placeNo }"></c:out> </td>
                        	<td style="width: 220px; height: 30px; "><c:out value="${list.no }"/></td>
                            <td style="width: 220px; height: 30px;" ><c:out value="${list.reason }"/></td>
                            <td style="width: 220px; height: 30px;" ><c:out value="${list.reportPlaceDTO.name }"/>-<c:out value="${list.placeNo }"/>  </td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reportDate }"/></td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reported.nickname }"/></td>
                            <td style="width: 220px; height: 30px;"><c:out value="${list.reporter.nickname }"/></td>
                            <td> <button style="color: red; " type="submit" formaction="${ pageContext.servletContext.contextPath }/admin/adminBoard/reportConfirm ">신고확정</button>
                             <button style="color: blue;" type="submit" formaction="${ pageContext.servletContext.contextPath }/admin/adminBoard/reportCancle ">신고취소</button> </td>

                     
                    </c:when>
                       </c:choose>
                        </c:forEach>
                    </table>
					</form>
                    <div style="height: 100px;"></div>

                    <div style="align-content: center; ">
                        <table>
                            <tr>
                                <td style="width: 450px;"></td>
                                <td><button class="btn-back" onclick="">돌아가기</button></td>    
                                <td style="width: 450px;"></td>
                            </tr>
                        </table>
                    </div>
</div>
</div>
</div>
    </section>
    	<jsp:include page="../../common/footer.jsp"/>
    
    

    
    
    
    <script type="text/javascript">
    
    var code = ${requestScope.no};
    console.log(code);
    

    
    switch (code){
    
    case 1 :
    	$(function(){
    		$("#listArea td").hover(function(){
    			$(this).parent().css({"background" : "#4F4F4F", "cursor":"pointer"});
    		},function(){
    			$(this).parent().css("background", "#2C2C2C");
    		}).click(function(){
    			const no =  $(this).parent().children(":eq(0)").text();
    			location.href = "${ pageContext.servletContext.contextPath }/board/detail?no=" + no;
    		})
    	});
    	break;
    	
    	
    case 2 : 
    	$(function(){
    		$("#listArea td").hover(function(){
    			$(this).parent().css({"background" : "#4F4F4F", "cursor":"pointer"});
    		},function(){
    			$(this).parent().css("background", "#2C2C2C");
    		}).click(function(){
    			const no = $(this).parent().children(":eq(0)").text();
    			location.href = "${ pageContext.servletContext.contextPath }/board/detail?no=" + no;
    		})
    	});
    	
    	break;
    	
    case 3 : 
    	$(function(){
    		$("#listArea td").hover(function(){
    			$(this).parent().css({"background" : "#4F4F4F", "cursor":"pointer"});
    		},function(){
    			$(this).parent().css("background", "#2C2C2C");
    		}).click(function(){
    			const no = $(this).parent().children(":eq(0)").text();
    			location.href = "${ pageContext.servletContext.contextPath }/board/detail?no=" + no;
    		})
    	});
    	
    	break;
    	
    	
    case 4 : 
    	$(function(){
    		$("#listArea td").hover(function(){
    			$(this).parent().css({"background" : "#4F4F4F", "cursor":"pointer"});
    		},function(){
    			$(this).parent().css("background", "#2C2C2C");
    		}).click(function(){
    			const no = $(this).parent().children(":eq(0)").text();
    			location.href = "${ pageContext.servletContext.contextPath }/board/detail?no=" + no;
    		})
    	});
    	
    	break;
    	
    	
    case 5 : 
    	$(function(){
    		$("#listArea td").hover(function(){
    			$(this).parent().css({"background" : "#4F4F4F", "cursor":"pointer"});
    		},function(){
    			$(this).parent().css("background", "#2C2C2C");
    		}).click(function(){
    			const no = $(this).parent().children(":eq(0)").text();
    			location.href = "${ pageContext.servletContext.contextPath }/board/detail?no=" + no;
    		})
    	});
    	
    	break;
    	
    	
    }
   
</script>



    
</body>
</html>