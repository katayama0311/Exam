<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="wrapper">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
	<div class="main">
		<div>
			<h2>科目情報更新</h2>
			<form action="../subject/Subject_updateexe.action">
				<div id="noin">
					<label for="cd">科目コード</label><br>
					<input type="text" name="cd" value="${ subject.cd}" readonly>
				</div>
				<br>
				
				<div id="in">
					<label for="name">科目名</label><br>
					<input type="text" name="name" value="${ subject.name}" maxlength=20 required>
				</div>
				<br>
				
				<div id="subm">
					<input type="submit" value="変更">
				</div>
			</form>
			<a href="../subject/Subject.action">戻る</a>
		</div>
	</div>
</div>
<%@include file="../kyoutu/footer.jsp" %>