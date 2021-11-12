
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" 	  		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 	  	uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" 	  	tagdir="/WEB-INF/tags"%>
<p class="text-center fs-1 m-4">Наши тренеры</p>
<div class="container">
    <section class="">
        <div class="row">
            <div class = "mainContent col-8">
                <c:forEach var="coach" items="${listCoaches}">
                    <c:set var="speciality" value="${SPECIALITY_MAP}" />

                    <div class="col special_col p-5 mb-4">
                        <div class = "col">
                            <a href="${pageContext.request.contextPath}${coach.url}"><img src="${coach.photoUrl}" style="width:200px; height:200px"></a>
                        </div>
                        <div class = "col">
                            <div class="data">
                                <h3><a href="${pageContext.request.contextPath}${coach.url}">${coach.name}</a></h3>
                                <h4></h4>
                                <h4>Rating: ${coach.rating}</h4>
                            </div>
                        </div>

                    </div>
                </c:forEach>
                <tags:pagination pagination="${pagination }"/>
            </div>
            <div class="col-lg-4 col-sm-6 navig right category">
                <div class="card p-4 mb-5">
                    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                        <jsp:include page="../fragment/coachCategory.jsp" />
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
