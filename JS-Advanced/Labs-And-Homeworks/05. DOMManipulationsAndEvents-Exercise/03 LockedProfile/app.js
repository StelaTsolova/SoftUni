function lockedProfile() {
    let profileElements = document.querySelectorAll('.profile')

    for (let profile of profileElements) {
        let buttonElment = profile.querySelector('button');

        buttonElment.addEventListener('click', onClick);

        function onClick(event) {
            let unlockElement = event.target.parentNode.querySelector('input[value="unlock"]');
            let userHiddenFieldsElement = event.target.parentNode.querySelector('div');

            if (unlockElement.checked) {
                if (event.target.textContent == 'Show more') {
                    event.target.textContent = 'Hide it';
                    userHiddenFieldsElement.style.display = 'block';
                } else if (event.target.textContent == 'Hide it') {
                    event.target.textContent = 'Show more';
                    userHiddenFieldsElement.style.display = 'none';
                }
            }
        };
    }
}