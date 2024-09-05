<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:choose>
    <c:when test="${course.id != null}"><h1>Update course</h1></c:when>
    <c:otherwise><h1>Add new course</h1></c:otherwise>
</c:choose>

<c:url value="/courses" var="action"/>
<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="course" onsubmit="formatPriceBeforeSubmit()">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/> 
    <form:hidden path="id"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="title" id="title" placeholder="Enter title" />
        <label for="title">Title</label>
        <form:errors path="title" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="price" id="price" placeholder="Enter price" oninput="formatPrice(this)" />
        <label for="price" >Price</label>
        <form:errors path="price" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="description" id="description" placeholder="Enter description" />
        <label for="description">Description</label>
        <form:errors path="description" element="div" cssClass="text-danger"/>
    </div>

    <div class=" mb-3 mt-3">
        <label class="form-label" for="file">Upload cover image</label>
        <form:input type="file" class="form-control" path="file" id="file"/>
        <c:if test="${course.id != null}">
            <img src="${course.coverImg}" alt="${course.title}" width="120" />
        </c:if>
    </div>

    <div class="form-floating">
        <form:select class="form-select" id="sel1" name="sellist" path="category">
            <c:forEach items="${categories}" var="c">
                <c:choose>
                    <c:when test="${c.id == course.category.id}">           
                        <option value="${c.id}" selected>${c.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="sel1" class="form-label">Select list (select one):</label>
    </div>

    <div class="form-floating mb-3">
        <form:select class="form-select" id="teacher" path="teacher">
            <option value="">None</option>
            <c:forEach items="${teachers}" var="t">
                <c:choose>
                    <c:when test="${t.id == course.teacher.id}">           
                        <option value="${t.id}" selected>${t.fullName}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${t.id}">${t.fullName}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="teacher" class="form-label">Select Teacher:</label>
    </div>

    <form:hidden path="teacher" />

    <div class="mb-3 mt-3">
        <form:hidden path="id" />
        <form:hidden path="coverImg" />
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${course.id != null}">Update course</c:when>
                <c:otherwise>Add course</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>

<script>
    function formatPrice(input) {
        // Format price input
        let value = input.value.replace(/[^0-9.]/g, ''); // Remove non-numeric characters except dot
        let parts = value.split('.');
        if (parts[1]) {
            parts[1] = parts[1].substring(0, 2); // Limit decimal places to 2
        }
        parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ','); // Add comma as thousand separator
        input.value = parts.join('.');
    }

    function formatPriceBeforeSubmit() {
        let priceInput = document.getElementById('price');
        let value = priceInput.value.replace(/[^0-9.]/g, ''); // Remove non-numeric characters except dot
        priceInput.value = value;
    }
</script>
