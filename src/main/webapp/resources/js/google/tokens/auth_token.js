let btn_getToken;
let clientId;
let clientSecret;
let resultDiv;
	
window.onload = function(){
	btn_getToken = document.querySelector('#getToken');
    clientId = document.querySelector('#clientId');
    clientSecret = document.querySelector('#clientSecret');
    resultDiv = document.getElementById('result');
	
    
    btn_getToken.addEventListener('click',function(){
    	getUrl(clientId.value,clientSecret.value,resultDiv,btn_getToken)
    });
}

function getUrl(clientId,clientSecret,resultDiv,btn_getToken){
    $.ajax({
        type : 'POST'
        ,url : '/google/tokens/auth_token'
        ,data : {clientId : clientId, clientSecret : clientSecret}
    	,dataType : 'JSON'
        ,success : (res)=>{
            resultDiv.innerHTML=`
            auth_token : <input type="text" id="code" placeholder="여기에 발급코드를 입력하세요"/><br>
            <button onclick="getAccessToken()">accessToken 받기</button>
            `;
            window.open(res.authorizationUrl,'_blank','width:600, height:800');
            btn_getToken.className='invisible';
        }
        ,error : ()=>{
            console.log('실패')
        }
    })
}

function getAccessToken(){
    let code = document.querySelector('#code');
    let redirect_uri = 'urn:ietf:wg:oauth:2.0:oob';
    let grant_type = 'authorization_code';
    $.ajax({
        type : 'POST'
        ,enctype : 'application/x-www-form-urlencoded'
        ,url : 'https://accounts.google.com/o/oauth2/token'
        ,data : {
            clientId : clientId.value,
            clientSecret : clientSecret.value, 
            code : code.value,
            redirect_uri : redirect_uri,
            grant_type : grant_type,
        }
    	,dataType : 'JSON'
        ,success : (res)=>{
            resultDiv.innerHTML = `
            access_token <input id ="access_token"type="text" value="${res.access_token}"><br>
            <button onclick ="getCampaignInfo()">캠페인 가져와보기</button>
            `;
        }
        ,error : ()=>{
            console.log('실패')
            
        }
    })
}

function getCampaignInfo(){
	
	let Authorization = document.querySelector('#access_token'); 
	let dev_token = '2E8tBIOePbzNV9kHxAwbPQ';
	
	$.ajax({
        type : 'GET'
        ,enctype : 'application/x-www-form-urlencoded'
        ,url : 'https://googleads.googleapis.com/v6/customers/3532769670/campaigns/12544803541'
        ,data : {
        	'developer-token' :  dev_token
        }
		,headers : { Authorization : 'Bearer ' + Authorization }
    	,dataType : 'JSON'
        ,success : (res)=>{
        	console.log(res)
        }
        ,error : ()=>{
            alert('실패')
            
        }
    })
	
}