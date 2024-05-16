<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="wrapper">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
	<div class="main">
		<div>
			<h2>科目情報削除</h2>
			<form action="../subject/Subject_delexe.action">
				<label><p>「${ del_subject.name}」を削除してもよろしいですか</p></label>
				<div id="del">
					<input type="submit" value="削除">
				</div>
			</form>
			<br>
			<a href="../subject/Subject.action">戻る</a>
		</div>
	</div>
</div>
<%@include file="../kyoutu/footer.jsp" %>