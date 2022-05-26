function deleteByEmail() {
    let emailsElement = document.querySelectorAll('tr td:nth-of-type(2)');
    let inputEmailElement = document.querySelector('input[name="email"]');
    let resultElement = document.getElementById('result');

    resultElement.textContent = 'Not found.';

    for (let email of emailsElement) {
        if (email.textContent == inputEmailElement.value) {
            email.parentNode.remove();
            resultElement.textContent = 'Deleted.';
        }
    }
}