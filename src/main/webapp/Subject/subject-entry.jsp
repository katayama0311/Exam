<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="wrapper">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
	<div class="main">
		<div>
			<h2>科目情報登録</h2>
			<form action="../subject/Subject_entryexe.action">
				<div id="in">
					<label for="cd">科目コード</label><br>
					<input type="text" name="cd" value="${ cd}" maxlength=3 placeholder="科目コードを入力してください" required>
					<c:if test="${ Onaji == -1}">
						<p>科目コードが重複しています
					</c:if>
				</div>
				<br>
				
				<div id="in">
					<label for="name">科目名</label><br>
					<input type="text" name="name" value="${ name}" maxlength=20 placeholder="科目名を入力してください" required>
				</div>
				<br>
				
				<div id="subm">
					<input type="submit" value="登録">
				</div>
					
			</form>
			<a href="../subject/Subject.action">戻る</a>
		</div>
	</div>
</div>
<%@include file="../kyoutu/footer.jsp" %>