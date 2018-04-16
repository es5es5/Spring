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
	<form action="DataRoomRegController"
		method="post" enctype="multipart/form-data"
	 name="drRegForm" onsubmit="return drRegCheck();">
		<table id="drRegTbl">
			<c:choose>
				<c:when test="${sessionScope.loginMember != null }">
					<tr>
						<td align="center"><input class="drRegInput" name="id_title" placeholder="����" maxlength="10" autocomplete="off"></td>
					</tr>
					<tr>
						<td align="center"><input name="id_file" type="file"></td>
					</tr>
					<tr>
						<td align="center">
							<input id="drRegBtn" type="submit" value="���ε�">
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td align="center" id="drBlankTitleTd">�ڷ��</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</form>
	<table id="drArea">
		<tr>
			<td align="center">
				<c:forEach var="d" items="${datas }">
					<table class="drItem">
						<tr>
							<c:choose>
								<c:when test="${sessionScope.loginMember.im_id == d.id_owner }">
									<td align="center" colspan="2" class="drTitle" ondblclick="deleteData(${d.id_id}, '${d.id_file }');">${d.id_title }</td>
								</c:when>
								<c:otherwise>
									<td align="center" colspan="2" class="drTitle">${d.id_title }</td>
								</c:otherwise>
							</c:choose>
						</tr>
						<tr>				
							<td rowspan="2" class="drImgTd" align="center">
								<a href="etc/${d.id_file }">
									<img src="etc/d.png">
								</a>
							</td>
							<td>${d.id_owner }</td>
						</tr>
						<tr>
							<td align="right">
								<fmt:formatDate value="${d.id_date }" pattern="yyyy-MM-dd"/>&nbsp;
							</td>
						</tr>
					</table>
				</c:forEach>
			</td>
		</tr>
	</table>
	
</body>
</html>