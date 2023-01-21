<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Hello</title>
    </head>
    <body>
      <form:form method="post" modelAttribute="person">
          <span>이름</span><form:input path="name" />
          <form:errors path="name" cssClass="error" />
          <span>나이</span><form:input path= "age" />
          <form:errors path="age" cssClass="error" />
          <button type="submit">Send</button>
      </form:form>
    </body>
</html>
