import { showView } from "./dom.js";
import { showHome } from "./home.js";
import { updateNav } from "./app.js"

const section = document.getElementById('form-sign-up');
section.remove();

section.querySelector('form').addEventListener('submit', onSubmit);

export function showRegister() {
    showView(section);
}

async function onSubmit(e) {
    e.preventDefault();

    const formData = new FormData(e.target);
    const email = formData.get('email').trim();
    const password = formData.get('password').trim();
    const rePassword = formData.get('repeatPassword').trim();

    if (email == '' || password == '' || rePassword == '') {
        alert('All fields are required.');
        return;
    }
    if (password !== rePassword) {
        alert('Password and repat password must be the same.');
        return;
    }

    try {
        const response = await fetch('http://localhost:3030/data/movies', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email,
                password
            })
        });
        const data = await response.json();

        if (response.status != 200) {
            throw new Error(data.message);
        }

        const userData = JSON.stringify({
            token: data.accessToken,
            email: data.email,
            id: data._id
        });

        localStorage.setItem('userData', userData);
        showHome();
        updateNav();
        e.target.reset();
    } catch (err) {
        console.error(err.massage);
    }
}