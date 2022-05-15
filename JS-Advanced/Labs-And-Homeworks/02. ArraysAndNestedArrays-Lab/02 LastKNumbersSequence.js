function getArray(n, k) {
    let array = [1];

    for (let index = 1; index < n; index++) {
        let startIndex = index - k;

        if (startIndex < 0) {
            startIndex = 0;
        }

        let currentNumbers = array.slice(startIndex, index);

        let sum = currentNumbers.reduce((a, b) => a + b);

        array.push(sum);
    }

    return array;
}

console.log(getArray(6, 3));