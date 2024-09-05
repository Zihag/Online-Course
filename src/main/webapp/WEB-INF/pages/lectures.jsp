<%-- 
    Document   : lectures
    Created on : Sep 2, 2024, 1:23:38 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container mt-3">
    <h1 class="display-4 text-center mb-4">Lecture Manage</h1>

    <!-- Course Selector -->
    <form action="<c:url value='/lectures'/>" method="get" class="mb-3">
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

    <!-- Add Lecture Button -->
    <div class="mb-3">
        <a href="<c:url value="/lectures/add-lecture"/>" class="btn btn-info">Add Lecture</a>
    </div>

    <!-- Lectures Table -->
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>URL</th>
                <th>Course</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lectures}" var="l">
                <tr>
                    <td>${l.id}</td>
                    <td>${l.title}</td>
                    <td>${l.content}</td>
                    <td><a href="${l.url}" target="_blank">${l.url}</a></td>
                    <td>${l.courseId.title}</td>
                    <td>
                        <c:url value="/api/lectures/${l.id}/delete" var="apiDel"/>
                        <a href="<c:url value="/lectures/${l.id}/update"/>" class="btn btn-success btn-sm">Edit</a>

                        <button class="btn btn-danger" onclick="deleteLecture('${apiDel}', ${d.id})">Delete</button>                    
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="<c:url value="/js/main.js"/>">

</script>

