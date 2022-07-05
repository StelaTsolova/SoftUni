function loadCommits() {
    let username = document.getElementById('username').value;
    let repository = document.getElementById('repo').value;

    let url = `https://api.github.com/repos/${username}/${repository}/commits`;
    let commitsElement = document.getElementById('commits');

    fetch(url)
        .then(response => response.json())
        .then(data => {
            commitsElement.innerHTML = '';

            data.forEach(element => {
                let liElement = document.createElement('li');
                liElement.textContent = `${element.commit.author.name}: ${element.commit.message}`;

                commitsElement.append(liElement);
            });
        })
        .catch(error => console.log(error));
}