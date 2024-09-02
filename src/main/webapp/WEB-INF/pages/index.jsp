<%-- 
    Document   : index
    Created on : Aug 11, 2024, 6:35:33 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container mt-4">
    <h1 class="display-4 text-center mb-4">Course Manage</h1>
    <section class="container">
        <div class="mb-3">
            <a href="<c:url value="/courses/"/>" class="btn btn-info">Add Course</a>
        </div>
        <c:if test="${counter > 1}">
            <ul class="pagination justify-content-center mb-4">
                <li class="page-item"><a class="page-link" href="/online_course">All</a></li>
                    <c:forEach begin="1" end="${counter}" var="i">
                        <c:url value="/" var="pageAction">
                            <c:param name="page" value="${i}"/>
                        </c:url>
                    <li class="page-item"><a class="page-link" href="${pageAction}">${i}</a></li>
                    </c:forEach>
            </ul>
        </c:if>
        <table class="table">
            <thead>
                <tr>
                    <th></th>
                    <th>Id</th>
                    <th>Course</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Teacher</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${courses}" var="c">
                    <tr>
                        <td>
                            <img src="${c.coverImg}" alt="${c.title}" width="120" class="img-thumbnail"/>
                        </td>
                        <td>${c.id}</td>
                        <td>${c.title}</td>
                        <td>${c.price}</td>
                        <td>${c.description}</td>
                        <td>${c.teacher.fullName}</td>
                        <td>
                            <c:url value="/api/courses/${c.id}" var="apiDel"/>
                            <a href="<c:url value="/courses/${c.id}"/>" class="btn btn-success">Update</a>
                            <button class="btn btn-danger" onclick="delCourse('${apiDel}', ${c.id})">Delete</button>
                            <a href="<c:url value="/courses/assign-teacher/${c.id}"/>" class="btn btn-primary">Assign teacher</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>
</div>

<script src="<c:url value="/js/main.js"/>">

</script>