function printRotatedArray(array, numberRotation) {
    for (let i = 1; i <= numberRotation; i++) {
        array.unshift(array.pop());
    }

    console.log(array.join(' '));
}