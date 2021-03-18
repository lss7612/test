<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="application/javascript" src="/resources/js/google/tokens/auth_token.js">
</script>
<style type="text/css">
	button{
		cursor:pointer;
	}
	.invisible{
		display: none;
	}
</style>
</head>
<body>

<div>
	clientId <input type="text" id="clientId" name="clientId" value="624023799723-ftk48aaq2m6bg9tpt5p1ig2mf8gjm6a5.apps.googleusercontent.com"><br>
	clientSecret <input type="password" id="clientSecret" name="clientSecret" value="cVZJBNb9BaAsNYffaYKriPdp"><br>
	<button id="getToken">제출</button>
</div>

<div id="result">
	
</div>

</body>
</html>