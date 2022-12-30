const express = require('express');
const app = express();
const path = require('path');




app.get('/',(req,res)=>{
    res.send('<h1>this is webpage</h1> <a href="aboutus">aboutus</a>');
})
app.get('/aboutus',(req,res)=>{
    res.sendFile(path.join(__dirname,'./public/aboutus.html'))
})
app.listen(4000,()=>{
    console.log("server listening at 4000")
});