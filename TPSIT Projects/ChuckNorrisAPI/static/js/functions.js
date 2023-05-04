let btn = document.querySelector(".load-joke")
let copyBtn = document.querySelector("copy")

let joke = document.querySelector(".joke")
let joke_container = document.querySelector(".joke-container")

btn?.addEventListener("click", async (e)=>{
    e.preventDefault()
    let genre = document.querySelector("select").value
    let url = `https://api.chucknorris.io/jokes/random?category=${genre.toLowerCase()}`

    await fetch(url)
        .then(data => {            
            return data.json()
        })
        .then(jokegen =>{
            if(jokegen.value == undefined){
                joke_container.innerHTML = "A"
                return
            }

            joke_container.innerHTML = jokegen.value     
        })
        .catch(err => {
            console.error(err)
            joke_container.innerHTML = "Error"
        })
})


/*copyBtn.addEventListener("click", async ()=>{
    await navigator.clipboard.writeText(joke_container);
})
*/
