function printRectangle(size) {
    if (typeof (size) != 'number' || size == 5) {
        console.log('* * * * *\n* * * * * \n* * * * *\n* * * * *\n* * * * *')
    } else {
        let array = [];

        for (let index = 0; index < size; index++) {
            array[index] = '*';
        }

        for (let row = 0; row < size; row++) {
            console.log(array.join(' '));
        }
    }
}