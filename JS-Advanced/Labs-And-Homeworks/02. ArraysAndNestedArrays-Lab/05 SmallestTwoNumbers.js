function printTheTwoSmallestElements(numbers) {
    let firstElement = Math.min(...numbers);

    let indexFirstElement = numbers.indexOf(firstElement);
    numbers.splice(indexFirstElement, 1);

    let secondElement = Math.min(...numbers);

    console.log(firstElement + ' ' + secondElement);
}