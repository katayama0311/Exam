<%@page pageEncoding="UTF-8" %>

		<div>
			<h2>成績管理</h2>
			
			<form action="../testlist/TestListExecute.action" method="post">
				<label for="f1">入学年度</label>
				<select name="f1" id="f1">
					<option value="-1">--------</option>
					<c:forEach var="year" begin="2020" end="2030">
						<option value=${ year}>${ year}</option>
					</c:forEach>
				</select>
				
				<label for="f2">クラス</label>
				<select name="f2" id="f2">
					<option value="-1">--------</option>
					<c:forEach var="num" items="${ classlist}">
						<option value=${ num}>${ num}</option>
					</c:forEach>
				</select>
				
				<label for="f3">科目</label>
				<select name="f3" id="f3">
					<option value="-1">--------</option>
					<c:forEach var="subject" items="${ sublist}">
						<option value=${ subject.name}>${ subject.name}</option>
					</c:forEach>
				</select>
				
				<label for="f4">回数</label>
				<select name="f4" id="f4">
					<option value="-1">--------</option>
					<c:forEach var="num" begin="1"  end="2">
						<option value=${ num}>${ num}</option>
					</c:forEach>
				</select>
				
				<input type="submit" value="検索">
				
			</form>
		</div>
