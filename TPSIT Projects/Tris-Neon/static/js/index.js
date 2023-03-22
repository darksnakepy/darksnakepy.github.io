let th = document.querySelectorAll("th")

let grid = [
            [null, null, null],
            [null, null, null],
            [null, null, null]
           ]

let xWins = 0
let oWins = 0

let matchWinner = false
let is_bot_playing = true
let difficulty = "easy"
let x_written = false
let value = null
let counter = 0


function checker(grid) {
    for (let i = 0; i < 3; i++) {
        if (grid[i][0] === grid[i][1] && grid[i][1] === grid[i][2]) {
            return grid[i][0]
        }
    }

    for (let i = 0; i < 3; i++) {
        if (grid[0][i] === grid[1][i] && grid[1][i] === grid[2][i]) {
            return grid[0][i]
        }
    }
    
    if (grid[0][0] === grid[1][1] && grid[1][1] === grid[2][2]) {
        return grid[0][0]
    }
    if (grid[0][2] === grid[1][1] && grid[1][1] === grid[2][0]) {
        return grid[0][2]
    }
}

function reset() {
    th.forEach(th => th.innerHTML = "")
    grid = [
        [null, null, null],  
        [null, null, null],  
        [null, null, null]  
    ]
    matchWinner = false
    document.querySelector(".winner").style.display = "none"

    x_written = false;
    value = null;
    counter = 0
}

function getEmptyCells(grid){
    let emptyCells = []
    for(let i = 0; i<3; i++){
        for(let j = 0; j<3; j++){
            if(grid[i][j] === ""){
                emptyCells.push([i, j])
            }
        }
    }
    return emptyCells
}


function gameSession(){
    th.forEach(th=>th.addEventListener("click", ()=>{
        if(!matchWinner){
            if (th.textContent == "") {
                if(!is_bot_playing){
                    if (!x_written) {
                        value = "X"
                        th.innerHTML = value            
                        x_written = true
                    } else {
                        value = "O"
                        th.innerHTML = value
                        x_written = false
                        counter++
                    }
            }else{
                value = "X"
                th.innerHTML = value
                grid[th.parentNode.getAttribute("row")][th.getAttribute("cell")] = value           
                counter++
                switch(difficulty){
                    case "easy":
                        let found = false
                        for(let i = 0; i<grid.length; i++){
                            if(!found){
                            for(let j = 0; j < grid[i].length; j++){
                                if(grid[i][j] == null){
                                    found = true
                                    grid[i][j] = "O"
                                    document.querySelector(`[row='${i}'] [cell='${j}']`).innerHTML = "O"
                                    counter++
                                    break
                                }
                            }
                        }
                        else{
                            break
                        }
                    }
                    case "impossible":
                        break
                }
            }
        }
        
    console.log(counter)

    grid[th.parentNode.getAttribute("row")][th.getAttribute("cell")] = value
    
    if (checker(grid) == "X") {
        document.querySelector("#status").style.display = "block"
        document.querySelector(".winner").style.display = "block"
        document.querySelector(".winner").innerHTML = "WINNER: X"
        xWins++
        matchWinner = true
        document.querySelector(".xwins").innerHTML = "X WINS:" + xWins
    } 
    else if (checker(grid) == "O") {
        document.querySelector("#status").style.display = "block"
        document.querySelector(".winner").style.display = "block"
        document.querySelector(".winner").innerHTML = "WINNER: O"
        oWins++
        matchWinner = true
        document.querySelector(".owins").innerHTML = "O WINS:" + oWins
    } 

    else if (counter == 9) {
        document.querySelector("#status").style.display = "block"
        document.querySelector(".winner").style.display = "block"
        document.querySelector(".winner").innerHTML = "Draw"
    }
 }
    }))
    
}

gameSession()

