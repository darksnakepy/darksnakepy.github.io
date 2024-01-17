<?php
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        $user = $_POST["username"];
        $pass = $_POST["password"];
        $choice = $_POST["remember"];
        $expiration = 0;

        if (isset($choice)) {
            $expiration = time() + 60 * 60 * 24;
        }

        setcookie("username", $user, $expiration);
        setcookie("password", $pass, $expiration);
        header("Location: PaginaRiservata.php");
    }
?>