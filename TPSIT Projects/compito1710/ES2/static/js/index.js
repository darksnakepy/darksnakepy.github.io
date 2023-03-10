let sizer = document.querySelector("[name=sizeTriangles]")

let width = 600
let height = 600

let x = 0
let y = 0

let size = 50


function setup() 
{
  createCanvas(width, height)
  background(220)  
}

function draw() {

  noStroke()

  if(random() <= 0.5){

    fill(255, 255, 255)
    square(x, y, size)
    fill(0)
    triangle(x + size/2, y + size/2 , x + size/2, y + size, x + size, y + size/2);
  }
  else{
    fill(0)
    square(x, y, size)
    fill(255, 255, 255)
    triangle(x + size/2, y + size/2 , x + size/2, y + size, x + size, y + size);
  }

  x+=size
  if(x>=width){
    x = 0
    y+=size
  }
}

sizer.addEventListener("input", function(e){
  e.preventDefault()
  let value = parseInt(sizer.value)
  background(255, 255, 255)
  size = value
  x=0
  y=0
})