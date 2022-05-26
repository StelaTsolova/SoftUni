function focused() {
    let sectionsInputsElement = document.querySelectorAll('div input');

    for (let input of sectionsInputsElement) {
        input.addEventListener('focus', (e) => {
            e.target.parentNode.classList.add("focused");
        });

        input.addEventListener('blur', (e) => {
            e.target.parentNode.classList.remove("focused")
        })
    }
}