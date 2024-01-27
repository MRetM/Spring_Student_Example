<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="menu.jsp" %>

    <div class="container">

        <h2>Student Registration</h2>
        <form:form action="/SpringMVC/setUpStudentUpdate" method="post" modelAttribute="studentUpdateBean">
        
           <div class="mb-3">
                            <form:hidden path="id"/>

            </div>
            <div class="mb-3">
                <form:label for="name" class="form-label" path="name" >Name</form:label>
                <form:input class="form-control col-3" type="text" name="name" id="name" path="name" />
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <form:input class="form-control col-3" type="text" name="email" id="email" path="email"/>
            </div>

            <div class="mb-3">
                <label for="age" class="form-label">Age</label>
                <form:input class="form-control col-3" type="number" name="age" id="age" path="age" />
            </div>

            <div class="mb-3">
                <label for="address" class="form-label">Address</label>
                <form:input class="form-control col-3" type="text" name="address" id="address" path="address" />
            </div>

            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Phone Number</label>
                <form:input class="form-control col-3" type="text" name="phoneNumber" id="phoneNumber" path="phoneNumber" />
            </div>

            <div class="mb-3">
                <label for="fatherName" class="form-label">Father Name</label>
                <form:input class="form-control col-3" type="text" name="fatherName" id="fatherName" path="fatherName" />
            </div>

            <div class="mb-3">
                <label class="form-label">Gender</label>
                <div class="form-check form-check-inline">
                    		<form:radiobutton id="gender" name="gender" path="gender" value="Male"/> Male
                </div>
                <div class="form-check form-check-inline">
                			<form:radiobutton id="gender" name="gender" path="gender" value="Female"/> Female
                </div>
            </div>

            <input type="submit" value="Save" class="btn btn-primary">
            <a href="${pageContext.request.contextPath}/student" class="btn btn-secondary">Cancel</a>
                        <p>${error}</p>
            
        </form:form>
    </div>
</body>
</html>
