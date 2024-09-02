<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
    <c:url value="/courses/assign-teacher" var="action"/>
    <form:form method="post" action="${action}" modelAttribute="assignedCourse">
        <form:errors path="*" element="div" cssClass="alert alert-danger"/> 
        <form:hidden path="id"/>
        <h1 class="display-4 text-center mb-4">Assign Teacher to Course: ${assignedCourse.title}</h1>
        <div class="form-floating mb-3">
            <form:select class="form-select" id="teacher" path="teacher">
                <c:forEach items="${teachers}" var="t">
                    <form:option value="${t.id}">${t.fullName}</form:option>
                </c:forEach>
            </form:select>
            <label for="teacher" class="form-label">Select Teacher:</label>
        </div>
        <form:hidden path="coverImg" value="${assignedCourse.coverImg}"/>
        <form:hidden path="title" value="${assignedCourse.title}"/>
        <form:hidden path="description" value="${assignedCourse.description}"/>
        <form:hidden path="price" value="${assignedCourse.price}"/>
        <form:hidden path="category" value="${assignedCourse.category.id}"/>
        
        <button type="submit" class="btn btn-primary">Assign Teacher</button>
    </form:form>
</div>
