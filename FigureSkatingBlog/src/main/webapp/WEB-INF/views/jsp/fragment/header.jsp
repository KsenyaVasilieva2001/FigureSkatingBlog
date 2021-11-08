<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <div id="brand">
        <img src="${pageContext.request.contextPath}/static/images/figure-skatingPNG.png" width="50%" alt="logo">
    </div>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto  mb-lg-0 nav-pills ">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/mainpage">Главная</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/videoblog">Видео</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/signup">Запись на занятия</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/about">О нас</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/signin">Вход | Регистрация</a>
            </li>
        </ul>
    </div>
</div>
