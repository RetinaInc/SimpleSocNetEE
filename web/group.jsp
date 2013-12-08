<%--
  Created by IntelliJ IDEA.
  User: pasha
  Date: 12/8/13
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SocNET | home</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css" />
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
</head>
<body>

<div class="wrapper">

    <jsp:include page="header.jsp"/>



   <%-- <div> &lt;%&ndash;form show message&ndash;%&gt;
        <a href="viewpastbooking">View my booking</a>
        <form name="viewpastbook" method="POST" onsubmit="">
            <c:if test="${requestScope.message!=null}">

                <table cellpadding="0" cellspacing="0" border="0" id="table" class="sortable">
                    <thead>
                    <tr>

                        <th><h3>Type</h3></th>
                        <th><h3>Hotel Name</h3></th>
                        <th><h3>City</h3></th>
                        <th><h3>Order's date</h3></th>
                        <th><h3>Start date</h3></th>
                        <th><h3>End date</h3></th>
                        <th><h3>Price</h3></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.bookinglist}" var="b">
                        <tr>

                            <td><c:out value="${b.type}"/></td>
                            <td><c:out value="${b.hotelName}"/></td>
                            <td><c:out value="${b.hotelCity}"/></td>
                            <td><c:out value="${b.dateOrder}"/></td>
                            <td><c:out value="${b.startOrder}"/></td>
                            <td><c:out value="${b.endOrder}"/></td>
                            <td><c:out value="${b.price}"/></td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="controls">
                    <div class="perpage">
                        <select onchange="sorter.size(this.value)">
                            <option value="5">5</option>
                            <option value="10" selected="selected">10</option>
                            <option value="20">20</option>
                            <option value="50">50</option>
                            <option value="100">100</option>
                        </select>
                        <span>Entries Per Page</span>
                    </div>
                    <div class="navigation">
                        <img src="resources/img/first.gif" width="16" height="16" alt="First Page" onclick="sorter.move(-1,true)"/>
                        <img src="resources/img/previous.gif" width="16" height="16" alt="First Page" onclick="sorter.move(-1)"/>
                        <img src="resources/img/next.gif" width="16" height="16" alt="First Page" onclick="sorter.move(1)"/>
                        <img src="resources/img/last.gif" width="16" height="16" alt="Last Page" onclick="sorter.move(1,true)"/>
                    </div>
                    <div class="text">Displaying Page <span id="currentpage_h"></span> of <span id="pagelimit_h"></span></div>
                </div>
                <script type="text/javascript">
                    var sorter = new TINY.table.sorter("sorter");
                    sorter.head = "head";
                    sorter.asc = "asc";
                    sorter.desc = "desc";
                    sorter.even = "evenrow";
                    sorter.odd = "oddrow";
                    sorter.evensel = "evenselected";
                    sorter.oddsel = "oddselected";
                    sorter.paginate = true;
                    sorter.currentid = "currentpage";
                    sorter.limitid = "pagelimit";
                    sorter.init("table", 1);
                </script>
            </c:if>
        </form>
    </div> &lt;%&ndash;form show message&ndash;%&gt;
--%>
</body>
</html>