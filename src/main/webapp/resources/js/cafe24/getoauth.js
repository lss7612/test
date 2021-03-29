window.onload=()=>{

    const test_btn = document.getElementById('btn');
    test_btn.addEventListener("click",function(){
        sendRequest();
    })

}

function sendRequest(){
    let client_id = 'YIx19lL9FFhkX3Xu0XQEPC';
    let scope_arr = ['mall.read_application','mall.write_application']
    let url = 'armyring.cafe24api.com/api/v2/oauth/authorize';
    console.log(url);
    $.ajax({
        method : 'GET',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        url : url,
        data:{client_id : client_id, response_type:'code', scope : scope_arr},
        dataType:"String",
        success:function(res){
            console.log(res)
        },
        error:function(){
            console.log('실패')
        }
    })
}