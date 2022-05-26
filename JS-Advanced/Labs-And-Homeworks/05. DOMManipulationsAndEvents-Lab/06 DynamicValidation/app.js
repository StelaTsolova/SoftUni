function validate() {
    let emailElement = document.getElementById('email');

    emailElement.addEventListener('change', (e) => {
        let emailText = e.target.value;
        let pattern = new RegExp('[a-z]+@[a-z]+\.[a-z]+', 'g');
        
        if (!emailText.match(pattern)) {
            e.target.classList.add('error');
        } else {
            e.target.classList.remove('error');
        }
    });
}