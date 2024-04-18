<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../kyoutu/header.jsp" %>
<%@include file="../kyoutu/sidebar.jsp" %>

<h2>ログイン</h2>
<form action="Login.action" method="post">
	<input type="text" name="id" value="id" placeholder="ID" />
	<input type="text" name="password" value="password" placeholder="パスワード" />
	<input type="checkbox" name="chk_d_ps">
	<label>パスワードを表示</label>
	<input type="submit" name="login">
</form>


<%@include file="../kyoutu/footer.jsp" %>