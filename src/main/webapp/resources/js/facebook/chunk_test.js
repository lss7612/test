window.onload=function(){
	let btn_submit = document.querySelector('#btn_submit');
    let input_file = document.querySelector('#file');
    console.log(btn_submit);
    console.log(input_file);

    btn_submit.addEventListener('click',()=>{
        send_file_ajax();
    })
}

function send_file_ajax(){
	let form = $('#uploadForm')[0];
    let formData = new FormData(form);
	console.log(formData)
	$.ajax({
		type: "POST"
		, enctype: 'multipart/form-data'
		, url: "/chunk_test_ajax"
		, data: formData
		, contentType: false
		, processData: false
		, dataType:"json" //응답받은 데이터의 형식
		, success: function( res ){
			alert('성공')
			console.log(res)
			location.href="/repository/video_repository"
		}
		, error: function(){
			console.log('실패')
		}
	})
}