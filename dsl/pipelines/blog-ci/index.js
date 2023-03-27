const express = require('express');
const bodyParser = require('body-parser');

//Mysql Connection
const connection = require('./database/connection');
const app = express();
const port = 3000;
const newBlog = require('./routes/newBlog');
const signIn = require('./routes/signin');
const signOut = require('./routes/signout');
const editBlog = require('./routes/editBlog');
const blog = require('./routes/blog');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.use(express.static(__dirname + '/public'));

app.set('view engine', 'ejs');

const session = require('express-session');



app.use(session({
    secret: 'secret-key',
    resave: false,
    saveUninitialized: true
}));



app.get('/', (req, res) => {
    connection.query("SELECT * FROM blog", (err, rows, fields) => {

        var resultArray = Object.values(JSON.parse(JSON.stringify(rows)));
        res.render('home', { data: req.session.isLogged, blogs: resultArray });

    });
});






app.use(blog);
app.use(editBlog);
app.use(newBlog);
app.use(signIn);
app.use(signOut);













app.listen(port, () => {
    console.log('Port Listenning at : ', port)
})
