function extractText() {
    let items = document.querySelectorAll('ul li');
    let result = document.getElementById('result');

    for (let item of items) {
        result.textContent += item.textContent + '\n';
    };
    //items.forEach(item => result.textContent += item.textContent + '\n');
}