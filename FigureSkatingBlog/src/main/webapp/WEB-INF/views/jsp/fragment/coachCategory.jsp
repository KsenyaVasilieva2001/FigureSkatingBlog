<%--
  Created by IntelliJ IDEA.
  User: kseny
  Date: 05.11.2021
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a class="nav-link active disabled"  id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Тренеры</a>
<c:forEach var="listCoachEntry" items="${COACH_MAP}"><c:set var="coach" value="${listCoachEntry.value}" />
    <a class="nav-link " id="v-pills" data-toggle="pill" href="${pageContext.request.contextPath}${coach.url}" role="tab" aria-controls="v-pills-profile" aria-selected="false">${coach.name}</a>
</c:forEach>