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

    <c:if test="${empty employee.id}">
        LastName:<form:input path="lastName"/><br>
    </c:if>
    <c:if test="${not empty employee.id}">
        <form:hidden path="id"/>
        <input type="hidden" name="_method" value="PUT">
    </c:if>
    Email:<form:input path="email"/></input><br>
    <%
        Map<Integer, String> genders = new HashMap<Integer, String>();
        genders.put(1, "Male");
        genders.put(0, "Female");
        request.setAttribute("genders", genders);

//        getServletConfig().getServletContext().getContextPath();
//        request.getContextPath();
//        session.getServletContext();
//        application.getContextPath();
//        pageContext.getRequest().getServletContext().getContextPath();

    %>
    Gender:<form:radiobuttons path="gender" items="${genders}"/><br>
    Department:<form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id"/><br>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
