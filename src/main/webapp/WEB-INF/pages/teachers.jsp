<%-- 
    Document   : teachers.jsp
    Created on : Aug 20, 2024, 11:41:57 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container mt-3">
    <h1 class="display-4 text-center mb-4">Teacher Manage</h1>
    <div class="mb-3">
        <a href="<c:url value="/teachers/add-teacher"/>" class="btn btn-info">Add Teacher</a>
    </div>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Id</th>
                <th>Full name</th>
                <th>Gender</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${teachers}" var="teacher">
                <tr>
                    <td>${teacher.id}</td>
                    <td>${teacher.fullName}</td>
                    <td>${teacher.gender}</td>
                    <td>${teacher.email}</td>
                    <td>
                        <a href="#" class="btn btn-success btn-sm ms-2">
                            Add class
                        </a>
                        <a href="#" class="btn btn-danger btn-sm" title="Delete">
                            <i class="fas fa-trash"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>