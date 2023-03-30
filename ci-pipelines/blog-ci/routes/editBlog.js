const express = require('express');
const router = express.Router();

const connection = require('../database/connection');
const isLogged = require('../middleware/loginControl');



router.get("/editBlog", isLogged, (req, res) => {

  connection.query("SELECT * FROM blog", (err, rows, fields) => {

    var resultArray = Object.values(JSON.parse(JSON.stringify(rows)));
    res.render('editBlog', { data:req.session.isLogged,blogs: resultArray });
  });



});

router.get("/delete/:id", (req, res) => {

  var sql = ` DELETE FROM blog WHERE id = ${req.params.id}`;
  connection.query(sql, function (err, result) {
    if (err) throw err;
    res.redirect('/editBlog')
  
  });

});

router.get("/update/:id", (req, res) => {

  connection.query(`SELECT * FROM blog where id = ${req.params.id}`, (err, rows, fields) => {

 
    res.render('updateBlog', { oldData: rows[0] });
  });

});


router.post("/update/:id", (req, res) => {

  var blogTitle = req.body.title;
  var blogText = req.body.text;

  var sql = "UPDATE blog set title =? , text =?  WHERE id = ?";
  connection.query(sql, [blogTitle, blogText, req.params.id], function (err, result) {
    if (err) throw err;
    console.log(result.affectedRows + " record(s) updated");
    res.redirect('/editBlog');
  });

});














module.exports = router;