class Contact {
    #online;

    constructor(firstName, lastName, phone, email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;

        this.#online = false;
    }

    render(id) {
        let articleElement = document.createElement('article');

        this.divTitleElement = document.createElement('div');
        this.divTitleElement.classList.add('title');
        this.divTitleElement.innerHTML = `${this.firstName} ${this.lastName}`;
        if (this.#online) {
            this.divTitleElement.classList.add('online');
        }

        let buttonElement = document.createElement('button');
        buttonElement.innerHTML = '&#8505';
        buttonElement.addEventListener("click", (e) => {
            let h = e.currentTarget.parentNode.parentNode.querySelector('.info');

            h.style.display = h.style.display == 'none' ? 'block' : 'none';
        });
        this.divTitleElement.appendChild(buttonElement);

        articleElement.appendChild(this.divTitleElement);

        let divInfoElement = document.createElement('div');
        divInfoElement.classList = 'info';
        divInfoElement.style.display = 'none';
        divInfoElement.innerHTML = `<span>&phone; ${this.phone}</span>
                                    <span>&#9993; ${this.email}</span>`;
        articleElement.appendChild(divInfoElement);

        document.getElementById(id).appendChild(articleElement);
    }

    get online() {
        return this.#online;
    }

    set online(value) {
        if (this.divTitleElement) {
            value === true ? this.divTitleElement.classList.add('online')
                           : this.divTitleElement.classList.remove('online');
        }

        this.#online = value;
    }
}