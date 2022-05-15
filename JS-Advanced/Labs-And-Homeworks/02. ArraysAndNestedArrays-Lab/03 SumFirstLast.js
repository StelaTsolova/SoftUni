function getSum(array) {
    let firstNumber = Number(array.shift());
    let lastNumber = Number(array.pop());

    return firstNumber + lastNumber;
}