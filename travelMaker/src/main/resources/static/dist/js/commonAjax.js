/**
 *  ajax 공통 모듈
 *  - 공통 모듈이라고 해서 코드가 짧아지진 않음 단지 유지보수를 한 곳에서 할 수 있다는 장점이 있음!! 
 */

var commonAjax = function(url, data, fn, methodType ){
	
	if(methodType == undefined){
		methodType = 'POST';
	}
	var request = $.ajax({
		  url: url,  
		  method: methodType,
		  data: data, 
		  dataType: "json"
	}); 	     

	request.done(fn);	

	request.fail(function( jqXHR, textStatus ) {
		  alert( "Request failed: " + textStatus );
	});
}
