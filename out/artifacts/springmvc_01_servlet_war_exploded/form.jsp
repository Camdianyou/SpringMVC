<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2022/8/8
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/hello" method="post">

  <input type="text" name="method">
  <input type="submit">
</form>

</body>
</html>
