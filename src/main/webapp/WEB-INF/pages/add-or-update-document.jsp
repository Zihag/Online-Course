<%-- 
    Document   : add-document
    Created on : Sep 1, 2024, 11:17:35 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Add new Document</h1>

<c:choose>
    <c:when test="${document.id == null}">
        <c:url value="/documents/add-document" var="action"/>
    </c:when>
    <c:otherwise>
        <c:url value="/documents/update" var="action"/>
    </c:otherwise>
</c:choose>
<form:form method="post" action="${action}" modelAttribute="document">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <form:hidden path="id"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="title" id="title" placeholder="Enter title" />
        <label for="title">Title: </label>
        <form:errors path="title" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="url" id="url" placeholder="Enter URL" />
        <label for="url">URL: </label>
        <form:errors path="url" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating">
        <div class="form-floating mb-3">
            <form:select class="form-select" id="courseId" path="courseId">
                <c:forEach items="${courses}" var="c">
                    <c:choose>
                        <c:when test="${c.id == document.courseId.id}">
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
        ${document.id == null ? 'Add Document' : 'Update Document'}
    </button>
</form:form>

