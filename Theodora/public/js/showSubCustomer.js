// Variable Initialization
let body = document.body;

let link = body.querySelector('#link');
let titlePage = body.querySelector('h1');
let bigDivContent = body.querySelector('.bigDivContent');

let bigDivManager;
let searchBox;

link.addEventListener('click', function(){
        // to check
    //body.style.backgroundColor= "red";

    bigDivContent.style.display = "none";

    // Adapting Titles for Manager page
    link.textContent = "You are connected as Relationship Manager";
    titlePage.textContent = "Find subscriptions";
    
    // Creating an other big div for Manager
    bigDivManager = document.createElement('div');
    body.appendChild(bigDivManager);


    bigDivManager.style.border= "solid 1px black";
    bigDivManager.style.margin= "2% 5%";

    // Adding search box
    searchBox = document.createElement('div');

    
}); 

// link.addEventListener('click', function(){
//     bigDivContent.style.display = "block";
//     bigDivManager.style.display = "none";

//     // Adapting Titles for Cutomer page
//     link.textContent = "You are connected to your profile";
//     titlePage.textContent = "My subscription";
// });