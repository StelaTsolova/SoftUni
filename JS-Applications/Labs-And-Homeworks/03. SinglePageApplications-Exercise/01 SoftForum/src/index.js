const url = 'http://localhost:3030/jsonstore/collections/myboard/posts';
let topicTitlesElement;

window.addEventListener('load', () => {
    topicTitlesElement = document.querySelector('.topic-title');
    topicTitlesElement.addEventListener('click', (e) => {
        if (e.target.tagName == 'H2') {
            e.preventDefault();

            localStorage["postInfo"] = JSON.stringify({
                id: e.target.dataset.id,
                time: e.target.parentElement.parentElement.querySelector('time').textContent
            });

            window.location = 'theme-content.html';
        }})

    loadTopics();

    document.querySelector('form').addEventListener('submit', onSubmit);
});

function loadTopics() {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            let fragmet = document.createDocumentFragment();
            Object.values(data).map(createTopicContainer).forEach(c => fragmet.appendChild(c));

            topicTitlesElement.replaceChildren(fragmet);
        });
}

function onSubmit(e) {
    e.preventDefault();

    const textContentBtn = e.submitter.textContent;

    if (textContentBtn == 'Post') {
        createPost(e.target);
    } else if (textContentBtn == 'Cancel') {
        cleanFields(e.target);
    }
}

async function createPost(formElement) {
    const formData = new FormData(formElement);
    const topicName = formData.get('topicName').trim();
    const username = formData.get('username').trim();
    const postText = formData.get('postText').trim();

    if (topicName == '' || username == '' || postText == '') {
        alert('All fields are required.');
        return;
    }

    cleanFields(formElement);

    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            topicName,
            username,
            postText
        })
    });
    const data = await response.json();

    topicTitlesElement.appendChild(createTopicContainer(data))
}

function cleanFields(formElement) {
    formElement.reset();
}

// function distributeData(data){
//     if (topicTitles.includes(data.topicName)) {
//         topicTitlesElement.querySelector(`[data-${data.topicName}]`).appendChild(createColumn(data));
//     } else {
//         topicTitles.push(data.topicName);
//         topicTitlesElement.appendChild(createTopicContainer(data));
//     }
// }

function createTopicContainer(data) {
    let dateTime = getTimeNow();

    let divElement = document.createElement('div');
    divElement.classList.add('topic-container');

    divElement.innerHTML = `
    <div class="topic-name-wrapper">
        <div class="topic-name">
            <a href="theme-content.html" class="normal">
                <h2 data-id="${data._id}">${data.topicName}</h2>
            </a>
            <div class="columns">
            <div>
            <p>Date: <time>${dateTime}</time></p>
            <div class="nick-name">
                <p>Username: <span>${data.username}</span></p>
            </div>
        </div>
            </div>
        </div>
    </div>`

    return divElement;
}

 function getTimeNow() {
    let today = new Date();
    let date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
    let time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    let dateTime = date + ' ' + time;

    return dateTime;
}