<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>TODO</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>Task List</h1>
<h3><a href="/todo/newtask">New Task</a></h3>
<table class="tg">

    <th>Description</th>
    <th>Due Time</th>
    <th>isWasted</th>
    <th>isDone</th>
    <th>Edit</th>
    <th>Delete</th>

    <c:forEach var="task" items="${listTask}">
        <tr>
            <td>${task.description}</td>
            <td>${task.due_time}</td>
            <td>${task.wasted}</td>
            <td>${task.done}</td>
            <td><a href="<c:url value='/todo/edit?id=${task.task_id}'/>"> Edit </a></td>
            <td><a href="<c:url value='/todo/delete/${task.task_id}'/>"> Delete </a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
