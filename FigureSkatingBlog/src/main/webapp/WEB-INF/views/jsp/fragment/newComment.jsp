<%--
  Created by IntelliJ IDEA.
  User: kseny
  Date: 05.11.2021
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container text-white new-comment-container comment-item">
    <div class="card">
        <div class="card-body p-4">
            <div class="d-flex flex-start w-100">
                <img
                        class="rounded-circle shadow-1-strong me-3 avatar"
                        src="https://mdbootstrap.com/img/Photos/Avatars/img%20(21).jpg"
                        alt="avatar"
                        width="65"
                        height="65"
                />
                <div>
                    <h5>Добавить комментарий</h5>
                    <div class="form-outline">
                        <textarea class="form-control" id="textAreaExample"></textarea>
                    </div>
                    <div class="d-flex justify-content-between mt-3">
                        <button type="button" class="btn blue_items">Send <i class="fas fa-long-arrow-alt-right ms-1"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
