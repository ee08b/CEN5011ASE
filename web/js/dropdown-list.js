	$(document).ready(function() {
		/*--	JS for sub drop down list	--*/
	    $(".sub-dropdown img.flag").addClass("flagvisibility");

	    $(".sub-dropdown dt a").click(function() {
		$(".sub-dropdown dd ul").toggle();
	    });
			
	    $(".sub-dropdown dd ul li a").click(function() {
		var text = $(this).html();
		$(".sub-dropdown dt a span").html(text);
		$(".sub-dropdown dd ul").hide();
		$("#subTopicResult").html("Selected value is: " + getSelectedValue("subTopic"));
	    });
			
	    function getSelectedValue(id) {
		return $("#" + id).find("dt a span.value").html();
	    }

	    $(document).bind('click', function(e) {
		var $clicked = $(e.target);
		if (! $clicked.parents().hasClass("sub-dropdown"))
		    $(".sub-dropdown dd ul").hide();
	    });

	    $("#flagSwitcher").click(function() {
		$(".sub-dropdown img.flag").toggleClass("flagvisibility");
	    });


		/*--	JS for pub drop down list	--*/

		$(".pub-dropdown img.flag").addClass("flagvisibility");

	    $(".pub-dropdown dt a").click(function() {
		$(".pub-dropdown dd ul").toggle();
	    });
			
	    $(".pub-dropdown dd ul li a").click(function() {
		var text = $(this).html();
		$(".pub-dropdown dt a span").html(text);
		$(".pub-dropdown dd ul").hide();
		$("#pubTopicResult").html("Selected value is: " + getSelectedValue("pubTopic"));
	    });
			
	    function getSelectedValue(id) {
		return $("#" + id).find("dt a span.value").html();
	    }

	    $(document).bind('click', function(e) {
		var $clicked = $(e.target);
		if (! $clicked.parents().hasClass("pub-dropdown"))
		    $(".pub-dropdown dd ul").hide();
	    });

	    $("#flagSwitcher").click(function() {
		$(".pub-dropdown img.flag").toggleClass("flagvisibility");
	    });
	});