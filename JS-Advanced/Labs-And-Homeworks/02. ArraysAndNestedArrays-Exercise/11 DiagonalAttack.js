function solve(input) {
    let matrix = [];

    for (let i = 0; i < input.length; i++) {
        matrix.push(input[i].split(' '));
    }

    let leftDiagonal = 0;
    let rigthDiagonal = 0;

    for (let i = 0; i < matrix.length; i++) {
        leftDiagonal += Number(matrix[i][i]);
        rigthDiagonal += Number(matrix[i][matrix.length - 1 - i]);
    }


    if (leftDiagonal == rigthDiagonal) {
        for (let row = 0; row < matrix.length; row++) {
            for (let col = 0; col < matrix[row].length; col++) {

                if (row != col && col != matrix.length - 1 - row) {
                    matrix[row][col] = leftDiagonal;
                }
            }
        }
    }

    matrix.forEach(row => console.log(row.join(' ')));
}