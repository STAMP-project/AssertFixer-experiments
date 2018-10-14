

$(document).ready(function () {

    validate();
})

function validate() {

    $('.form').validate({
        rules: {
            firstname: {
                minlength: 3,
                maxlength: 15,
                required: true
            }

        }

    });

}