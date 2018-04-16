<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사물인터넷기반 하이브리드 웹앱 개발자 양성 과정 카페</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/member.css">
<link rel="stylesheet" href="resources/css/sns.css">
<link rel="stylesheet" href="resources/css/community.css">
<link rel="stylesheet" href="resources/css/dataroom.css">
<link rel="stylesheet" href="resources/css/vote.css">
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<script type="text/javascript" src="resources/js/check.js"></script>
<script type="text/javascript" src="resources/js/go.js"></script>
</head>
<body>
	<table id="siteTitleArea">
		<tr>
			<td align="center" id="siteMenuArea">
				<table id="siteMenuArea2"> 
					<tr>
						<td>
							<a href="SNSController" class="siteMenu">SNS</a>
							<a href="DataRoomController" class="siteMenu">자료실</a>
							<c:if test="${sessionScope.loginMember != null }">
							<a href="VoteController" class="siteMenu">투표</a>
							<a href="CommunityController" class="siteMenu">커뮤니티</a>
							</c:if>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table id="siteTitleArea2">
					<tr>
						<td id="siteTitleTd">
							<a id="siteTitle" href="home.go">사물인터넷기반 하이브리드웹앱 개발자 양성 과정 카페 <span style="color:#A5D6A7; font-size: 13pt;">v2.0</span></a>
							<div id="siteURL">&nbsp;&nbsp;&nbsp;http://172.16.1.100/ihwac2</div>
						</td> 
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<div id="siteLoginArea">
		<jsp:include page="${loginPage }"></jsp:include>
	</div>
	<table id="siteContentArea">
		<tr>
			<td align="center">
				<table id="siteContentArea2">
					<tr>
						<td align="center">
							<jsp:include page="${contentPage }"></jsp:include>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html> 