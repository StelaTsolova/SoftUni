function getSortedNumbers(numbers) {
    let sortedNumbers = [];

    numbers.sort((a, b) => a - b);

    while (numbers.length != 0) {
        sortedNumbers.push(numbers.shift());
        sortedNumbers.push(numbers.pop());
    }

    return sortedNumbers;
}