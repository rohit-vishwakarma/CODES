// let days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]; 
let countries = ["India", "Australia", "USA"];
let times = ["+0:0", "+5:30", "-10:30"];

function currentTime(cidx){
    let date = new Date();
    // let daynumber = date.getDay(); //getting day
    // let day = days[daynumber - 1]; //Day 

    // let Datetodisplay = date.getDate() +"-" + date.getMonth() +"-" +date.getFullYear(); //date

    let hh = date.getHours();
    let mm = date.getMinutes();
    let ss = date.getSeconds();
    let session = "AM";
    // hh =00;mm=0;ss=0;

    let sign = times[cidx][0];
    if(sign === "-"){
        let newtime = times[cidx].replace('-','');
        let diff = newtime.split(':');
        let nhour = diff[0];
        let nmin = diff[1];
        let car = 0;
        mm = mm - nmin;
        if(mm < 0){
            car = 1;
            mm = mm + 60;
        }
        hh = hh - car - nhour;
        if(hh < 0){
            hh = hh + 24;
        }
        // console.log(hh , mm);
    }else{
        let newtime = times[cidx].replace('+','');
        let diff = newtime.split(':');
        let nhour = diff[0];
        let nmin = diff[1];
        let car = 0;
        
        // console.log(hh , mm, nhour ,nmin);
        mm = mm + (nmin - '0');
        // console.log(mm);
        if(mm >= 60){
            car = 1;
            mm = mm - 60;
        }
        hh = hh + car + (nhour - '0');
        if(hh == 24){
            hh = 0;
        }
        if(hh > 24){
            hh = hh%24;
        }
        // console.log(hh , mm);
    }
    if(hh == 0){
        hh = 12;
    }
    if(hh > 12){
        hh = hh - 12;
        session = "PM";
    }

    hh = (hh < 10) ? "0" + hh : hh;
    mm = (mm < 10) ? "0" + mm : mm;
    ss = (ss < 10) ? "0" + ss : ss;
    
    let time = hh + ":" + mm + ":" + ss + " " + session;
     
    document.getElementById("addTime0").innerText = time; 
    document.getElementById("addCountry0").innerText = countries[cidx];
    let t = setTimeout(function(){ currentTime(cidx) }, 1000);
    // console.log(date, hh, mm, ss, countryName);
}
currentTime(1);