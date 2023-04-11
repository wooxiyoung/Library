<%@page import="com.pj.library.XmlParsingInfo"%>
<%@page import="com.pj.library.dto.BookDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
// URL 매개변수를 통해 값을 받아와서 bookList 변수에 저장
int pages = Integer.parseInt(request.getParameter("page"));
int perPage = Integer.parseInt(request.getParameter("perPage"));
XmlParsingInfo xmlParsingInfo = new XmlParsingInfo();
List<BookDto> booklist = xmlParsingInfo.getData(pages, perPage);
%>
<title>Insert title here</title>
</head>
<body>
 <%-- Book list table --%>
    <table>
        <thead>
            <tr>
                <th>대분류</th>
                <th>도서관구분코드</th>
                <th>도서관명</th>
                <th>도서관홈페이지url</th>
                <th>번호</th>
                <th>제목</th>
                <th>중분류</th>
                <th>출판사</th>
                <th>형식</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${booklist}" var="book">
                <tr>
                
                
                
                
                    <td>${book.category}</td>
                    <td>${book.libraryCode}</td>
                    <td>${book.libraryName}</td>
                    <td>${book.libraryHomepageUrl}</td>
                    <td>${book.number}</td>
                    <td>${book.title}</td>
                    <td>${book.subCategory}</td>
                    <td>${book.publisher}</td>
                    <td>${book.format}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>