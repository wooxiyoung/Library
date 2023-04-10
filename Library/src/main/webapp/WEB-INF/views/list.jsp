<%@page import="com.pj.library.XmlParsingInfo"%>
<%@page import="com.pj.library.dto.BookDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
// URL 매개변수를 통해 값을 받아와서 bookList 변수에 저장
int pages = Integer.parseInt(request.getParameter("page"));
int perPage = Integer.parseInt(request.getParameter("perPage"));
XmlParsingInfo xmlParsingInfo = new XmlParsingInfo();
List<BookDto> bookList = xmlParsingInfo.getData(pages, perPage);
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
            <c:forEach items="${list}" var="book">
                <tr>
                    <td>${book.대분류}</td>
                    <td>${book.도서관구분코드}</td>
                    <td>${book.도서관명}</td>
                    <td>${book.도서관홈페이지url}</td>
                    <td>${book.번호}</td>
                    <td>${book.제목}</td>
                    <td>${book.중분류}</td>
                    <td>${book.출판사}</td>
                    <td>${book.형식}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>