<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Form</title>

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
            <td><form:hidden path="wasted" value="${true}"/></td>
        </tr>
        <tr>
            <td><form:hidden path="done" value="${true}"/></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>
</div>

</body>
</html>
