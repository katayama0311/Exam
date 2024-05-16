<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>

<div class="wrapper">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
	<div class="main">
		<h2>メニュー</h2>
		<div class="menu">
			<div id="stu">
				<a href="../student/StudentList.action">学生管理</a>
			</div>
			<div id="grade">
				<p>成績管理
				<br>
				<a href="../testlist/TestList.action">成績登録</a>
				<br>
				<a href="../testlist/TestSubjectList.actions">成績参照</a>
			</div>
			<div id="sub">
				<a href="../subject/Subject.action">科目管理</a>
			</div>
		</div>
	</div>
</div>
<%@include file="../kyoutu/footer.jsp" %>