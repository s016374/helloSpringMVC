<%@ page import="org.springframework.ui.ModelMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: s016374
  Date: 15/8/13
  Time: 下午3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Input</title>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/mvc/emp" method="post" modelAttribute="employee">
    LastName:<form:input path="lastName"/><br>
    Email:<form:input path="email"/><br>
    <%
        Map<Integer, String> genders = new HashMap<Integer, String>();
        genders.put(1, "Male");
        genders.put(0, "Female");
        request.setAttribute("genders", genders);
    %>
    Gender:<form:radiobuttons path="gender" items="${genders}"/><br>
    Department:<form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id"/><br>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
