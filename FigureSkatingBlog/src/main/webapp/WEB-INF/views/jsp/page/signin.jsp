<%--
  Created by IntelliJ IDEA.
  User: kseny
  Date: 04.11.2021
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" 	  		uri="http://java.sun.com/jsp/jstl/core"%>
<div class = "wrapper-bg">
  <div class="d-flex align-items-center">
    <div class=" reg container " style=" margin-bottom: 15%; margin-top: 7%;">
      <div class="row d-flex justify-content-center align-items-center">
        <div class="col-12 col-md-6 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 18px; background: rgba(255, 255, 255, 0.56);">
            <div class="card-body p-4">
              <h3 class="text-uppercase text-center mb-3">Вход</h3>

              <form>
                <div class="form-outline mb-3">
                  <input type="text" placeholder="email" name="email" required class="form-control form-control-lg">
                </div>
                <div class="form-outline mb-3">
                  <input type="password" placeholder="пароль" name = "password" aria-describedby="passwordHelp" required class="form-control form-control-lg" />
                </div>
                <div class="d-flex justify-content-center">
                  <input type="submit" class="btn btn-block btn-outline-primary text-body outline" style="font-size: large; border-width: 2px; border-color: #337ab7 " value="Войти в аккаунт">
                  <button type="button" class="btn btn-block btn-lg" href="#">
                    <i class="fab fa-google-plus fa-2x" style="color: #337ab7" aria-hidden="true"></i>
                  </button>
                  <c:if test="${not empty message}">
                    <div class = "text-center">
                      <h6 class="text-danger">${message}</h6>
                    </div>
                  </c:if>
                </div>
                <p class="text-center text-muted mt-3 mb-0">Еще нет аккаунта? <a href="<c:url value="/registration"/>" class="fw-bold text-body"><u>Регистрация</u></a></p>
              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>