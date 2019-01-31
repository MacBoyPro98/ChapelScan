<?php
/**
 * Created by PhpStorm.
 * User: nteeter
 * Date: 9/13/2017
 * Time: 5:41 PM
 */

//Insert into Table2 from Table1
/**
 * @param $table2
 * @param $table1
 */

$id = "";

// First connect to the database via your connection insert file
include_once $_SERVER["DOCUMENT_ROOT"]."/login/config.php";

function insertFrom($table2, $table1, $id = 0) {
    "INSERT INTO $table2 (id, userName, firstName, lastName) SELECT id, userName, firstName, lastName FROM $table1 WHERE id=$id";
}