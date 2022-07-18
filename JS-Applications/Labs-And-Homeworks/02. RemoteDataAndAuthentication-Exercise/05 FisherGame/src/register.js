document.querySelector('form').addEventListener('submit', onSubmit);

async function onSubmit(e) {
    e.preventDefault();
    const formData = new FormData(e.currentTarget);

    const email = formData.get('email');
    const password = formData.get('password');
    const repeatPassword = formData.get('rePass');
    const url = 'http://localhost:3030/users/register';

    if (!email || !password || !repeatPassword) {
        alert('All fields are required.');
        return;
    }
    if (password !== repeatPassword) {
        alert('Password and Repeat must be the same.');
        return;
    }

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
        alert('This email already exist.');
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