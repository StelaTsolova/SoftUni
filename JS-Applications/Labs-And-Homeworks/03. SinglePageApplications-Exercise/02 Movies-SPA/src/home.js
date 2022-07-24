import { showView } from "./dom.js";
import { showCreate } from "./create.js"
import { showDetails } from "./details.js";

const section = document.getElementById('home-page');
const addBtn = section.querySelector('#createLink');
section.remove();

addBtn.addEventListener('click', (e) => {
    e.preventDefault();
    showCreate();
});

const calatog = section.querySelector('.card-deck.d-flex.justify-content-center');
calatog.addEventListener('click', onClick);

export function showHome() {
    const userData = JSON.parse(localStorage.getItem('userData'));
    userData !== null ? addBtn.style.display = 'inline' : addBtn.style.display = 'none';

    showView(section);
    addMovies();
}

async function addMovies() {
    calatog.innerHTML = '<p>Loading...</p>';

    const response = await fetch('http://localhost:3030/data/movies');
    const data = await response.json();

    calatog.replaceChildren(...data.map(createMovieCard));
}

function onClick(e) {
    e.preventDefault();

    let target = e.target;
    if (target.tagName == 'BUTTON') {
        target = e.target.parentElement;

        const id = target.dataset.id;
        showDetails(id);
    }
}

function createMovieCard(movie) {
    let divElement = document.createElement('div');
    divElement.classList.add('card', 'mb-4');

    divElement.innerHTML = `<img class="card-img-top" src="${movie.img}"
    alt="Card image cap" width="400">
<div class="card-body">
    <h4 class="card-title">${movie.title}</h4>
</div>
<div class="card-footer">
    <a data-id="${movie._id}" href="#">
        <button type="button" class="btn btn-info">Details</button>
    </a>
</div>`

    return divElement;
}