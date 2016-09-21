<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>News</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
    <title>Task List</title>
</head>
<body>
<h1>Task List</h1>
<h3><a href="/newTask">New Task</a></h3>
<table border="1">

    <th>Description</th>
    <th>Create Date</th>
    <th>Due Date</th>
    <th>Done</th>

    <c:forEach var="task" items="${listTask}">
        <tr>
            <td>${task.description}</td>
            <td>${task.create_date}</td>
            <td>${task.due_date}</td>
            <td>${task.done}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
