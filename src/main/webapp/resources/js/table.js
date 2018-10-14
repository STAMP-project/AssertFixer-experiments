$(document).ready(function () {
    modal();
})

function modal() {
    //coins redirect
    $("#topCoins,#looseCoins,.coin").click(function () {
        window.location.href = "coin-list";
    })

    $("#topCoins,#looseCoins,.coin, .team,.icoStats").mouseenter(function () {
        $(this).css('cursor', 'pointer');
    })


    $(".card").mouseenter(function () {
        $(this).css('cursor', 'pointer');
        var title = $(this).find(".title").text();
        var description = $(this).find(".description").text();
        var date = $(this).find(".date").text();

        var th = $(this);

        $(this).append("<div class=\"card-img-overlay   animated zoomin faster\">\n" +
            "                    <p class=\"card-text text-white brown darken-2\"> " + description + " </p>\n" +
            "                </div>")


    })

    $(".card").mouseleave(function () {
        $(this).find(".card-img-overlay").removeClass("animated zoomin").removeClass("animated shake").addClass("animated zoomout");
    })


    //
    $(".card").dblclick(function () {
        var href = $(this).find(".href").text();
        $(location).attr("href", href);
    })

    $("button").click(function () {
        var href = $(this).attr("value");
        if (href != null)
            window.location = href;

    })



}