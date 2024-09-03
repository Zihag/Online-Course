<%-- 
    Document   : exercises
    Created on : Sep 2, 2024, 6:00:58 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container mt-3">
    <h1 class="display-4 text-center mb-4">Exercise Manage</h1>

    <!-- Course Selector -->
    <form action="<c:url value='/exercises'/>" method="get" class="mb-3">
        <div class="form-group">
            <label for="courseSelect" class="form-label">Select Course:</label>
            <select id="courseSelect" name="courseId" class="form-select" onchange="this.form.submit()">
                <option value="" disabled selected>Select a course</option>
                <c:forEach items="${courses}" var="c">
                    <option value="${c.id}" ${param.courseId == c.id ? 'selected' : ''}>${c.title}</option>
                </c:forEach>
            </select>
        </div>
    </form>

    <div class="mb-3">
        <a href="<c:url value="/exercises/add"/>" class="btn btn-info">Add exercise</a>
    </div>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Description</th>
                <th>Course</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${exercises}" var="e">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.title}</td>
                    <td>${e.description}</td>
                    <td>${e.courseId.title}</td>
                    <td>
                        <a href="<c:url value="/exercises/${e.id}"/>" class="btn btn-success btn-sm">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>



