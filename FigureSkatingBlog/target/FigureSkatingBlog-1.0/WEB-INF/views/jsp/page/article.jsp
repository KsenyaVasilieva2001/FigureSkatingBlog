<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 	  	uri="http://java.sun.com/jsp/jstl/fmt"%>
<p class="text-center fs-1 m-4">Видео</p>

<div class="container">
    <section class="">
        <div class="row">
            <div class = "mainContent col-9">
                <c:set var="category" value="${CATEGORY_MAP[article.idCategory]}" />
                <div class="col special_col p-5 mb-4">
                    <div class="embed-responsive video mb-5">
                        <iframe width="560" height="315" class="embed-responsive-item" src="${article.videoUrl}" allowfullscreen></iframe>
                    </div>
                    <div class="data">
                <h3><a href="${pageContext.request.contextPath}${article.articleUrl}">${article.title}</a></h3>
                <ul class="vertical large-horizontal menu">
                <li class="blue_items"><i class="fas fa-comments"></i></i><fmt:formatNumber value="${article.comments}" /> comments</li>
                <li class="blue_items"><i class="fas fa-clock"></i></i><fmt:formatDate value="${article.created}" dateStyle="FULL" timeStyle="SHORT" type="both"/></li>
                <li class="blue_items"><i class="fas fa-eye"></i></i>Hits: <fmt:formatNumber value="${article.views}" /></li>
                </ul>
                <hr>
                <div class="content">
                <p>${article.content}</p>
                </div>
                <br>
                    </div>
                    <section class = "comments">
                        <jsp:include page="../fragment/newComment.jsp" />
                        <jsp:include page="../fragment/videoComment.jsp" />
                    </section>
                </div>
            </div>
            <div class="col-3 navig right">
                <div class="card p-3">
                    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                       <jsp:include page="../fragment/videoCategory.jsp" />
                    </div>

                        <form action="${pageContext.request.contextPath}/search" method="GET">
                            <div class="input-group mt-4">
                                <input id="search" class="form-control" name="query" placeholder="поиск" type="text" value="${searchQuery }" aria-label="Search" aria-describedby="search-addon"/>
                                <div class="input-group-button">
                                    <button class="btn btn_search" value="Find" type="submit" ><i class="fas fa-search"></i></button>
                                </div>
                            </div>
                        </form>

                </div>
            </div>
        </div>
    </section>
</div>
