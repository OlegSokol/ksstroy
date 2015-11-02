$(document).ready(
		function() {

			// FOR TEST PURPOSES ONLY
			$(".expanded").toggle();
			$(".constructor").toggle();

			$("input").prop('disabled', true);

			// show expande icon if zoneGroup contain zones
			// and hide subGroups
			$.each($(".zoneGroups_basicView"), function(index, value) {
				if ($(this).closest("li").siblings("ul").first().hasClass(
						"subGroups")) {
					$(this).find(".clickableIcon").toggle();
					$(this).closest("li").nextAll("ul").first().toggle();
				}
			})

			// show expande icon if zone contain additional and surplus zones
			// and hide subGroups
			$.each($(".zones_basicView"), function(index, value) {
				if ($(this).closest("li").siblings("ul").first().hasClass(
						"subZones")) {
					$(this).find(".clickableIcon").toggle();
					$(this).closest("li").nextAll("ul").first().toggle();
				}
			})

			// ONCLICK HANDLERS AND ETC.
			// hide sub groups or zones on click
			$(".clickableIcon").click(function(event) {
				$(event.target).closest("li").nextAll("ul").first().toggle();
			});

			// show details on double click
			$(".zoneGroups_basicView,.zones_basicView").dblclick(
					function(event) {
						$(event.target).closest("li").nextAll(".expanded")
								.first().toggle();
					});

			// toggle redactor mode on click
			$(".redactor_btn").click(function(event) {
				$(event.target).toggleClass("redactor_btn_clicked");
				if ($("input").prop('disabled')) {
					$("input").prop('disabled', false);
				} else {
					$("input").prop('disabled', true);
				}
				$(".add_delete_wrapper").toggleClass("hide");
			});
			// show constructor on click
			$(".add_kostul").click(
					function(event) {
						$(event.target).closest("li").nextUntil(".expanded",
								".constructor").toggle();
					});
		});