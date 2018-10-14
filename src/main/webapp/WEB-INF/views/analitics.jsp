<jsp:include page="template/header.jsp"/>

<script>
    window.onload = function () {
        var chart = new CanvasJS.Chart("chartContainer1", {
            animationEnabled: true,
            title: {
                text: "Market data"
            },
            data: [{
                type: "pie",
                startAngle: 240,
                yValueFormatString: "##0.00\"%\"",
                indexLabel: "{label} {y}",
                dataPoints: [
                    {y: 55, label: "Bitcoin"},
                    {y: 45, label: "AltCoin"}
                ]
            }]
        });
        chart.render();
    }

</script>


<div class="container">
    <div id="chartContainer1" style="height: 650px; width: 100%;"></div>

</div>


<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

<jsp:include page="template/footer.jsp"/>

