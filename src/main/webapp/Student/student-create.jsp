<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="wrapper">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
	<div class="main">
		<div>
			<h2>学生情報登録</h2>
			<form action="../student/StudentCreateExecute.action">
				<div id="sel">
					<label for="ent_year">入学年度</label><br>
					<select name="ent_year" id="ent_year">
						<option value="-1" selected>--------</option>
						<c:forEach var="year" begin="2020" end="2030">
							<option value=${ year}>${ year}</option>
						</c:forEach>
					</select>
						<c:if test="${ Era == -1}">
							<p>入学年度を入力してください
						</c:if>
				</div>
				<br>
				
				<div id="in">
					<label for="no">学生番号</label><br>
					<c:choose>
						<c:when test="${ Era == -1}">
							<input type="text" name="no" value="${ studentinfo.no}" maxlength=10 placeholder="学生番号を入力してください" required>
						</c:when>
						<c:otherwise>
							<input type="text" name="no" value="${ no}" maxlength=10 placeholder="学生番号を入力してください" required>
							<c:if test="${ Kira == -1}">
								<p>学生番号が重複しています
							</c:if>
						</c:otherwise>
					</c:choose>
				</div>
				<br>
				
				<div id="in">
					<label for="name">氏名</label><br>
					<c:choose>
						<c:when test="${ Era == -1}">
							<input type="text" name="name" value="${ studentinfo.name}" maxlength=10 placeholder="氏名を入力してください" required>
							</c:when>
						<c:otherwise>
							<input type="text" name="name" value="${ name}" maxlength=10 placeholder="氏名を入力してください" required>
						</c:otherwise>
					</c:choose>
				</div>
				<br>
				
				<div id="sel">
					<label for="class_num">クラス</label><br>
					<c:choose>
						<c:when test="${ Era == -1}">
							<select name="class_num" id="class_num">
								<option value=${ studentinfo.classNum} selected>${ studentinfo.classNum}</option>
								<c:forEach var="num" items="${ classlist}">
									<option value=${ num}>${ num}</option>
								</c:forEach>
							</select>
						</c:when>
						<c:otherwise>
							<select name="class_num" id="class_num">
								<c:forEach var="num" items="${ classlist}">
									<option value=${ num}>${ num}</option>
								</c:forEach>
							</select>
						</c:otherwise>
					</c:choose>
				</div>
				<br>
				
				<div id="GACKT">
					<input  type="submit" value="登録して終了">
				</div>
			</form>
			<a href="../student/StudentList.action">戻る</a>
		</div>
	</div>
</div>
<%@include file="../kyoutu/footer.jsp" %>