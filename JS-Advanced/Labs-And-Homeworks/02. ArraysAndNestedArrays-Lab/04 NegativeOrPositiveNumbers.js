function printNewArray(numbers) {
    let array = [];

    for (let number of numbers) {
        if (number < 0) {
            array.unshift(number);
        } else {
            array.push(number);
        }
    }

    array.forEach(num => console.log(num));
}