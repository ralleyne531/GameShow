let min = 0;
let max = 10;
let user = document.getElementById('guess');
let minRange = document.getElementById('min')
let maxRange = document.getElementById('max');
let hiddenNum;
document.addEventListener('DOMContentLoaded', () => {
    user.setAttribute('min', min.toString());
    user.setAttribute('max', max.toString());
    hiddenNum = Math.floor(Math.random() * max + min);
    
    minRange.addEventListener(('change'), () => {
        user.setAttribute('min', minRange.value);
        min = parseInt(minRange.value)
        hiddenNum = Math.floor(Math.random() * max + min);
    });
    maxRange.addEventListener(('change'), () => {
        user.setAttribute('max', maxRange.value);
        max = parseInt(minRange.value)
        hiddenNum = Math.floor(Math.random() * max + min);
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
        hiddenNum = Math.floor(Math.random() * max + min);
        alert("CONGRATS YOU GUESSED THE NUMBER");
    }
    
    user.setAttribute('value', guess.toString())
    user.setAttribute('placeholder', guess.toString())
});

document.getElementById('up').addEventListener('click',() => {
    let oldGuess = parseInt(user.value);
    let newGuess = oldGuess + 1;
    user.setAttribute('value', newGuess.toString())
    user.setAttribute('placeholder', newGuess.toString())

});

document.getElementById('down').addEventListener('click',() => {
    let oldGuess = parseInt(user.value);
    let newGuess = oldGuess - 1;
    user.setAttribute('value', newGuess.toString())
    user.setAttribute('placeholder', newGuess.toString())

});

