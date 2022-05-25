function generateReport() {
    let inputHeadElement = document.querySelectorAll('input[type="checkbox"]');
    let tableRowsElement = document.querySelectorAll('body main table tbody tr');

    let output = [];

    for (let row = 0; row < tableRowsElement.length; row++) {
        let object = {};

        for (let col = 0; col < inputHeadElement.length; col++) {
            if (inputHeadElement[col].checked) {
                object[inputHeadElement[col].name] = tableRowsElement[row].children[col].textContent;
            }
        }
        output.push(object);
    }

    let outputElement = document.getElementById('output');
    outputElement.textContent = JSON.stringify(output);
}