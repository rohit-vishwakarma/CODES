#!/usr/bin/env node


const fs= require("fs");

// fs.writeFileSync("abc.txt","wow what is this this amazing");
// let data= fs.readFileSync("abc.txt", "utf-8");

// let data= fs.readFileSync("abc.md", "utf-8");
// console.log(data);

// npm i fs
// npm init
// console.log(fs.existsSync("abc.txt"));
// console.log(process.argv);
let arguments = process.argv.slice(2);

function wcat(arguments){

        let options = arguments.filter(function(data,index){
            return data.startsWith("-");
        });

        let files = arguments.filter(function(data,index){
            return !data.startsWith("-");
        });
    
    if(files.length==0){
        console.log("Please specify the file name.");
        return;
    }
    for(let i=0;i<files.length;i++){

        if(!fs.existsSync(files[i])){
            console.log(files[i]+" doesn't exits");
            return;
        }

    }
    let numbering =1;
    for(let i=0; i<files.length;i++){
        let data = fs.readFileSync(files[i],"utf-8");
        if(options.includes("-s")){
            let lines = data.split("\r\n");
            console.log(lines);
            for(let j=0;j<lines.length;j++){
                if(lines[j]!=""){
                    if(options.includes("-n")){
                        console.log(numbering+". "+lines[j]);
                        numebring+=1;

                    }else{
                    console.log(lines[j]);}
                }
            }
        }else if((options.includes("-n") && !options.includes("-b")) || (options.includes("-n") && options.includes("-b") && (options.indexOf("-n")< options.indexOf("-b")))){
            let lines = data.split("\r\n");
            for(let j = 0; j<lines.length; j++){
                console.log(numbering+". "+lines[j]);
                numbering+=1;
            }

        }else if(options.includes("-b")){
            let lines= data.split("\r\n");
            for(let j=0;j<lines.length;j++){
                if(lines[j]!=""){
                console.log(numbering+". "+lines[j]);
                numbering+=1;
                }else{
                    console.log(lines[j]);
                }
            }
        
        }else {
              console.log(data);
           }
    }
}
wcat(arguments);
