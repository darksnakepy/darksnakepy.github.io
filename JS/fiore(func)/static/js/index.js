let width = 600
let height = 300
let diametro = 50
let raggio = diametro/2
let delta = 5

function setup() {
    createCanvas(600, 300)
}

function draw() {
    background(0,253,0)
    flower(width/2, height/2, diametro)
    if(width < diametro)
    {
        delta = Math.abs(delta);
    }

    if(width > 600 - diametro)
    {
        delta = delta * (-1);
    }

    width = delta + width;
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