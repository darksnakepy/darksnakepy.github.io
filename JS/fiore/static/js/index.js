let diametro = 100
let y = 100
let raggio = diametro/2

function drawFlower(x, y, d)
{
    strokeWeight(3)
    fill(255,117,20)
    circle(x+raggio, y, d)


    fill(255,117,20)
    circle(x+raggio, y+d, d)
    
    fill(255,117,20)
    circle(x-raggio, y, d)

    fill(255,117,20)
    circle(x-raggio, y+d, d)

    fill(255,0,0)
    circle(width/2, height/2, d)

}

function setup()
{
    createCanvas(600, 300)
}

function draw()
{
    background(0, 255, 0)
    drawFlower(300, y, diametro)
    drawFlower(650, y/2, d)
    drawFlower(0, y/2, d)
}