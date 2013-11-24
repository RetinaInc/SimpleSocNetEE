<%--
  Created by IntelliJ IDEA.
  User: pasha
  Date: 11/24/13
  Time: 1:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<form name="showall" method="POST" action="showalluser" onsubmit="">
<c:if test="${requestScope.allpromocodes != null}">
    <table cellpadding="0" cellspacing="0" border="0" id="table_pc" class="sortable">
        <thead>
        <tr>
            <th><h3>id_user</h3></th>
            <th><h3>lastname</h3></th>
            <th><h3>firstname</h3></th>
            <th><h3>email</h3></th>
            <%--<th><h3>password</h3></th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.allusers}" var="u">
            <tr>
                <td><c:out value="${u.id}"/></td>
                <td><c:out value="${u.lastname}"/></td>
                <td><c:out value="${u.firstname}"/></td>
                <td><c:out value="${u.email}"/></td>
        <%--        <td><c:out value="${u.pass}"/></td>--%>
            </tr>
            </br>
        </c:forEach>
        </tbody>
    </table>
    </c:if>
   <p class="submit">
    <input type="reset" name="reset" value="Reset">
    <input type="submit" name="commit" value="Submit">
    </p>
    </form>
</body>
</html>