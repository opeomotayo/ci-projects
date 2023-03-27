const express = require('express');
const router = express.Router();

const connection = require('../database/connection');



router.get('/blog/:id', (req, res) => {

    connection.query(`SELECT * FROM blog WHERE id=${req.params.id}`, (err, rows, fields) => {

        var specialArr = Object.values(JSON.parse(JSON.stringify(rows)));
        res.render('readMore', { data: req.session.isLogged, blogs: specialArr });
    });

});


module.exports=router;