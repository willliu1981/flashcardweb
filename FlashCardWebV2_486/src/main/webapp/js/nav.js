/**
 * 
 */

function processNav() {
	$(".navbar-header a").attr("href", contextPath);

	$(".navbar-collapse .modelManager a").attr("href",
		contextPath + "/" + version + "/" + flashcards + "/fcsManager");

	let mm_fc = $(".navbar-collapse ul .dropdown ul .modelManager-flashcard a");
	mm_fc
		.attr("href", contextPath + "/" + version + "/" + flashcards + "/fcManager");
	mm_fc.text = "字卡管理";

	$(".navbar-collapse ul .dropdown ul .modelManager-flashcardHolder a")
		.attr("href", contextPath + "/" + version + "/" + flashcards + "/fhManager");

	$(".navbar-collapse ul .dropdown ul .modelManager-holderData a")
		.attr("href", contextPath + "/" + version + "/" + flashcards + "/hdManager");

	$(".navbar-collapse ul .quizManager a")
		.attr("href", contextPath + "/" + version + "/" + quiz + "/quizManager");

	

};


//使發生作用
function doAction(selector) {
	$(selector).addClass("active");
	$(selector + " a").addClass("hrefDisabled");
}