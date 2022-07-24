import { showView } from "./dom.js";
import { showHome } from "./home.js";

const section = document.getElementById('add-movie');
section.remove();

section.querySelector('form').addEventListener('submit', onSubmit);

export function showCreate() {
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

    try {
        const response = await fetch('http://localhost:3030/data/movies', {
            method: 'POST',
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
        if (response.status !== 200) {
            throw new Error(await response.json());
        }

        showHome();
        e.target.reset();
    } catch (err) {
        console.error(err.massage);
    }
}