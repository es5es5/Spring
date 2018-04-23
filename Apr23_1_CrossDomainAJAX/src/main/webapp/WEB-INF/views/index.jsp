<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jquery.js"></script>
<script type="text/javascript">
	$(function() {

		$("#b1").click(function() {
			var cityName = $("#i1").val();

			// Cross-Domain AJAX
			// 		1. JSONP (JSON with Padding)
			//			�����ʿ��� �Ķ���� �ϳ� ����(callback)
			//			callback=asd�� �־� ��û������
			//			����� asd(...) (JS�Լ�����)�� ������ ����
			//						

			// AJAX
			$.ajax({
				url : "http://api.openweathermap.org/data/2.5/weather",
				data : {
					q : cityName,
					appid : "baff8f3c6cbc28a4024e336599de28c4",
					units : "metric",
					lang : "kr"
				},
				success : function(json) {
					// JSON -> String
					var w = json.weather[0].description;
					var i = json.weather[0].icon;
					var t = json.main.temp;

					i = "https://openweathermap.org/img/w/" + i + ".png";
					$("#img1").attr("src", i);
					$("#h31").text(w);
					$("#h32").text(t);
				}
			});
		});
		$("#b2").click(function() {
			var movieTitle = $("#i2").val();
			movieTitle = encodeURIComponent(movieTitle);
			// 2. JSONP�� �Ǿ� ���� ������
			// 		JavaScript�δ� �ܺο� ������ �Ұ����ϳ�
			//		Java�� ����
			//		�߰� �� �ܰ�(proxy)�� ��ġ��

			$.ajax({
				url : "movie.get",
				data : {
					q : movieTitle
				},
				success : function(xml) {
					$("#t2").empty();
					$(xml).find("item").each(function(i, m) {
						var t = $(m).find("title").text();
						var i = $(m).find("image").text();
						var u = $(m).find("userRating").text();

						var img = $("<img>").attr("src", i);
						var td1 = $("<td></td>").append(img);
						var td2 = $("<td></td>").html(t);
						var td3 = $("<td></td>").text(u);
						var tr = $("<tr></tr>").append(td1, td2, td3);
						$("#t2").append(tr);
					});
				}
			});
		});
		$("#i2").keyup(function(){
			$("#b2").trigger("click");
		});
	});
</script>
</head>
<body>
	<h2>���� �˻�</h2>
	<input id="i1">
	<button id="b1">���ø����� �˻�</button>
	<img id="img1">
	<h3 id="h31"></h3>
	<h3 id="h32"></h3>
	<hr>
	<h2>��ȭ �˻�</h2>
	<input id="i2">
	<button id="b2">���� �˻�</button>
	<table id="t2"></table>

</body>
</html>