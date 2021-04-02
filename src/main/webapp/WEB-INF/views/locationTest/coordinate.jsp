<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
	window.onload = function(){
		
		let arr_location = `${arr_location}`;
		console.log(`${arr_location}`);
		
		$('#trigger').click(function(){
			const query = $('#query').val();
			getCoordinate(query);
		})
	}
	
	function getCoordinate(query){
		$.ajax({
			method : 'POST',
			url : '/coordinate',
			dataType : 'json',
			data : {query : query, display: 1, start: 1},
			success : function(result){
				console.log(result)
			},
			error : function() {
				alert('실패')
			}
		})
	}
</script>
</head>
<body>
<input id = "query">
<button id = "trigger">Trigger</button>
</body>
</html>