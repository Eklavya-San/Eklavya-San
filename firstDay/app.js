const express = require('express') //import express package
const mongoose = require('mongoose');
const app = express();
const postRoute = require('./routes/posts');
const bodyParser = require('body-parser');
const e = require('express');
// middlewares

    // app.use('/posts',()=>{
    //     console.log("this is middleware running");
    // })

    app.use(bodyParser.json()) // this will parse our input of json 
//routes
app.get('/',(req,res)=>{
    res.send("we are on home");
});

//whenever localhost:3000/posts/ is calledd we will send that request to postRoute
    app.use('/posts',postRoute);



// app.get('/posts',(req,res)=>{
//     res.send("we are in posts");
// });



//connection to mongo db 
mongoose.connect(
    'mongodb://localhost:27017/foodsaftey',//
    {
    useNewUrlParser:true
    },
    (err)=>{
        if(err){
            console.log(err);
        }
        else{
        console.log("\nconnected to DB!");
        }
    })

//how to start server
app.listen(3000);