
let sizer = document.querySelector("#size")


let width = 600
let height = 600

let size = 20

let x = 0
let y = 0


function setup() {
    createCanvas(width, height)
    background(0) 
}

function draw() {
    stroke("white")

    if(random() < 0.5){
        line(x, y, x + size, y + size)
    }
    
    else{
        line(x, y + size, x + size, y)
    }

    x += size

    if(x >= width){
        x = 0 
        y += size
    }
}

sizer.addEventListener("input", function(e){
    e.preventDefault()
    let value = parseInt(sizer.value)
    background(0)
    size = value
    y=0
    x=0
})









/*function setup() {
    createCanvas(400, 400);
    tileSize = 50;
  }
  
  // Draw the Truchet tiles
  function draw() {
    background(255);
    strokeWeight(2);
    stroke(0);
    
    // Draw a grid of tiles
    for (let i = 0; i < width; i += tileSize) {
      for (let j = 0; j < height; j += tileSize) {
        // Determine the direction of the diagonal lines based on the position of the tile
        if ((i / tileSize + j / tileSize) % 2 === 0) {
          line(i, j, i + tileSize, j + tileSize);
          line(i + tileSize, j, i, j + tileSize);
        } else {
          line(i, j + tileSize, i + tileSize, j);
          line(i + tileSize, j + tileSize, i, j);
        }
      }
    }
  }

*/