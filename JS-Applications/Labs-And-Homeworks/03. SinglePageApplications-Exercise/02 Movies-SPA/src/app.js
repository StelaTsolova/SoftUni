import { showHome } from "./home.js";
import { showLogin } from "./login.js";
import { showRegister } from "./register.js";

const navElement = document.querySelector('nav');

showHome();
updateNav();

const links = {
    'homeLink': showHome,
    'logoutBtn': logout,
    'loginLink': showLogin,
    'registerLink': showRegister
}

navElement.addEventListener('click', (e) => {
    if (e.target.tagName == 'A') {
        e.preventDefault();

        const hendler = links[e.target.id];
        hendler();
    }
});

export function updateNav() {
    const userData = JSON.parse(localStorage.getItem('userData'));

    const userButtons = navElement.querySelectorAll('.user');
    const guestButtons = navElement.querySelectorAll('.guest');

    if (userData !== null) {
        navElement.querySelector('#welcome').textContent = `Welcome, ${userData.email}`;
        userButtons.forEach(e => e.style.display = 'block');
        guestButtons.forEach(e => e.style.display = 'none');
    } else {
        userButtons.forEach(e => e.style.display = 'none');
        guestButtons.forEach(e => e.style.display = 'block');
    }
}

function logout() {
    const userData = JSON.parse(localStorage.getItem('userData'));

    fetch('http://localhost:3030/users/logout', {
        method: 'DELETE',
        headers: {
            'X-Authorization': userData.token
        }
    });

    localStorage.clear();
    updateNav();
    showHome();
}