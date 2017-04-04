<%--
  Created by IntelliJ IDEA.
  User: linzf
  Date: 2017/4/2
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>附件上传</title>
</head>
<body>
<form action="upload.do" enctype="multipart/form-data" method="post">
    <input type="file" name="multipartFile" /><br />
    <input type="submit" value="提交">
</form>
</body>
</html>
