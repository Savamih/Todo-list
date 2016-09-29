<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Form</title>

    <style type="text/css">
        .error {font-family:Tahoma, sans-serif;font-size:10px;padding:10px 5px;color: #d22218;
        }
    </style>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <spring:url value="/resources/js/jquery.js" var="jquery"/>
    <spring:url value="/resources/js/jquery.datetimepicker.full.min.js" var="datetimepickerJs"/>
    <spring:url value="/resources/css/jquery.datetimepicker.css" var="datetimepickerCss"/>

    <link href="${datetimepickerCss}" rel="stylesheet"/>
    <script src="${datetimepickerJs}"></script>
    <script src="${jquery}"></script>

    <script>
        jQuery('#datetimepicker').datetimepicker({
        });
    </script>

</head>
<body>

<div align="center">
<h1>Task Form</h1>
<sf:form action="savetask" method="post" modelAttribute="task">
    <table>
        <form:hidden path="task_id"/>
        <tr>
            <td>Description:</td>
            <td><sf:input path="description" size="20" /></td><br/>
            <sf:errors path="description" cssClass="error"/>

            <!--p>Date: <input type="text" id="datepicker"></p>
            <p><input class="timepicker"></p-->

        </tr>
        <tr>
            <td>Due time:</td>
            <td>
                <sf:input id="datetimepicker" path="due_time" /><br/>
                <sf:errors path="due_time" cssClass="error"></sf:errors>
                <small>Example: 2016-11-23 15:14:13</small>
            </td>
        </tr>

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
</sf:form>
</div>
</body>
</html>
