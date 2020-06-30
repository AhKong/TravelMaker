/**
 * 
 */


$(function(){
	 $('#scrapIcon').click(function(){
		 var mId = $('#mId').val();
		 var sightsNum = $('#sightsNum').attr('data-sightsNum');

		 console.log(mId);
		 console.log(sightsNum);
		 if(mId !='' || mId == undefined){
			 var sights ='sights_1';
			 var request = $.ajax({
				  url: "/ajax/SightsScrap", 
				  method: "POST",
				  dataType: "text",
				  data: {mId: mId,
					  sightsNum: sightsNum  
				  	} 
			});
			 
			 request.done(function( data ) {
				alert(data);
				
			});	

			request.fail(function( jqXHR, textStatus ) {
				  alert( "Request failed: " + textStatus );
			});		 
		 } else {
			 alert('스크랩은 회원만 가능합니다 로그인 해주세욥 ');
			window.location.href = '/member/login';
		 }
		
	 
	});
})


