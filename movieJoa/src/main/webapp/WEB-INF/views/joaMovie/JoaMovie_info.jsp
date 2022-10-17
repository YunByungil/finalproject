<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
  google.charts.load("current", {packages:["corechart"]});
  google.charts.setOnLoadCallback(drawChart);
  google.charts.setOnLoadCallback(drawChart2);
  function drawChart() {
    var data = google.visualization.arrayToDataTable([
      ['Task', 'Hours per Day'],
      ['남',     60.7],
      ['녀',      39.3]
    ]);

    var options = {
      title: '성별 예매 분포',
      pieHole: 0.4,
      pieSliceTextStyle: {
      	color: 'black',
      }
    };

    var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
    chart.draw(data, options);
  }
  function drawChart2() {
      var data = google.visualization.arrayToDataTable([
        ['Year', 'Visitations', { role: 'style' } ],
        ['10대', 1.6, ''],
        ['20대', 16.1, ''],
        ['30대', 29.1, ''],
        ['40대', 30.6, ''],
        ['50대', 22.6, '']
      ]);
      
      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "연령별 예매 분포",
        width: 525,
        height: 265,
        bar: {groupWidth: "61.8%"},
        legend: { position: "none" },
      };
      var chart2 = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart2.draw(view, options);
  }
</script>
<c:forEach var="list" items="${list }">
	<b>${list.mov_info }</b>
</c:forEach>
<hr>
<div id="chart">
	<ul>
		<li><div id="donutchart" style="width: 530px; height: 265px;"></div></li>
		<li><div id="columnchart_values" style="width: 530px; height: 265px;"></div></li>
	</ul>
</div>
<hr style="clear:both;">