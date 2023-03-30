const express=require('express');
const router=express.Router();

const connection=require('../database/connection');



router.post('/signin',(req,res)=>{
    var username=req.body.username;
    var password=req.body.password;
    
    if(username && password){
        connection.query("SELECT * FROM logininfo ",(err,rows,fields)=>{

            if(username==rows[0].username&& password==rows[0].password){
                req.session.isLogged=true;
                res.redirect('/');
                
              
            }
            else{
                res.redirect('/signin');
                console.log('Wrong Password or Username');
            }


        });
    }


});

router.get('/signin',(req,res)=>{
    res.render('signin');
});




module.exports=router;