<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>

<%@include file="../kyoutu/login-sidebar.jsp" %>



<h2>科目情報登録</h2>
<table>

<form action="../subject/Subject_entry.action" method="post">
	<input type="text" name="cd" placeholder="科目コードを入力" />
	<input type="text" name="name" placeholder="科目名を入力" />
	<input type="submit" name="entry" value="登録">
</form>
<a href="../Subject/subject-list.jsp">戻る</a>
</table>