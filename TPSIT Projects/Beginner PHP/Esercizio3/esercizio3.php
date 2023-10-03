<?php

    $nomeprimasquadra = $_POST["primasquadra"];
    $npartite = $_POST["npartite"];
    $npareggi = $_POST["npareggi"];
    $nperse = $_POST["nperse"];

    $secsquadra = $_POST["secsquadra"];
    $secpartitevinte = $_POST["secpartitevinte"];
    $secnpareggi = $_POST["secnpareggi"];
    $secnperse = $_POST["secnperse"];

    $punteggioPrimaSquadra = ($npartite * 3) + $npareggi;
    $punteggioSecondaSquadra = ($secpartitevinte * 3) + $secnpareggi;

    $stato = "";


    if($punteggioSecondaSquadra > $punteggioPrimaSquadra){
        $primaSquadra = "$secsquadra = $punteggioSecondaSquadra <br> $nomeprimasquadra = $punteggioPrimaSquadra";
    }
    else{
        $primaSquadra = "$nomeprimasquadra = $punteggioPrimaSquadra <br> $secsquadra = $punteggioSecondaSquadra";
    }

    $partiteGiocate = $npartite + $npareggi + $nperse;
    $partiteGiocate_sec = $secpartitevinte + $secnpareggi + $secnperse;

    if ($partiteGiocate == $partiteGiocate_sec) {
        $stato = "Le due squadre hanno giocato lo stesso numero di partite<br/>";
    } else{
        $stato = "Le due squadre hanno giocato un numero di partite diverso <br/>";
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
            <td>Nome <br> Vinte <br> Pareggiate <br> Perse <br></td>
            <td>*$nomeprimasquadra* <br> $npartite <br> $npareggi <br> $nperse </td>
            <td rowspan='4' >Classifica <br>$primaSquadra <br> $stato</td>
        </tr>  
        <tr>
            <td>Nome <br> Vinte <br> Pareggiate <br> Perse <br></td>
            <td>*$secsquadra* <br> $secpartitevinte <br> $secnpareggi <br> $secnperse </td>          
        </tr>
    </table>
    
           

    "
?>