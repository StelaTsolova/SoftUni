function printResult(array) {
    let result = [];

    for (let index = 0; index < array.length; index += 2) {
        result.push(array[index]);
    }

    console.log(result.join(' '));
}