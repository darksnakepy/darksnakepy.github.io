let listener = document.querySelector("#formGiorni")

listener.addEventListener("submit", function(e) {
    e.preventDefault()
    let inputMonth = document.querySelector("#user_input")
    let output = document.querySelector("#output")
    output.innerHTML = getMonthDays(inputMonth)
})


let voti = document.querySelector("#formVoti")
voti.addEventListener("submit", function(e) {
    e.preventDefault()
    let inputVoti = document.querySelector("#inputvoti").value
    document.querySelector("#outputVoti").innerHTML = getGrade(inputVoti)
})

let convertToMillisecs = document.querySelector("#formConvert")
convertToMillisecs.addEventListener("submit", function(f) {
    f.preventDefault()
    let inputOre = document.querySelector("#inputOre").value
    let inputMinuti = document.querySelector("#inputMinuti").value
    document.querySelector("#outputMs").innerHTML = convertToMS(inputOre, inputMinuti)
})


let convertToF = document.querySelector("#formDegrees")
convertToF.addEventListener("submit", function(f) {
    f.preventDefault()
    let inputGradi = document.querySelector("#inputGradi").value

    document.querySelector("#outputGradi").innerHTML = convertToC(inputGradi)
})

let timezone = document.querySelector("#formTimezone")
timezone.addEventListener("submit", function(f) {
    f.preventDefault()
    let hour = document.querySelector("#inputhours").value
    let min = document.querySelector("#inputmins").value
    document.querySelector("#outputTimezone").innerHTML = timezoneInput(hour, min)
})