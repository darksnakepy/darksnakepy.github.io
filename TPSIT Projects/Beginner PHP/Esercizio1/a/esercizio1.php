<?php
    $localita = $_POST["localita"];
    $data = $_POST["data"];
    $ora = $_POST["ora"];
    $rilevazione = $_POST["rilevazione"];
    $umidita = $_POST["umidita"];
    $clima = $_POST["clima"];
    $altitudine = $_POST["altitudine"];

    echo "$localita", "<br />\n", "$data", "<br />\n", "$ora", "<br />\n",
            "$rilevazione", "<br />\n", "$umidita", "<br />\n", "$clima", "<br />\n", "$altitudine"
?>  