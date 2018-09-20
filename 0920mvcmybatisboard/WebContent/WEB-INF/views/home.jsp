<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- list 출력할 때는 꼭 3번 라인의  코드를 추가할 것 -->
	<table align="center"  cellpadding="3px">
		<tr style="background:pink">
			<th width="80">아이템 번호</th>
			<th width="200">아이템 이름</th>
			<th width="120">가격</th>
		</tr>

		<c:forEach var="item" items="${list}">
			<tr style="background:lightgray">
				<td align="right">${item.itemid}</td>
				<td><a href="detail?itemid=${item.itemid}">${item.itemname}</a></td>
				<td>${item.price}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>