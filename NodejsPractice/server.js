//prerequisite
const express = require ('express');
const path = require('path');
const app = express();
const bodyParser=require('body-parser');
const routes = require('./routes/paths')
const port = 7878;
app.use(bodyParser.json());
app.use("/",routes);

app.listen(port,()=>{
    console.log(`Server is listening to ${port}`);
})
