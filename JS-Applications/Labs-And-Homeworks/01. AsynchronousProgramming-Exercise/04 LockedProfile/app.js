async function lockedProfile() {
    let mainELement = document.getElementById('main');
    mainELement.innerHTML = '';

    let url = 'http://localhost:3030/jsonstore/advanced/profiles';

    let response = await fetch(url);
    let data = await response.json();
    Object.values(data).forEach(user => {
        // console.log(user)
        let divElement = document.createElement('div');
        divElement.classList.add('profile');

        divElement.innerHTML = `<img src="./iconProfile2.png" class="userIcon" />
       <label>Lock</label>
       <input type="radio" name="user1Locked" value="lock" checked>
       <label>Unlock</label>
       <input type="radio" name="user1Locked" value="unlock"><br>
       <hr>
       <label>Username</label>
       <input type="text" name="user1Username" value="${user.username}" disabled readonly />
       <div class="user1Username" style="display: none">
           <hr>
           <label>Email:</label>
           <input type="email" name="user1Email" value="${user.email}" disabled readonly />
           <label>Age:</label>
           <input type="text" name="user1Age" value="${user.age}" disabled readonly />
        </div>
           
           <button>Show more</button>`;

        mainELement.appendChild(divElement);
    });

    let lockElements = mainELement.querySelectorAll('[value="lock"]')
    lockElements.forEach(l => {
        l.addEventListener('change', (e) => {
            if (e.currentTarget.checked) {
                let profileElment = e.currentTarget.parentNode;

                profileElment.querySelector('.user1Username').style.display = 'none';
                profileElment.querySelector('button').textContent = 'Show me';
            }
        });
    });

    let buttonElemnts = document.querySelectorAll('button');
    buttonElemnts.forEach(b => {
        b.addEventListener('click', (e) => {
            let lockElement = e.currentTarget.parentNode.querySelector('[value="lock"]');
            let info = e.currentTarget.parentNode.querySelector('.user1Username');

            if (e.currentTarget.textContent == 'Hide it') {
                info.style.display = 'none';
                e.currentTarget.textContent = 'Show me';
            } else if (!lockElement.checked) {
                info.style.display = 'block';
                e.currentTarget.textContent = 'Hide it';
            }
        });
    });
}