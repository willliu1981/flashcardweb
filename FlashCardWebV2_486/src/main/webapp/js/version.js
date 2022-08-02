/**
 * 
 */

function processVersion() {
	$.ajax({
		type: 'post',
		dataType: 'json',
		url: contextPath + '/v0/' + flashcards + '/version',
		success: function(data) {
			version = data.version;
			processNav();
		},
		error: function(err) {
			alert('err:' + err);
		}
	});
}