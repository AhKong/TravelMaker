/**
 * 
 */
		
	var scrap = function(mId){
	
	$(document).on('click','#scrapModal',function() {
		$(".modal-backdrop").remove();
		
		sightsNum = $(this).attr('data-sightsNum');
		if(mId != undefined || mId != null) {
			var request = $.ajax({
				url : "/ajax/scrapModal",
				method : "POST",
				dataType : "json",
				data : {"mId" : mId}
			});

			request.done(function(data) {
				console.log(data.result);
				var html ='';
				var myTripList = data.result.length
				var listInfo = data.result;
				var i = 0;
				for(i = 0; i < myTripList;i++){				
					html+='<div class="col-12">'
					html+='<div class="sights row">'
					html+='<div class="sightsImg col-12 col-md-2">'
					html+=' <img src="/fileupload/'+ listInfo[i].tPhoto +'"width="80" height="80">'
					html+='</div>'
						html+='<div class="col-12 col-md-10">'
				    html+= '<p style="text-align: center"><input type="radio" name="myTrip" data-tPhoto="'+listInfo[i].tPhoto+'" data-tNum="'+listInfo[i].tNum+'" data-sightsNum="'+listInfo[i].sightsNum+'" id="myTripRadio'+i+'"><label for="myTripRadio'+i+'">'+ listInfo[i].tName+'</label></p>'
				    html+= '</div> </div>'
				}

				html+= '<div onclick="location.href='+'/myTrip/editTrip'+'"> <span class="glyphicon glyphicon-search" aria-hidden="true"></span><a><strong><i class="fas fa-plus"></i> 내여행 만들기</strong></a></div>'
			
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
			var indexNum= $('#scrapModal').attr('data-indexnum');
			console.log(indexNum+'<-----');
			/*var dIcon = $('.scrapDeleteIcon').index();
			var sIcon = $('.scrapSelectIcon').index();
			*/
			
			//var indexD = $('.scrapDeleteIcon').index(this);
			   $('.scrapDeleteIcon').eq(indexNum);
			   
			//var indexS = $('.scrapSelectIcon').index(this);
			   $('.scrapSelectIcon').eq(indexNum);
			   
			  var j = $("#scrapModal").index(this); 
			  console.log(j);
			  console.log($('#scrapModal').eq(1))
			  alert($('#scrapModal').index(this));

		   
			
			if($('.scrapInsertIcon4').css('display') != 'none'){
				$('.scrapInsertIcon4').hide();
				$('.scrapDeleteIcon4').show();
			}else if($('.scrapDeleteIcon4').css('display') != 'none'){
				$('.scrapInsertIcon4').show();
				$('.scrapDeleteIcon4').hide();
			}
			
			
			
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
					//alert(data);
					//console.log(data);
				});	
			 
				request.fail(function(jqXHR, textStatus) {
					alert("Request failed: " + textStatus);
				}); 
				
		});
		
	});
	}
	
