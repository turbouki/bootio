<%--
  Created by IntelliJ IDEA.
  User: liya
  Date: 2022/12/24
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<figure class="highcharts-figure">
    <div id="container"></div>
    <p class="highcharts-description">
        Chart showing data loaded dynamically. The individual data points can
        be clicked to display more information.
    </p>
</figure>
</body>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<script>
    // https://www.highcharts.com/docs/working-with-data/live-data
    //https://ko.javascript.info/onload-ondomcontentloaded
    //https://developer.mozilla.org/en-US/docs/Web/API/Window/DOMContentLoaded_event
    document.addEventListener('DOMContentLoaded', function () {
        var options = {
            chart: {
                type: 'line'
            },
            title: {
                text: 'Monthly Average Temperature'
            },
            subtitle: {
                text: 'Source: ' +
                    '<a href="https://en.wikipedia.org/wiki/List_of_cities_by_average_temperature" ' +
                    'target="_blank">Wikipedia.com</a>'
            },
            xAxis: {
                categories: [],
                title: {
                    text: 'Number of Year'
                }
            },
            yAxis: {
                title: {
                    text: 'Temperature (°C)'
                }
            },
            plotOptions: {
                line: {
                    dataLabels: {
                        enabled: true
                    },
                    enableMouseTracking: false
                }
            },
            series: [{
                name: '남자',
                data: []
            }, {
                name: '여자',
                data: []
            }]
        };
        Highcharts.ajax({
            url: "<c:url value='/data/sales.json'/>",
            dataType: "json",
            success: function(data) {
                options.xAxis.categories = data.map(function(o) {return o.salesYear});
                options.series[0].data = data.map(function(o) {return o.menSales});
                options.series[1].data = data.map(function(o) {return o.womenSales});
                Highcharts.chart('container', options);
            }
        });
    });
</script>

</html>
