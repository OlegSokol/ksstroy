/*
 THIS SCRIPT SHOULD CONTAIN ONLY COMMON FEATURES
 */
function toggleVisibilityFeature() {
    var updateBtns = (function () {
        return document.getElementsByClassName("show_update_forms_btn")
    })()
    var toggleChildrenBtns = (function () {
        return document.getElementsByClassName('dropdown_btn')
    })()

    for (var i = 0; i < updateBtns.length; i++) {
        updateBtns[i].addEventListener("click", function (event) {
            var controllers = event.target.closest(".item").getElementsByClassName('controller')
            for (var z = 0; z < controllers.length; z++) {
                controllers[z].classList.toggle('hidden')
            }
        })
    }

    for (var k = 0; k < toggleChildrenBtns.length; k++) {
        toggleChildrenBtns[k].addEventListener("click", function (event) {
            event.target.closest(".item").nextElementSibling.classList.toggle('hidden')
        })
    }
}

window.onload = toggleVisibilityFeature;

