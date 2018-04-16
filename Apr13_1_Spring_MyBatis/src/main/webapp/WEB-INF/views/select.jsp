<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="searchMenu">
	메뉴명 : <input name=m_name>
	<input type="submit" value="검색">
</form>
	<c:forEach var="m" items="${menus }">
	${m.m_name }
	<fmt:formatNumber value="${m.m_price }" type="currency">
		</fmt:formatNumber>
	</c:forEach>
</body>
</html>