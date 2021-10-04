var formBtn = document.querySelector('#formBtn');

var input = document.querySelector('#input');
var inputValue =0;

var customer1 = document.querySelector('.customer1');
var customer2 = document.querySelector('.customer2');
var customer3 = document.querySelector('.customer3');
var customer4 = document.querySelector('.customer4');
var customer5 = document.querySelector('.customer5');
var customer6 = document.querySelector('.customer6');

// save the input Id
input.addEventListener('change', function(){
    inputValue = input.value;
});

formBtn.addEventListener('click', function(e){
    e.preventDefault();

    console.log(inputValue);
    if(inputValue==1){
        customer1.style.display = "flex";
        customer2.style.display = "none";
        customer3.style.display = "none";
        customer4.style.display = "none";
        customer5.style.display = "none";
        customer6.style.display = "none";
    }
    else if(inputValue==2){
        customer1.style.display = "none";
        customer2.style.display = "flex";
        customer3.style.display = "none";
        customer4.style.display = "none";
        customer5.style.display = "none";
        customer6.style.display = "none";
    }
    else if(inputValue==3){
        customer1.style.display = "none";
        customer2.style.display = "none";
        customer3.style.display = "flex";
        customer4.style.display = "none";
        customer5.style.display = "none";
        customer6.style.display = "none";
    }
    else if(inputValue==4){
        customer1.style.display = "none";
        customer2.style.display = "none";
        customer3.style.display = "none";
        customer4.style.display = "flex";
        customer5.style.display = "none";
        customer6.style.display = "none";
    }
    else if(inputValue==5){
        customer1.style.display = "none";
        customer2.style.display = "none";
        customer3.style.display = "none";
        customer4.style.display = "none";
        customer5.style.display = "flex";
        customer6.style.display = "none";
    }
    else if(inputValue==6){
        customer1.style.display = "none";
        customer2.style.display = "none";
        customer3.style.display = "none";
        customer4.style.display = "none";
        customer5.style.display = "none";
        customer6.style.display = "flex";
    }
    else{
        customer1.style.display = "flex";
        customer2.style.display = "flex";
        customer3.style.display = "flex";
        customer4.style.display = "flex";
        customer5.style.display = "flex";
        customer6.style.display = "flex";
    }
    
});