<?php
session_start();

if (!isset($_SESSION["users"])) {
    $_SESSION["users"] = array();
}

$users = &$_SESSION["users"];
$username = $_POST["username"];
$password = $_POST["password"];

if (isset($_POST["confirmPassword"])) {
    $confirm = $_POST["confirmPassword"];
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($confirm)) {
        if ($password != $confirm) {
            echo "Passwords do not match";
            return;
        }
        if (checkUser($users, $username) === null) {
            $users[$username] = array("username" => $username, "password" => $password);
            $_SESSION["logged"] = true;
            $_SESSION["username"] = $username;
            $_SESSION["password"] = $password;
            echo "Welcome $username <br>";
            echo "<a href='reservedPage.php'>Go to reserved page</a>";
            return;
        } else {
            echo "User already exists";
            return;
        }
    } 
    else {
        $user = checkUserPass($users, $username, $password);
        if ($user !== null) {
            $_SESSION["logged"] = true;
            $_SESSION["username"] = $user["username"];
            $_SESSION["password"] = $user["password"];
            echo "Welcome $username";
            echo "<a href='reservedPage.php'>Go to reserved page</a>";
            return;
        } else {
            echo "User does not exist<br>";
            echo "<a href='index.html'>Go Back</a>";
            return;
        }
    }
}

function checkUser($users, $username) {
    if (isset($users[$username])) {
        return $users[$username];
    }
    return null;
}

function checkUserPass($users, $username, $password) {
    if (isset($users[$username]) && $users[$username]["password"] == $password) {
        return $users[$username];
    }
        return null;
}