/**
 * 
 */

$(function() {

	$(document).ready(function(){
		$("#scrapModal").click(function(){
			$("#scrapTripModal").modal();
		});
	});
	
	$('#scrapModal').click(function() {
		var mId = $('#mId').val();
		console.log(mId);

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
				var tName = $(tName)

				for(var i = 0; i < myTripList;i++){
					html+='<th:block th:each="l: ${tripList}">'
						html+='<div class="col-12">'
							html+='<div class="sights row">'
								html+='<div class="sightsImg col-12 col-md-2">'
					html+=' <img src="/fileupload/'+listInfo[i] +'" alt="User Avatar" class="img-size-50 mr-3 img-circle">'
					html+=' <div class="media-body">'
						html+='</div>'
							html+='<div class="sightsDesc col-12 col-md-10"><p th:text="${'+ tName +}"></p>'" +
									"" +
									"" +
									"" +
									"
		            html+='<h3 class="dropdown-item-title">'+ listInfo[i]+'</h3>';
					html+= '<p class="text-sm">'+listInfo[i]+'+</p>';
				    html+= '<p class="text-sm text-muted"><i class="far fa-clock mr-1"></i>'+ listInfo[i]+'</p>'
				    html+= '   </div> </div> </div>'	
				    html+= '</th:block>';
				}
				var myTripList = $('#myTripList');
				myTripList.html(html)
					
						
							<img th:src="@{/fileupload/{file}(file=${l.tPphto1})}"
								alt="User Image" width="50" height="50">
						

			
			});

			
			
			request.fail(function(jqXHR, textStatus) {
				alert("Request failed: " + textStatus);
			});
		} else {
			alert('스크랩은 회원만 가능합니다 로그인 해주세욥 ');
			window.location.href = '/member/login';
		}

	});

});