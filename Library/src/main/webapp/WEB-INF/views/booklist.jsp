<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>도서 목록</title>
</head>
</head>
<body>
    <h1>Book List</h1>
    
    <form action="/library/list" method="get">
        <label for="page">Page:</label>
        <input type="text" id="page" name="page">
        <br>
        <label for="perPage">Per Page:</label>
        <input type="text" id="perPage" name="perPage">
        <br>
        <input type="submit" value="Submit">
    </form>
    
    
</body>
</html>