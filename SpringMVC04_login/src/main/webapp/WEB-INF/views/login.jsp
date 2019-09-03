<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		$("#loginChk").hide();
	})
	
	function login(){
		var idVal = $("#id").val();
		var pwVal = $("#pw").val();
		
		if(idVal == "" || idVal == null){
			alert("ID를 확인해 주세요.");
		} else if(pwVal == "" || pwVal == null){
			alert("PW를 확인해 주세요.");
		} else{
			$("#loginChk").show();
			
			$.ajax({
				type : "post",
				url : "loginajax.do",
				data : "id="+idVal+"&pw="+pwVal,
				success : function(msg){
					alert(msg.loginChk);
					if(msg.loginChk == true){
						location.href="list.do";
					} else {
						$("#loginChk").html("ID와 PW를 확인 해주세요");
					}
				},
				error : function(){
					alert("로그인 실패!");
				}
			});
		}
	}
	
</script>

</head>
<body>

	<h1>LOGIN</h1>
	
	<table>
		<tr>
			<th>I D </th>
			<td><input type="text" id="id"></td>
		</tr>
		<tr>
			<th>P W </th>
			<td><input type="text" id="pw"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="Login" onclick="login()"></td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
	</table>

</body>
</html>