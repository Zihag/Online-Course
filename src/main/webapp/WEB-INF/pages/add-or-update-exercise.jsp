<%-- 
    Document   : add-or-update-exercise
    Created on : Sep 2, 2024, 5:59:07 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Add new exercise</h1>


<c:choose>
    <c:when test="${exercise.id == null}">
        <c:url value="/exercises" var="action"/>
    </c:when>
    <c:otherwise>
        <c:url value="/exercises" var="action"/>
    </c:otherwise>
</c:choose>
<form:form method="post" action="${action}" modelAttribute="exercise">
    <form:hidden path="id"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="title" id="title" placeholder="Enter title" />
        <label for="title">Title: </label>
        <form:errors path="title" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:textarea class="form-control" path="description" id="description" placeholder="Enter description" rows="4"></form:textarea>
            <label for="description">Description: </label>
        <form:errors path="description" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating">
        <div class="form-floating mb-3">
            <form:select class="form-select" id="courseId" path="courseId">
                <c:forEach items="${courses}" var="c">
                    <c:choose>
                        <c:when test="${c.id == exercise.courseId.id}">
                            <option value="${c.id}" selected>${c.title}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${c.id}">${c.title}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <label for="courseId" class="form-label">Select course</label>
        </div>
    </div>

    <button class="btn btn-info" type="submit">
        ${exercise.id == null ? 'Add exercise' : 'Update exercise'}
    </button>
</form:form>

