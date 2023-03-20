<%--
  Created by IntelliJ IDEA.
  User: vipqk
  Date: 20/03/2023
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add New Employee</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>Add New Employee</h1>
    <h2>

        <a href="/employees">Back To List</a>
    </h2>
</center>
<div>
<form>
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" id="name" aria-describedby="emailHelp">
    </div>

    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="text" class="form-control" id="email">
    </div>

    <div class="mb-3">
        <label for="address" class="form-label">Address</label>
        <input type="text" class="form-control" id="address" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="phone" class="form-label">Phone</label>
        <input type="text" class="form-control" id="phone" aria-describedby="emailHelp">
    </div>

    <div class="mb-3">
        <label for="salary" class="form-label">Salary</label>
        <input type="text" class="form-control" id="salary" aria-describedby="emailHelp">
    </div>

    <div class="form-floating">
        <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
            <option selected>Open this select menu</option>
            <option value="1">RnD</option>
            <option value="2">Kinh doanh</option>
            <option value="3">Dam bao</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
