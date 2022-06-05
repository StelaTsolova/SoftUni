function solve(array, startIndex, endIndex) {

    if (!Array.isArray(array)) {
        return NaN;
    }

    startIndex = Math.max(startIndex, 0);

    endIndex = Math.min(endIndex, array.length - 1);

    return array.map(e => Number(e)).slice(startIndex, endIndex + 1).reduce((a, n) => a + n, 0);
}