<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SocNet | Registration</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<script src="js/md5-min.js"></script>
<!--[if lt IE 7]>
<style type="text/css">
     #wrapper { height:100%; }
</style>
<![endif]-->
<script>
    function validateRegForm() {
        var isValid = true;

        if(document.regfrm.firstname.value.length < 4 || document.regfrm.firstname.value.length > 20
                || (!(/^[a-zA-Z]+$/).test(document.regfrm.username.value))) {
            document.getElementById("span_firstname").style.display = 'inline';
            isValid = false;
        }
        else { document.getElementById("span_firstname").style.display = 'none'; }


        if(document.regfrm.lastname.value.length < 4 || document.regfrm.lastname.value.length > 20
                || (!(/^[a-zA-Z]+$/).test(document.regfrm.username.value))) {
            document.getElementById("span_lastname").style.display = 'inline';
            isValid = false;
        }
        else { document.getElementById("span_lastname").style.display = 'none'; }

        if(document.regfrm.password.value.length < 6 || document.regfrm.password.value.length > 20
                || (!(/^[a-zA-Z0-9]+$/).test(document.regfrm.password.value))) {
            document.getElementById("span_pswd1").style.display = 'inline';
            isValid = false;
        }
        else { document.getElementById("span_pswd1").style.display = 'none'; }

        if(document.regfrm.password.value == document.regfrm.password2.value) {
            document.getElementById("span_pswd2").style.display = 'none';
        }
        else {
            document.getElementById("span_pswd2").style.display = 'inline';
            isValid = false;
        }

        if (!(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/).test(document.regfrm.email.value)) {
            document.getElementById("span_email").style.display = 'inline';
            isValid = false;
        }
        else { document.getElementById("span_email").style.display = 'none'; }

        if(isValid){
            document.regfrm.password.value = hex_md5(document.regfrm.password.value);
        }
        return isValid;
    }
</script>
</head>

<body>

<div id="wrapper">
    <jsp:include page="header.jsp"/>
<%--    <div id="header">
        <div class="nav">
            <ul>
                <li><a href="home.jsp"><h1>SocNET</h1></a></li>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contacts</a></li>
            </ul>
        </div>
    </div><!-- #header -->--%>

    <div id="content">
        <div class="window" >
            <h1>Registration</h1>
            <form name="regfrm" method="POST" action="signup" onsubmit="return validateRegForm();">
                <p>Login:<input type="text" name="username" maxlength="20"/></p>
                <span id="span_firstname">First Name must contain only latin letters (4 to 20 symbols)!</span>

                <p>Email:<input type="text" name="email" maxlength="50"/></p>
                <span id="span_email">Invalid email!</span>
                <c:if test="${requestScope.isExist==true}">
                    <p style="color: #bc0f0f;">This email is already registered.</p>
                </c:if>

                <p>Password:<input type="password" name="password" maxlength="20"></p>
                <span id="span_pswd1">Password must contain only latin letters and numbers (6 to 20 symbols)!</span>
                <p>Confirm password:<input type="password" name="password2" maxlength="20"></p>
                <span id="span_pswd2">Passwords do not match!</span>
                <p class="submit">
                    <input type="reset" name="reset" value="Reset">
                    <input type="submit" name="commit" value="Submit">
                </p>
            </form>
        </div>

    </div><!-- #content -->

    <div id="footer">
    </div><!-- #footer -->

</div><!-- #wrapper -->

</body>

</html>

