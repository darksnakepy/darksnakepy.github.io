let width = 600
let height = 300
let offset = 5
let diametro = 50;
let raggio = diametro/2;
let y = 300;
let x = diametro;

function setup() {
    createCanvas(width, height)
}

function draw() {
    background(0,253,0)
    flower(x, y/2, diametro)
    if(x < diametro)
    {
        offset = Math.abs(offset)
    }
    else if(x > width - diametro){
        offset *= -1
    }
    x += offset
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