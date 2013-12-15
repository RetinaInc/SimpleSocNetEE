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
        document.getElementById('allgr').submit();

    </script>
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


        /*    document.allgr.action="getallgroups";
         document.allgr.submit();*/


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


        function OnGetAllMyGroups(){
            document.allmygr.action="getallmygroups";
            document.allmygr.submit();
            return true;
        }

        function OnGetAllInfoGroups(){
            document.allinfogr.action="getallinfogroups";
            document.allinfogr.submit();
            return true;
        }

        /*    $( "#tabs-3" ).load( document.URL +  '#tabs-3', function() {
         alert( "Load was performed." );
         });*/

        $(document).ready(function() { /// Wait till page is loaded
            $('#tabs-3').click(function(){
                $('#tabs-3').load('getallgroups #tabs-3', function() {
/// can add another function here
                });
            });
        }); //// End of Wait till page is loaded

        /*  $("#allgr").ajaxSubmit({url: 'getallgroups', type: 'post'})*/

    </script>
</head>

<body <%--onload="Init ()"--%>>

<div class="wrapper">

    <jsp:include page="header.jsp"/>

    <div class="content">
        <div id="tabs">

            <ul>

                <li><a href="#tabs-1">All groups</a></li>
                <li><a href="#tabs-2">Subscribed groups</a></li>
                <%--<li><a href="#tabs-3"><a href="getallgroups"> All groups</a></a></li>--%>
                <%-- <li><a href="#tabs-3"><a onclick="OnGetAllGroups();"> All groups</a></a></li>--%>
               <%-- <li><a href="#tabs-3"> All groups</a></li>--%>
                <%--<a href="smgetallusers"--%>
            </ul>

            <div id="tabs-1"><!-- 'All groups' tab -->
                <form id="allinfogr" name="allinfogr" method="POST" onsubmit="">
                    <input type = "submit" name = "getallgroups" value="Get all groups" onclick="OnGetAllInfoGroups();">
                    <c:if test="${requestScope.allinfogroups!= null}">
                        <div id="accordion"> <%--begin accordion--%>
                            <c:forEach items="${requestScope.allinfogroups}" var="group">
                                <h3><c:out value="${group.groupName}"/></h3>
                                <div>
                                    <p>
                                        <br>
                                        <h2>Creator: </h2><c:out value="${group.usernameCreator}"/>

                                        </br>
                                        <br>
                                        <c:out value="${group.description}"/>

                                        </br>
                                        <a href="getgroupboard?grp=${group.idGroup}">Go to page group</a>
                                    </p>
                                </div>

                            </c:forEach>

                        </div>  <%--end accordion--%>
                    </c:if>
                </form>

            </div> <!-- #tab1 -->

            <div id="tabs-2"><!-- 'Subscribed groups' tab-->

                <form id="allsubgr" name="allsubgr" method="POST" onsubmit="">
                    <input type = "submit" name = "getallsubcribedgroups" value="Get all subscribed groups" onclick="">
                    <c:if test="${requestScope.allsubgroups!= null}">
                        <div id="accordion"> <%--begin accordion--%>
                            <c:forEach items="${requestScope.allsubgroups}" var="group">
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

                        </div>  <%--end accordion--%>
                    </c:if>
                </form>

            </div>




    </div><!-- #content -->



</div> <!-- #wrapper -->



</body>

</html>


