function SomeDeleteRowFunction(o) {

    var row = o.parentNode.parentNode;
    var date = new Date(row.cells[2].innerHTML);
    var currentDate = new Date();
    currentDate.setMonth(currentDate.getMonth() - 3);
    console.log(currentDate);

    if(date < currentDate){
        var p=o.parentNode.parentNode;
        p.parentNode.removeChild(p);
    } else {
        alert("Your subscription started less than 3 months ago. You can only cancel your subscription after 3 months");
    }
   }