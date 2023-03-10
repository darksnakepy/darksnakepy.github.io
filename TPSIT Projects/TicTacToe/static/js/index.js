const cells = document.querySelectorAll('.square')
let currentPlayer = 'X'
let gameOver = false
const arrays = [
    [null],[null],[null]
    [null],[null],[null]
    [null],[null],[null]
]

const result = document.getElementById('result')
let restartBtn = document.getElementById('restart-btn')
const scoreX = document.getElementById('score-x')
const scoreO = document.getElementById('score-o')

let xScore = 0
let oScore = 0

function checkForWin() {
    for (let i = 0; i < 3; i++) {
        if (arrays[i][0] === arrays[i][1] && arrays[i][1] === arrays[i][2]) {
            return arrays[i][0]
        }
    }

    for (let i = 0; i < 3; i++) {
        if (arrays[0][i] === arrays[1][i] && arrays[1][i] === arrays[2][i]) {
            return arrays[0][i]  
        }
    }
    
    if (arrays[0][0] === arrays[1][1] && arrays[1][1] === arrays[2][2]) {
        return arrays[0][0]
    }
    if (arrays[0][2] === arrays[1][1] && arrays[1][1] === arrays[2][0]) {
        return arrays[0][2]
    }
}

function checkForTie() {
    let openSquares = 0
    for (let i = 0; i < cells.length; i++) {
        if (cells[i].textContent === '') {
            openSquares++
        }
    }
    if (openSquares === 0 && !gameOver) {
        result.textContent = 'Tie'
        gameOver = true
    }
}
function switchPlayer() {
    if (currentPlayer === 'X') {
        currentPlayer = 'O'
    } else {
        currentPlayer = 'X'
    }
}

restartBtn.addEventListener('click', function() {
    for (let i = 0; i < cells.length; i++) {
        cells[i].textContent = ''
    }
    xScore++
    result.textContent = ''
    gameOver = false
    currentPlayer = 'X'
})