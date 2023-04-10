<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/library/list" method="get">
  <input type="number" name="page" placeholder="페이지 번호">
  <input type="number" name="perPage" placeholder="페이지당 글 개수">
  <button type="submit">조회</button>
</form>
</body>
</html>