<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../kyoutu/login-header.jsp" %>
<%@include file="../kyoutu/login-sidebar.jsp" %>

<h2>成績管理</h2>

	<from action="TestList.action" method="post">	
		<label>入学年度</label>	
		<select name="f1" value="year">
			<option value="">-------</option>
			<c:forEach items="${f1}" var="f1">
				<option value="${f1.ent_year}">${f1.ent_year}</option>
		</select>
		
		<label>クラス</label>
		<select name="f2" value="num">
			<option value="">-------</option>
			<option value="101">101</option>
			<option value="131">131</option>
			<option value="201">201</option>
		</select>
		
		<label>科目</label>
		<select name="f3" value="subject.cd">
			<option value="">-------</option>
			<option value="A01">A01</option>
			<option value="A02">A02</option>
			<option value="B01">B01</option>
			<option value="B02">B02</option>
			<option value="C01">C01</option>
			<option value="C02">C02</option>
			<option value="D01">D01</option>
			<option value="D02">D02</option>
			<option value="E01">E01</option>
			<option value="E02">E02</option>
			<option value="F01">F01</option>
			<option value="F02">F02</option>
			<option value="G01">G01</option>
			<option value="G02">G02</option>
			<option value="H01">H01</option>
			<option value="H02">H02</option>
			<option value="I01">I01</option>
			<option value="I02">I02</option>
			<option value="J01">J01</option>
			<option value="J02">J02</option>
		</select>
		
		<label>回目</label>
		<select name="f4" value="num">
			<option value="">-------</option>
			<option value="1">1</option>
			<option value="2">2</option>
		</select>
	</from>

<input type="button" value="検索">

<%@include file="../kyoutu/footer.jsp" %>
