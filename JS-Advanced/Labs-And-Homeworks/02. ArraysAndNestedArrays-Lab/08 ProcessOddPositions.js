function getElementsAtOddPositions(numbers) {
    let array = [];

    for (let index = 1; index < numbers.length; index += 2) {
        array.push(numbers[index] * 2);
    }

    return array.reverse().join(' ');
}