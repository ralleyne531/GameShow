const postContainer = document.querySelectorAll(".card-container");

function flipCard(card) {
    card.classList.toggle("flipped");
}
const loadCard = () => {

    const card = document.createElement('div');
    card.classList.add("card");
    card.onclick = () => {
        flipCard(card)
    };
    card.innerHTML = `
        <div class="card-content front">Front</div>
        <div class="card-content back">Back</div>`;
    postContainer.forEach(container =>{
        container.appendChild(card)
    });

}

for (let i = 0; i < 10; i++){
    loadCard(i);
}
