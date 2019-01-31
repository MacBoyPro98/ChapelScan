<?php
include_once $_SERVER["DOCUMENT_ROOT"]."/chapelScan/login/config.php";

class fileIO {
    var $filePath = "C:/wamp64/output/scan-in.csv";

    function add($filePath, $connect, $card_id) {
        $file = fopen($filePath, "r");

        //check for file read error
        if (!$file) {
            echo ("Error Opening file");
        }

        //get data
        $photo = mysqli_query($connect, "SELECT PHOTO FROM students WHERE CARD_ID = '$card_id'");

        //Format string
        $temp = $card_id."\n";

        //write to file
        fwrite($file, $temp);

        //return photo to display to the user
        return $photo;
    }

    function add_best($filePath, $connect, $card_id) {
        $file = fopen($filePath, "r");

        //check for file read error
        if (!$file) {
            echo ("Error Opening file");
        }

        //get data
        $stu_id = mysqli_query($connect, "SELECT STU_ID FROM students WHERE CARD_ID = '$card_id'");
        $fName = mysqli_query($connect, "SELECT fName FROM students WHERE CARD_ID = '$card_id'");
        $lName = mysqli_query($connect, "SELECT lName FROM students WHERE CARD_ID = '$card_id'");
        $photo = mysqli_query($connect, "SELECT PHOTO FROM students WHERE CARD_ID = '$card_id'");

        //Format string
        $temp = $fName.",".$lName.",".",".$card_id.",".$stu_id.",".$photo.","."\n";

        //write to file
        fwrite($file, $temp);
    }
}