document.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll(".card-container").forEach(card => { 
        card.addEventListener("click", () => {
            card.classList.toggle("flipped");
        });
    });
    document.getElementById('shuffle').click();
});

const hierarchy = ['1','2','3','4','5','6','7','8','9','T','J','Q','K'];
const suits = ['c','d','h','s']
let userRank = null;
let cpuRank = null;
let alertBox = document.getElementById('alert');

const generateCard = () => {
    return `${hierarchy[Math.floor(Math.random() * hierarchy.length)]}${suits[Math.floor(Math.random() * suits.length)]}`
}

const updateRanks = () => {
    const userCard = document.getElementById('usr').getAttribute('cid');
    const cpuCard = document.getElementById('cpu').getAttribute('cid');
    userRank = hierarchy.indexOf(userCard?.charAt(0)); // Extract rank from '9s' -> '9'
    cpuRank = hierarchy.indexOf(cpuCard?.charAt(0));
};

let incrementScore = (player) => {
    let oldGuess = parseInt(player.innerText);
    player.innerHTML = oldGuess + 1;
}

let alert = (message) => {
    alertBox.innerHTML = message;
    alertBox.style.visibility = "visible";
    
    setTimeout(()=>{
        alertBox.style.visibility = "hidden"
    }, 1500)
    
}

document.getElementById("shuffle").addEventListener("click", function () {

    const cards = document.querySelectorAll(".card-container");
    cards.forEach(card =>{ card.classList.toggle("flipped");})

    Array.from(document.querySelectorAll("playing-card"))
    .filter(card => card.getAttribute('cid') !== '0')
    .forEach(pcard => {
        pcard.setAttribute('cid',generateCard());
    });

    // Move the cards in opposite directions
    cards[0].style.transform = "translateX(-40vw)";
    cards[1].style.transform = "translateX(40vw)";

    // Add smooth transition
    cards.forEach(card => (card.style.transition = "transform 0.5s ease"));
    // Reset position after 1.5 seconds (same as transition duration)
    setTimeout(() => {
        cards[1].classList.toggle("flipped");
        cards[0].style.transform = "translateX(0)";
        cards[1].style.transform = "translateX(0)";

        updateRanks();
    }, 1000);
});

document.getElementById('higher').addEventListener("click", () => {
    let card = document.getElementById("user");
    card.click();
    
    setTimeout(() => {
        if (userRank !== null && cpuRank !== null) {
            if(userRank === cpuRank){
            alert("Tie.");
            }
            else if (userRank > cpuRank) {
            alert("User guessed correctly: Higher!");
            incrementScore(document.getElementById('userNum'))

            } else {
            alert("User guessed incorrectly: CPU card was higher!");
            incrementScore(document.getElementById('cpuNum'))
            }
        }
        document.getElementById('shuffle').click();
    }, 1500)
    
});

document.getElementById('lower').addEventListener("click", () => {
    let card = document.getElementById("user");
    card.click();
    
    setTimeout(() => {
        if (userRank !== null && cpuRank !== null) {
            if(userRank === cpuRank){
                alert("Tie.");
            }
            else if (userRank < cpuRank) {
                alert("User guessed correctly: Lower!");
                incrementScore(document.getElementById('userNum'))
            } else {
                alert("User guessed incorrectly: CPU card was lower!");
                incrementScore(document.getElementById('cpuNum'))
            }
        }
        document.getElementById('shuffle').click();
    }, 1500)
    
});