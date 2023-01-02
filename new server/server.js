const express = require('express');
const app = express();
const port = 4000;
const path = require('path');

app.get ('/',(req,res)=>{
    res.sendFile(path.join(__dirname,'./public/index.html'));
})
app.get ('/home',(req,res)=>{
    res.sendFile(path.join(__dirname,'./public/next.html'));
})

app.listen(port, (error)=>{
    if(error){
        console.log(error);
    }else{
        console.log(`Server is listening to ${port}`);
    }
})
