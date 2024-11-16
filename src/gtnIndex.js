const min = 0;
const max = 10;
let user = document.getElementById('guess');
let minRange = document.getElementById('min')
let maxRange = document.getElementById('max');

document.addEventListener('DOMContentLoaded', () => {
    user.setAttribute('min', min.toString());
    user.setAttribute('max', max.toString());
    minRange.addEventListener(('change'), () => {
        user.setAttribute('min', minRange.value);
    });
    maxRange.addEventListener(('change'), () => {
        user.setAttribute('max', maxRange.value);
    });
});

document.getElementById('submit').addEventListener('click',()=>{
    let guess = document.getElementById('guess').value;
    console.log(guess)
    document.body.appendChild(document.createElement('h1'));
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

