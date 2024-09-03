<%-- 
    Document   : header
    Created on : Aug 16, 2024, 11:31:29 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/" var ="action" />
<c:url value="/teachers" var="teacherAction"/>
<c:url value="/documents" var="documentAction"/>
<c:url value="/exercises" var="exerciseAction"/>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: rgba(0, 0, 0, 0.05);">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold" href="javascript:void(0)">Online Course</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto ">
                <li class="nav-item">
                    <a class="nav-link fw-bold" href="${action}">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fw-bold" href="${action}">Course Manage</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fw-bold" href="${teacherAction}">Teacher Manage</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fw-bold" href="${documentAction}">Document Manage</a>
                    <a class="nav-link fw-bold" href="${teacherAction}">Lecture Manage</a>
                    <a class="nav-link fw-bold" href="${exerciseAction}">Exercise Manage</a>
                </li>
                <div class="dropdown">
                    <div class="dropdown">
                        <button type="button" class="btn dropdown-toggle fw-bold" data-bs-toggle="dropdown">
                            Category
                        </button>
                        <ul class="dropdown-menu">
                            <c:forEach items = "${categories}" var = "c">
                                <c:url value="/" var ="cateAction" >
                                    <c:param name="cateId" value="${c.id}"/>
                                </c:url>
                                <a class="nav-link fw-bold" href="${cateAction}">${c.name}</a>

                            </c:forEach>
                        </ul>
                    </div>
                </div>

            </ul>
            <form class="d-flex input-group w-auto" action="${action}">
                <input class="form-control" type="text" name="kw" placeholder="Search" aria-label="Search">
                <button data-mdb-ripple-init class="btn btn-outline-primary" type="submit" data-mdb-ripple-color="dark">Search</button>
            </form>
            <c:choose>
                <c:when test="${not empty pageContext.request.userPrincipal}">
                    <a class="nav-link fw-bold text-primary" href="<c:url value='/'/>">Chào ${pageContext.request.userPrincipal.name}!</a>
                    <a class="btn btn-danger" href="<c:url value="/logout" />">
                        Đăng xuất
                    </a>
                </c:when>
                <c:otherwise>
                    <a class="nav-link fw-bold text-primary" href="<c:url value='/login'/>">Login</a>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</nav>


