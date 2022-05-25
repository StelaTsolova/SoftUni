function solve() {
    let firstOptionElement = document.createElement('option');
    firstOptionElement.text = "Binary";
    firstOptionElement.value = "binary";

    let secondOptionElement = document.createElement('option');
    secondOptionElement.text = "Hexadecimal";
    secondOptionElement.value = "hexadecimal";

    let selectMenuToElement = document.getElementById('selectMenuTo');
    selectMenuToElement.add(firstOptionElement);
    selectMenuToElement.add(secondOptionElement);

    document.querySelector('body div button').addEventListener('click', onClick);

    function onClick() {
        let inputElement = document.getElementById('input');
        let number = Number(inputElement.value);

        let result;
        if (selectMenuToElement.value === 'binary') {
            result = number.toString(2);

        } else if (selectMenuToElement.value === 'hexadecimal') {
            result = number.toString(16).toUpperCase();
        }

        let resultElement = document.getElementById('result');

        resultElement.value = result;
    }
}