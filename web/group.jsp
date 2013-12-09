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
    <link type="text/css" rel="stylesheet" href="resources/css/additional.css" />
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
    <script type="text/javascript" language="javascript" id="hcb">
     /*<!--*/ if(!window.hcb_user){hcb_user={  };}
     (function(){s=document.createElement("script");
         s.setAttribute("type","text/javascript");
         s.setAttribute("src", "http://www.htmlcommentbox.com/jread?page="+escape((window.hcb_user && hcb_user.PAGE)||(""+window.location)).replace("+","%2B")+"&opts=470&num=10");if (typeof s!="undefined") document.getElementsByTagName("head")[0].appendChild(s);})(); /*-->*/
    </script>

</head>
<body>

<div class="wrapper">

    <jsp:include page="header.jsp"/>

    <div> <%--start add new comment--%>
        <!-- begin htmlcommentbox.com -->
        <h1>Leave you message!</h1>
        <form action="addnewmessage" method="post">
            <table>
                <tr>
                    <td>Title</td>
                    <td>
                        <input type="text" name="title" value="" maxlength="100" />
                    </td>
                </tr>
                <tr>
                    <td>Comments:</td>
                    <td>
                        &lt;textarea rows="10" cols="50" name="comments"&gt;&lt;/textarea&gt;
                    </td>
                </tr>
                <tr><td>&nbsp;</td>
                    <td>
                        <input type="submit" value="Submit" />
                    </td>
                </tr>
            </table>
        </form>
        <!-- end htmlcommentbox.com -->

    </div>    <%--end add new comment--%>


        <!-- DC Comment Boxes Start -->
       <%-- url(resources/img/up-arrow.png)--%>

        <div> <%--all comment begin--%>
            <c:if test="${requestScope.messinfo!= null}">
                <c:forEach items="${requestScope.messinfo}" var="messinfo">
                    <div class="tsc_clean_comment">
                        <div class="avatar_box"> <img src="resources/img/avatar.jpg" alt="Avatar" class="avatar" />
                            <p class="username"><c:out value="${messinfo.username}"/></p>
                        </div>
                        <div class="comment_box fr">
                            <%--<p class="comment_paragraph" contenteditable="true">This field is completely editable. To disable this feature remove the "contenteditable=true" tag from this code.</p>--%>
                                <p class="comment_paragraph"><c:out value="${messinfo.bodymess}"/></p>
                            <a href="#" class="reply">Reply</a> <span class="date"><c:out value="${messinfo.create_date}"/></span> </div>
                        <div class="tsc_clear"></div>
                    </div>   <%--end tsc_clean_comment--%>
                    <!-- DC Comment Boxes End -->
                </c:forEach>
            </c:if>
        </div>  <%--all comment end--%>


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