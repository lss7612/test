<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Authorization Code</title>
<script type="text/javascript"
 src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
		
	
	window.onload=function(){
		
		let client_id = 'YIx19lL9FFhkX3Xu0XQEPC'; 
		let client_secret = 'gauEdbNXMtqpS0t1cx6qCB';
		let redirect_uri = 'https://www.optimize-mkt.kr/customer/test/cafe24/getoauth';
		let base_uri = 'https://armyring.cafe24api.com/api/v2/oauth/authorize';
		let scope = 'mall.read_application,mall.write_application';
		let uri = '?client_id='+client_id+'&redirect_uri='+redirect_uri+'&scope='+scope+'&response_type=code';
		
		const btn_trigger = document.getElementById('btn_trigger');
		btn_trigger.addEventListener('click',function(){
			alert('https://armyring.cafe24api.com/api/v2/oauth/authorize'+uri);
			location.href='https://armyring.cafe24api.com/api/v2/oauth/authorize'+uri;
		});
		
	}

</script>
</head>
<body>

<button id="btn_trigger">trigger</button>

</body>
</html>