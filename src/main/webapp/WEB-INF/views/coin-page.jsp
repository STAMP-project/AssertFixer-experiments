<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<script type="text/javascript">

    var ctx = "${context}";

    window.onload = function () {

        var dataPoints = [];
        var chart = new CanvasJS.Chart("chartContainer", {
            theme: "light2", // "light1", "dark1", "dark2"
            animationEnabled: true,
            exportEnabled: true,
            zoomEnabled: true,
            axisX: {
                valueFormatString: "YYYY"
            },
            axisY: {
                title: "Price (in USD)",
                prefix: "$",
                includeZero: false
            },
            data: [{
                type: "candlestick",
                xValueType: "dateTime",
                xValueFormatString: "MMM YYYY",
                yValueFormatString: "$#,##0.00",
                dataPoints: dataPoints
            }]
        });

        $.getJSON(ctx +"/ajax/coins/${symbol}", parseData);

        function parseData(result) {
            for (var i = 0; i < result.length; i++) {
                dataPoints.push({
                    x: result[i].x,
                    y: result[i].y
                });
            }
            chart.render();
        }

    }
</script>

<br/>
<div class="container-fluid">


    <div class="row">

        <div class="col">

        </div>

        <div class="col-8 ml-5">
            <br/>
            <div class="row">
                <div class="col">
                    <div class="text-center">
                        <img style="height: 5rem" src="${coin.image}"
                             class="img-fluid rounded-circle align-content-lg-center text-center " alt="hoverable">
                    </div>
                    <h5 class="text-center font font-weight-bold">${coin.name} (${coin.symbol})</h5>
                </div>

                <div class="col-lg-2">
                    <h5 class="font-weight-bold text-center">PRICE</h5>
                    <h6 class="text-center font-weight-bold">${coin.price}$</h6>
                </div>

                <div class="col-lg-2">
                    <h5 class="font-weight-bold text-center">CHANGE 1H</h5>

                    <c:choose>
                        <c:when test="${coin.percent_change_1h > 0}">
                            <h6 style="color: green"
                                class="text-center font-weight-bold">${coin.percent_change_1h}%</h6>
                        </c:when>

                        <c:when test="${coin.percent_change_1h < 0}">
                            <h6 style="color: red" class="text-center font-weight-bold">${coin.percent_change_1h}%</h6>
                        </c:when>
                    </c:choose>
                </div>

                <div class="col-lg-2">
                    <h5 class="font-weight-bold text-center">CHANGE 7D</h5>

                    <c:choose>
                        <c:when test="${coin.percent_change_7d > 0}">
                            <h6 style="color: green"
                                class="text-center font-weight-bold">${coin.percent_change_7d}%</h6>
                        </c:when>

                        <c:when test="${coin.percent_change_7d < 0}">
                            <h6 style="color: red" class="text-center font-weight-bold">${coin.percent_change_7d}%</h6>
                        </c:when>
                    </c:choose>
                </div>

                <div class="col-lg-2">
                    <h5 class="font-weight-bold text-center">CHANGE 24H</h5>

                    <c:choose>
                        <c:when test="${coin.percent_change_24h > 0}">
                            <h6 style="color: green"
                                class="text-center font-weight-bold">${coin.percent_change_24h}%</h6>
                        </c:when>

                        <c:when test="${coin.percent_change_24h < 0}">
                            <h6 style="color: red" class="text-center font-weight-bold">${coin.percent_change_24h}%</h6>
                        </c:when>
                    </c:choose>
                </div>


                <div class="col-lg-2">

                </div>

            </div>

            <div class="row">

                <div class="col-lg-2">

                    <br/>

                    <h5 class="font-weight-bold text-center">VOLUME 24</h5>
                    <h6 class="text-center font-weight-bold">${coin.volume_24h}$</h6>

                    <br/>
                    <br/>

                    <h5 class="font-weight-bold text-center">MARKET CAP</h5>
                    <h6 class="text-center font-weight-bold">${coin.market_cap}$</h6>

                    <br/>
                    <br/>

                    <h5 class="font-weight-bold text-center">CIRCULATING SUPPLY</h5>
                    <h6 class="text-center font-weight-bold">${coin.circulating_supply} ${coin.symbol}</h6>


                </div>

                <div class="col-10">
                    <div id="chartContainer" style="height: 370px; width: 100%;"></div>
                </div>

            </div>

        </div>

        <div class="col">

        </div>

    </div>

</div>

<br/>

<br/>
<br/>

<script src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

</body>
</html>


<jsp:include page="template/footer.jsp"/>