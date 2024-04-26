<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../kyoutu/login-header.jsp" %>
<%@include file="../kyoutu/login-sidebar.jsp" %>

<div id="main">
	<h2>学生管理</h2>
	
	<a href="student-create.jsp">新規登録</a><p>
	<label for="f1">入学年度</label>
	<select name="f1" id="f1">
		<option value="temp">------</option>
		<c:forEach var="year" begin="2020" end="2030">
			<option value=${ year}>${ year}</option>
		</c:forEach>
	</select>
	
	<label for="f2">クラス</label>
	<select name="f2" id="f2">
		<option value="temp">------</option>
	</select>
		
	
	<label for="f3">在学中</label>
		<input type="checkbox"name="f3" id="f3" value="f3">
	
	<table>
		<tr>
			<th>入学年度</th>
			<th>学生番号</th>
			<th>氏名</th>
			<th>クラス</th>
			<th>在学中</th>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		
	</table>
</div>

<%@include file="../kyoutu/footer.jsp" %>
