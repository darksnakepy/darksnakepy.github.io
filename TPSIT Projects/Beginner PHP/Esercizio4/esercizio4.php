<?php

    $marca = $_POST["marca"];
    $modello = $_POST["modello"];
    $porte = $_POST["porte"];
    $refresh = $_POST["refresh"];
    $risoluzione = $_POST["risoluzione"];


    const porte = "Si consiglia di acquistare un televisore con almeno due porte hdmi";
    const refresh = "Si consiglia di acquistare un televisore con refresh rate pari a 50hz";
    const statoRes = "Su consiglia una risoluzione ULTRA HD O 4k";

    $statoPorte = ""; $statoRefresh =""; $statoRes = "";

    if($porte < 2){
        $statoPorte = porte;
    }else{
        $statoPorte = "PORTE OK";
    }


    if($refresh < 50) {
        $statoRefresh = refresh;
    }else{
        $statoRefresh = "REFRESH OK";
    }

    if($risoluzione == "full hd") {
        $statoRes = statoRes;
    }else{
        $statoRes = "RISOLUZIONE OK";
    }


    echo "
    <table border='1'>
        <tr>
            <th align='center' colspan='2'>
                Dati
            </th>
            <th align='center' colspan='2'>
                Output
            </th>
        </tr>
        <tr>
            <td>Marca <br> Modello <br> Porte HDMI <br> Refresh rate <br></td>
            <td>$marca<br> $modello <br> $porte <br> $refresh </td>
            <td rowspan='4' >Consigli <br> $statoPorte<br> $statoRefresh <br> $statoRes</td>
        </tr>  
    </table>
    
           

    "
?>