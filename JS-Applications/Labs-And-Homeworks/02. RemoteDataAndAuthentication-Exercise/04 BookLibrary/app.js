const url = 'http://localhost:3030/jsonstore/collections/books/';
const tbodyElement = document.querySelector('body tbody');
const formElement = document.querySelector('form');
const formButton = formElement.querySelector('button');

loadBooks();

document.getElementById('loadBooks').addEventListener('click', loadBooks);
tbodyElement.addEventListener('click', onTableClick);
formElement.addEventListener('submit', onSubmit)

async function loadBooks() {
    tbodyElement.innerHTML = '';

    const response = await fetch(url);
    const data = await response.json();
    Object.entries(data)
        .map(([key, value]) => getTrElement(key, value))
        .forEach(e => tbodyElement.appendChild(e));
}

function onTableClick(e){
    if (e.target.textContent == 'Edit') {
        onEdit(e);
    } else if (e.target.textContent == 'Delete') {
         deleteBook(e);
    }
}

async function createBook() {
    const formData = getFormData();

    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            author: formData.author,
            title: formData.title
        })
    });
    const data = await response.json();

    tbodyElement.appendChild(getTrElement(data.key, data.values));
}

function onSubmit(e){
    e.preventDefault();

    const button = e.target.querySelector('button');
    if (button.textContent == 'Save') {
        updateBook()
    } else if (button.textContent == 'Submit') {
        createBook();
    }
};

const h3Element = formElement.querySelector('h3');
const inputTitle = formElement.querySelector('[name="title"]');
const inputAuthor = formElement.querySelector('[name="author"]');
let id;

async function onEdit(e) {
    h3Element.textContent = 'Edit FORM';
    formButton.textContent = 'Save';

    id = e.target.dataset.id;

    const response = await fetch(url + id);
    const data = await response.json();

    inputTitle.value = data.title;
    inputAuthor.value = data.author;
}

async function updateBook() {
    const formData = getFormData();

    await fetch(url + id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            author: formData.author,
            title: formData.title
        })
    });

    h3Element.textContent = 'FORM';
    inputTitle.value = '';
    inputAuthor.value = '';
    formButton.textContent = 'Submit';

    loadBooks();
}

function deleteBook(e) {
    const id = e.target.dataset.id;

    fetch(url + id, {
        method: 'delete'
    });

    e.target.parentNode.parentNode.remove();
}

function getTrElement(key, value) {
    const trElement = document.createElement('tr');

    const tdTitleElement = document.createElement('td');
    tdTitleElement.textContent = value.title;
    trElement.appendChild(tdTitleElement);

    const tdAuthorElement = document.createElement('td');
    tdAuthorElement.textContent = value.author;
    trElement.appendChild(tdAuthorElement);

    const tdButtonsElement = document.createElement('td');

    const editButton = document.createElement('button');
    editButton.setAttribute('data-id', key);
    editButton.textContent = 'Edit';
    tdButtonsElement.appendChild(editButton);

    const deleteButton = document.createElement('button');
    deleteButton.setAttribute('data-id', key);
    deleteButton.textContent = 'Delete';
    tdButtonsElement.appendChild(deleteButton);

    trElement.appendChild(tdButtonsElement);

    return trElement;
}

function getFormData() {
    const formData = new FormData(formElement);
    const title = formData.get('title');
    const author = formData.get('author');

    if (!title || !author) {
        alert('All fields are required');
        return;
    }

    return { title, author };
}