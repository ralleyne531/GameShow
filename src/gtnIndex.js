const min = 0;
const max = 10;
let user = document.getElementById('guess');
let minRange = document.getElementById('min')
let maxRange = document.getElementById('max');
let hiddenNum;
document.addEventListener('DOMContentLoaded', () => {
    user.setAttribute('min', min.toString());
    user.setAttribute('max', max.toString());
    minRange.addEventListener(('change'), () => {
        user.setAttribute('min', minRange.value);
    });
    maxRange.addEventListener(('change'), () => {
        user.setAttribute('max', maxRange.value);
    });
    
    hiddenNum = Math.floor(Math.random() * max);
});

document.getElementById('submit').addEventListener('click',e =>{
    e.preventDefault();
    let guess = document.getElementById('guess').value;
    console.log(guess, hiddenNum)
    switch(guess){
        case guess < hiddenNum:
            alert("Sorry Chief, that aint it, too low, try again");
            break;
        case guess > hiddenNum:
            alert("Sorry Chief, that aint it, too high try again");
            break;
        case guess === hiddenNum:
            hiddenNum = Math.floor(Math.random() * max);
            alert("CONGRATS YOU GUESSED THE NUMBER");
            break;
        default:
            break;
    }
})

document.getElementById('up').addEventListener('click',() => {
    let oldGuess = user.value;
    let newGuess = parseInt(oldGuess) + 1;
    user.setAttribute('value', newGuess.toString())

});

document.getElementById('down').addEventListener('click',() => {
    let oldGuess = user.value;
    let newGuess = parseInt(oldGuess) - 1;
    user.setAttribute('value', newGuess.toString())

});

