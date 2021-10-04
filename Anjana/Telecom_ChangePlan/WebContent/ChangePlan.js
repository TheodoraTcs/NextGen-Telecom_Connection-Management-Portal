var plans = '{ "plans": [{ "name": "Plan 1", "price": 1.99, "billing": "Weekly", "rental": "Yes" }, { "name": "Plan 2", "price": 6.99, "billing": "Monthly", "rental": "Yes" }, { "name": "Plan 3", "price": 5.00, "billing": "Monthly", "rental": "No" }, { "name": "Plan 4", "price": 25.00, "billing": "Monthly", "rental": "No" }, { "name": "Plan 5", "price": 15.00, "billing": "Monthly", "rental": "No" }, { "name": "Plan 6", "price": 25.00, "billing": "Bi-Monthly", "rental": "No" } ] }';

function showMessage(event) {
	console.log("hello");
  	alert("Your plan has been changed to " + document.querySelector('input[name="radio"]:checked').value);

}

function addRadioOption(plan){
	var form = document.getElementById('form_ChangePlan');
	
	const cont = document.createElement("label");
	const radioOpt = document.createElement("input");
	const spanR = document.createElement("span");
	
	cont.className = "container";

	radioOpt.type = "radio";
	radioOpt.checked = "checked";
	radioOpt.name = "radio";
	radioOpt.value = plan["name"];

	cont.innerHTML = '<label class="planName">'+plan["name"]+'</label>'+"</br>Price: "+ plan["price"] + "</br>Rent: "+ plan["rental"];

	cont.appendChild(radioOpt);
	cont.innerHTML = cont.innerHTML + '<span class="checkmark"></span>';
	
	form.insertBefore(cont, document.getElementById("submit"));
	form.insertBefore(document.createElement("hr"), document.getElementById("submit"))
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
	var form = document.getElementById('form_ChangePlan');
	form.addEventListener('submit', showMessage);
	
	var res = JSON.parse(plans)["plans"];
	res.forEach(element => addRadioOption(element));


	//Check that at least a radio button is selected and change the button to enabled
	if (document.querySelector('input[name="radio"]')) {
		document.querySelectorAll('input[name="radio"]').forEach((elem) => {
		  elem.addEventListener("change", function(event) {
			  document.querySelector('button').disabled = false;
		  });
		});
	  }
	
});
