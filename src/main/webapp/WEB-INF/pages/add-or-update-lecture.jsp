<%-- 
    Document   : add-lecture
    Created on : Sep 2, 2024, 2:48:08 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:choose>
    <c:when test="${lecture.id == null}">
        <c:url value="/lectures/add-lecture" var="action"/>
    </c:when>
    <c:otherwise>
        <c:url value="/lectures/update" var="action"/>
    </c:otherwise>
</c:choose>
<form:form method="post" action="${action}" modelAttribute="lecture" >
    <form:errors path="*" element="div" cssClass="alert alert-danger"/> 
    <form:hidden path="id"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="title" id="title" placeholder="Enter title" />
        <label for="title">Title</label>
        <form:errors path="title" element="div" cssClass="text-danger"/>
    </div>
    
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="content" id="content" placeholder="Enter content" />
        <label for="content">Content</label>
        <form:errors path="content" element="div" cssClass="text-danger"/>

    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="url" id="url" placeholder="Enter url" />
        <label for="url">Url</label>
        <form:errors path="url" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating">
        <form:select class="form-select" id="courseId" name="courseId" path="courseId">
            <c:forEach items="${courses}" var="c">
                <c:choose>
                    <c:when test="${c.id == lecture.courseId.id}">           
                        <option value="${c.id}" selected>${c.title}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.title}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="courseId" class="form-label">Select list (select one):</label>
    </div>

    <div class="mb-3 mt-3">
        <form:hidden path="id" />
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${lecture.id != null}">Update lecture</c:when>
                <c:otherwise>Add lecture</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>