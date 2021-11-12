
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="carouselIndicators" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="static/images/imgonline-com-ua-Resize-8B7HGEQsitGwt.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block mb-5"  style="font-size: xx-large; text-align: left; font-style: italic;">
                Осуществи свою мечту - научись кататься на коньках
            </div>
        </div>
        <div class="carousel-item">
            <img src="static/images/imgonline-com-ua-Resize-Tn1510NAjWPKpW.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block mb-5"  style="font-size: xx-large; text-align: left; font-style: italic; color:rgb(28, 77, 184);">
                Не иди за всеми - иди впереди всех
            </div>
        </div>
        <div class="carousel-item">
            <img src="static/images/1614676774_9-p-fon-figurnoe-katanie-9.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block mb-5"  style="font-size: xx-large; text-align: right; font-style: italic; color:rgb(255, 255, 255)">
                Брось вызов самому себе
            </div>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselIndicators" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselIndicators" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<p class="text-center fs-1 mt-5 mb-5">Добро пожаловать в клуб фигурного катания Free Skating!</p>

<div class="container-fluid bg-dark text-white d-flex justify-content-center">
    <section class="mb-5 p-3">
        <div class="row m-2">
            <div class="col p-5 m-5 text-wrap special_col" style="font-size:x-large; text-align: center;" >
                Начните заниматься фигурным катанием прямо сейчас
                <div class="d-flex justify-content-center mt-3 ">
                    <button type="button" class="btn btn-block btn-lg text-body special round" onClick='location.href="${pageContext.request.contextPath}/signup"'>Записаться</button>
                </div>
            </div>
            <div class="col p-5 m-5 text-wrap special_col" style="font-size: x-large; text-align: center;">
                Познакомьтесь с нашей дружной командой тренеров
                <div class="d-flex justify-content-center mt-5">
                    <button type="button" class="btn btn-block btn-lg text-body special round" onClick='location.href="${pageContext.request.contextPath}/coach-list"'>Тренеры</button>
                </div>
            </div>
            <div class="col p-5 m-5 text-wrap special_col" style="font-size: x-large; text-align: center;">
                Изучайте элементы фигурного катания онлайн
                <div class="d-flex justify-content-center mt-5">
                    <button type="button" class="btn btn-block btn-lg text-body special round" onClick='location.href="${pageContext.request.contextPath}/videoblog"'>Видеокурс</button>
                </div>
            </div>
        </div>
    </section>
</div>
<div class="m-5">
    <section>
        <p class = "text-uppercase fs-2 mt-5" style="font-size: x-large;">O клубе</p>
        <img src="static/images/Group 2линия.png" class="mb-3" id="about">
        <div class="row">
            <div class="col text-wrap desc" style="font-size: larger;">
                Студенты и взрослые! Наш Клуб - единственный в Казани, где вы сможете "с нуля" научиться кататья на коньках, а также усовершенствовать свое мастерство! Принять участие в соревнованиях для спортсменов-любителей, почувствовать себя настоящим спортсменом!
                Наши дети успешно выступают в спортивных соревнованиях в категории "юный фигурист" и "первые шаги"!
                Наш Клуб является учредителем и организатором ежегодных Открытых соревнований для спортсменов-любителей "Весенняя капель".

            </div>
            <div class = "col" style="text-align:center">
                <img src="static/images/Ellipse 1Photo.png" class="mb-3">
                <div class = "text-wrap desc" style="text-align: center; font-size: larger; font-weight: bold;">
                    Трусова Регина Викторовна
                </div>
                <div class = "text-wrap desc" style="text-align: center;">
                    Руководитель и основатель Клуба фигурного катания «Движение» г.Казань
                </div>
            </div>
        </div>
    </section>
</div>