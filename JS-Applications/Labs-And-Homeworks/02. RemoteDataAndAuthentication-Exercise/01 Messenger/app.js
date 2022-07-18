function attachEvents() {
    loadMessages();

    document.querySelector('#refresh').addEventListener('click', loadMessages);
    document.querySelector('#submit').addEventListener('click', onSubmit);
}

attachEvents();

const authorElement = document.querySelector('[name="author"]');
const contentElement = document.querySelector('[name="content"]');
const listElement = document.getElementById('messages');

async function onSubmit() {
    const author = authorElement.value;
    const content = contentElement.value;

    await createMassage({ author, content });

    listElement.value += `\n${author}: ${content}`;
    contentElement.value = '';
}

async function loadMessages() {
    const url = 'http://localhost:3030/jsonstore/messenger';

    const response = await fetch(url);
    const data = await response.json();

    listElement.value = Object.values(data).map(d => `${d.author}: ${d.content}`).join('\n');
}

async function createMassage(massage) {
    const url = 'http://localhost:3030/jsonstore/messenger';

    await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(massage)
    });
}