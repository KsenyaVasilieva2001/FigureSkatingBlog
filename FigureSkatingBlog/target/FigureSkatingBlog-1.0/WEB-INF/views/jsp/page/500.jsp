<%--
  Created by IntelliJ IDEA.
  User: kseny
  Date: 11.11.2021
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class = "wrapper-bg p-5">
    <div class="container p-5">
        <div class="row">
            <div class="col-md-12">
                <div class="error-template">
                    <h1>
                        Oops!</h1>
                    <h2>
                        500 Internal Server Error</h2>
                    <div class="error-details">
                        Кажется, мы обнаружили ошибку...
                    </div>
                    <div class="error-actions">
                        <a href="${pageContext.request.contextPath}/mainpage" class="btn blue_items special btn-lg" style="color: black;">
                            Вернуться домой </a><a href="${pageContext.request.contextPath}/mainpage" class="btn btn-default btn-lg"> Оставить отзыв </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
