/**
 * Ajax 통신과 관련된 라이브러리
 */
var httpRequest = null;

function getXMLHttpRequest() {
	if(window.XMLHttpRequest)
		return new XMLHttpRequest();
	if(window.ActiveXObject) 
		return new ActiveXObject("Microsoft.XMLHTTP");
	return null;
}

/*
 	params
 		"name=홍길동&age=25"			typeof("name=홍길동&age=25")    ==> 'string'
 		{name:'홍길동', age:25}		typeof({name:'홍길동', age:25}) ==> 'object'
 */
function sendProcess(method, url, params, callback) {
	httpRequest = getXMLHttpRequest();
	httpRequest.onreadystatechange = callback;
	
	console.log(params, typeof(params));
	
	var httpMethod = method.toUpperCase();
	if(method != 'GET' && method != 'POST')
		httpMethod = 'GET';
	
	httpParams = '';
	if(typeof(params) == 'object') {
		for(var key in params) {
			if(httpParams)
				httpParams += '&';
			httpParams += key + "=" + encodeURIComponent(params[key]);
		}
	} else if(typeof(params) == 'string') {
		// "name=홍길동&age=25"
		args = params.split('&');
		args.forEach(function(data, index) {
			var key = data.split('=')[0];
			var value = data.split('=')[1];
			httpParams += (index == 0 ? '' : '&') 
							+ key + '=' + encodeURIComponent(value);
			
		});
	}
	console.log(httpParams);
	
	var httpUrl = url;
	if(httpMethod == 'GET')
		httpUrl += '?' + httpParams;
	
	httpRequest.open(httpMethod, httpUrl, true)
	if(httpMethod == 'POST') 
		httpRequest.setRequestHeader(
				'Content-type', 'application/x-www-form-urlencoded');
	httpRequest.send(httpMethod == 'GET' ? null : httpParams);
}

function sendProcess_v1(method, url, params, callback) {
	httpRequest = getXMLHttpRequest();
	httpRequest.onreadystatechange = callback;
	
	console.log(params);
	
	var httpMethod = method.toUpperCase();
	if(method != 'GET' && method != 'POST')
		httpMethod = 'GET';
	
	httpParams = '';
	
	if(params != null && params != '') {
		for(var key in params) {
			if(httpParams)
				httpParams += '&';
			httpParams += key + "=" + encodeURIComponent(params[key]);
		}
	}
	console.log(httpParams);
	
	var httpUrl = url;
	if(httpMethod == 'GET')
		httpUrl += '?' + httpParams;
	
	httpRequest.open(httpMethod, httpUrl, true)
	if(httpMethod == 'POST') 
		httpRequest.setRequestHeader(
				'Content-type', 'application/x-www-form-urlencoded');
	httpRequest.send(httpMethod == 'GET' ? null : httpParams);
}


function sendProcess_v0(method, url, params, callback) {
	httpRequest = getXMLHttpRequest();
	httpRequest.onreadystatechange = callback;
	
	var httpMethod = method.toUpperCase();
	if(method != 'GET' && method != 'POST')
		httpMethod = 'GET';
	
	httpParams = encodeURIComponent(params);
	var httpUrl = url;
	if(httpMethod == 'GET')
		httpUrl += '?' + params;
	
	httpRequest.open(httpMethod, httpUrl, true)
	if(httpMethod == 'POST') 
		httpRequest.setRequestHeader(
				'Content-type', 'application/x-www-form-urlencoded');
	httpRequest.send(httpMethod == 'GET' ? null : params);
}











