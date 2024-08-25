<%-- 
    Document   : add-teacher.jsp
    Created on : Aug 22, 2024, 7:11:04 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Add new teacher</h1>

<c:url value="/teachers/add-teacher/" var="action"/>
<form:form method="post" action="${action}" modelAttribute="user">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="fullName" id="fullName" placeholder="Enter teachers' full name" />
        <label for="fullName">Full name: </label>
        <form:errors path="fullName" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="email" id="email" placeholder="Enter email" />
        <label for="email">Email:</label>
        <form:errors path="email" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="userName" id="userName" placeholder="Enter username" />
        <label for="userName">User name:</label>
        <form:errors path="userName" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="password" id="password" placeholder="Enter password" />
        <label for="password">Password:</label>
        <form:errors path="password" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="gender" id="gender" placeholder="Enter gender" />
        <label for="gender">Gender:</label>
        <form:errors path="gender" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="phone" id="phone" placeholder="Enter phone" />
        <label for="phone">Phone:</label>
        <form:errors path="phone" element="div" cssClass="text-danger"/>
    </div>

    <button class="btn btn-info" type="submit">
        <form:hidden path="role" value="ROLE_TEACHER"/>
        Add teacher
    </button>
</form:form>

