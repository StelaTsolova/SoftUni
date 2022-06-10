function validate() {
    let emailElement = document.getElementById('email');
    const pattern = /[a-z]+@[a-z]+.[a-z]+/g;

    emailElement.addEventListener('change', (e) => {
        if (pattern.test(e.target.value)) {
            e.target.classList.remove('error');
        } else {
            e.target.classList.add('error');
        }
    });
}