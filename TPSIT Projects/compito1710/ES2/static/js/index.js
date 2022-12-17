

let sizer = document.querySelector("[name=size]")

function setup() 
{
  createCanvas(600, 600)
  background(0)
}

function draw() {
    stroke(255, 0 ,0)
    

    
}

inputAmpiezza.addEventListener("input", function(e){
    e.preventDefault()
    let value = parseInt(inputAmpiezza.value)
    ampiezza = value
})
