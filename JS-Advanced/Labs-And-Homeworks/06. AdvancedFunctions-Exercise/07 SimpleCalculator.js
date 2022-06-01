function calculator() {
    let firstNumElement;
    let secondNumElement;
    let resultElement;

    function init(selector1, selector2, resultSelector) {
        firstNumElement = document.querySelector(selector1);
        secondNumElement = document.querySelector(selector2);
        resultElement = document.querySelector(resultSelector);
    }

    function add() {
        resultElement.value = Number(firstNumElement.value) + Number(secondNumElement.value);
    }

    function subtract() {
        resultElement.value = Number(firstNumElement.value) - Number(secondNumElement.value);
    }

    return {
        init,
        add,
        subtract
    }
}