<%@page pageEncoding="UTF-8" %>

<div>
	<h2>学生管理</h2>
	
	<a href="../Student/student-create.jsp" id="a">新規登録</a>
	<form action="StudentExecute.action" method="post" id="form">
		<div id="form1">
			<div id="sele">
				<label for="f1">入学年度</label>
				<select name="f1" id="f1">
					<c:choose>
						<c:when test="${ empty choiceYear}"><option value="-1" selected>--------</option></c:when>
						<c:when test="${ choiceYear == -1}"><option value="-1" selected>--------</option></c:when>
						<c:otherwise>
							<option value="${ choiceYear}" selected hidden>${ choiceYear}</option>
							<option value="-1">--------</option>
						</c:otherwise>
					</c:choose>
					<c:forEach var="year" begin="2020" end="2030">
						<option value=${ year}>${ year}</option>
					</c:forEach>
				</select>
			</div>
				
			<div id="sele">
				<label for="f2">クラス</label>
				<select name="f2" id="f2">
					<c:choose>
						<c:when test="${ empty choiceClass}"><option value="notselect" selected>--------</option></c:when>
						<c:otherwise>
							<option value="${ choiceClass}" selected hidden>${ choiceClass}</option>
							<option value="notselect">--------</option>
						</c:otherwise>
					</c:choose>
					<c:forEach var="num" items="${ classlist}">
						<option value=${ num}>${ num}</option>
					</c:forEach>
				</select>
			</div>
					
			<div id="sele">
				<c:choose>
					<c:when test="${ choiceAttend}">
						<label><input type="checkbox" name="f3" value="true" checked>在学中</label>
					</c:when>
					<c:otherwise>
						<label><input type="checkbox" name="f3" value="true" checked>在学中</label>
					</c:otherwise>
				</c:choose>
			</div>
				
			<div id="GACKT">
					<input  type="submit" value="絞込み">
			</div>
		</div>
	</form>
</div>