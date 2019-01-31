<?php
/**
 * Created by PhpStorm.
 * User: nteeter
 * Date: 9/19/2017
 * Time: 5:09 PM
 */

//Connect to SQL database
include_once $_SERVER["DOCUMENT_ROOT"]."/login/config.php";

//update the scanOut timestamp
mysqli_query($connect, "UPDATE scans SET scanOut = current_timestamp WHERE (scanIn > (NOW() - INTERVAL 1 HOUR) && (id='$_POST[id])')");
//update the total count in users table
mysqli_query($connect, "UPDATE users SET total = total + 1 WHERE (id='$_POST[id]')");