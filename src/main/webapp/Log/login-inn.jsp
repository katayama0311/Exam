<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../kyoutu/header.jsp" %>

<div class="wrapper">
	<%@include file="../kyoutu/sidebar.jsp" %>
	<div class="logmain">
		<h2>ログイン</h2>
		<form action="../log/Login.action" method="post" id="login">
			<input type="text" name="id" placeholder="IDを入力してください" maxlength=20 required />
			<br>
			<input type="password" name="password" id="password" placeholder="パスワードを入力してください" maxlengt=20 required/>
			<br>
			<label for="chk_d_ps"><input type="checkbox" id="chk_d_ps" onchange="togglePasswordVisibility()" />パスワードを表示する</label>
			<br>
			<input type="submit" name="login" value="ログイン">
			<script>
				function togglePasswordVisibility() {
					let passwordInput = document.getElementById("password");
					let showPasswordCheckbox = document.getElementById("chk_d_ps");
		
					if (showPasswordCheckbox.checked) {
						passwordInput.type = "text";
					} else {
						passwordInput.type = "password";
					}
				}
			</script>
		</form>
	</div>
</div>

<%@include file="../kyoutu/footer.jsp" %>