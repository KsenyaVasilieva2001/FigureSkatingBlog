<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 	  		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 	  	uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:forEach var="comment" items="${comments }">
<div class="media-object comment-item" data-id-comment="${comment.id}">
    <div class="container text-white mt-3 ">
        <div class="card">
            <div class="card-body p-4">
                <div class="d-flex flex-start">
                    <img
                            class="rounded-circle shadow-1-strong me-3 avatar"
                            src="${comment.account.getAvatar()}"
                            alt="avatar"
                            width="65"
                            height="65"
                    />
                    <div>
                        <div class="media-object-section">
                        <h5 class = "name">${comment.account.login}</h5>
                        <p>${comment.content }</p>
                        <p class="meta">
                            <small><fmt:formatDate type="both" value="${comment.created}" dateStyle="MEDIUM" timeStyle="SHORT"/></small>
                            <a class = "blue_items" href="javascript:reply('${comment.account.login}');">Ответить</a>
                        </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</c:forEach>


