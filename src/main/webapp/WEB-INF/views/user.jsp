<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Hello</title>
    </head>
    <body>
      <form method="post">
         <span>이름 </span><input type="text" name="name" />
         <span>아이디</span><input type="text" name="id" />
         <span>암호 </span><input type="text" name="pw" />
         <span>이메일</span><input type="text" name="email" />
         <span>역할 </span><input type="text" name="userRole" />
         <span>나이 </span><input type="text" name="age" />
          <button type="submit">Send</button>
      </form>
    </body>
</html>
