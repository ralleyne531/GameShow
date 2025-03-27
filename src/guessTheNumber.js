let min = 0;
let max = 10;
let user = document.getElementById('guess');
let minRange = document.getElementById('min')
let maxRange = document.getElementById('max');
let hiddenNum;
let oldGuess;
let newGuess;

document.addEventListener('DOMContentLoaded', () => {
    user.min = min
    user.max = max;
    hiddenNum = Math.floor(Math.random() * (max - min + 1)) + min;
    
    minRange.addEventListener(('change'), () => {
        // user.setAttribute('min', minRange.value);
        min = parseInt(minRange.value);
        user.min = min
        user.value = min
        hiddenNum = Math.floor(Math.random() * (max - min + 1)) + min;
    });
    maxRange.addEventListener(('change'), () => {
        // user.setAttribute('max', maxRange.value);
        max = parseInt(maxRange.value);
        user.max = max
        user.value = min;
        hiddenNum = Math.floor(Math.random() * (max - min + 1)) + min;
    });
    
});

document.getElementById('submit').addEventListener('click', event =>{
    event.preventDefault();
    let guess = parseInt(document.getElementById('guess').value);

    if (guess < hiddenNum) {
        alert("Too low, try again");
    } else if (guess > hiddenNum) {
        alert("Too high, try again");
    } else if (guess === hiddenNum) {
        hiddenNum = Math.floor(Math.random() * (max - min + 1)) + min;
        alert("CONGRATS YOU GUESSED THE NUMBER");
    }
    
    user.value = guess;
});

document.getElementById('right').addEventListener('click',() => {
    oldGuess = parseInt(user.value) || min;
    newGuess = Math.min(oldGuess + 1, max);
    user.value = newGuess

});

document.getElementById('left').addEventListener('click',() => {
    oldGuess = parseInt(user.value) || min;
    newGuess = Math.max(oldGuess - 1, min);
    user.value = newGuess
});

