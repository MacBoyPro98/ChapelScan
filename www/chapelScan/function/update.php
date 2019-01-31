<?php
/**
 * Created by PhpStorm.
 * User: nteeter
 * Date: 9/25/2017
 * Time: 4:09 PM
 */

include "../function/SQL.php";

class update extends SQL{
    //variables
    var $query;

    //getters


    //setters


    //functions
    function sendUpdate() {
        $connection = SQL::getConn();

        //update the scanOut timestamp
        mysqli_query($connection, "UPDATE scans SET scanOut = current_timestamp WHERE (scanIn > (NOW() - INTERVAL 1 HOUR) && (id='$_POST[id])')");

        //update the total count in users table
        mysqli_query($connection, "UPDATE users SET total = total + 1 WHERE (id='$_POST[id]')");
    }

    //update the scanOut timestamp
    function updateScanOut() {
        //get a connection to the database
        $connection = SQL::getConn();

        //MySQL query to execute
        mysqli_query($connection, "UPDATE scans SET scanOut = current_timestamp WHERE (scanIn > (NOW() - INTERVAL 1 HOUR) && (id='$_POST[id])')");
    }

    //update the total count in the users table
    function updateCount() {
        $connection = SQL::getConn();

        //MySQL query to execute
        mysqli_query($connection, "UPDATE users SET total = total + 1 WHERE (id='$_POST[id]')");
    }
}