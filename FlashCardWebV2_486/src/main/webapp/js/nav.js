/**
 * 
 */

function processNav() {
	$(".navbar-header a").attr("href", basePath.context);

	$(".navbar-collapse .modelManager a").attr("href",
		basePath.path()+ "/" + flashcards + "/fcsManager");

	let mm_fc = $(".navbar-collapse ul .dropdown ul .modelManager-flashcard a");
	mm_fc
		.attr("href", basePath.path() + "/" + flashcards + "/fcManager");
	mm_fc.text = "字卡管理";

	$(".navbar-collapse ul .dropdown ul .modelManager-flashcardHolder a")
		.attr("href", basePath.path() + "/" + flashcards + "/fhManager");

	$(".navbar-collapse ul .dropdown ul .modelManager-holderData a")
		.attr("href", basePath.path() + "/" + flashcards + "/hdManager");

	$(".navbar-collapse ul .quizManager a")
		.attr("href", basePath.path() + "/" + quiz + "/quizManager");

	

};


//使發生作用
function doAction(selector) {
	$(selector).addClass("active");
	$(selector + " a").addClass("hrefDisabled");
}