<?php
/**
 * Created by PhpStorm.
 * User: nteeter
 * Date: 9/25/2017
 * Time: 3:33 PM
 */

class SQL {
    var $connection;
    var $connect;
    var $server;
    var $username;
    var $password;
    var $name;

    //constructor
    function __construct($db_server, $db_username, $db_password, $db_name) {
        $this->server = $db_server;
        $this->username = $db_username;
        $this->password = $db_password;
        $this->name = $db_name;
    }

    //getters
    function getConn() {
        return $this->connection;
    }

    //setters
    function setConn($db_server, $db_username, $db_password, $db_name) {
        /* Database credentials. Assuming you are running MySQL
        server with default setting (user 'root' with no password) */
        define('DB_SERVER', $db_server);
        define('DB_USERNAME', $db_username);
        define('DB_PASSWORD', $db_password);
        define('DB_NAME', $db_name);

        /* Attempt to connect to MySQL database */
        $link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);

        // Check connection
        if(!$link){
            die("ERROR: Could not connect. " . mysqli_connect_error());
        }

        $this->connection = mysqli_connect('localhost','root','','chapelScan');
    }
}