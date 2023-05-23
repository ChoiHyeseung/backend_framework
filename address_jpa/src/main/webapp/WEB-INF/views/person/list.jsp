<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="${R}common.js"></script>
  <link rel="stylesheet" type="text/css" href="${R}common.css" />
  <style>
    a.btn { float: right; margin: -20px 0 5px 0; }
    td:nth-child(1), td:nth-child(5) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>목록</h1>
  <a href="create" class="btn">등록</a>
  <table class="list">
    <thead>
      <tr>
        <th>pid</th>
        <th>이름</th>
        <th>전화번호</th>
        <th>성별</th>
        <th>친목정도</th>
        <th>종류</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="person" items="${ persons }">
        <tr data-url="edit?pid=${ person.pid }">
          <td>${ person.pid }</td>
          <td>${ person.name }</td>
          <td>${ person.phone }</td>
          <td>${ person.gender }</td>
          <td>${ person.title }</td>
          <td>${ person.category.title }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>