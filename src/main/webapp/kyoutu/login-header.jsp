<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>得点管理システム</title>
	<style>
		<%@include file="../css/main.css" %>
	</style>
</head>
<header>
	<h1>得点管理システム</h1>
	<a href="../Log/logout-in.jsp">ログアウト</a>
	<form action="../log/Login.action">
		<a>${ teacher.name}様</a>
	</form>
</header>
<body>