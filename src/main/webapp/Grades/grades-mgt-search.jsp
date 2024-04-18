<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../kyoutu/login-header.jsp" %>
<%@include file="../kyoutu/login-sidebar.jsp" %>

<h2>成績管理</h2>
<table>
	<tr>
		<th>入学年度</th>
		<th>クラス</th>
		<th>科目</th>
		<th>回目</th>
	</tr>
	<tr>
		<th>		
		<select name="f1" value="year">
			<option value="">-------</option>
		</select>
		</th>
		<th>
		<select name="f2" value="num">
			<option value="">-------</option>
		</select>
		</th>
		<th>
		<select name="f3" value="subject.cd">
			<option value="">-------</option>
		</select>
		</th>		
		<th>
		<select name="f4" value="num">
			<option value="">-------</option>
		</select>
		</th>
	</tr>
</table>
<form action="" >
	<input type="submit" value="検索">
</form>

<h2>科目：</h2>
<table>
	<tr></table>
<%@include file="../kyoutu/footer.jsp" %>
