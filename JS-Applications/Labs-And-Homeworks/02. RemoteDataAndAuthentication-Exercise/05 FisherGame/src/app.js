const url = 'http://localhost:3030/data/catches/';
let userData = localStorage.userData;

window.addEventListener('load', () => {
    if (userData != null) {
        userData = JSON.parse(localStorage.userData);

        document.getElementById('guest').style.display = 'none';
        document.querySelector('.email span').textContent = userData.email;
        document.querySelector('.add').disabled = false;
    } else {
        document.getElementById('home').style.display = 'none';
    }
    loadData();

    document.querySelector('.load').addEventListener('click', loadData);
    document.getElementById('catches').addEventListener('click', onClick);
    document.getElementById('addForm').addEventListener('submit', onSubmit);
    document.getElementById('logout').addEventListener('click', () => {
        localStorage.clear();
        window.location = './index.html';
    })
});

async function loadData() {
    const response = await fetch(url);
    const data = await response.json();

    document.getElementById('catches').replaceChildren(...data.map(createCatch));
}

function createCatch(info) {
    const isOwner = (userData && userData.id == info._ownerId);

    let div = document.createElement('div');
    div.className = 'catch';

    div.innerHTML = `<label>Angler</label>
            <input type="text" class="angler" value="${info.angler}" ${isOwner ? '' : 'disabled'}>
            <label>Weight</label>
            <input type="text" class="weight" value="${info.weight}" ${isOwner ? '' : 'disabled'}>
            <label>Species</label>
            <input type="text" class="species" value="${info.species}" ${isOwner ? '' : 'disabled'}>
            <label>Location</label>
            <input type="text" class="location" value="${info.location}" ${isOwner ? '' : 'disabled'}>
            <label>Bait</label>
            <input type="text" class="bait" value="${info.bait}" ${isOwner ? '' : 'disabled'}>
            <label>Capture Time</label>
            <input type="number" class="captureTime" value="${info.captureTime}" ${isOwner ? '' : 'disabled'}>
            <button class="update" data-id="${info._id}" ${isOwner ? '' : 'disabled'}>Update</button>
            <button class="delete" data-id="${info._id}" ${isOwner ? '' : 'disabled'}>Delete</button>`

    return div;
}

function onClick(e) {
    if (e.target.textContent == 'Update') {
        onUpdate(e);
    } else if (e.target.textContent == 'Delete') {
        onDelete(e);
    }
}

function onUpdate(e) {
    const id = e.target.dataset.id;

    const fields = e.target.parentNode.querySelectorAll('input');
    let [angler, weight, species, location, bait, captureTime] = Array.from(fields).map(i => i.value);

    let body = JSON.stringify({
        angler,
        weight,
        species,
        location,
        bait,
        captureTime,
        _id: id
    });

    fetch(url + id, {
        method: "put",
        headers: {
            'Content-Type': 'application/json',
            'X-Authorization': userData.accessToken
        },
        body
    });
}

function onDelete(e) {
    const id = e.target.dataset.id;

    fetch(url + id, {
        method: "DELETE",
        headers: {
            'X-Authorization': userData.accessToken
        }
    });

    e.target.parentNode.remove();
}

async function onSubmit(e) {
    e.preventDefault();

    let info = {};
    const formData = new FormData(e.target);
    for (let field of formData.entries()) {
        info[field[0]] = field[1];
    }

    let body = JSON.stringify({
        angler: info.angler,
        weight: info.weight,
        species: info.species,
        location: info.location,
        bait: info.bait,
        captureTime: info.captureTime,
    });

    const response = await fetch(url, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
            'X-Authorization': userData.accessToken
        },
        body
    });
    if (response.status != 200) {
        alert('Try again');
        return;
    }
    const data = await response.json();

    let catchElement = createCatch(data);
    document.getElementById('catches').appendChild(catchElement);
}