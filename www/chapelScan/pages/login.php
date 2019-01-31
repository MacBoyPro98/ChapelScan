<?php
//include config file
require_once '../login/config.php';

//define variables
$username = "";
$password = "";
$username_err = "";
$username_err = "";

//process data when form is submitted
if($_SERVER["REQUEST_METHOD"] == "POST"){
    //check if the username is empty
    if(empty($_POST['username'])){
        $username_err = 'Please enter a username';
    } else {
        $username = ($_POST("username"));
    }

    //check if the password is empty
    if(empty($_POST['password'])){
        $password_err = 'Please enter a password';
    } else {
        $password = ($_POST("password"));
    }

    //Validate Credentials
    if(empty($username_err) && empty($password_err)){
        //prepare a select statement
        $sql = "SELECT username, password FROM members WHERE username= ?";

        if($stmt = mysqli_prepare($link, $sql)){
            //Bind variables to the prepared statement as params
            mysqli_stmt_bind_param($stmt, "s", $param_username);

            //set params
            $param_username = $username;

            //attempt the statement
            if(mysqli_stmt_execute($stmt)){
                //store result
                mysqli_stmt_store_result($stmt);

                //check if the username exists, then verify the password
                if(mysqli_num_rows($stmt) == 1){
                    //bind result variables
                    mysqli_stmt_bind_result($stmt, $username, $hashed_password);
                    if(mysqli_stmt_fetch($stmt)){
                        if(password_verify($password, $hashed_password)) {
                            //password is correct, start the session
                            session_start();
                            $_SESSION['username'] = $username;
                            header("location: welcome.php");
                        } else{
                            //display an error message if password is not valid
                            $password_err = 'The password you entered was not valid.';
                        }
                    } else{
                        //display an error message if username doesn't exist
                        $username_err = 'No account found with that username.';
                    }
                } else{
                    echo "Oops! Something went wrong. Please try again later.";
                }
            }
            //close statement
            mysqli_stmt_close($stmt);
        }
    }
    //close connection
    mysqli_close($link);
}
?>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Chapel Scan - Login</title>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.php">Chapel Scan</a>
            </div>
            <!-- /.navbar-header -->
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Chapel Scan</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="POST">
                                <fieldset>
                                    <div class="form-group<?php echo (!empty($username_err)) ? 'has-error' : ''; ?>">
                                        <input class="form-control" placeholder="Username" name="username" type="username" value="<?php echo $username; ?>" autofocus>
                                        <span class="help-block"><?php echo $username_err; ?></span>
                                    </div>
                                    <div class="form-group<?php echo (!empty($username_err)) ? 'has-error' : ''; ?>">
                                        <input class="form-control" placeholder="Password" name="password" type="password">
                                    </div>
                                    <!-- Change this to a button or input when using this as a form -->
                                    <button href="index.php" class="btn btn-lg btn-success btn-block" value="Submit">Login</button>
                                </fieldset>
                            </form>
                        </div>
                        <div class="panel-footer">
                            <a href="index.php" class="btn btn-lg btn-success btn-block">Sign-up</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
