console.log("Hello World!")
const http = require('http');

const server = http.createServer((req, res)=>{
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/plain');
    res.end("It's my first project of node-js");
});
server.listen(3000);
