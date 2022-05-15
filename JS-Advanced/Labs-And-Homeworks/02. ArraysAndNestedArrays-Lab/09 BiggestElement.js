function getTheBiggestElements(matrix) {
    let theBiggestNumber = Number.MIN_SAFE_INTEGER;

    for (let row of matrix) {
        let currentTheBiggestNum = Math.max(...row);

        if (currentTheBiggestNum > theBiggestNumber) {
            theBiggestNumber = currentTheBiggestNum;
        }
    }

    return theBiggestNumber;
}