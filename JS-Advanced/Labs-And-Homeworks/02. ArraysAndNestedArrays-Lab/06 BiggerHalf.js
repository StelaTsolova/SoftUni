function getSortedHalfArray(numbers) {
    let lengthNewArray = Math.floor(numbers.length / 2);

    let array = numbers.sort((a, b) => a - b).slice(lengthNewArray);

    return array;
}