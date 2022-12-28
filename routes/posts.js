const express = require('express');

const router = express.Router();

const Post = require('../models/post');

//this will route to localhost:3000/posts/
router.get('/', (req,res) =>{
    res.send("we are on middleware posts");
})


//this will route to localhost:3000/posts/getAllPosts
//firing query for find all objects from database
router.get('/getAllPosts',async(req,res)=>{
    
    try {
        const posts = await Post.find();
        res.json(posts);
    } catch (error) {
        res.json({message:error})
    }
    
})

//get specific post 
//'/:param' use of : after address will get paramaters send 
router.get('/:postId',async(req,res)=>{
    try {
        const post = await Post.findById(req.params.postId);
        res.json(post);

    } catch (error) {
        res.json({message:error})
    }
  

    console.log(req.params.postId);
})

//this will route to localhost:3000/posts/specific
router.get('/specific',(req,res)=>{
    res.send("we are inside route post and more");
})

//if request is post in localhost:3000/posts this code will execute
router.post('/',async(req,res)=>{
    console.log(req.body)

    //get data from front end and save it in json object
    const post = new Post ({
        title: req.body.title,
        description: req.body.description
    });


    //1.save it in data  base 
    // post.save()
    //     .then(data=>{ //showing the data if it is saved other wise show errror
    //         res.json(data);
    //     }).catch(err=>{
    //         res.json({message: err})
    //     })

    //2.another way to save data on database
         
            try {
                const savedPost = await post.save();
                res.json(savedPost);
            } catch (error) {
                res.json({message:error});
            }
        }
    )

router.delete('/:postId',async(req,res)=>{
    try {
    const removePost = await Post.remove({_id : req.params.postId})

    res.json(removePost);
        
    } catch (error) {
        res.json({ message: error})
    }

});

router.patch('/:postId',async(req,res)=>{
    try {
        const updatePost=await Post.updateOne({_id: req.params.postId},{title:req.body.title})

        res.json(updatePost);

    } catch (error) {
        res.json({message:error})
    }
})

module.exports = router;