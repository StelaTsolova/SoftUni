function attachEvents() {
    const btnLoadPosts = document.getElementById('btnLoadPosts');
    const btnViewPost = document.getElementById('btnViewPost');

    btnLoadPosts.addEventListener('click', loadPost, { once: true });
    btnViewPost.addEventListener('click', displayPostAndCommends);
}

attachEvents();

async function loadPost() {
    const postsElement = document.getElementById('posts');

    let posts = await getPosts();
    Object.values(posts).forEach(p => {
        let optionElement = document.createElement('option');
        optionElement.value = p.id;
        optionElement.textContent = p.title;

        postsElement.appendChild(optionElement);
    });
}

async function displayPostAndCommends() {
    let postsElement = document.getElementById('posts');
    let id = postsElement.value;

    let [post, comments] = await Promise.all([getPosts(), getCommends(id)]);
    post = post[id];

    const titleElement = document.getElementById('post-title');
    titleElement.textContent = post.title

    const bodyElement = document.getElementById('post-body');
    bodyElement.innerHTML = '';

    let pElement = document.createElement('p');
    pElement.textContent = post.body;
    bodyElement.appendChild(pElement);

    const commentsElement = document.getElementById('post-comments');
    commentsElement.innerHTML = '';

    comments.forEach(c => {
        let liElement = document.createElement('li');
        liElement.id = c.id;
        liElement.textContent = c.text;

        commentsElement.appendChild(liElement);
    });
}

async function getPosts() {
    const urlPost = 'http://localhost:3030/jsonstore/blog/posts';

    let response = await fetch(urlPost);
    let data = await response.json();

    return data;
}

async function getCommends(id) {
    const urlComments = 'http://localhost:3030/jsonstore/blog/comments';

    let response = await fetch(urlComments);
    let data = await response.json();

    data = Object.values(data).filter(d => d.postId == id);

    return data;
}