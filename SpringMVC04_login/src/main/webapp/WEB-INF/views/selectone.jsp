<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>PASSWORD</th>
			<th>NAME</th>
		</tr>
		
		<tr>
			<td>${dto.id }</td>
			<td>${dto.password }</td>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<td colspan="3">
				<button onclick="location.href='delete.do?id=${dto.id}'">삭제</button>
				<button onclick="location.href='updateform.do?id=${dto.id}'">수정</button>
				<button onclick="location.href='list.do'">목록</button>
			</td>
		</tr>
	</table>
</body>
</html>