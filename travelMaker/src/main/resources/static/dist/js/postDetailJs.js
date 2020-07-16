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