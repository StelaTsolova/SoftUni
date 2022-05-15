function getArray(array, startSection, endSection) {
    let startIndex = array.indexOf(startSection);
    let endIndex = array.indexOf(endSection);

    return array.slice(startIndex, endIndex + 1);
}