<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="wrapper">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
	<div class="main">
		<div id="kanryo">
			<h2>科目情報削除</h2>
			<p>削除が完了しました</p>
			<a href="../subject/Subject.action">科目一覧</a>
		</div>
	</div>
</div>
<%@include file="../kyoutu/footer.jsp" %>