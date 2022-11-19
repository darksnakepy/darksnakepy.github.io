let angle = 0 
let ampiezza = 100
let frequenza = 1
let fase = 0

let inputAmpiezza = document.querySelector("[name=ampiezza]")
let inputFrequenza = document.querySelector("[name=frequenza]")
let inputFase = document.querySelector("[name=fase]")

function setup() 
{
  createCanvas(window.innerWidth, 400)
  background(220)
  angleMode(DEGREES)
  line(0,200,900,200)
}

function draw() 
{
    strokeWeight(3)
    stroke(0, 0, 255)
    let y2 = ampiezza * cos(frequenza * angle + fase)
    point(angle, y2 + 200)
    strokeWeight(3)
    stroke(255, 0, 0)
    let y = ampiezza * sin(frequenza * angle + fase)
    point(angle, y + 200)
    angle += 1
    if (angle > window.innerWidth){
        background(220) 
        line(0,200,900, )
        angle=0
    }
}

inputAmpiezza.addEventListener("input", function(e){
    e.preventDefault()
    let value = parseInt(inputAmpiezza.value)
    ampiezza = value
})

inputFrequenza.addEventListener("input", function(e){
    e.preventDefault()
    let value = parseInt(inputFrequenza.value)
    frequenza = value
})

inputFase.addEventListener("input", function(e){
    e.preventDefault()
    let valuefase = parseInt(inputFase.value)
    fase = valuefase
})
