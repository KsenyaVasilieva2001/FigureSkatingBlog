<%--
  Created by IntelliJ IDEA.
  User: kseny
  Date: 04.11.2021
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="d-flex align-items-center wrapper-bg">
  <div class=" reg container " style=" margin-bottom: 15%; margin-top: 10%;">
    <div class="row d-flex justify-content-center align-items-center">
      <div class="col-12 col-md-6 col-lg-7 col-xl-6">
        <div class="card" style="border-radius: 18px; background: rgba(255, 255, 255, 0.56);">
          <div class="card-body p-4">
            <h3 class="text-uppercase text-center mb-3">Запишитесь на занятие прямо сейчас!</h3>

            <form>
              <div class="form-outline mb-3">
                <input type="text" placeholder="ФИО" name="username_" required class="form-control form-control-lg">
              </div>
              <div class="form-outline mb-3">
                <input type="text" placeholder="номер телефона" name="pnone_number" required class="form-control bfh-phone form-control-lg" data-format="+7 (ddd) ddd dd-dd"  />
              </div>
              <div class=" d-flex justify-content-center">
                <button type="button" class="btn btn-block btn-lg text-body special">Оставить заявку</button>
              </div>
            </form>

          </div>
        </div>
      </div>
    </div>
  </div>
</div>
