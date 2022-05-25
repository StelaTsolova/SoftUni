function colorize() {
    let rows = document.querySelectorAll('table tr:nth-child(2n)');

    for (let row of rows) {
        row.style.backgroundColor = "Teal";
    };
}