<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>SocNET | Mygroups</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css"/>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<!-- Script and css for the sorting table -->
<script type="text/javascript" src="resources/js/sorttable.js"></script>
<%--<style type="text/css">
    .sortable .head h3 { background: url(resources/img/sort.gif) 7px center no-repeat; cursor: pointer; padding-left: 18px }
    .sortable .desc, .sortable .asc { background: #4b708d } /* unsort 2 arrows */
    .sortable .desc h3 { background: url(resources/img/desc.gif) 7px center no-repeat; cursor: pointer; padding-left: 18px } /* selected header */
    .sortable .asc h3 { background: url(resources/img/asc.gif) 7px center no-repeat; cursor: pointer; padding-left: 18px } /* dsc arrpw */
</style>--%>
<script>

    $(function() {
//            $( "#tabs" ).tabs();
        $("#tabs").tabs({
            create: function(event, ui){
                $(this).tabs({'select': $(this).find("ul").index($(this).find('a[href="' + window.location.hash + '"]').parent())});
            },
            activate: function(event, ui){
                window.location.hash = $(ui.newTab[0]).find('a[href^="#tab"]').attr("href");
            }
        });
    });



</script>

<script type="text/javascript">
    function OnSliderChanged (slider) {
        var sliderValue = document.getElementById (slider.id + "Value");
        sliderValue.innerHTML = slider.value+"%";
    }

    function Init () {
        var slider = document.getElementById ("slider1");
        OnSliderChanged (slider);
        var slider = document.getElementById ("slider2");
        OnSliderChanged (slider);
        var slider = document.getElementById ("slider3");
        OnSliderChanged (slider);
        var slider = document.getElementById ("slider4");
        OnSliderChanged (slider);
    }

    $(function() {
        $( "#accordion" ).accordion({
            heightStyle: "content"
        });
    });

    function OnGetAllGroups(){
        document.allgr.action="getallgroups";
        document.allgr.submit();
        return true;
    }
</script>
</head>

<body <%--onload="Init ()"--%>>

<div class="wrapper">

<jsp:include page="header.jsp"/>

<div class="content">
<div id="tabs">

    <ul>

        <li><a href="#tabs-1">My groups</a></li>
        <li><a href="#tabs-2">Subscribed groups</a></li>
        <li><a href="#tabs-3"> <a href="tab3.jsp">All groups</a></a></li>

    </ul>

            <div id="tabs-1"><!-- 'My groups' tab -->


            </div> <!-- #tab1 -->

            <div id="tabs-2"><!-- 'Subscribed groups' tab-->

            </div>

            <div id="tabs-3"><!-- 'All groups' tab -->

                <form name="allgr" method="POST" onsubmit="">
                    <input type = "submit" name = "getallgroups" value="Get all groups" onclick="OnGetAllGroups();">
                    <c:if test="${requestScope.allgroups!= null}">
                    <div id="accordion"> <%--begin accordion--%>
                        <c:forEach items="${requestScope.allgroups}" var="group">
                            <h3><c:out value="${group.groupName}"/></h3>
                            <div>
                                <p>
                                    <br>
                                   <c:out value="${group.description}"/>

                                   </br>
                                    <a href="getgroupboard?grp=${group.idGroup}">Go to page group</a>
                                </p>
                            </div>

                        </c:forEach>

        <%--                <h3>Section 1</h3>
                        <div>
                            <p>
                                Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
                                ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit
                                amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut
                                odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
                            </p>
                        </div>
                        <h3>Section 2</h3>
                        <div>
                            <p>
                                Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
                                purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
                                velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
                                suscipit faucibus urna.
                            </p>
                        </div>
                      --%>
                    </div>  <%--end accordion--%>
                    </c:if>
                </form>
              </div> <!-- end 'All groups' tab -->


</div> <%--end tabs--%>


</div><!-- #content -->



</div> <!-- #wrapper -->



</body>

</html>