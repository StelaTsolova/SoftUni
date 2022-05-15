function solve(params) {
    let [width, height, x, y] = params;

    let matrix = [];
    for (let row = 0; row < width; row++) {
        matrix.push([]);
    }

    for (let row = 0; row < width; row++) {
        for (let col = 0; col < height; col++) {
            matrix[row][col] = Math.max(Math.abs(row - x), Math.abs(col - y)) + 1;
        }
    }

    matrix.forEach(e => console.log(e.join(' ')));
}