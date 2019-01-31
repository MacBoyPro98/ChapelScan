<?php
/**
 * Created by PhpStorm.
 * User: nteeter
 * Date: 9/25/2017
 * Time: 4:10 PM
 */

class post extends SQL{
    //variables


    //getters


    //setters


    //constructor
    function __construct($db_server, $db_username, $db_password, $db_name)
    {
        parent::__construct($db_server, $db_username, $db_password, $db_name);
    }

    //functions
    function sendPost() {
        $connection = SQL::getConn();

        //insert into scans
        mysqli_query($connection, "INSERT INTO scans (id, fName, lName, PHOTO) SELECT , userName, firstName, lastName FROM students WHERE id='$_POST[id]'");
    }
}