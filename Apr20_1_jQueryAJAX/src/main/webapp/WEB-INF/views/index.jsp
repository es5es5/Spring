<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$("#b1").click(function(){
			// Asynchronous : ������ ���� ���ο� ������� �� ���α׷��� �۵�
			// Javascript
			// And
			// Xml
			// �񵿱�� �ڹٽ�ũ��Ʈ xml���
			
			$.ajax({
				url : "menu.get", // ��û �ּ�
				success : function(xml){
					$("table").empty();
					$(xml).find("menu").each(function(i, m){
						var m_name = $(m).find("m_name").text();
						var m_price = $(m).find("m_price").text();
					
						var nTd = $("<td></td>").text(m_name);
						var pTd = $("<td></td>").text(m_price);
						var tr = $("<tr></tr>").append(nTd, pTd);
						$("table").append(tr);
					});
				} // ���� ����
			});
		});
		$("#b2").click(function(){
			var p = $("#i1").val();
			
			//$.ajax({
			//	url : "��û �ּ�",
			//	data : {�Ķ���͸�:��, �Ķ���͸�:��, ...},
			//	success : function(xml){
			//	}
			//});
			$.ajax({
				url : "menu.search.price",
				data : {m_price : p},
				success : function(xml){
					$("table").empty();
					$(xml).find("menu").each(function(i, m){
						var m_name = $(m).find("m_name").text();
						var m_price = $(m).find("m_price").text();
					
						var nTd = $("<td></td>").text(m_name);
						var pTd = $("<td></td>").text(m_price);
						var tr = $("<tr></tr>").append(nTd, pTd);
						$("table").append(tr);
					});
				}
			});
		});
		
		$("#b3").click(function(){
			var n = $("#i3").val();
			// �� ->%2D
			n = encodeURIComponent(n);
			// jquery�� utf-8
			// ...
			
			
			$.ajax({
				url : "menu.search.name",
				data : {m_name : n},
				success : function(xml){
					$("table").empty();
					$(xml).find("menu").each(function(i, m){
						var m_name = $(m).find("m_name").text();
						var m_price = $(m).find("m_price").text();
					
						var nTd = $("<td></td>").text(m_name);
						var pTd = $("<td></td>").text(m_price);
						var tr = $("<tr></tr>").append(nTd, pTd);
						$("table").append(tr);
					});
				}
			});
		});
			
		$("input").keyup(function(e){
			if(e.keyCode == 13){
				// ���� �̺�Ʈ �߻�
				$("#b2").trigger("click");
			}
		});
	});
</script>
</head>
<body>
	<h1>index</h1>
	<button id="b1">��ü �޴� ���</button>
	<br>
	<input id="i1">&nbsp;&nbsp;
	<button id="b2">�������� �˻�</button>
	<input id="i2">&nbsp;&nbsp;
	<button id="b3">�̸����� �˻�</button>

	<hr>
	<table></table>
</body>
</html>







