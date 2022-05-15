function chechMatrix(matrix) {
    let sumFirstRow = matrix[0].reduce((a, b) => a + b);

    for (let row = 0; row < matrix.length; row++) {
        let sumCurrentRows = matrix[row].reduce((a, b) => a + b);

        if (sumCurrentRows !== sumFirstRow) {
            return false;
        }
    }

    let sumCols = 0;

    for (let col = 0; col < matrix.length; col++) {
        for (let row = 0; row < matrix.length; row++) {
            sumCols += matrix[row][col];
        }

        if (sumCols !== sumFirstRow) {
            return false;
        }
        sumCols = 0;
    }

    return true;
}