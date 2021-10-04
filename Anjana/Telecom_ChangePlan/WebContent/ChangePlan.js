var plans = '{ "plans": [{ "name": "Plan 1", "price": 1.99, "billing": "Weekly", "rental": "Yes" }, { "name": "Plan 2", "price": 6.99, "billing": "Monthly", "rental": "Yes" }, { "name": "Plan 3", "price": 5.00, "billing": "Monthly", "rental": "No" }, { "name": "Plan 4", "price": 25.00, "billing": "Monthly", "rental": "No" }, { "name": "Plan 5", "price": 15.00, "billing": "Monthly", "rental": "No" }, { "name": "Plan 6", "price": 25.00, "billing": "Bi-Monthly", "rental": "No" } ] }';
var current = '{ "plans": [{ "name": "Plan 1", "price": 5.99, "billing": "Weekly", "upgradable": "Yes", "start_date": "01.01.2021" }, { "name": "Plan 1", "price": 5.99, "billing": "Weekly", "upgradable": "No", "start_date": "01.08.2021" }, { "name": "Plan 4", "price": 5.00, "billing": "Monthly", "upgradable": "Yes", "start_date": "01.04.2021" } ] }';


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
	
	form.insertBefore(cont, document.getElementById("buttons"));
	form.insertBefore(document.createElement("hr"), document.getElementById("buttons"))
}

function addSubscription(plan){
	var div = document.getElementById("left");

	const cont = document.createElement("label");
	const radioOpt = document.createElement("input");
	const spanR = document.createElement("span");
	
	cont.className = "container";

	radioOpt.type = "radio";
	radioOpt.checked = "checked";
	radioOpt.name = "radioLeft";
	radioOpt.value = plan["name"];
	if(plan["upgradable"]=="No"){
		radioOpt.disabled = true;
	}

	cont.innerHTML = '<label class="planName">'+plan["name"]+'</label>'+"</br>Price: "+ plan["price"] + "</br>Upgredable: "+ plan["upgradable"];
	if(plan["upgradable"]=="No"){
		cont.innerHTML = cont.innerHTML + ", created on "+plan["start_date"]; 
	}
	cont.appendChild(radioOpt);
	cont.innerHTML = cont.innerHTML + '<span class="checkmark"></span>';

	div.appendChild(cont);
	div.appendChild(document.createElement("hr"));
	
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

	var currentPlans = JSON.parse(current)["plans"];
	currentPlans.forEach(element => addSubscription(element));

	//Check that at least a radio button is selected and change the button to enabled
	if (document.querySelector('input[name="radio"]')) {
		document.querySelectorAll('input[name="radio"]').forEach((elem) => {
		  elem.addEventListener("change", function(event) {
			  document.querySelector('button').disabled = false;
		  });
		});
	  }
	
});
