<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="Student.DAO" %>
<%@ page import="Student" %>
<%@include file="../kyoutu/login-header.jsp" %>
<%@include file="../kyoutu/login-sidebar.jsp" %>

<h2>成績管理</h2>
<%
        StudentDAO studentDAO = new StudentDAO();
        List<Seiseki> seisekis = seisekiDAO.getAllSeisekis();
    %>
<table>
	<tr>
		<th>入学年度</th>
		<th>クラス</th>
		<th>科目</th>
		<th>回目</th>
	</tr>
	<tr>
		<th>		
		<select name="f1" value="year">
			<option value="">-------</option>
		</select>
		</th>
		<th>
		<select name="f2" value="num">
			<option value="">-------</option>
		</select>
		</th>
		<th>
		<select name="f3" value="subject.cd">
			<option value="">-------</option>
		</select>
		</th>		
		<th>
		<select name="f4" value="num">
			<option value="">-------</option>
		</select>
		</th>
	</tr>
</table>
<input type="button" value="検索">

<%@include file="../kyoutu/footer.jsp" %>
