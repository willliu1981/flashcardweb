/**
 * 
 */

function processVersion() {
	$.ajax({
		type: 'post',
		dataType: 'json',
		async:false,
		url: basePath.context + '/v0/' + flashcards + '/version',
		success: function(data) {
			basePath.version=data.version;
			processNav();
		},
		error: function(err) {
			alert('err:' + err);
		}
	});
}