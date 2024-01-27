<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
    <script>
        function editStudent(id) {
            document.getElementById('editForm_' + id).submit();
        }

        function deleteStudent(id) {
            if (confirm("Are you sure you want to delete this student?")) {
                document.getElementById('deleteForm_' + id).submit();
            }
        }
    </script>
</head>
<body>
    <%@ include file="menu.jsp" %>

    <div class="container row coll-6" style="padding: 50px">
        <p>${message}</p>
        <h1>Student List</h1>

        <form action="/SpringMVC/setupStudentRegister" method="get">
            <input type="submit" value="Add New Student">
        </form>

        <table class="table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Gender</th>
                    <th>Phone Number</th>
                    <th>Father Name</th>
                    <th>Batch</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${studentList}" var="student">
                    <tr>
                    	<td>${student.id }</td>
                        <td>${student.name}</td>
                        <td>${student.age}</td>
                        <td>${student.email}</td>
                        <td>${student.address}</td>
                        <td>${student.gender}</td>
                        <td>${student.phoneNumber}</td>
                        <td>${student.fatherName}</td>
                        <td>ss</td>
                        <!-- Add Batch information here -->

                        <td>
                                  <a href="/SpringMVC/studentUpdate/${student.id}">
              					<button type="submit" class="btn btn-secondary mb-2">Update</button>
              				</a> 

                        </td>
                        <td>
                            <a href="/SpringMVC/deleteStudent/${student.id}">
                            	<button type="submit" class="btn btn-primary mb-2">Delete</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
