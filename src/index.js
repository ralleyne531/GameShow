const postContainer = document.querySelector(".card-container");

const loadCards = () => {

    const cards = document.createElement('div');
    cards.classList.add("card");
    cards.innerHTML = "num";
    postContainer.appendChild(cards);

}

loadCards();