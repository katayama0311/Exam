<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="wrapper">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
	<div class="main">
		<div>
			<h2>学生情報更新</h2>
			<p>変更が完了しました</p>
			<a href="../student/StudentList.action">学生一覧</a>
		</div>
	</div>
</div>
<%@include file="../kyoutu/footer.jsp" %>