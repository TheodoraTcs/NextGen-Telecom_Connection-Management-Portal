function showMessage(event) {
	console.log("hello");
  	alert("Your plan has been changed.");
}

function ready(callback){
    // in case the document is already rendered
    if (document.readyState!='loading') callback();
    // modern browsers
    else if (document.addEventListener) document.addEventListener('DOMContentLoaded', callback);
    // IE <= 8
    else document.attachEvent('onreadystatechange', function(){
        if (document.readyState=='complete') callback();
    });
}

ready(function(){
    const form = document.getElementById('form_ChangePlan');
	form.addEventListener('submit', showMessage);
});
