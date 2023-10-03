<?php
    $nome = $_POST["nome"];
    $password = $_POST["password"];
    $htmlinfo = isset($_POST["htmlinfo"]) ? "SI" : null;
    $immagini = isset($_POST["immagini"]) ? "SI" : null;
    $collegamenti = isset($_POST["collegamenti"])? "SI" : null;
    $multimediali = isset($_POST["multimediali"]) ? "SI" : null;
    $xhtml = isset($_POST["xhtml"]) ? "SI" : null;

    echo
    "<table border='1'>
        <tr>
            <td>Nome: </td>
            <td>$nome</td>
        </tr>   
        <tr>
            <td>Password: </td>
            <td>$password</td>
        </tr>
        <tr>
            <td>Immagini:</td>
            <td>$immagini</td>
        </tr>
        <tr>
            <td>Collegamenti:</td>
            <td>$collegamenti</td>
        </tr>
        <tr>
            <td>Multimediale:</td>
            <td>$multimediali</td>
        </tr>
        <tr>
            <td>XHTML:</td>
            <td>$xhtml</td>
        </tr>
    </table>"

?>