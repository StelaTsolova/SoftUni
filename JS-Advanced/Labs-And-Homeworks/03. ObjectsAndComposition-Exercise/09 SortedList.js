function createSortedList() {

    let object = {
        numbers: [],
        add: function (element) {
            this.numbers.push(element)
            this.size++;
            this.numbers.sort((a, b) => a - b);
        },
        remove: function (index) {
            if (index >= 0 && index < this.numbers.length) {
                this.numbers.splice(index, 1);
                this.size--;
                this.numbers.sort((a, b) => a - b);
            }
        },
        get: function (index) {
            if (index >= 0 && index < this.numbers.length) {
                return this.numbers[index];
            }
        },
        size: 0
    };

    return object;
}