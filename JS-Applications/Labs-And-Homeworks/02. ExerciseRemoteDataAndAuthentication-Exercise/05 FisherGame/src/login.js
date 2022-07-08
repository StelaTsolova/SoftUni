document.querySelector('form').addEventListener('submit', onSubmit);

async function onSubmit(e) {
    e.preventDefault();
    const formData = new FormData(e.currentTarget);

    const url = 'http://localhost:3030/users/login';
    const email = formData.get('email');
    const password = formData.get('password');

    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            email,
            password
        })
    });
    if (response.status != 200) {
        alert('Invalid password or email.');
        return;
    }

    const data = await response.json();

    const userData = {
        id: data._id,
        email,
        accessToken: data.accessToken
    }
    localStorage.setItem('userData', JSON.stringify(userData));
    window.location = './index.html';
}