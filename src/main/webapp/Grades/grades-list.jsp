<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../kyoutu/login-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="wrapper">
	<%@include file="../kyoutu/login-sidebar.jsp" %>
	<div class="main">
		<%@include file="grades-list-form.jsp" %>
		
		<p>科目：${ subject.name} (${ no}回)
		
	</div>
</div>
<%@include file="../kyoutu/footer.jsp" %>