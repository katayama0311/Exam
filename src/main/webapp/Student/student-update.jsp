<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="wrapper">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
	<div class="main">
		<div>
			<h2>学生情報変更</h2>
			<form action="../student/StudentUpdateExecute.action">
				<div id="in">
					<label for="ent_year">入学年度</label><br>
					<input type="text" name="ent_year" value="${ student.entYear}" readonly>
				</div>
				<br>
				
				<div id="in">
					<label for="no">学生番号</label><br>
					<input type="text" name="no" value="${ student.no}" readonly>
				</div>
				<br>
				
				<div id="in">
					<label for="name">氏名</label><br>
					<input type="text"name="name" value="${ student.name}" maxlength=10 required>
				</div>
				<br>
				
				<div id="sel">
					<label for="class_num">クラス</label><br>
					<select name="class_num" id="class_num">
						<option value=${ student.classNum}>${ student.classNum}
						<c:forEach var="num" items="${ classlist}">
							<option value=${ num}>${ num}</option>
						</c:forEach>
					</select>
				</div>
				<br>

				<div id="che">
					<c:choose>
						<c:when test="${ student.isAttend == true}">
							<label><input type="checkbox" name="is_attend" value="true" checked>在学中</label>
						</c:when>
						<c:otherwise>
							<label><input type="checkbox" name="is_attend" value="true">在学中</label>
						</c:otherwise>
					</c:choose>
				</div>
				<br>

				<input  type="submit" value="変更">
			</form>
		<a href="../student/StudentList.action">戻る</a>
		</div>
	</div>
</div>
<%@include file="../kyoutu/footer.jsp" %>