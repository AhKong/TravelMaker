/**
 * 
 */

$(function() {
	
	var mId = $('#mId').val();
	var sightsNum = null;
	
	$(document).on('click','#scrapModal',function() {
		$(".modal-backdrop").remove();
		
		sightsNum = $(this).attr('data-sightsNum');
		console.log(sightsNum);
		
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
				    html+= '<p style="text-align: center"><input type="radio" name="myTrip"  data-tNum="'+listInfo[i].tNum+'"id="myTripRadio'+i+'"><label for="myTripRadio'+i+'">'+ listInfo[i].tName+'</label></p>'
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

		$(document).on('click','#scrapBtn',function() {

			console.log(sightsNum)
			
			var radio = $(this).parents('.modal-content').find('input[name="myTrip"]:checked');
			var tNum = radio.attr('data-tNum');	
		
			 var request = $.ajax({
				  url: "/ajax/SightsScrap", 
				  method: "POST",
				  dataType: "text",
				  data: {"mId": "id001",
					  	"sightsNum": sightsNum,
					  	tNum : tNum
					  	}
			  });

			 	request.done(function( data ) {
					alert(data);
					console.log(data);
				});	
			 
				request.fail(function(jqXHR, textStatus) {
					alert("Request failed: " + textStatus);
				});   //값 받아다가 쿼리문에 집어넣고 
			 
			});
	});
	
	
	});
		
		
