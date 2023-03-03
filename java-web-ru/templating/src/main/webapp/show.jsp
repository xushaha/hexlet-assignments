<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Company</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th>id</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>email</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${user.get("id")}</td>
            <td>${user.get("firstName")}</td>
            <td>${user.get("lastName")}</td>
            <td>${user.get("email")}</td>
        </tr>
    </tbody>
</table>
<br>
<a href='/users/delete?id=${user.get("id")}'>Delete user</a>
</body>
</html>
<!-- END -->




