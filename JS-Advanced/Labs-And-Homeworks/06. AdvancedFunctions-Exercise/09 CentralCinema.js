function solve() {
    let [onScreenButton, clearButton] = document.getElementsByTagName('button');
    let [nameElement, hallElement, ticketPriceElement] = document.querySelectorAll('#container input');

    onScreenButton.addEventListener('click', (e) => {
        e.preventDefault();
        if (nameElement.value && hallElement.value && Number(ticketPriceElement.value) || ticketPriceElement.value === '0') {
            let liElement = document.createElement('li');

            let spanElement = document.createElement('span');
            spanElement.textContent = nameElement.value;
            nameElement.value = '';
            liElement.appendChild(spanElement);

            let strongElement = document.createElement('strong');
            strongElement.textContent = `Hall: ${hallElement.value}`;
            hallElement.value = '';
            liElement.appendChild(strongElement);

            let divElement = document.createElement('div');
            strongElement = document.createElement('strong');
            strongElement.textContent = Number(ticketPriceElement.value).toFixed(2);
            ticketPriceElement.value = '';
            divElement.appendChild(strongElement);

            let inputElement = document.createElement('input');
            inputElement.placeholder = 'Tickets Sold';
            divElement.appendChild(inputElement);

            let buttonElement = document.createElement('button');
            buttonElement.textContent = 'Archive';
            buttonElement.addEventListener('click', (e) => {
                let divElement = e.target.parentNode;
                let countTicketsElement = divElement.querySelector('input');

                if (Number(countTicketsElement.value) || countTicketsElement.value === '0') {
                    let liArchiveElement = document.createElement('li');

                    let spanElement = document.createElement('span');
                    spanElement.textContent = divElement.parentNode.querySelector('span').textContent;
                    liArchiveElement.appendChild(spanElement);

                    let strongArchiveElement = document.createElement('strong');
                    let count = Number(countTicketsElement.value);
                    let price = Number(divElement.querySelector('strong').textContent);
                    let sum = price * count;
                    strongArchiveElement.textContent = `Total amount: ${sum.toFixed(2)}`;
                    liArchiveElement.appendChild(strongArchiveElement);

                    let buttonElement = document.createElement('button');
                    buttonElement.textContent = 'Delete';
                    buttonElement.addEventListener('click', (e) => {
                        e.target.parentNode.remove();
                    })
                    liArchiveElement.appendChild(buttonElement)

                    let archiveElement = document.querySelector('#archive ul');
                    archiveElement.appendChild(liArchiveElement);

                    divElement.parentNode.remove();
                }
            })
            divElement.appendChild(buttonElement);

            liElement.appendChild(divElement);

            let moviesElement = document.querySelector('#movies ul');
            moviesElement.appendChild(liElement);
        }
    })

    clearButton.addEventListener('click', (e) => {
        let archivedMoviesElements = e.target.parentNode.querySelector('ul');

        for (let li of archivedMoviesElements) {
            li.remove();
        }
    });
}