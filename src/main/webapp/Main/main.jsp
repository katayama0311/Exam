<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>

<div class="wrapper">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
	<div class="main">
		<div class="menu">
			<h2>メニュー</h2>
			<a href="../student/StudentList.action">学生管理</a>
			<div>
				<p>成績管理</a>
				<a href="../testlist/TestList.action">成績登録</a>
				<a href="">成績参照</a>
			</div>
			<a href="../subject/Subject.action">科目管理</a>
		</div>
	</div>
</div>
<%@include file="../kyoutu/footer.jsp" %>