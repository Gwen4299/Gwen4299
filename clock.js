setInterval(function(){
    var Clock=new Date()
    var hour=Clock.getHours()
    var minutes=Clock.getMinutes()
    var seconds=Clock.getSeconds()
    var amOrpm=0;
    if(hour>12){
        hour=Clock.getHours()-12
        amOrpm=1
    }
    if(hour<10){hour="0"+hour}
    if(minutes<10){minutes="0"+minutes}
    if(seconds<10){seconds="0"+seconds}
    
    var Clock=[hour,minutes,seconds,amOrpm]
    
    var figureDivs=Array.from(document.querySelectorAll(".figure"))
    var figureDivs=figureDivs.slice(0,figureDivs.length)
    
    var Clock=Clock.join("").split("")
    for(let i in Clock){
    
        Array.from(figureDivs[i].querySelectorAll("li")).forEach((e)=>{e.style.top=-(parseInt(Clock[i])*50)+"px"})
    }
    },100)