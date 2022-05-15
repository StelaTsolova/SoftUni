function getCountEqualNeighbor(matrix) {
    let count = 0;

    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {

            let currentElemetn = matrix[row][col];

            if (row + 1 < matrix.length) {
                if (currentElemetn === matrix[row + 1][col]) {
                    count++;
                }
            }

            if (col + 1 < matrix[row].length) {
                if (currentElemetn === matrix[row][col + 1]) {
                    count++;
                }
            }
        }
    }

    return count;
}