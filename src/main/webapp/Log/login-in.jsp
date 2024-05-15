<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../kyoutu/header.jsp" %>

<div class="wrapper">
	<%@include file="../kyoutu/sidebar.jsp" %>
	<div class="logmain">
		<h2>ログイン</h2>
		<form action="../log/Login.action" method="post" id="login">
			<input type="text" name="id" placeholder="IDを入力してください" maxlength=20 required />
			<br>
			<input type="password" name="password" placeholder="パスワードを入力してください" maxlength=20 required/>
			<br>
			<label for="chk_d_ps"><input type="checkbox" name="chk_d_ps">パスワードを表示</label>
			<br>
			<input type="submit" name="login" value="ログイン">
		</form>
	</div>
</div>

<%@include file="../kyoutu/footer.jsp" %>