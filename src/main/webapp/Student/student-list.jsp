<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="wrapper">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
	<div class="main">
		<%@include file="student-list-form.jsp" %>
		<c:choose>
			<c:when test="${ SAKANANOera == -1}">
				クラスを指定する場合は入学年度も指定してください。
			</c:when>
			<c:when test="${ studentlist.size() == 0}">
				学生情報が存在しませんでした。
			</c:when>
			<c:otherwise>
				<div>
					検索結果:${ studentlist.size()}件
					<table>
						<tr>
							<th>入学年度</th>
							<th>学生番号</th>
							<th>氏名</th>
							<th>クラス</th>
							<th>在学中</th>
							<th></th>
						</tr>
						
						<c:forEach var="student" items="${ studentlist}">
						<tr>
							<td>${ student.entYear}</td>
							<td>${ student.no}</td>
							<td>${ student.name}</td>
							<td>${ student.classNum}</td>
							<td>${student.isAttend == "True" ? "〇" : "×"}</td>
							<td><a href="StudentUpdate.action?no=${ student.no}">変更</a></td>
						</tr>
						</c:forEach>
					</table>
				</div>
			</c:otherwise>
		</c:choose>	
	</div>
</div>
<%@include file="../kyoutu/footer.jsp" %>