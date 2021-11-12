<%--
  Created by IntelliJ IDEA.
  User: kseny
  Date: 04.11.2021
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" 	  		uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-flex align-items-center wrapper-bg">
  <div class=" reg container " style=" margin-bottom: 15%; margin-top: 10%;">
    <div class="row d-flex justify-content-center align-items-center">
      <div class="col-12 col-md-6 col-lg-7 col-xl-6">
        <div class="card" style="border-radius: 18px; background: rgba(255, 255, 255, 0.56);">
          <div class="card-body p-4">

            <form method="post">
              <c:if test="${success eq true}">
                <div class = "text-center">
                  <h3>Ваша заявка успешно отправлена!</h3>
                  <div class=" d-flex justify-content-center mt-4">
                    <a type="button" class="btn btn-block btn-lg text-body special" href="${pageContext.request.contextPath}/signup">Отправить еще заявку</a>
                  </div>
                </div>
              </c:if>
              <c:if test="${success eq false}">
                <h3 class="text-uppercase text-center mb-3">Запишитесь на занятие прямо сейчас!</h3>
                <div class="form-outline mb-3">
                  <input type="text" placeholder="ФИО" name="userName" required class="form-control form-control-lg">
                </div>
                <div class="form-outline mb-3">
                  <input type="text" placeholder="номер телефона" name="pnone_number" required class="form-control bfh-phone form-control-lg" data-format="+7 (ddd) ddd dd-dd"  />
                </div>
                <div class=" d-flex justify-content-center">
                  <input type="submit" class="btn btn-block btn-lg text-body special" value="Оставить заявку"/>
                </div>
                <c:if test="${not empty message}">
                  <div class = "text-center">
                    <h6 class="text-danger">${message}</h6>
                  </div>
                </c:if>
              </c:if>
            </form>

          </div>
        </div>
      </div>
    </div>
  </div>
</div>
