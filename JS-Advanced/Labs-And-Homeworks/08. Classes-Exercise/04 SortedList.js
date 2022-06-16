class List {
    size = 0;

    constructor() {
        this.numbers = [];
    }

    add(element) {
        this.numbers.push(element);
        this.size++;

        this.numbers.sort((a, b) => a - b);
    }

    remove(index) {
        if (index < 0 || index >= this.size) {
            throw new Error;
        }

        this.numbers.splice(index, 1);
        this.size--;
    }

    get(index) {
        if (index < 0 || index >= this.size) {
            throw new Error;
        }

        return this.numbers[index];
    }
}