const phonebookElement = document.getElementById('phonebook');

function attachEvents() {
    loadContacts();

    btnLoad.addEventListener('click', loadContacts);
    phonebookElement.addEventListener('click', onDelete);
    document.getElementById('btnCreate').addEventListener('click', onCreate);
}

attachEvents();

async function loadContacts() {
    const url = 'http://localhost:3030/jsonstore/phonebook';

    const response = await fetch(url);
    const data = await response.json();

    phonebookElement.replaceChildren(...Object.values(data).map(createLiElement));
}

function createLiElement(data) {
    let liElement = document.createElement('li');
    liElement.innerHTML = `${data.person}: ${data.phone}`;

    let buttonElement = document.createElement('button');
    buttonElement.textContent = 'Delete';
    buttonElement.setAttribute('data-id', data._id);
    liElement.appendChild(buttonElement);

    return liElement;
}

async function onDelete(e) {
    const id = e.target.dataset.id;

    if (id) {
        await deleteContact(id);
        e.target.parentNode.remove();
    }
}

async function deleteContact(id) {
    const url = 'http://localhost:3030/jsonstore/phonebook/' + id;

    await fetch(url, {
        method: 'delete'
    });
}

async function onCreate() {
    const personElement = document.getElementById('person');
    const phoneElement = document.getElementById('phone');

    const data = await createContact({ person: personElement.value, phone: phoneElement.value });

    const liElement = createLiElement(data);
    phonebookElement.appendChild(liElement);

    personElement.value = '';
    phoneElement.value = '';
}

async function createContact(data) {
    const url = 'http://localhost:3030/jsonstore/phonebook';

    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const result = await response.json();

    return result;
}