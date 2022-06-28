//Poner id incrementable para cuando hayan multiples elementos
//Meter todo a un for con un contador y repetir codigo con la cantidad de medicinas en la cuenta y cambiar el id en cada iteracion
var medCard = document.getElementById('medWarnChangeCard');

function changeColorMeds(){
today = new Date(); 
hour = today.getHours(); 
minutes = today.getMinutes(); 
//obtener dato de hora desde la bd y cambiarlo por el int plano de la linea 8
diferencia = 58 - minutes; 
console.log("diferencia: " + diferencia);
if(diferencia<=1 && diferencia>-1){
	console.log("Warning, ya casi es hora")
    medCard.style.backgroundColor = "orange";
}else if(diferencia<=-1){
	console.log("Te pasaste")
    medCard.style.backgroundColor = "red";
}
}

setInterval(changeColorMeds,1000); 
    