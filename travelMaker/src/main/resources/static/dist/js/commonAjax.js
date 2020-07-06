/**
 *  ajax 공통 모듈
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
