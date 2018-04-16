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
			<th>품번</th>
			<th width="130px">사진</th>
			<th>품명</th>
			<th>가격</th>
			<th>유통기한</th>
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
		<h2>상품등록</h2>
		<form action="product.reg" method="post"
			enctype="multipart/form-data">
			품명 : <input name="p_name"><br>
			사진 : <input type="file"	name="p_img"><br>
			가격 : <input name="p_price"><br>
			유통기한: <input name="p_exp"><br>
			<input type="submit" value="등록">
		</form>
		<hr>
		<h2>상품명으로 찾기</h2>
		<form action="product.search">
			품명 : <input name="p_name"> <input type="submit" value="찾기">
		</form>
		<hr>
		<h2>가격으로 찾기</h2>
		<form action="SearchPriceController">
			<input name="p_price">원 이하 <input type="submit" value="찾기">
		</form>
		<hr>
		<h2>상품번호로 지우기</h2>
		<form action="product.delete">
			품명 : <input name="p_no"> <input type="submit" value="지우기">
		</form>
		<hr>
		<h2>가격 인상</h2>
		<form action="UpdateController">
			<input name="search">원 이하인 것<br>
			<input name="increase">원 인상<br>
			<input type="submit" value="인상">
		</form>
	</div>
</body>
</html>
