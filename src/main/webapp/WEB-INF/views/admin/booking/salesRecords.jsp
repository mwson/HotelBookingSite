<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">예약실적</h1>
		</div>
		<div class="row">
			<div class="col-12 col-lg-6">
				<div class="card flex-fill w-100">
					<div class="card-header">
						<h5 class="card-title">객실타입별 예약실적</h5>
						<h6 class="card-subtitle text-muted">객실타입별 예약실적을 바차트로 보여줍니다.</h6>
					</div>
					<div class="card-body">
						<div class="chart">
							<div id="barchart_div" style="width: 100%"></div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-12 col-lg-6">
				<div class="card">
					<div class="card-header">
						<h5 class="card-title">객실타입별 예약실적</h5>
						<h6 class="card-subtitle text-muted">객실타입별 예약실적을 파이차트로 보여줍니다.</h6>
					</div>
					<div class="card-body text-center">
						<div class="chart">
							<div id="piechart_div"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			type: 'GET',
			header: {
				Accept: "application/json; charset=UTF-8",
				"Content-type": "application/json; charset=UTF-8"
			},
			url: 'sales_record_chart',
			success: function(result) {
				// 최신 버전의 구글 코어차트 패키지 로드
				google.charts.load('current', {'packages':['corechart']});
				
				// 차트API가 로드완료했을 때 실행할 콜백함수 선언
				google.charts.setOnLoadCallback(function() {
					drawChart(result);
				});
			},
			error: function() {
				alert("Chart drawing error!");
			}
		});
	});
	
	function drawChart(result) {
		// 차트 그리는데 사용할 데이터 객체 생성
		var data = new google.visualization.DataTable();
		
		data.addColumn("string", "type");
		data.addColumn("number", "예약건수");
		
		// Controller에서 json타입으로 전달된 데이터를 자바스크립트의 배열로 저장
		var dataArray = [];
		$.each(result, function(i, obj) {
			dataArray.push([obj.type, obj.booking]);
		});
		
		// data객체에 dataArray의 내용을 저장
		data.addRows(dataArray);
		
		// 바 차트 그리기
		var barchart_option = {
			title: '예약별 판매 실적',
			width: '580',
			height: '450',
			legend: {position: 'bottom'}
		};
		
		var barchart = new google.visualization.BarChart(document.getElementById('barchart_div'));
		
		barchart.draw(data, barchart_option);
		
		// 파이 차트 그리기
		var piechart_option = {
			title: '예약별 판매 실적',
			width: '580',
			height: '450',
			legend: {position: 'bottom'}
		};
		
		var piechart = new google.visualization.PieChart(document.getElementById('piechart_div'));
		
		piechart.draw(data, piechart_option);

	}
</script>

<%@include file="../footer.jsp"%>