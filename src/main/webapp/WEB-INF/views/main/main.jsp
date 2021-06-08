<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PEOPLAY</title>
<link rel="stylesheet" href="/peoplay/resources/css/common/reset.css">
<link rel="stylesheet" href="/peoplay/resources/css/main/main.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	const message = '${ requestScope.message }';
	if(message != null && message !== '') {
		alert(message);
	}
</script>
</head>
<body>
<body>
    <div id="wrap">
	<jsp:include page="../common/header.jsp"/>
        <main class="main">
            <div class="banner">
            	<c:forEach var="movieImg" items="${ requestScope.banner.movieFile }">
	            	<c:if test="${ movieImg.fileType == 'MAIN' }">
		                <img src="${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/${ movieImg.saveName }">
	            	</c:if>
            	</c:forEach>
                <div class="banner_contents">
                    <p class="banner_title">${ requestScope.banner.name }</p>
                    <p class="banner_subTitle">요새 뜨고 있는 작품 1위</p>
                    <p class="banner_intro">
						${ requestScope.banner.info }
                    </p>
                    <button class="banner_play" onClick="location.href='${pageContext.servletContext.contextPath}/movie/${ requestScope.banner.no }/play'">▶ 재생</button>
                    <button class="banner_detail" onClick="location.href='${pageContext.servletContext.contextPath}/movie/${ requestScope.banner.no }'">상세 정보</button>
                </div>
            </div>
            <div class="main_contents">
            
            	<c:if test="${ !empty sessionScope.loginMember }">
            		<c:if test="${ !empty requestScope.zzimList }">
		                <section class="main_section">
		                    <p class="main_title">내가 찜한 영화</p>
		                    <ul>
		                        <li>
			            			<c:if test="<fn:length(${ requestScope.zzimList })/> gt 8">
			                        <div id="zzim-left" class="section_btn">
			                            <img src="${ pageContext.servletContext.contextPath }/resources/images/main-left-arrow.png">
			                        </div>
		                            </c:if>
		                        </li>
		                        <li>
		                            <div class="movieList">
		                                <div id="zzim" class="slide">
		                                    <c:forEach var="zzim" items="${ requestScope.zzimList }" begin="0" end="15">
			                                    <div class="movie" onClick="location.href='${pageContext.servletContext.contextPath}/movie/${ zzim.no }'">
			                                    	<c:forEach var="movieImg" items="${ zzim.movieFile }">
										            	<c:if test="${ movieImg.fileType == 'SUB' }">
											                <img src="${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/${ movieImg.saveName }">
										            	</c:if>
									            	</c:forEach>
			                                        <p>${ zzim.name }</p>
			                                    </div>
	                                		</c:forEach>
		                                </div>
		                            </div>
		                        </li>
		                        <li>
		                        	<c:if test="<fn:length(${ requestScope.zzimList })/> gt 8">
		                            <div id="zzim-right" class="section_btn">
		                                <img src="${ pageContext.servletContext.contextPath }/resources/images/main-right-arrow.png">
		                            </div>
		                            </c:if>
		                        </li>
		                    </ul>
		                </section>
	                </c:if>
	                <section class="main_section">
	                    <p class="main_title">추천 영화</p>
	                    <ul>
	                        <li>
	                        	<c:if test="<fn:length(${ requestScope.favList })/> gt 8">
	                            <div id="fav-left" class="section_btn">
	                                <img src="${ pageContext.servletContext.contextPath }/resources/images/main-left-arrow.png">
	                            </div>
	                            </c:if>
	                        </li>
	                        <li>
	                            <div class="movieList">
	                                <div id="fav" class="slide">
	                                    <c:forEach var="fav" items="${ requestScope.favList }" begin="0" end="15">
		                                    <div class="movie" onClick="location.href='${pageContext.servletContext.contextPath}/movie/${ fav.no }'">
		                                    	<c:forEach var="movieImg" items="${ fav.movieFile }">
									            	<c:if test="${ movieImg.fileType == 'SUB' }">
										                <img src="${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/${ movieImg.saveName }">
									            	</c:if>
								            	</c:forEach>
		                                        <p>${ fav.name }</p>
		                                    </div>
	                                	</c:forEach>
	                                </div>
	                            </div>
	                        </li>
	                        <li>
	                        	<c:if test="<fn:length(${ requestScope.favList })/> gt 8">
	                            <div id="fav-right" class="section_btn">
	                                <img src="${ pageContext.servletContext.contextPath }/resources/images/main-right-arrow.png">
	                            </div>
	                            </c:if>
	                        </li>
	                    </ul>
	                </section>
	            </c:if>
	            
                <section class="main_section">
                    <p class="main_title">인기 영화</p>
                    <ul>
                        <li>
                        	<c:if test="<fn:length(${ requestScope.bestList })/> gt 8">
                            <div id="best-left" class="section_btn">
                                <img src="${ pageContext.servletContext.contextPath }/resources/images/main-left-arrow.png">
                            </div>
                            </c:if>
                        </li>
                        <li>
                            <div class="movieList">
                                <div id="best" class="slide">
                                	<c:forEach var="best" items="${ requestScope.bestList }" begin="0" end="15">
	                                    <div class="movie" onClick="location.href='${pageContext.servletContext.contextPath}/movie/${ best.no }'">
	                                    	<c:forEach var="movieImg" items="${ best.movieFile }">
								            	<c:if test="${ movieImg.fileType == 'SUB' }">
									                <img src="${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/${ movieImg.saveName }">
								            	</c:if>
							            	</c:forEach>
	                                        <p>${ best.name }</p>
	                                    </div>
                                	</c:forEach>
                                </div>
                            </div>
                        </li>
                        <li>
                        	<c:if test="<fn:length(${ requestScope.bestList })/> gt 8">
                            <div id="best-right" class="section_btn">
                                <img src="${ pageContext.servletContext.contextPath }/resources/images/main-right-arrow.png">
                            </div>
                            </c:if>
                        </li>
                    </ul>
                </section>
                <section class="main_section">
                    <p class="main_title">최신 영화</p>
                    <ul>
                        <li>
                        	<c:if test="<fn:length(${ requestScope.newList })/> gt 8">
                            <div id="new-left" class="section_btn">
                                <img src="${ pageContext.servletContext.contextPath }/resources/images/main-left-arrow.png">
                            </div>
                            </c:if>
                        </li>
                        <li>
                            <div class="movieList">
                                <div id="new" class="slide">
                                    <c:forEach var="newMovie" items="${ requestScope.newList }" begin="0" end="15">
	                                    <div class="movie" onClick="location.href='${pageContext.servletContext.contextPath}/movie/${ newMovie.no }'">
	                                    	<c:forEach var="movieImg" items="${ newMovie.movieFile }">
								            	<c:if test="${ movieImg.fileType == 'SUB' }">
									                <img src="${ pageContext.servletContext.contextPath }/resources/images/movieImageFiles/${ movieImg.saveName }">
								            	</c:if>
							            	</c:forEach>
	                                        <p>${ newMovie.name }</p>
	                                    </div>
                                	</c:forEach>
                                </div>
                            </div>
                        </li>
                        <li>
                        	<c:if test="<fn:length(${ requestScope.newList })/> gt 8">
                            <div id="new-right" class="section_btn">
                                <img src="${ pageContext.servletContext.contextPath }/resources/images/main-right-arrow.png">
                            </div>
                            </c:if>
                        </li>
                    </ul>
                </section>
            </div>
        </main>
	<jsp:include page="../common/footer.jsp"/>
    </div>
    <script>
        ;(function($){
            var zzimSlide = {
                init: function(){
                    this.slideFn();
                },
                
                slideFn:function(){
                var $slideWrap = $('#zzim');
                var $nextBtn = $('#zzim-right');
                var $prevBtn = $('#zzim-left');
                var cnt = 0;

                function mainSlideFn(){
                    if(cnt == -2){
                    $slideWrap.stop().animate({left:-1520},0);
                    cnt = -1;
                    }else if(cnt == 1){
                    $slideWrap.stop().animate({left:0},0);
                    cnt = 0;
                    }else{
                    $slideWrap.stop().animate({left:cnt*1520},600)
                    }
                }
                function nextSlideFn(){
                    cnt--;
                    console.log(cnt);
                    mainSlideFn();
                }
                function prevSlideFn(){
                    cnt++;
                    console.log(cnt);
                    mainSlideFn();
                }
                $nextBtn.on({
                    click:function(){
                    if(!$slideWrap.is(':animated')){
                        nextSlideFn()
                    }
                    }
                })
                $prevBtn.on({
                    click:function(){
                    if(!$slideWrap.is(':animated')){
                        prevSlideFn()
                    }
                    }
                })
                }      
            }
            zzimSlide.init();

            var favSlide = {
                init: function(){
                    this.slideFn();
                },
                
                slideFn:function(){
                var $slideWrap = $('#fav');
                var $nextBtn = $('#fav-right');
                var $prevBtn = $('#fav-left');
                var cnt = 0;

                function mainSlideFn(){
                    if(cnt == -2){
                    $slideWrap.stop().animate({left:-1520},0);
                    cnt = -1;
                    }else if(cnt == 1){
                    $slideWrap.stop().animate({left:0},0);
                    cnt = 0;
                    }else{
                    $slideWrap.stop().animate({left:cnt*1520},600)
                    }
                }
                function nextSlideFn(){
                    cnt--;
                    console.log(cnt);
                    mainSlideFn();
                }
                function prevSlideFn(){
                    cnt++;
                    console.log(cnt);
                    mainSlideFn();
                }
                $nextBtn.on({
                    click:function(){
                    if(!$slideWrap.is(':animated')){
                        nextSlideFn()
                    }
                    }
                })
                $prevBtn.on({
                    click:function(){
                    if(!$slideWrap.is(':animated')){
                        prevSlideFn()
                    }
                    }
                })
                }      
            }
            favSlide.init();

            var bestSlide = {
                init: function(){
                    this.slideFn();
                },
                
                slideFn:function(){
                var $slideWrap = $('#best');
                var $nextBtn = $('#best-right');
                var $prevBtn = $('#best-left');
                var cnt = 0;

                function mainSlideFn(){
                    if(cnt == -2){
                    $slideWrap.stop().animate({left:-1520},0);
                    cnt = -1;
                    }else if(cnt == 1){
                    $slideWrap.stop().animate({left:0},0);
                    cnt = 0;
                    }else{
                    $slideWrap.stop().animate({left:cnt*1520},600)
                    }
                }
                function nextSlideFn(){
                    cnt--;
                    console.log(cnt);
                    mainSlideFn();
                }
                function prevSlideFn(){
                    cnt++;
                    console.log(cnt);
                    mainSlideFn();
                }
                $nextBtn.on({
                    click:function(){
                    if(!$slideWrap.is(':animated')){
                        nextSlideFn()
                    }
                    }
                })
                $prevBtn.on({
                    click:function(){
                    if(!$slideWrap.is(':animated')){
                        prevSlideFn()
                    }
                    }
                })
                }      
            }
            bestSlide.init();

            var newSlide = {
                init: function(){
                    this.slideFn();
                },
                
                slideFn:function(){
                var $slideWrap = $('#new');
                var $nextBtn = $('#new-right');
                var $prevBtn = $('#new-left');
                var cnt = 0;

                function mainSlideFn(){
                    if(cnt == -2){
                    $slideWrap.stop().animate({left:-1520},0);
                    cnt = -1;
                    }else if(cnt == 1){
                    $slideWrap.stop().animate({left:0},0);
                    cnt = 0;
                    }else{
                    $slideWrap.stop().animate({left:cnt*1520},600)
                    }
                }
                function nextSlideFn(){
                    cnt--;
                    console.log(cnt);
                    mainSlideFn();
                }
                function prevSlideFn(){
                    cnt++;
                    console.log(cnt);
                    mainSlideFn();
                }
                $nextBtn.on({
                    click:function(){
                    if(!$slideWrap.is(':animated')){
                        nextSlideFn()
                    }
                    }
                })
                $prevBtn.on({
                    click:function(){
                    if(!$slideWrap.is(':animated')){
                        prevSlideFn()
                    }
                    }
                })
                }      
            }
            newSlide.init();
        })(jQuery);
    </script> 
</body>
</html>