<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="wapper">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
	<div id="main">
		<div>
			<h2>学生情報登録</h2>
			<form action="StudentUpdateExecute.action">
				<label for="ent_year">入学年度</label>
				<input type="text" value="${ ent_year}" readonly>
				<br>
				
				<label for="no">学生番号</label>
				<input type="text" value="${ no}" readonly>
				<br>
				
				<label for="name">氏名</label>
				<input type="text"name="name" value="${ name}">
				<br>
			
				<label for="class_num">クラス</label>
				<select name="class_num" id="class_num">
					<c:forEach var="num" items="${ classlist}">
						<option value=${ num}>${ num}</option>
					</c:forEach>
				</select>
				<br>

				<label><input type="checkbox" name="si_attend" value="true" checked>在学中</label>
				<br>
				
				<td>
					<input  type="submit" value="絞込み">
				</td>
			</form>
		</div>
	</div>
</div>
<%@include file="../kyoutu/footer.jsp" %>