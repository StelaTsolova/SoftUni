const postInfo = JSON.parse(localStorage["postInfo"]);
const urlComments = 'http://localhost:3030/jsonstore/collections/myboard/comments';
let userCommentElement;

window.addEventListener('load', async () => {
  userCommentElement = document.getElementById('user-comment');
  const post = await getPost(postInfo.id);

  addTitleName(post.topicName);
  addComment(post, postInfo.time);
  addUserComment()

  document.querySelector('form').addEventListener('submit', onSubmit);

});

async function getPost(id) {
  const url = 'http://localhost:3030/jsonstore/collections/myboard/posts/' + id;

  const response = await fetch(url);
  const data = await response.json();

  return data;
}

function addTitleName(newTitle) {
  document.querySelector('.theme-name h2').textContent = newTitle;
}

function addComment(post, time) {
  const commentElement = createComment(post, time);

  document.querySelector('.comment').insertBefore(commentElement, userCommentElement);
}

function createComment(post, time) {
  let divElement = document.createElement('div');
  divElement.classList.add('header');

  divElement.innerHTML = `<div class="header">
  <img src="./static/profile.png" alt="avatar">
  <p><span>${post.username}</span> posted on <time>${time}</time></p>

  <p class="post-content">${post.postText}</p>`

  return divElement;
}

async function addUserComment() {
  const response = await fetch(urlComments);
  const data = await response.json();

  userCommentElement.replaceChildren(...Object.values(data).filter(c => c.topicId === postInfo.id).map(createUserComment));
}

async function onSubmit(e) {
  e.preventDefault();

  const formData = new FormData(e.target);
  const username = formData.get('username').trim();
  const postText = formData.get('postText').trim();

  if (username == '' || postText == '') {
    alert('All fields are required.');
    return;
  }

  try {
    const response = await fetch(urlComments, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        postText,
        username,
        topicId: postInfo.id
      })
    });
    const data = await response.json();

    if (response.status !== 200) {
      throw new Error(data.message());
    }

    userCommentElement.appendChild(createUserComment(data));
    e.target.reset();
  } catch (err) {
    console.error(err.message());
  }
}

function createUserComment(comment) {
  const dateTime = getTimeNow();

  let divElement = document.createElement('div');
  divElement.classList.add('topic-name-wrapper');

  divElement.innerHTML = `<div class="topic-name">
  <p><strong>${comment.username}</strong> commented on <time>${dateTime}</time></p>
 <div class="post-content">
     <p>${comment.postText}</p>
 </div>
 </div>`

  return divElement;
}

function getTimeNow() {
  let today = new Date();
  let date = today.getDate() + '/' + (today.getMonth() + 1) + '/' + today.getFullYear();
  let time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
  let dateTime = date + ' ' + time;

  return dateTime;
}