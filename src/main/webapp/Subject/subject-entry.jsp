<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../kyoutu/login-sidebar.jsp" %>



<h2>科目情報登録</h2>
<table>

<tr>
<th>科目コード</th>
<th>科目名</th>
</tr>
<c:forEach var="subject" items="${subject_list }">
<tr>
<td>${subject.cd }</td>
<td>${subject.name }</td>
<td><a href="">変更</a></td>
<td><a href="">削除</a></td>
</tr>
</c:forEach>
</table>