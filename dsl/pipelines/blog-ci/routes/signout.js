const express=require('express');
const router=express.Router();



router.get('/signout',(req,res)=>{
    req.session.destroy();
    res.redirect('/');
});

module.exports=router;