function convertBinary(num) {
	if (num === 0) {
		return ""	
	} 
	else {
		return convertBinary(Math.floor(num / 2)) + (num % 2).toString()
	}
}

document.querySelector("#converter").addEventListener("change", (e)=>{
	document.querySelector(".number-output").innerHTML = convertBinary(parseInt(e.currentTarget.value))
})

	