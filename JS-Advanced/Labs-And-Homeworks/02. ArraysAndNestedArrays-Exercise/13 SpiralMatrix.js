function printMatrix(rows, cows) {

    let matrix = [];
    for (let row = 0; row < rows; row++) {
        matrix.push([]);
    }

    let topRow = 0
    let downRow = rows - 1;
    let leftCol = 0;
    let rigthCol = cows - 1;

    let endNumber = rows * cows;

    let number = 1;

    while (number <= endNumber) {
        for (let col = leftCol; col <= rigthCol && number <= endNumber; col++) {
            matrix[topRow][col] = number++;
        }
        topRow++;

        for (let row = topRow; row <= downRow && number <= endNumber; row++) {
            matrix[row][rigthCol] = number++;
        }
        rigthCol--;

        for (let col = rigthCol; col >= leftCol && number <= endNumber; col--) {
            matrix[downRow][col] = number++;
        }
        downRow--;

        for (let row = downRow; row >= topRow && number <= endNumber; row--) {
            matrix[row][leftCol] = number++;
        }
        leftCol++;
    }

    matrix.forEach(row => console.log(row.join(' ')))
}