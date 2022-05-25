function calc() {
    let fisrtNumber = document.getElementById('num1').value;
    let secondNumber = document.getElementById('num2').value;

    let sum = document.getElementById('sum');

    sum.value = Number(fisrtNumber) + Number(secondNumber);
}