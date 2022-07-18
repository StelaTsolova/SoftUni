const tabelBody = document.querySelector('#results tbody');
const url = 'http://localhost:3030/jsonstore/collections/students';

function loadStudents() {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            Object.values(data).map(d =>
                `<tr>
          <td>${d.firstName}</td>
          <td>${d.lastName}</td>
          <td>${d.facultyNumber}</td>
          <td>${d.grade}</td>
        </tr>`
            ).forEach(e => tabelBody.innerHTML += e);
        });
};

loadStudents();

document.getElementById('submit').addEventListener('click', () => {
    const formElement = document.getElementById('form');
    const formData = new FormData(formElement);
    onSubmit(formData);
})

async function onSubmit(formData) {
    const firstName = formData.get('firstName');
    const lastName = formData.get('lastName');
    const facultyNumber = formData.get('facultyNumber');
    const grade = formData.get('grade');

    if (!firstName || !lastName || !facultyNumber || !grade) {
        alert('All fields are required');
        return;
    }

    await fetch(url, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify({
            firstName,
            lastName,
            facultyNumber,
            grade
        })
    });
}