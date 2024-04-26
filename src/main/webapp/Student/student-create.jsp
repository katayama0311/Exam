<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../kyoutu/login-header.jsp" %>
<%@include file="../kyoutu/login-sidebar.jsp" %>

<div class="main">
	<h2>学生情報登録</h2>
	<form action="StudentCreateExecute.action">
		<label for="ent_year">入学年度</label>
		<select name="ent_year" id="ent_year">
			<option value="temp">------</option>
			<c:forEach var="year" begin="2020" end="2030">
				<option value=${ year}>${ year}</option>
			</c:forEach>
		</select>
		<br>
		
		<label for="no">学生番号</label>
	</form>
</div>