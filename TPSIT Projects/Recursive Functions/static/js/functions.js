let nArray = [1, 2, 3, 4, 5]
let min = nArray[0]
let max = nArray[0]

function sum(number){
    let sum = 0
    for(let i = 0; i < number; i++){
        sum += i+1
    }
    return sum;
}

function recursiveSum(number){
    if (number==1){
        return 1
    }
    else{
        return number + recursiveSum(number-1)
    }
}

function sumArray(){
    let sum = 0
    let array = [1, 2, 3, 4, 5]
    for(let i = 0; i < array.length; i++)
    {
        sum+=array[i];
    }
    return sum;
}

function recursiveArray(arr, n){
    if (n <= 0) {
        return 0;
    }
    else{
        return arr[n - 1] + recursiveArray(arr, n - 1)
    }
}



/*function SortingArrays(){
    let numbersArr = [1, 18, 22, 10, 5, 9, 12] 
    for(let i = 0; i < numbersArr.length; i++){  
        for (let j = i + 1; j < numbersArr.length; j++)
        {
            if (numbersArr[i] > numbersArr[j])
            {
                let temp = numbersArr[i]
                numbersArr[i] = numbersArr[j]
                numbersArr[j] = temp
            }
        }  
    }
    console.log(numbersArr) // sorting arrays from smallest to largest
}
SortingArrays()

*/

function biggest(){
    let max = nArray[0]

    for (let i = 0; i < nArray.length; i++){
		if (nArray[i] > max){
			max = nArray[i];
		}
	}
    console.log(max)
}

function smallest(){
    for (let i = 0; i < nArray.length; i++){
		if (nArray[i] < min){
			min = nArray[i]
		}
	}
    console.log(min)
}

function recursiveBiggest(arr,n){
    if(n==0){
        return 0;
    }
    else{
        if (arr[n] > max){
			max = arr[n]
		}   
        return recursiveBiggest(arr, n-1)                   
    }
}

function recursiveSmallest(arr,n){
    if(n==0){
        return 0;
    }
    else{
        if (arr[n] < min){
			min = arr[n]
		}   
        return recursiveSmallest(arr, n-1)                   
    }
}

console.log(sum(100))
console.log(recursiveSum(100)) // recursive sum
console.log(recursiveArray(nArray, nArray.length))  // sum of array (recursive method)
biggest()
smallest()
console.log(recursiveBiggest(nArray, nArray.length))
console.log(recursiveSmallest(nArray,nArray.length))