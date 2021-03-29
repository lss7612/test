window.onload = function(){
	let result_div = document.querySelector('#result');
	loadFileList(result_div);
}

function loadFileList(result_div){
	$.ajax({
		type: "GET"
		, url: "/repository/getfilelist"
		, dataType:"json" //응답받은 데이터의 형식
		, success: function( res ){
			console.log(res)
			result_div.innerHTML=res.fileList;
		}
		, error: function(){
			console.log('실패')
		}
	})
}