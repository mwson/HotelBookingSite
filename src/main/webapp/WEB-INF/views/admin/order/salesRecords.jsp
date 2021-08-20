<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<div align="center">
	<h1>제품 판매 실적</h1>
	<table>
		<tr>
			<td><div id="piechart_div" style="border: 1px solid #ccc;"></div></td>
			<td><div id="barchart_div" style="border: 1px solid #ccc;"></div></td>
		</tr>
	</table>
</div>

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
		
		data.addColumn("string", "pname");
		data.addColumn("number", "quantity");
		
		// Controller에서 json타입으로 전달된 데이터를 자바스크립트의 배열로 저장
		var dataArray = [];
		$.each(result, function(i, obj) {
			dataArray.push([obj.pname, obj.quantity]);
		});
		
		// data객체에 dataArray의 내용을 저장
		data.addRows(dataArray);
		
		// 파이 차트 그리기
		var piechart_option = {
			title: '제품별 판매 실적',
			width: 350,
			height: 300,
			legend: {position: 'bottom'}
		};
		
		var piechart = new google.visualization.PieChart(document.getElementById('piechart_div'));
		
		piechart.draw(data, piechart_option);
		
		// 바 차트 그리기
		var barchart_option = {
			title: '제품별 판매 실적',
			width: 350,
			height: 300,
			legend: {position: 'bottom'}
		};
		
		var barchart = new google.visualization.BarChart(document.getElementById('barchart_div'));
		
		barchart.draw(data, barchart_option);
	}
</script>

<%@include file="../footer.jsp"%>