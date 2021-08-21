<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="orders.model.vo.SalesList, java.util.ArrayList, java.util.List, java.util.Date, java.text.SimpleDateFormat"%>
<%
ArrayList<SalesList> orderlist = (ArrayList<SalesList>) request.getAttribute("olist");
int sortno = (Integer)request.getAttribute("sortno");

int endIndex = orderlist.size() - 1;
ArrayList<String> xs = new ArrayList<String>();
/* ArrayList<Date> xs = new ArrayList<Date>(); */
ArrayList<Double> ys = new ArrayList<Double>();
/* SimpleDateFormat formats = null;
if(sortno==1){
	formats = new SimpleDateFormat("yyyy-MM-dd");
}else if(sortno==7){
	formats = new SimpleDateFormat("yyyy-MM-W");
}else{
	formats = new SimpleDateFormat("yyyy-MM");
} */

for(int i=0; i<endIndex; i++){
	/* xs.add(format.parse(orderlist.get(i).getDate())); */
	xs.add(orderlist.get(i).getDate());
	/* Date date = formats.parse(orderlist.get(i).getDate());
	xs.add(date); */
	ys.add(orderlist.get(i).getPrice());
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Graph</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/moment@2.24.0"></script>
</head>
<body>
	<canvas id="myChart"></canvas>
</body>
<script>
  // === include 'setup' then 'config' above ===
	const labels = <%= xs %>;
	const data = {
	  labels: labels,
	  datasets: [{
	    label: '판매 기록',
	    borderColor: 'rgb(255, 99, 132)',
	    data: <%= ys %>
	  }]
	};
	  
	const config = {
			  type: 'line',
			  data: data,
			  options: {
			    responsive: true,
			    plugins: {
			      legend: {
			        display: false,
			      },
			      title: {
			        display: true,
			        text: '가격선'
			      }
			    },
			    scales:{
			    	xAxes: [{
				    	display: false
				    }],
				    yAxes: [{
				    	ticks:{
				    		beginAtZero: true
				    	}
				    }]
			    },
			    layout: {
		            padding: 5
		        }
			  }
			};
	
	var myChart = new Chart(
	  document.getElementById('myChart'),
	  config
	);
</script>
</html>