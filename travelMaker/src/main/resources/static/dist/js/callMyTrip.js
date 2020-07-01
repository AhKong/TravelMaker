/**
 * 
 */

$(function() {
	
	var mId = $('#mId').val();
	
	$(document).on('click','#scrapModal',function() {
		$(".modal-backdrop").remove();
		
		var sightsNum = $(this).val();
		console.log(mId, sightsNum);
		
		if (mId != '' || mId == undefined) {
			var request = $.ajax({
				url : "/ajax/scrapModal",
				method : "POST",
				dataType : "json",
				data : {"mId" : mId}
			});

			request.done(function(data) {
				alert(JSON.stringify(data));
				console.log(data.result);
				var html ='';
				var myTripList = data.result.length
				var listInfo = data.result;
				
				for(var i = 0; i < myTripList;i++){				
					html+='<div class="col-12">'
					html+='<div class="sights row">'
					html+='<div class="sightsImg col-12 col-md-2">'
					html+=' <img src="/fileupload/'+ listInfo[i].tPhoto +'"width="80" height="80">'
					html+='</div>'
						html+='<div class="col-12 col-md-10">'
				    html+= '<p style="text-align: center"><input type="radio" name="myTrip" data-tPhoto="'+listInfo[i].tPhoto+'" data-tNum="'+listInfo[i].tNum+'" data-sightsNum="'+listInfo[i].sightsNum+'" id="myTripRadio'+i+'"><label for="myTripRadio'+i+'">'+ listInfo[i].tName+'</label></p>'
				    html+= '</div> </div>'	
				}
				
				
				console.log(html)
				var myTripList = $('#myTripList');
				myTripList.html(html);
				$("#scrapTripModal").modal();
					
			});
			
			request.fail(function(jqXHR, textStatus) {
				alert("Request failed: " + textStatus);
			});
		} else {
			alert('스크랩은 회원만 가능합니다 로그인 해주세욥 ');
			window.location.href = '/member/login';
		}

		
	});
	
	$(document).on('click','#scrapBtn',function() {

		
		var radio = $(this).parents('.modal-content').find('input[name="myTrip"]:checked');
		var sightsNumRadio = radio.val();	
		var tNum = radio.attr('data-tNum');	
		var sightsNum = radio.attr('data-sightsNum');
		var tPhoto = radio.attr('data-tPhoto');
		console.log(tNum,sightsNum,tPhoto);
		
		 /*var request = $.ajax({
			  url: "/ajax/SightsScrap", 
			  method: "POST",
			  dataType: "text",
			  data: {"mId": mId,
				  	sightsNum: sightsNum,
				  	tNum : tNum
				  	tPhoto : tPhoto
				  	}
		  });

		 	request.done(function( data ) {
				alert(data);
				console.log(data);
			});	
		 
			request.fail(function(jqXHR, textStatus) {
				alert("Request failed: " + textStatus);
			});   값 받아다가 쿼리문에 집어넣고 
		 */
		});
	});
		
		
