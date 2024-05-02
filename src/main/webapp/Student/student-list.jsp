<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="sidebar">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
</div>

<div class="main">
	<h2>学生管理</h2>
	
	<a href="../Student/student-create.jsp">新規登録</a><p>
	<form action="StudentList.action" method="post">
		<label for="f1">入学年度</label>
		<select name="f1" id="f1">
			<option value="temp">------</option>
			<c:forEach var="year" begin="2020" end="2030">
				<option value=${ year}>${ year}</option>
			</c:forEach>
		</select>
		
		<label for="f2">クラス</label>
		<select name="f2" id="f2">
			<option value="temp">------</option>
			
		</select>
			
		
		<label for="f3">在学中</label>
		<input type="checkbox"name="f3" id="f3" value="f3">
		
		
		<input  type="submit" name="login" value="絞込み">
	</form>
		
	<table>
		<tr>
			<th>入学年度</th>
			<th>学生番号</th>
			<th>氏名</th>
			<th>クラス</th>
			<th>在学中</th>
		</tr>
		<c:forEach var="student" items="${ student_list}">
		<tr>
			<td>${ student.entYear}</td>
			<td>${ student.no}</td>
			<td>${ student.name}</td>
			<td>${ student.classNum}</td>
			<c:choose>
    			<c:when test="${student.isAttend}">
        			<td>〇</td>
    			</c:when>
    			<c:otherwise>
        			<td>×</td> <!-- isAttend が false の場合は × を表示 -->
    			</c:otherwise>
			</c:choose>
			<td><a href="../student/StudentUpdate.action">変更</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
