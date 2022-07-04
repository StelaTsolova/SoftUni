function solve() {
    const recipientElement = document.getElementById('recipientName');
    const titleElement = document.getElementById('title');
    const messageElement = document.getElementById('message');

    const listElement = document.getElementById('list');
    listElement.addEventListener('click', onClick);

    const sentListElement = document.querySelector('.sent-list');
    sentListElement.addEventListener('click', onClick);

    const deleteListElement = document.querySelector('.delete-list');

    document.getElementById('add').addEventListener('click', addEmail);
    document.getElementById('reset').addEventListener('click', clearForm);
    let formElement = document.querySelector('form');

    function addEmail(event) {
        event.preventDefault();

        const recipientName = recipientElement.value;
        const title = titleElement.value;
        const message = messageElement.value;
        if (recipientName == '' || title == '' || message == '') {
            return;
        }

        let liElement = document.createElement('li');
        liElement.innerHTML = `
                <h4>Title: ${title}</h4>
                <h4>Recipient Name: ${recipientName}</h4>
                <span>${message}</span>
                <div id="list-action">
                    <button type="submit" id="send">Send</button>
                    <button type="submit" id="delete">Delete</button>
                </div>
    `
        listElement.appendChild(liElement);

        clearForm();
    }

    function onClick(event) {
        event.preventDefault();

        if (event.target.id == 'send') {
            sendEmail(event);
        } else if (event.target.id == 'delete' || event.target.tagName == 'BUTTON') {
            deleteEmail(event)
        }
    }

    function sendEmail(event) {
        let sendedElement = event.target.parentNode.parentNode;
        let [h4Title, h4RecipientName] = sendedElement.querySelectorAll('h4');

        let liElement = document.createElement('li');
        liElement.innerHTML = `
                      <span>${h4RecipientName.textContent}</span>
                        <span>${h4Title.textContent}</span>
                        <div class="btn">
                            <button type="submit" class="delete">Delete</button>
                        </div>
      `
        sentListElement.appendChild(liElement);

        console.log(sendedElement)
        sendedElement.remove();

    }

    function deleteEmail(event) {
        let deletedElement = event.target.parentNode.parentNode;

        let toText;
        let titleText;
        if (deletedElement.querySelector('h4') != undefined) {
            let [h4Title, h4RecipientName] = deletedElement.querySelectorAll('h4');
            toText = h4RecipientName.textContent;
            titleText = h4Title.textContent;
        } else {
            let [spanRecipintName, spanTitle] = deletedElement.querySelectorAll('span');
            toText = spanRecipintName.textContent;
            titleText = spanTitle.textContent;
        }

        let liElement = document.createElement('li');
        liElement.innerHTML = `
                        <span>${toText}</span>
                        <span>${titleText}</span>
        `
        deleteListElement.appendChild(liElement);

        deletedElement.remove();
    }


    function clearForm() {
        recipientElement.value = '';
        titleElement.value = '';
        messageElement.value = '';
    }
}
solve()