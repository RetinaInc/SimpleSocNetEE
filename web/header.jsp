
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- TOP MENU -->
<div class="header">

    <c:if test="${sessionScope.email == null}">
        <ul class="navlist">
            <li><a href="login.jsp">Log in</a> / <a href="registration.jsp">Register</a></li>
        </ul>
    </c:if>
    <c:if test="${sessionScope.email != null}">
        <div class="navlist">
            <span>Welcome, <c:out value="${sessionScope.username}"/> !</span><a href="signout">(Log out)</a>

        </div>
    </c:if>
</div>

<!-- MAIN MENU -->
<div class="mainmenu">
    <ul>
     <%--   <li><a class="logo" href="home.jsp">NCLodger</a></li>--%>
        <li><a href="index.jsp">Home</a></li>
        <c:if test="${sessionScope.email != null}">
            <li><a href="mygroups.jsp">My Groups</a></li>

        </c:if>
<%--        <li><a href="aboutus.jsp">About Us</a></li>
        <li><a href="contacts.jsp">Contacts</a></li>--%>
    </ul>
</div>
