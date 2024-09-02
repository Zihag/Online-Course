<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container mt-3">
    <h1 class="display-4 text-center mb-4">Document Manage</h1>

    <!-- Course Selector -->
    <form action="<c:url value='/documents'/>" method="get" class="mb-3">
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

    <!-- Add Document Button -->
    <div class="mb-3">
        <a href="<c:url value="/documents/add-document"/>" class="btn btn-info">Add Document</a>
    </div>

    <!-- Documents Table -->
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
            <c:forEach items="${documents}" var="d">
                <tr>
                    <td>${d.id}</td>
                    <td>${d.title}</td>
                    <td><a href="${d.url}" target="_blank">${d.url}</a></td>
                    <td>${d.courseId.title}</td>
                    <td>
                        <c:url value="/api/documents/${d.id}" var="apiDel"/>
                        <a href="<c:url value="/documents/${d.id}/update"/>" class="btn btn-success btn-sm">Edit</a>

                        <button class="btn btn-danger" onclick="delCourse('${apiDel}', ${d.id})">Delete</button>                    
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="<c:url value="/js/main.js"/>">

</script>
