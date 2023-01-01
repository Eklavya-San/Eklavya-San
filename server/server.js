const express = require('express');
const { join } = require('path');
const app = express();
const port =4949;
const path = require('path');
app.get('/',(req,res)=>{
    res.send("<h1>You have joined My page!")
})

app.get('/home',(req,res)=>{
    res.sendFile(path.join(__dirname,'./public /index.html'));
})
app.listen(port,(error)=>{
    if(error){
        console.log(error);
    }else{
        console.log(`server is listening to ${port}`);
    }
})