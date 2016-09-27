<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Form</title>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker({
                dateFormat:"yy-mm-dd"
            });
        } );
    </script>

    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">

    <script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>

    <script>
        $(document).ready(function(){
            $('input.timepicker').timepicker({});
        });
    </script>

</head>
<body>

<div align="center">
<h1>Task Form</h1>
<form:form action="savetask" method="post" modelAttribute="task">
    <table>
        <form:hidden path="task_id"/>
        <tr>
            <td>Description:</td>
            <td><form:input path="description" /></td>
            <!--p>Date: <input type="text" id="datepicker"></p>
            <p><input class="timepicker"></p-->
        </tr>
        <tr>
            <td>Due time:</td>
            <td>
                <form:input path="due_time" />
            </td>
        </tr>

        <c:if test="${!empty task.task_id}">
        <tr>
            <td><form:hidden path="wasted" /></td>
        </tr>
        <tr>
            <td><form:hidden path="done" /></td>
        </tr>
        </c:if>

        <tr>
            <td><form:hidden path="wasted" /></td>
        </tr>
        <tr>
            <td><form:hidden path="done" /></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>
</div>

</body>
</html>
