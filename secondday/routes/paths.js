const express = require('express');

const router = express.Router();
const path = require('path');

router.get('/',(req,res)=>{
    res.sendFile(path.join(__dirname,'../public/home.html'));
})
router.get('/aboutus',(req,res)=>{
    res.sendFile(path.join(__dirname,'../public/aboutus.html'));
})
router.get('/user',(req,res)=>{
    res.sendFile(path.join(__dirname,'../public/user.html'));
})
router.get('/admin',(req,res)=>{
    res.sendFile(path.join(__dirname,'../public/admin.html'));
})


module.exports=router;