<?php
    $name = "utente";
    $value = "Giovanni Sansonetti";
    $duration = 86400 * 30;

    setcookie($name, $value, time() + $duration, "/"); 

    if(!isset($_COOKIE[$name])) {
        echo "Il cookie di nome $name non risulta ancora settato!";
      } else {
        echo "Il cookie utente è settato,<br>Il suo valore è $value";
      }

?>