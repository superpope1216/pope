/**
 * 
 */

$(document).ready(function(){
	
	doGet(basePath+"/login/getStaticData","",function(data){
		var myChart = echarts.init(document.getElementById('brushSelected'));
		var xAxisData=[];
		var data1=[];
		var data2=[];
		var data3=[];
		var _d=data.data;
		for(var i=0;i<_d.length;i++){
			xAxisData.push(toStr(_d[i].dataMonth)+"月");
			data1.push(toStr(_d[i].sr));
			data2.push(toStr(_d[i].wrz));
			data3.push(toStr(_d[i].zc));
		}
		 // 指定图表的配置项和数据
	    var option = {
	        title: {
	            text: '收支统计'
	        },
	        tooltip: {},
	        legend: {
	            data:['收入','未入账','支出'],
	            align:'right',
	            right:10
	        },
	        toolbox:{
	        },
	        xAxis: {
	        	data:xAxisData,
	        	silent:false,
	        	axisLine:{onZero:true},
	        	splitLine:{show:false},
	        	splitArea:{show:false}
	        },
	        yAxis: {
	        	inverse:false,
	        	splitArea:{show:false}
	        },
	        series: [{
	            name: '收入',
	            type: 'bar',
	            stack:'one',
	            data:data1
	        },{
	            name: '未入账',
	            type: 'bar',
	            stack:'one',
	            data:data2
	        },{
	            name: '支出',
	            type: 'bar',
	            stack:'one',
	            data:data3
	        }]
	    };

	    // 使用刚指定的配置项和数据显示图表。
	    myChart.setOption(option);
	});
   
});