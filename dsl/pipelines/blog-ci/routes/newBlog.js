const express = require('express');
const isLogged = require('../middleware/loginControl');
const path = require('path');
var multer = require('multer')


const storage = multer.diskStorage({
    destination: (req, file, cb) => {
        cb(null, 'C:/Users/berka/Desktop/Projects/blogApp/public/images');
    },
    filename: (req, file, cb) => {

        cb(null, file.originalname);
    }
});

const upload = multer({ storage: storage });
const connection = require('../database/connection');
const router = express.Router();






router.get('/newBlog', isLogged, (req, res) => {
    res.render('newBlog');
});


router.post('/newBlog', upload.single('image'), (req, res) => {

    var blogTitle = req.body.title;
    var blogImage = req.file.originalname;
    var blogText = req.body.text;
    var sql = `INSERT INTO blog (title,image,text) VALUES ('${blogTitle}', '${blogImage}', '${blogText}')`;
    connection.query(sql, function (err, result) {
        if (err) throw err;
        console.log("record inserted");
    });
    res.redirect('/');



});

module.exports = router;