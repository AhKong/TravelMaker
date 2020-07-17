/**
 * 음식점/관광명소 상세페이지 공통 함수  
 */

var goLogin = function(){
	alert('로그인 후 이용가능한 서비스 입니다.')
	window.location.href = '/member/login';
}

var reveiwChart = function(gradeArr){
	var donutChartCanvas = $('#donutChart').get(0).getContext('2d')
	var donutData = {
		labels : [ ],
		datasets : [ {
			data : [],
			backgroundColor : [ '#f56954', '#00a65a', '#f39c12',
					'#00c0ef', '#3c8dbc' ],
		} ]
	}
	for(var i = 0 ; i< gradeArr.length;i++){
		donutData.labels.push(gradeArr[i].grade+'점');
		donutData.datasets[0].data.push(gradeArr[i].gradeCnt)
	}
	var donutOptions = {
		maintainAspectRatio : false,
		responsive : true,
	}
	
	//Create pie or douhnut chart
	// You can switch between pie and douhnut using the method below.
	var donutChart = new Chart(donutChartCanvas, {
		type : 'doughnut',
		data : donutData,
		options : donutOptions
	})
	
}

var showReveiwModal = function(mId,isWrited,Obj){
	$('#reveiwBtn').click(function(){
		if(mId == null ){
			goLogin();
			return false;
		} else{
			if(isWrited == '1'){
				alert('리뷰는 한번만 작성 가능합니다 !');
			} else {
				Obj.modal();	
			}
		}
	})
}

var showCommentsList = function(commentsList,reviewWirter,mId){
	var html ='';
	 for(var i =0; i<commentsList.length;i++){
		 html +='<div class="card-comment">';
		 html+='<img src="/fileupload/'+commentsList[i].member.mAvatar +'" alt="User Avatar" class="img-size-50 mr-3 img-circle">'
		 html +='<div class="comment-text">';
		 html += '<span class="username">'+commentsList[i].member.mId;
		 if(reviewWirter ==commentsList[i].member.mId ){
			 html += '<span style="font-size:12px;color:#ff5050"> (리뷰 작성자)</span>';
		 }
		 html += '<span class="text-muted float-right">'+commentsList[i].commentsRegDate+'</span>';
		 html += ' </span><!-- /.username -->';
		 if(commentsList[i].member.mId == mId){
			 html += '<a class="text-muted float-right deleteComments" commentsNum ="'+commentsList[i].commentsNum+'">삭제</a>';
		 }
	
		 html += commentsList[i].commentsContents+'</div></div>'	 	 
	 }
	 
	 return html;

}

var showComments = function(obj,mId,url){
		var comments = obj.parents().siblings('.comments-warp');
		var reviewNum =obj.attr('reviewNum');
		var commentList = comments.children('.card-comments');
		var reviewWirter = obj.attr('reviewWriter');

		if(obj.attr('toggle') =='show'){
			comments.css('display','block');
			obj.attr('toggle','hidden');
		
			commonAjax('/ajax/'+url,
					{"reviewNum" :reviewNum},
					function(data){
						console.log(commentList.html());
						var commentsList = data.commentsList;
						var html ='';
						if(commentsList.length >0){
							 html += showCommentsList(commentsList,reviewWirter,mId);
						} else {
							html ='<p> 아직 댓글이 없습니다 첫 댓글을 남겨주세요!</p>'
						}
						 
						commentList.html(html)	
					},'Get'); 
			
		} else {
			comments.css('display','none');
			obj.attr('toggle','show');
		}

}

var addComments = function(obj,mId,url,key){
	var input = obj;
	var reviewNum = obj.attr('reviewNum');
	var reviewWirter = obj.attr('reviewWriter');

	if(key.keyCode == 13){
		 if(mId == null || mId == undefined || mId ==''){
			 goLogin();
		}
		if(input.val() ==''){
			alert('댓글을 입력하세요!');
			input.focus();
			return false;
		} 
		commonAjax('/ajax/'+url,
				{"member.mId" :mId, "reviewNum" :reviewNum,"commentsContents":input.val(),"reviewWirter":reviewWirter},
				function(data){
					var commentsList = data.commentsList;
					var html = showCommentsList(commentsList,reviewWirter,mId);
					input.val('');
					input.parents().siblings('.card-footer').html(html)
					
				},'Get'); 
	}
	
}

var deleteComments = function(obj,url){
 	var commentsNum = obj.attr('commentsNum');
 	var deleteComment = obj;
 	var isDeleted = confirm('진짜 삭제하시겠어요?');
 	if(isDeleted==true){
 		commonAjax('/ajax/'+url,
				{"commentsNum":commentsNum},
				function(data){
					deleteComment.parents('.card-comment').remove();			
				},'Get'); 
 		
 	}
}
