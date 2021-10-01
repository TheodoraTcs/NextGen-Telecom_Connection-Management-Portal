var form = document.getElementById('form_ChangePlan');
form.addEventListener('submit', showMessage);

function showMessage(event) {
  	alert("Your plan has been changed.");
  	event.preventDefault();
}
