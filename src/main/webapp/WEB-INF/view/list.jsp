<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>ToDo List</title>
</head>
<body>
<h1>ToDo List</h1>
<c:forEach var="todo" items="${todos}" varStatus="status">
    <p>${todo.todo}</p>
</c:forEach>

<br><br>
// http://localhost:8080/todos/list
// http://localhost:8080/todos/addTodo   action="addToDo"     상대경로
// http://localhost:8080/addToDo         action="/addToDo"    절대경로
<form method="post" action="addToDo">
    할일 : <input type="text" name="todo">
    <input type="submit" value="추가">
</form>
</body>
</html>
