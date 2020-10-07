<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>이벤트 목록</h1>
    <h2>${message}</h2>
    <table>
        <tr>
            <th>이름</th>
            <th>시작</th>
            <c:forEach items="${events}" var="event">
                <tr>
                    <td>${event.name}</td>
                    <td>${event.starts}</td>
                </tr>
            </c:forEach>
        </tr>
    </table>
</body>
</html>
