<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../kyoutu/header.jsp" %>

<h2>ログイン</h2>
<p>ログインに失敗しました。IDまたはパスワードが正しくありません。</p>
<form action="../log/Login.action" method="post">
	<input type="text" name="id" placeholder="ID" />
	<input type="password" name="password" placeholder="パスワード" />
	<input type="checkbox" name="chk_d_ps">
	<label>パスワードを表示</label>
	<input type="submit" name="login">
</form>


<%@include file="../kyoutu/footer.jsp" %>