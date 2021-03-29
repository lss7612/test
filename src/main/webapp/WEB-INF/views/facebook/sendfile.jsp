<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
 src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<title>Insert title here</title>

</head>
<body>
<div>경로 C:\Users\이상성\Desktop\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp3\wtpwebapps\Test\resources\repository</div>
<div>Dog - 49330.mp4를 페이스북에 보내는 예제</div>
<button id="send">SEND</button>

<script type="text/javascript">
	$('#send').on('click',function(){
		$.ajax({
			type: "POST"
			, enctype: 'multipart/form-data'
			, url: "/facebook/sendfile"
			, dataType:"json" //응답받은 데이터의 형식
			, success: function( res ){
				alert(res.sucess);
			}
			, error: function(){
				console.log('실패')
			}
		})
	})
</script>

</body>
</html>