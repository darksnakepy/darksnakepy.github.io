
let sizer = document.querySelector("[name=size]")

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
    y=0 // reset del canvas per la x e la y
    x=0
})
