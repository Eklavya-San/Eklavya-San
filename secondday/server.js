const express = require('express');
const app = express();
const bodyparser = require('body-parser')
app.use(bodyparser.json());
const port = 6969;
const homeRoutes = require('./routes/paths');

app.use('/home',homeRoutes);


app.get("/",(req,res)=>{
    res.send("<h1>hello chanakyya</h1>");
})

app.listen(port,()=>{
    console.log(`server running on ${port}`);
})