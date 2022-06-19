class Person {
    #fullName;
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    get fullName() {
        return `${this.firstName} ${this.lastName}`;
    }

    set fullName(newFullName) {
        if (/\w+ \w+/.test(newFullName)) {
            let [newFirstName, newLastName] = newFullName.split(' ');

            this.#fullName = newFullName;
            this.firstName = newFirstName;
            this.lastName = newLastName;
        }
    }
}