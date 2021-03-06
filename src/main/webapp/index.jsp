<%--
  Created by IntelliJ IDEA.
  User: s016374
  Date: 15/8/10
  Time: 上午11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Spring MVC</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script>
        $(function () {
            $("#json").click(function () {
                var url = this.href;
                var args = {};
                $.post(url, args, function (data) {
                            for (var i = 0; i < data.length; i++) {
                                var id = data[i].id;
                                var lastName = data[i].lastName;
                                alert(id + ":" + lastName);
                            }
                        }
                )
                return false;
            })
        })
    </script>
</head>
<body>
<a href="/mvc/helloWorld">Hello World</a>
<hr>
<form action="/mvc/postMethod" method="post">
    <input type="submit" value="Test postMethod"/>
</form>
<hr>
<a href="/mvc/paramsAndHeaders?user=abc&password=1">Test paramsAndHeader</a>
<hr>
<a href="/mvc/pathVariable/ppp">Test pathVariable</a>
<hr>
<a href="/mvc/restGet/1">Test REST-get</a>
<br><br/>

<form action="/mvc/restPost" method="post">
    <input type="submit" value="Test REST-post"/>
</form>
<form action="/mvc/restDelete/1" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="Test REST-delete"/>
</form>
<form action="/mvc/restPut/1" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="Test REST-put"/>
</form>
<hr>
<a href="mvc/requestParam?user=ztx&password=123">Test requestParam</a>
<hr>
<a href="/mvc/requestHeader">Test requestHeader</a>
<hr>
<a href="/mvc/requestCookieValue">Test cookieValue</a>
<hr>
<form action="/mvc/POJO" method="post">
    ID:<input type="text" name="id"/><br>
    UserName:<input type="text" name="username"/><br>
    Password:<input type="password" name="password"/></br>
    Email:<input type="text" name="mail"/><br>
    Age:<input type="text" name="age"/></br>
    Province:<input type="text" name="address.province"/><br>
    City:<input type="text" name="address.city"/></br>
    <input type="submit" value="submit"/>
</form>
<%--<form:form action="${pageContext.request.contextPath}/mvc/POJO" method="post" modelAttribute="user">--%>
<%--UserName:<form:input path="username"/>--%>
<%--Password:<form:password path="password"/>--%>
<%--Email:<form:input path="mail"/>--%>
<%--Age:<form:input path="age"/>--%>
<%--Province:<form:input path="address.province"/>--%>
<%--City:<form:input path="address.city"/>--%>
<%--<input type="submit" value="submit"/>--%>
<%--</form:form>--%>
<hr>
<a href="/mvc/servletAPI">Test servletAPI</a>
<hr>
<a href="/mvc/modelAndView">Test modelAndView</a>
<hr>
<a href="/mvc/modelMap">Test modelMap</a>
<hr>
<a href="/mvc/sessionAttributes">Test sessionAttributes</a>
<hr>
<form action="/mvc/modelAttribute" method="post">
    <input type="hidden" name="id" value="1"/>
    UserName:<input type="text" name="username" value="Mike"/><br>
    <%--Password:<input type="password" name="password"/></br>--%>
    Email:<input type="text" name="mail" value="mike@mail.com"/><br>
    Age:<input type="text" name="age" value="20"/></br>
    Province:<input type="text" name="address.province" value="ZheJiang"/><br>
    City:<input type="text" name="address.city" value="HangZhou"/></br>
    <input type="submit" value="submit"/>
</form>
<hr>
<a href="/mvc/helloView">Test helloView</a>
<hr>
<a href="/mvc/redirect">Test redirect</a>
<hr>
<a href="/mvc/emps">List All Employees</a>
<hr>
<a href="/mvc/json" id="json">Test JSON</a>
<hr>
<form action="/mvc/upload" method="post" enctype="multipart/form-data">
    File:<input type="file" name="file"/><br>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
