<?php
//Connect to SQL database
include_once $_SERVER["DOCUMENT_ROOT"]."/chapelScan/login/config.php";

$filePath = "C:/wamp64/output/scan-in.csv";

function append($filePath) {
    $file = fopen($filePath, "a+");

    //check for file read error
    if (!$file) {
        echo ("Error Opening file");
    }

    $size = filesize($file);

    if ($size != 0) {
        $current = fread($file, $size);
        $temp = $current."\n".$_POST[id]."\n";

        //write to the file
        fwrite($file, $temp);
    } else {
        $temp = $_POST[id]."\n";

        //write to the file
        fwrite($file, $temp);
    }

    //close the file
    fclose($filePath);
}

function append_2() {
    $file = fopen($filePath, "a+");

    //check for file read error
    if (!$file) {
        echo ("Error Opening file");
    }

    $size = filesize($file);

    if ($size != 0) {
        $current = fread($file, $size);
        $temp = $current."\n".$_POST[id]."\n";

        //write to the file
        fwrite($file, $temp);
    } else {
        $temp = $_POST[id]."\n";

        //write to the file
        fwrite($file, $temp);
    }

    //close the file
    fclose($filePath);
}

//Send form data to SQL database
mysqli_query($connect, "INSERT INTO scans (id, fName, lName, PHOTO) SELECT CARD_ID, fName, lName, PHOTO FROM students where CARD_ID ='$_POST[id]'");
append($filePath);