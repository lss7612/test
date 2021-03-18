<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="application/javascript">
	window.onload = function(){
		let resultDiv = document.querySelector('#result');
		resultDiv.innerHTML=`
			${fileList}
		`;
	}
</script>
</head>
<body>

	<div id ="result">
	
	</div>

</body>
</html>