let data = []
let button = document.querySelector(".submit")


button.addEventListener("click", (e)=>{
    e.preventDefault()
    let name = document.querySelector("#name").value 
    let last_name = document.querySelector("#last-name").value
    let age = document.querySelector("#age").value
    let gender = document.querySelector("#gender").value

    let users = {
        "name" : name,
        "last-name" : last_name,
        "age": age,
        "gender": gender
    }

    data.push(users)

    data.forEach(user=>{
        document.querySelector(".display").innerHTML += JSON.stringify(user) + "<br/>"
    })
})
