let width = 600
let height = 300
let diametro = 110
let raggio = diametro/2

function setup() {
    createCanvas(width, height)
}

function draw() {
    background(0,255,0)
    flower(0, height/2, diametro)
    flower(width / 2, height/2, diametro)
    flower(width, height/2, diametro)
}

function flower(x, y, d) {
    strokeWeight(3)
    stroke("black")
    fill(255,117,20)
    circle(x-raggio, y+raggio, d)

    strokeWeight(3)
    stroke("black")
    fill(255,117,20)
    circle(x+raggio, y+raggio, d)

    strokeWeight(3)
    stroke("black")
    fill(255,117,20)
    circle(x-raggio, y-raggio, d)

    strokeWeight(3)
    stroke("black")
    fill(255,117,20)
    circle(x+raggio, y-raggio, d)

    strokeWeight(3)
    stroke("black")
    fill(255,0,0)
    circle(x, height/2, diametro)
}