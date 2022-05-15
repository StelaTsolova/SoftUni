function printSumDiagonals(matrix) {
    let leftDiagonal = 0;
    for (let row = 0, col = 0; row < matrix.length && col < matrix[row].length; row++, col++) {
        leftDiagonal += matrix[row][col];
    }

    let rigthDiagonal = 0;
    for (let row = matrix.length - 1, col = 0; row >= 0 && col < matrix[row].length; row--, col++) {
        rigthDiagonal += matrix[row][col];
    }

    console.log(leftDiagonal + ' ' + rigthDiagonal)
}