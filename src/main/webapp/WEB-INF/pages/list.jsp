<%--
  Created by IntelliJ IDEA.
  User: s016374
  Date: 15/8/13
  Time: 上午11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List All Employees</title>
    <script type="text/javascript" src="../../scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
//            alert("hello jquery");
            $(".delete").click(function () {
                var href = $(this).attr("href");
                $("form").attr("action", href).submit();
                return false;
            });
        })
    </script>
</head>
<body>
<form action="" method="POST">
    <input type="hidden" name="_method" value="DELETE">
</form>

<c:if test="${empty requestScope.employees}">
    No Employee
</c:if>
<c:if test="${not empty requestScope.employees}">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${employees}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.gender == 0 ? 'Female' : 'Male'}</td>
                <td><a href="/mvc/emps/${emp.id}">Edit</a></td>
                <td><a class="delete" href="/mvc/emp/${emp.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br>
<a href="/mvc/emp">Add New Employee</a>
</body>
</html>
