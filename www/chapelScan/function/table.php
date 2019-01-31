<?php
/**
 * Created by PhpStorm.
 * User: nteeter
 * Date: 9/20/2017
 * Time: 5:49 PM
 */

// If session variable is not set it will redirect to login page
//if(!isset($_SESSION['username']) || empty($_SESSION['username'])){
//    header("location: login.php");
//    exit;
//}

// First connect to the database via your connection insert file
include_once $_SERVER["DOCUMENT_ROOT"]."/login/config.php";

//$connect = mysqli_connect('localhost','root','','login');

$results = mysqli_query($connect,"SELECT * FROM scans");

function scanOutTable() {
    ?>

<!-- Responsive Table -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <!-- /.panel-heading -->
            <div class="panel-body">
                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <thead>
                    <tr>
                        <th>ID Number</th>
                        <th>Username</th>
                        <th>Full Name</th>
                        <th>Time Out</th>
                        <th>Credit Type</th>
                    </tr>
                    </thead>
                    <tbody>
                    <?php while($row = mysqli_fetch_array($results)) {?>
                        <tr>
                            <td><?php echo $row['id']; ?></td>
                            <td><?php echo $row['userName']; ?></td>
                            <td><?php
                                $firstName = $row['firstName'];
                                $lastName = $row['lastName'];
                                echo "$firstName $lastName"; ?></td>
                            <td><?php
                                if ($row['scanOut'] == null) {
                                    echo "Did Not Scan Out";
                                } else {
                                    echo $row['scanOut'];
                                } ?></td>
                            <td><?php switch ($row['creditType']) {
                                    case 'F':
                                        echo "Full";
                                        break;
                                    case 'L':
                                        echo "Late";
                                        break;
                                    case 'A':
                                        echo "Alternative";
                                        break;
                                } ?></td>
                        </tr>
                    <?php } ?>
                    </tbody>
                </table>
                <!-- /.table-responsive -->
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
</div>

<?php
    }
?>