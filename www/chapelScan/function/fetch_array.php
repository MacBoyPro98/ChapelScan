<?php
/**
 * Created by PhpStorm.
 * User: Nathan
 * Date: 3/4/19
 * Time: 3:47 PM
 */

/**
 * Function: search local file and sort into an array
 * RETURNS: array of info formatted like SQL_fetch_array
 */
function fetch_array_nathan($filePath) {
    $row = 1;
    if (($file = fopen($filePath, "r")) !== FALSE) {
        while (($data = fgetcsv($file, 1000, ",")) !== FALSE) {
            $num = count($data);
            echo "<p> $num fields in line $row: <br /></p>\n";
            $row++;
            for ($c=0; $c < $num; $c++) {
                echo $data[$c] . "<br />\n";
            }
        }
        fclose($file);
    }
}