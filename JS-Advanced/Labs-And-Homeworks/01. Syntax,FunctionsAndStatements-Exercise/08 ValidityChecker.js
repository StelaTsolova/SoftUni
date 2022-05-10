function printResult(num1, num2, num3, num4) {

    let print = function (x1, y1, x2, y2) {

        let sum = Math.sqrt((x2 ** 2 - (2 * x2 * x1) + x1 ** 2) + (y2 ** 2 - (2 * y2 * y1) + y1 ** 2));

        let output = `{${x1}, ${y1}} to {${x2}, ${y2}} is`

        if (Number.isInteger(sum)) {
            console.log(`${output} valid`)
        } else {
            console.log(`${output} invalid`)
        }
    }

    print(num1, num2, 0, 0);
    print(num3, num4, 0, 0);
    print(num1, num2, num3, num4);
}