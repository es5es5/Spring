<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
div {
	position: fixed;
	top: 0px;
	right: 0px;
}

table {
	width: 800px;
	border-spacing: 0px;
}

table tr th {
	background-color: black;
	color: white;
}

table tr td, table tr th {
	padding-top: 10px;
	padding-bottom: 10px;
	border-top: black solid 1px;
}

img {
	max-width: 120px;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th>ǰ��</th>
			<th width="130px">����</th>
			<th>ǰ��</th>
			<th>����</th>
			<th>�������</th>
		</tr>
		<c:forEach var="p" items="${products }">
			<tr>
				<td align="center">${p.p_no }</td>
				<td align="center"><img src="resources/img/${p.p_img }"></td>
				<td>${p.p_name }</td>
				<td><fmt:formatNumber value="${p.p_price }" type="currency" /></td>
				<td align="right"><fmt:formatDate value="${p.p_exp }"
						dateStyle="long" /></td>
			</tr>
		</c:forEach>
	</table>

	<div>
		${r }
		<hr>
		<h2>��ǰ���</h2>
		<form action="product.reg" method="post"
			enctype="multipart/form-data">
			ǰ�� : <input name="p_name"><br>
			���� : <input type="file"	name="p_img"><br>
			���� : <input name="p_price"><br>
			�������: <input name="p_exp"><br>
			<input type="submit" value="���">
		</form>
		<hr>
		<h2>��ǰ������ ã��</h2>
		<form action="product.search">
			ǰ�� : <input name="p_name"> <input type="submit" value="ã��">
		</form>
		<hr>
		<h2>�������� ã��</h2>
		<form action="SearchPriceController">
			<input name="p_price">�� ���� <input type="submit" value="ã��">
		</form>
		<hr>
		<h2>��ǰ��ȣ�� �����</h2>
		<form action="product.delete">
			ǰ�� : <input name="p_no"> <input type="submit" value="�����">
		</form>
		<hr>
		<h2>���� �λ�</h2>
		<form action="UpdateController">
			<input name="search">�� ������ ��<br>
			<input name="increase">�� �λ�<br>
			<input type="submit" value="�λ�">
		</form>
	</div>
</body>
</html>
