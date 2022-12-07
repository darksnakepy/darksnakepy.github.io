let diameter = 100


function setup()
{
    createCanvas(600, 300)
}

function draw()
{
    background(0, 255, 0)

    strokeWeight(3)
    fill(255,117,20)
    circle(350, 100, diameter)

    strokeWeight(3)
    fill(255,117,20)
    circle(350, 200, diameter)
    
    strokeWeight(3)
    fill(255,117,20)
    circle(250, 100, diameter)

    strokeWeight(3)
    fill(255,117,20)
    circle(250, 200, diameter)

    strokeWeight(3)
    fill(255,0,0)
    circle(width/2, height/2, 100)


    strokeWeight(3)
    fill(255,117,20)
    circle(550, 100, diameter)

    strokeWeight(3)
    fill(255,117,20)
    circle(550, 200, diameter)

    strokeWeight(3)
    fill(255,0,0)
    circle(600, height/2, diameter)

    strokeWeight(3)
    fill(255,117,20)
    circle(50, 100, diameter)

    strokeWeight(3)
    fill(255,117,20)
    circle(50, 200, diameter)

    strokeWeight(3)
    fill(255,0,0)
    circle(0, height/2, diameter)
   
}