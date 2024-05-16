<%@page pageEncoding="UTF-8" %>
<div>
	<h2>成績参照</h2>

	
	<form action="../testlist/TestListExecute.action" method="post" id="form">
		<div id="form2">
			<p>科目情報</p>
			<div id="gra1">
				<label for="f1">入学年度</label>
				<select name="f1" id="f1">
					<option value="-1">--------</option>
					<c:forEach var="year" begin="2020" end="2030">
						<option value=${ year}>${ year}</option>
					</c:forEach>
				</select>
			</div>
		 	
		 	<div id="gra1">
				<label for="f2">クラス</label>
				<select name="f2" id="f2">
					<option value="-1">--------</option>
					<c:forEach var="num" items="${ classlist}">
						<option value=${ num}>${ num}</option>
					</c:forEach>
				</select>
			</div>
				
			<div id="gra2">
				<label for="f3">科目</label>
				<select name="f3" id="f3">
					<option value="-1">--------</option>
					<c:forEach var="subject" items="${ sublist}">
						<option value=${ subject.name}>${ subject.name}</option>
					</c:forEach>
				</select>
			</div>
				
			<div id="GACKT">
				<input type="submit" value="検索">
			</div>
		</div>
	</form>
		   
	
	<form action="../testlist/TestListStudentAction.java" method="post" id="form">
	<div id="form2">
		<p>学生情報</p>
		<div id="gra2">
			<label for="f4">学生番号</label>
			<input type="text" name="f4" value="${ f4 }"  placeholder="学生番号を入力してください">
		</div>
		
		<div id="GACKT">
			<input type="submit" value="検索">
		</div>
	</div>
	</form>

	<label>
	<p>科目情報を選択または学生情報を入力して検索ボタンをクリックしてください</p>
	</label>
</div>

