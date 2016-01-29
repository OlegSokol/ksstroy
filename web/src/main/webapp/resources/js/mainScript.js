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
    $(".purchase_material").click(function () {
        $(this).closest(".purchase").children(".controller").toggleClass("hidden");
    })

    $('#show-hide-works').click(function() {
       if($(this).is(':checked')){
           $('.work-group').toggleClass("hidden");}
        else{
           $('.work-group').toggleClass("hidden");
       }

    })


var url=$(location).attr('href')
    var shortURL=url.substr(url.lastIndexOf('/') + 1)



   $(".menu_item").each(function(){
        var a_href = $(this).attr('href');
        var shortHref= a_href.substr(a_href.lastIndexOf('/') + 1);
if(shortHref==shortURL){
    $(this).addClass('active_menu_item')
}
    });
});