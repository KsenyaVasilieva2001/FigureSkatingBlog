<%--
  Created by IntelliJ IDEA.
  User: kseny
  Date: 04.11.2021
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" 	  		uri="http://java.sun.com/jsp/jstl/core"%>
<p class="text-center fs-1 m-4">Тренеры</p>
<div class="container">
  <section>
    <div class="row">
      <div class = "mainContent col-8">
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
                <div>
                  <div class="container">
                    <div class="row">
                      <div class="col-lg-12">
                        <div class="star-rating">
                          <span class="far fa-star" data-rating="1"></span>
                          <span class="far fa-star" data-rating="2"></span>
                          <span class="far fa-star" data-rating="3"></span>
                          <span class="far fa-star" data-rating="4"></span>
                          <span class="far fa-star" data-rating="5"></span>
                        </div>
                      </div>
                    </div>
                  </div>
                  <a type="button" class="btn blue_items">Проголосовать<i class="fas fa-long-arrow-alt-right ms-1"></i></a>
                </div>
              </div>
            </div>
            <hr>
            <div class="content">
              <p>${coach.content}</p>
            </div>
            <br>
            <section class = "comments mt-3">
              <jsp:include page="../fragment/newComment.jsp" />
              <jsp:include page="../fragment/videoComment.jsp" />
            </section>
          </div>

      </div>
      <div class="col-lg-4 col-sm-6 navig right category">
        <div class="card p-4">
          <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
           <jsp:include page="../fragment/coachCategory.jsp" />
          </div>

          <div class="input-group mt-4">

          </div>
        </div>
      </div>
    </div>
  </section>
</div>
