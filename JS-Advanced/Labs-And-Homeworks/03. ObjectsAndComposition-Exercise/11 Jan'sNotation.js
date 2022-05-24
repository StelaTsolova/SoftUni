function solve(operands) {
    let numbers = [];
    let notEnoughOperands = false;

    for (let operand of operands) {
        if (typeof operand === 'number') {
            numbers.push(operand);
        } else {

            if (numbers.length < 2) {
                console.log('Error: not enough operands!');
                notEnoughOperands = true;
                break;
            }

            secondNumber = numbers.pop();
            firstNumber = numbers.pop();

            let sum;
            switch (operand) {
                case '+':
                    sum = firstNumber + secondNumber;
                    break;
                case '-':
                    sum = firstNumber - secondNumber;
                    break;
                case '*':
                    sum = firstNumber * secondNumber;
                    break;
                case '/':
                    sum = firstNumber / secondNumber;
                    break;
            }

            numbers.push(sum);
        }
    }

    if (numbers.length !== 1 && !notEnoughOperands) {
        console.log(`Error: too many operands!`);
    } else if (!notEnoughOperands) {
        console.log(numbers[0]);
    }
}