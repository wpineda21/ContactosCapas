function getTime() {
    today=new Date(); 
    hour=today.getHours(); 
    minutes=today.getMinutes(); 
    seconds=today.getSeconds(); 
    if (hour<10) { 
        hour="0"+hour;
        }
    if (minutes<10) { 
        minutes="0"+minutes;
        }
    if (seconds<10) {
        seconds="0"+seconds;
        }
    time = hour+" : "+minutes+" : "+seconds;	
    return time; 
    }

    function updateTime() { 
   irlTime=getTime(); 
   time=document.getElementById("irlTime");
   time.innerHTML=irlTime; 
	 }
setInterval(updateTime,1000); 