<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Form</title>
</head>
<body>
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
            <td><form:input path="due_time" /></td>
        </tr>
        <tr>
            <td>Wasted:</td>
            <td><form:input path="wasted" /></td>
        </tr>
        <tr>
            <td>Done:</td>
            <td><form:input path="done" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
