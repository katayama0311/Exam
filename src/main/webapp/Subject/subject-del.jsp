<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>

<%@include file="../kyoutu/login-sidebar.jsp" %>

<h2>科目情報削除</h2>

<p>を削除しますよろしいですか</p>
<form action="Subject_del.action">>
<input type="submit" name="del" value="削除"/>
</form>

<a href="../subject/Subject.action">戻る</a>