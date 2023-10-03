<?php
    $nome = $_POST["nome"];
    $cognome = $_POST["cognome"];
    $ragioneSociale = $_POST["ragionesoc"];
    $indirizzo = $_POST["indirizzo"];
    $piva = $_POST["piva"];
    $tel = $_POST["tel"];

    $descr = $_POST["descr"];
    $giacenza = $_POST["giacenza"];
    $prezzoUnitario = $_POST["prezzounitario"];
    $iva = $_POST["iva"];
    $quantita = $_POST["quantita"];

    echo
    "Dati cliente: ", "<br/>\n",
    "Nome: $nome", "<br/>\n",
    "Cognome: $cognome" , "<br/>\n",
    "Ragione sociale: $ragioneSociale", "<br/>\n",
    "Indirizzo: $indirizzo", "<br/>\n",
    "PIVA: $piva" , "<br/>\n",
    "Telefono: $tel", "<br/>\n";

    echo
    "Prodotto acquistato: ", "<br/>\n",
    "Descrizione: $descr", "<br/>\n",
    "Giacenza: $giacenza", "<br/>\n",
    "Prezzo unitario: $prezzoUnitario", "<br/>\n",
    "IVA: $iva","<br/>\n",
    "Quantita: $quantita", "<br/>\n";

    $prodottoFinale = $prezzoUnitario*$quantita;



?>