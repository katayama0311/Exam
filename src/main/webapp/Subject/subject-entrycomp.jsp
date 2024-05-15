<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="wapper">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
	<div class="main">
		<div>
			<h2>科目情報登録</h2>
			<p>登録が完了しました</p>
			<a href="../Subject/subject-entry.jsp">戻る</a>
			<a href="../subject/Subject.action">科目一覧</a>
		</div>
	</div>
</div>
<%@include file="../kyoutu/footer.jsp" %>