<%--
  Created by IntelliJ IDEA.
  User: kseny
  Date: 10.11.2021
  Time: 12:38-3
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <p class="text-center fs-1 m-4">Профиль</p>
    <div class="container col-12 special_col mb-4 text-center">
        <img
                class="rounded-circle shadow-1-strong me-3 avatar mb-3"
                src="${user.avatar}" alt="anonym"
                width="250"
                height="250"
        />
        <br/>
        <h4>Login: ${user.login} </h4>
        <h4>Email: ${user.email}</h4>
        <div class="row">
            <c:if test="${empty user.first_name or empty user.last_name}">
                <c:if test="${update eq null}">
                    <form method="post">
                    <div class="form-outline">
                        <input type="text" id="form3Examplev2" name = "first_name" required class="form-control form-control-lg" />
                        <label class="form-label" for="form3Examplev2">Фамилия</label>
                    </div>
                        <div class="form-outline">
                            <input type="text" id="form3Examplev3"  name = "last_name" required class="form-control form-control-lg" />
                            <label class="form-label" for="form3Examplev3">Имя</label>
                        </div>
                    <div class="d-flex justify-content-center mb-2">
                        <input type="submit" class="btn btn-block btn-lg text-body special" value="Сохранить изменения">
                    </div>
                    </form>
                </c:if>
            </c:if>

                    <h4>First Name: ${user.first_name} </h4>
                    <h4>Last Name: ${user.last_name}</h4>

        <a href="${pageContext.request.contextPath}/logout" class="logout-button">Выйти</a>
    </div>


    </div>