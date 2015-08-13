<%--
  Created by IntelliJ IDEA.
  User: s016374
  Date: 15/8/10
  Time: 上午11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Success</h1>
${requestScope.time}
${requestScope.name}
${sessionScope.user}
<%--${requestScope.user}--%>
${requestScope.abc}
</body>
</html>
