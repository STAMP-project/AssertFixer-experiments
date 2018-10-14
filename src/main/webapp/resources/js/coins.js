$(document).ready(function () {

    // getCoins();


})

function getCoins() {
    $.ajax({
        url: '/ajax/coins',
        dataType: 'json',
        type: 'get',
        cache: true,
        success: function (data) {
            var summary = " ";
            data.forEach(function (element, index) {
                var name = element.name;
                var symbol = element.symbol;
                var price = element.price;
                var change = element.percent_change_24h;

                $("#" + symbol).text(symbol + "  " + price.toFixed(2) + '$' + " " + change + '%');

                if (change > 0) {
                    $("#" + symbol).css('color', 'lime');
                }
                else {
                    $("#" + symbol).css('color', 'red');
                }
            })
            var dataJSON = JSON.stringify([1, 'false', false]);
        }
    });
}


function getPrice() {
    $.ajax({
        type: "POST",
        url: "/ajax/price",
        success: function (data) {
            $(".h1").text(data.price);
        }
    });
}

