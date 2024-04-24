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
<input type="button" value="検索">

<h2>科目:</h2>
<table>
	<tr>
		<th>入学年度</th>
		<th>クラス</th>
		<th>学生番号</th>
		<th>氏名</th>
		<th>点数</th>
	</tr>
	<tr>
		<th>a</th>
		<td>a</td>
		<td>a</td>
		<td>a</td>
		<input type="text" name="int_${学生番号}>
	</tr>
</table>
<input type="button" value="登録して終了">

<%@include file="../kyoutu/footer.jsp" %>
