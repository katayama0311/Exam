<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wrapper">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
	<div class="main">
		<h2>科目管理</h2>
		<table>
			<a href="../Subject/subject-entry.jsp">新規登録</a> <!-- 科目登録画面に遷移させる -->
			<tr>
				<th>科目コード</th>
				<th>科目名</th>
			</tr>
			<c:forEach var="subject" items="${subject_list }">
				<tr>
					<td>${subject.cd }</td>
					<td>${subject.name }</td>
					<td><a href="../subject/Subject_update.action?cd=${ subject.cd}">変更</a></td>
					<td><a href="../subject/Subject_del.action?cd=${subject.cd }">削除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<%@include file="../kyoutu/footer.jsp" %>
