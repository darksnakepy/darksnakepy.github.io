let btn = document.querySelector(".load-joke")
let copyBtn = document.querySelector("copy")
let genre = document.querySelector(".category-selector").value
let data = ""
let joke = document.querySelector(".joke")
let joke_container = document.querySelector(".joke-container")

btn?.addEventListener("click", async (e)=>{
    console.log(genre.value)
    e.preventDefault()
    let url = `https://api.chucknorris.io/jokes/random?category=${genre.toLowerCase()}`

    await fetch(url)
        .then(data => {            
            data = data.json()
        })
        .then(jokegen =>{
            if(jokegen.value == undefined){
                joke_container.innerHTML = "A"
            }

            joke_container.innerHTML = data.value     
        })
        .catch(err => {
            joke_container.innerHTML = "Error"
        })
})


/*copyBtn.addEventListener("click", async ()=>{
    await navigator.clipboard.writeText(joke_container);
})
*/