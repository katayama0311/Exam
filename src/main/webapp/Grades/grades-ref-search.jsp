<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../kyoutu/login-header.jsp" %>
<%@include file="../kyoutu/login-sidebar.jsp" %>

<h2>成績参照</h2>

<table>
	<div>
		科目情報
	</div>
	<tr>
		<th>入学年度</th>
		<th>クラス</th>
		<th>科目</th>
	</tr>
	<tr>
		<th>
		<select name="f1">
			<option value="">-------</option>
		</select>	
		</th>
		<th>
		<select name="f2">
			<option value="">-------</option>
		</select>
		</th>
		<th>
		<select name="f3">
			<option value="">-------</option>
		</select>
		</th>
	</tr>
</table>
<input type="button" value="検索">


<table>
	<label>
		<p>学生情報</p>
	</label>
	<tr>
		<div>
			学生番号
		</div>
	</tr>
	<tr>
		<form action="" >
			<input type="text" name="f4" value="${f4}" placeholder="学生番号を入力してください">
		</form>
	</tr>
</table>
<input type="button" value="検索">


<label>
	<p>科目情報を選択または学生情報を入力して検索ボタンをクリックしてください</p>
</label>

<%@include file="../kyoutu/footer.jsp" %>