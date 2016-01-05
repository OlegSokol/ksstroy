/*
 THIS SCRIPT SHOULD CONTAIN ONLY COMMON FEATURES
 */
$(document).ready(function () {
    $(".show_update_forms_btn").click(function () {
        $(this).closest(".item").children(".controller").toggleClass("hidden");
    })
    $(".dropdown_btn").click(function () {
        $(this).closest(".item").next("ul").toggleClass("hidden");
    })

});

