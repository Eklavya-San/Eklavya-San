const express = require('express');
const router = express();
const path = require('path')

router.get('/',(req,res)=>{
    res.send("<h1>this is sparta </h1><a href='/about'>about</a> <a href='/home'>home</a>");
})


router.get('/home',(req,res)=>{
    res.send("<h1>this is home </h1> <a href='/about'>about</a> <a href='/'>web</a>");
})


router.get('/about',(req,res)=>{
    res.send("<h1>this is about us</h1> <a href='/home'>home</a> <a href='/'>web</a> ");
})


module.exports=router;