function loadRepos() {
	let username = document.getElementById('username').value;
	let url = `https://api.github.com/users/${username}/repos`;

	let reposElement = document.getElementById('repos');

	fetch(url)
		.then(response => {
			if (!response.ok) {
				throw new Error(response.status);
			}
			return response.json();
		})
		.then(data => {
			reposElement.innerHTML = '';

			data.forEach(element => {
				let liElement = document.createElement('li');

				let aElement = document.createElement('a');
				aElement.setAttribute('href', element['html_url']);
				aElement.textContent = element['full_name'];

				liElement.append(aElement);
				reposElement.append(liElement);
			});
		})
		.catch(error => {
			reposElement.innerHTML = '';

			let liElement = document.createElement('li');
			liElement.textContent = 'Error: ' + error.message;

			reposElement.append(liElement);
		});
}