<?php
    if(isset($_COOKIE["username"]) && isset($_COOKIE["password"])) {
        echo "Username: ".$_COOKIE["username"]."<br/>";
        echo "Password: ".$_COOKIE["password"];
    }
?>