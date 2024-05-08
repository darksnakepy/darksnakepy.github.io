async function fetchUsers(){
    let users = ""
    const req = await fetch("./users.php")
    const data = await req.json()
    console.log(data)
    
    data.payload.forEach(el =>{
        users += `<div>${el.name}</div>`
    })

    document.querySelector("body").innerHTML = users
}

fetchUsers()