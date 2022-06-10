function validate() {
    let submitButton = document.getElementById('submit');

    let usernameElement = document.getElementById('username');
    let passwordElement = document.getElementById('password');
    let confirmPasswordElement = document.getElementById('confirm-password');
    let emailElement = document.getElementById('email');
    let companyElement = document.getElementById('company');
    let companyNumberElement = document.getElementById('companyNumber');

    let patternPassword = /^[\w]{5,15}$/;

    let validElement = document.getElementById('valid');

    submitButton.addEventListener('click', (e) => {
        e.preventDefault();

        if (/^[a-zA-Z0-9]{3,20}$/.test(usernameElement.value)) {
            usernameElement.style.border = 'none';
        } else {
            usernameElement.style.borderColor = 'red';
        }

        if (/^[^@.]+@[^@]*\.[^@]*$/.test(emailElement.value)) {
            emailElement.style.border = 'none';
        } else {
            emailElement.style.borderColor = 'red';
        }

        if (passwordElement.value === confirmPasswordElement.value && patternPassword.test(passwordElement.value)
            && patternPassword.test(confirmPasswordElement.value)) {
            passwordElement.style.border = 'none';
            confirmPasswordElement.style.border = 'none';
        } else {
            passwordElement.style.borderColor = 'red';
            confirmPasswordElement.style.borderColor = 'red';
        }

        if (companyElement.checked) {
            if (Number(companyNumberElement.value) >= 1000 && Number(companyNumberElement.value) <= 9999) {
                companyNumberElement.style.border = 'none';
            } else {
                companyNumberElement.style.borderColor = 'red';
            }
        }

        if (usernameElement.style.borderColor == '' && passwordElement.style.borderColor == ''
            && emailElement.style.borderColor == '' && companyNumberElement.style.borderColor == '') {
            validElement.style.display = 'block';
        } else {
            validElement.style.display = 'none';
        }
    });

    companyElement.addEventListener('change', (e) => {
        let companyInfoElement = document.getElementById('companyInfo');

        if (e.target.checked) {
            companyInfoElement.style.display = 'block';
        } else {
            companyInfoElement.style.display = 'none';
        }
    });
}