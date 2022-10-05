function getMonthDays(month){
    
    if (month === "febbraio"){
        return "28 giorni"
    }
    else if (month === "novembre" || month === "aprile" || month === "giugno" || month === "settembre"){
        return "30 giorni"
    }
    else{
        return "31 giorni"
    }
}

function getGrade(grade) {
    if (grade < 6)
    {
        return "Insufficiente"
    }
    else if (grade >= 6 && grade <= 6.9)
    {
        return "Sufficiente"
    }
    else if (grade >= 6 && grade <= 7.9)
    {
        return "Discreto"
    }
    else if (grade >= 8)
    {
        return "buono"
    }
}

function convertToMS(hour, min){
    return ("Ore in ms: "+ hour * 60 * 60000) + (" Minuti in millisecondi" + min * 60000)
}

function convertToC(temp){
    return (temp -32.0) * 5.0 / 9.0
} 


function 

let month = parseInt(prompt("Inserisci un mese: "))
console.log(getMonthDays(month))

let grade = parseFloat(prompt("Inserisci un voto: "))
console.log(getGrade(grade))

hour = parseInt(prompt("Inserisci un'ora: ")) // converte in millisceondi
min = parseInt(prompt("Inserisci un minuto "));
console.log(convertToMS(hour, min));


