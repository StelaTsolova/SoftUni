import { showView } from "./dom.js";
import { showHome } from "./home.js";

const section = document.getElementById('edit-movie');
section.remove();

section.querySelector('form').addEventListener('submit', onSubmit);

let movieId;
let urlMovies = 'http://localhost:3030/data/movies/';
export async function showEdit(id) {
    movieId = id;

    const response = await fetch(urlMovies + movieId);
    const data = await response.json();

    section.querySelector('[name="title"]').value = data.title;
    section.querySelector('[name="description"]').value = data.description;
    section.querySelector('[name="imageUrl"]').value = data.img;

    showView(section);
}

async function onSubmit(e) {
    e.preventDefault();

    const userData = JSON.parse(localStorage.getItem('userData'));

    const formData = new FormData(e.target);
    const title = formData.get('title').trim();
    const description = formData.get('description').trim();
    const img = formData.get('imageUrl').trim();

    if (title == '' || description == '' || img == '') {
        alert('All fields are required.');
        return;
    }

    await fetch(urlMovies + movieId, {
        method: 'PUT',
        headers: {
            'X-Authorization': userData.token,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            title,
            description,
            img
        })
    });

    showHome();
}