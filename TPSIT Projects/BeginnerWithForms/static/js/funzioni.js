function getMonthDays(month){
    if (month.value.toLowerCase() === "febbraio"){
        return "28 giorni"
    }
    else if (month.value.toLowerCase() === "novembre" || month.value.toLowerCase() === "aprile" || month.value.toLowerCase() === "giugno" || month.value.toLowerCase() === "settembre"){
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
    return `Ore in ms: ${hour * 60 * 60000}, Minuti in ms: ${min * 60000}`
}

function convertToC(temp){
    return `Gradi in fahrenheit: ${(temp -32.0) * 5.0 / 9.0} F°`
} 


function timezoneInput(hour, min)
{
    let diffNY = hour - 6, c = 24 - hour, diffTokyo = hour + 7
    let resultnY = (hour + c + diffNY) % 24
    let resultTokyo = (hour + c + diffTokyo) % 24
    if(hour <= 23 && min <= 59)
    {
        return `A new york sono le ${resultnY}:${min} A tokyo sono le ${resultTokyo}:${min}`
    }
    else{
        return "Scelta sbagliata!"
    }
}


