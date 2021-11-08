
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a class="nav-link active disabled"  id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Категории</a>
<c:forEach var="categoryEntry" items="${CATEGORY_MAP}"><c:set var="cat" value="${categoryEntry.value}" />
    <a class="nav-link ${selectedCategory.id == categoryEntry.key ? "active" : ""}"  id="v-pills" data-toggle="pill" href="${pageContext.request.contextPath}/videoblog${cat.url}" role="tab" aria-controls="v-pills-profile" aria-selected="true">${cat.name}</a>
</c:forEach>