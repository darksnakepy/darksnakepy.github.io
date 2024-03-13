async function fetchUsers(){
    let users = ""
    const req = await fetch("./users.php")
    const data = await req.json()
    console.log(data)
    data.payload.forEach(el =>{
        users += `<li>${el.name}</li>`
    })

    document.querySelector("body").innerHTML = users
}

fetchUsers()