<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
welcome to springMVC word!
<form method="post" action="/hello/ctrl/userLogin.do">
    <input type="text" name="userName" >
    <input type="submit" value="确定">
    info1212121  ---- ${entity.userName}
</form>
</body>
</html>
