let listener = document.querySelector("#formGiorni")
listener.addEventListener("submit", function(e) {
    e.preventDefault()
    let inputMonth = document.querySelector("#user_input").value
    let output = document.querySelector("#output")
    output.innerHTML = getMonthDays(inputMonth)
})

let voti = document.querySelector("#formVoti")
voti.addEventListener("submit", function(e) {
    e.preventDefault()
    let inputVoti = document.querySelector("#inputvoti").value
    document.querySelector("#outputVoti").innerHTML = getGrade(inputVoti)
})

let convert = document.querySelector("#formConvertToMs")
convert.addEventListener("submit", function(e) {
    e.preventDefault()
    let ore = document.querySelector("#inputOre").value
    let minuti = document.querySelector("#inputMinuti").value
    document.querySelector("#outputMs").innerHTML = convertToMS(parseInt(ore), parseInt(minuti))
})
