function checkDigitInNumber(number) {
    let firstDigit = Number(number.toString()[0]);
    let isSame = true;
    let sum = firstDigit;

    for (let index = 1; index < number.toString().length; index++) {
        let currentDigit = Number(number.toString()[index]);

        if (firstDigit != currentDigit) {
            isSame = false;
        }

        sum += currentDigit;
    }

    console.log(isSame);
    console.log(sum);
}