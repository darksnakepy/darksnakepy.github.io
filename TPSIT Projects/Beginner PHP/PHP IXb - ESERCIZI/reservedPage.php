<?php
session_start();
if (isset($_SESSION["logged"])) {
    echo "Welcome ". $_SESSION["username"] . "<br>";
    echo "Your password is ". $_SESSION["password"] . "<br>";
    echo "<label for='email'>Enter your email:</label>";
    echo "<input type='email' id='email' name='email'> <br>";
    echo "<input type='submit'>";
}
?>