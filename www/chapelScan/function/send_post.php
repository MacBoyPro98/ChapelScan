<?php
//Connect to SQL database
include_once $_SERVER["DOCUMENT_ROOT"]."/chapelScan/login/config.php";

//Send form data to SQL database
//function scanIn($connect) {
//    mysqli_query($connect, "INSERT INTO scans (id, fName, lName, PHOTO) SELECT STU_ID, fName, lName, PHOTO FROM students where STU_ID ='$_POST[id]'");
//}
mysqli_query($connect, "INSERT INTO scans (id, fName, lName, PHOTO) SELECT CARD_ID, fName, lName, PHOTO FROM students where CARD_ID ='$_POST[id]'");

//mysqli_query($connect, "INSERT INTO scans (id, fName, lName, PHOTO) SELECT STU_ID, fName, lName, PHOTO FROM students WHERE STU_ID='$_POST[id]'");

//mysqli_query($connect, "INSERT INTO scans (id, userName, firstName, lastName) VALUES ('$_POST[id]'), 'nteeter', 'Nathan', 'Teeter')");
//mysqli_query($connect, "INSERT INTO scans (id, userName, firstName, lastName) VALUES ('24665', 'nteeter', 'Nathan', 'Teeter')");

//$sql = "INSERT INTO scans (id, userName, firstName, lastName) VALUES ('24665', 'nteeter', 'Nathan', 'Teeter')";

//if ($connect->query($sql) === TRUE) {
//    echo "New record created successfully";
//} else {
//    echo "Error: " . $sql . "<br>" . $connect->error;
//}