<%@page import="test.data.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>502 jsp study</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<style>
	body *{
		font-family: 'Jua';
	}
	
	.tab thead th{
		background-color : olive;
	}
	
	.tab tbody td{
		background-color : lightgray;
	}
	</style>
</head>
<%!
	//선언문 안에는 변수 선언만
	List<ShopDto> list=new Vector<>();
%>
<%
	list.add(new ShopDto("사과", 3, 2000));
	list.add(new ShopDto("바나나", 1, 1000));
	list.add(new ShopDto("오렌지", 2, 1500));
	list.add(new ShopDto("딸기", 5, 10000));
	list.add(new ShopDto("참외", 10, 2500));
%>
<body>
	<table class="tab table table-bordered" style="width:400px;">
		<thead>
			<th width="50">번호</th>
			<th width="100">과일명</th>
			<th width="50">수량</th>
			<th width="50">단가</th>
			<th>총 가격</th>
		</thead>
		<tbody>
		<%
		int no=1;
		for(ShopDto dto:list){%>
			<tr>
				<td align="center"> <%= no++ %></td>
				<td><%=dto.getSang() %></td>
				<td align="right"><%=dto.getSu() %></td>
				<td align="right"><%=dto.getDan() %></td>
				<td align="right"><%=dto.getSu()*dto.getDan() %></td>
			</tr>
		<%}
		%>
		</tbody>
</body>
</html>