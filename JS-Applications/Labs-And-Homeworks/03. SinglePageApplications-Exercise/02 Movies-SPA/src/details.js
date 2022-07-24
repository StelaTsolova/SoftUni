import { showView } from "./dom.js";
import { showEdit } from "./edit.js";
import { showHome } from "./home.js";

const section = document.getElementById('movie-example');
section.remove();

export async function showDetails(movieId) {
    section.innerHTML = '<p>Loading...</p>';
    section.replaceChildren(await createContainer(movieId));

    showView(section);
}

async function createContainer(movieId) {
    const urlMovies = 'http://localhost:3030/data/movies/';
    const urlLikes = 'http://localhost:3030/data/likes/';

    const requests = [
        fetch(urlMovies + movieId),
        fetch(`http://localhost:3030/data/likes?where=movieId%3D%22${movieId}%22&distinct=_ownerId&count`),
    ];

    const userData = JSON.parse(localStorage.getItem('userData'));

    if (userData != null) {
        requests.push(fetch(`http://localhost:3030/data/likes?where=movieId%3D%22${movieId}%22%20and%20_ownerId%3D%22${userData.id}%22`));
    }

    const [movieRes, likesRes, hasLiknedRes] = await Promise.all(requests);
    const [movie, likes, hasLiked] = await Promise.all([
        movieRes.json(),
        likesRes.json(),
        hasLiknedRes && hasLiknedRes.json()
    ]);
  
    let isOwner;
    if (userData != null && userData.id == movie._ownerId) {
        isOwner = true;
    }

    let divElement = document.createElement('div');
    divElement.classList.add = 'container';

    divElement.innerHTML =
        `<div class="row bg-light text-dark">
    <h1>Movie title: ${movie.title}</h1>

    <div class="col-md-8">
        <img class="img-thumbnail" src="${movie.img}"
            alt="Movie">
    </div>
    <div class="col-md-4 text-center">
        <h3 class="my-3 ">Movie Description</h3>
        <p>${movie.description}</p>
        <a style="display: ${isOwner ? '' : 'none'}" class="btn btn-danger" href="#">Delete</a>
        <a data-id="${movie._id}" style="display: ${isOwner ? '' : 'none'}" class="btn btn-warning" href="#">Edit</a>
        <a style="display: ${userData && !isOwner ? '' : 'none'}" class="btn btn-primary" href="#">${hasLiked && hasLiked.length > 0 ? 'Unlike' : 'Like'}</a>
        <span class="enrolled-span">Liked ${likes}</span>
    </div>
</div>`

    const [deleteBtn, editBtn, likeBtn] = divElement.querySelectorAll('a');
    deleteBtn.addEventListener('click', onDelete);
    editBtn.addEventListener('click', onEdit);
    likeBtn.addEventListener('click', onClick);

    return divElement;

    async function onDelete(e) {
        e.preventDefault();

        await fetch(urlMovies + movie._id, {
            method: 'DELETE',
            headers: {
                'X-Authorization': userData.token
            }
        });

        showHome();
    }

    function onEdit(e) {
        e.preventDefault();

        showEdit(e.target.dataset.id);
    }

    function onClick(e) {
        e.preventDefault();

        if (e.target.textContent == 'Like') {
            onLike();
        } else if (e.target.textContent == 'Unlike') {
            onUnlike();
        }
    }

    async function onLike() {
        await fetch(urlLikes, {
            method: 'POST',
            headers: {
                'X-Authorization': userData.token,
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                movieId: movie._id
            })
        });

        showDetails(movie._id);
    }

    async function onUnlike() {
        const likeId = hasLiked[0]._id;

        await fetch(urlLikes + likeId, {
            method: 'DELETE',
            headers: {
                'X-Authorization': userData.token,
            }
        });

        showDetails(movie._id);
    }
}