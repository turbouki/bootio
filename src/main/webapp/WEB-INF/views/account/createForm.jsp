<%--
  Created by IntelliJ IDEA.
  User: liya
  Date: 2023/01/13
  Time: 5:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="accountCreateForm">
    <span>이름</span><form:input path="name" />
    <form:errors path="name" cssClass="error" />
    <span>전화</span><form:input path= "tel" />
    <form:errors path="tel" cssClass="error" />
    <span>이메일</span><form:input path= "email" />
    <form:errors path="email" cssClass="error" />
    <span>생일</span><form:input path= "dateOfBirth" type="date"/>
    <form:errors path="dateOfBirth" cssClass="error" />
    <button type="submit">Send</button>
</form:form>
</body>
</html>
