<%--
  Created by IntelliJ IDEA.
  User: pasha
  Date: 12/8/13
  Time: 12:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>SocNET | Home</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css" />
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
</head>
<body>
<div class="wrapper">
    <jsp:include page="header.jsp"/>

    <div class="content">
        <div class="window" >
            <h1>Login</h1>
            <form name="loginfrm" method="POST" action="signin" onsubmit="">
                <p>Email:<input type="text" name="email" maxlength="50"></p>
                <span id="span_email">Invalid email!</span>
                <c:if test="${requestScope.regConfirm==true}">
                    <p style="color: #bc0f0f;">This email wasn't registered. Please, sign up</p>
                </c:if>
                <p>Password:<input type="password" name="password" maxlength="20"></p>
                <c:if test="${requestScope.wrongPass==true}">
                    <p style="color: #bc0f0f;">Wrong password!</p>
                </c:if>
                <span id="span_pswd">Invalid password!</span><br>

                <p class="submit">
                    <input type="hidden" name="password" value=""/>
                    <input type="submit" name="commit" value="Login">
                    <input type="reset" name="reset" value="Reset">
                </p>
            </form>
        </div>
    </div><!-- #content -->


</div><!-- #wrapper -->
</body>
</html>