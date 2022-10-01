function getMonthDays(){
    let inputDati = prompt("Inserisci un mese: ")
    let a = inputDati.toLowerCase()
    if (a === "febbraio"){
        console.log(a + "=" + " 28 giorni")
    }
    else if (a === "novembre" || a === "aprile" || a === "giugno" || a === "settembre"){
        console.log(a + "=" + " 30 giorni")
    }
    else{
        console.log(a + "=" + " 31 giorni")
    }
}

function getGrade(){
    let inputDati = parseFloat(prompt("Inserisci il cazzo di voto: "))
    if (inputDati < 6)
    {
        console.log("Voto: " + inputDati + " = Negativo")
    }
    else if (inputDati >= 6 && inputDati <= 6.9)
    {
        console.log("Voto: " + inputDati + " = Sufficiente")
    }
    else if (inputDati >= 6 && inputDati <= 7.9)
    {
        console.log("Voto: " + inputDati + " = Discreto")
    }
    else if (inputDati >= 8)
    {
        console.log("Voto: " + inputDati + " = buono")
    }
    else{
        console.log("Reinserisci il numero")
    }
}

function 
