require("chromedriver");
const fs = require("fs");
const wd = require("selenium-webdriver");
let browser = new wd.Builder().forBrowser('chrome').build();
async function main(){
    await browser.get("https://github.com/topics");
    await browser.wait(wd.until.elementLocated(wd.By.css(".no-underline.d-flex.flex-column.flex-justify-center")));
    let data = await browser.findElements(wd.By.css(".no-underline.d-flex.flex-column.flex-justify-center"));
    let urls = [];
    for(let i=0; i<data.length;i++){
        let url =await data[i].getAttribute("href");
        urls.push({topicUrl : url});
    }
    console.log(urls);
    for(let i=0;i<urls.length;i++){
       await browser.get(urls[i].topicUrl);
    //    await browser.wait(wd.until.elementLocated(wd.By.css("a.text-bold")));
       let data2 =  await browser.findElements(wd.By.css("a.text-bold"));
       urls[i]["projects"] = [];
       for(let j=0;j<data2.length;j++){
           if(j==2) break;
           urls[i].projects.push({projectUrl : await data2[j].getAttribute("href")});
        //    urls2.push(url2);
       }
    //    console.log(urls2);
    for(let j=0;j<urls[i].projects.length;j++){
        await browser.get(urls[i].projects[j].projectUrl + "/issues");
        let issueBoxes  = await browser.findElements(wd.By.css(".d-block.d-md-none.position-absolute.top-0.bottom-0.left-0.right-0"));
        urls[i].projects[j]["issues"] = [];
        if(await browser.getCurrentUrl()==urls[i].projects[j].projectUrl + "/issues"){
            for(let k=0;k<issueBoxes.length;k++){
                if(k==2) {
                    break;
                }
                let heading = issueBoxes[k].getAttribute("innerText");
                let url = await issueBoxes[k].getAttribute("href");
                urls[i].projects[j].issues.push({heading: heading, url : url});
            }
        }
    }
    }
    fs.writeFileSync("urls.json", JSON.stringify(urls));
    browser.close()
}
main();