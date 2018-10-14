$(document).ready(function () {

    $("#tableM").click(function () {
        var url = "coin-list";
        $(location).attr("href", url);
    })

    $(".card").click(function () {

        var h = $(this).children();
        var url = h.children()[1].href;
        $(location).attr("href", url);
    })

});


