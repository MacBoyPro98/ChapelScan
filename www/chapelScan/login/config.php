<?php
/* Database credentials. Assuming you are running MySQL
server with default setting (user 'root' with no password) */
define('DB_SERVER', 'localhost');
define('DB_USERNAME', 'nteeter');
define('DB_PASSWORD', 'St4rw@rs1977');
define('DB_NAME', 'chapelScan');
 
/* Attempt to connect to MySQL database */
$link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
 
// Check connection
if(!$link){
    die("ERROR: Could not connect. " . mysqli_connect_error());
}

$connect = mysqli_connect('localhost',DB_USERNAME,DB_PASSWORD,'chapelScan');