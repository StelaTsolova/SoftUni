function sumTable() {
    let table = document.querySelectorAll('table tbody tr td:nth-child(2n)');
    let array = Array.from(table);
    array.pop();

    let totalSum = document.getElementById('sum');

    let sum = 0;
    for (let row of array) {
        sum += Number(row.textContent);
    };

    totalSum.textContent = sum;
}