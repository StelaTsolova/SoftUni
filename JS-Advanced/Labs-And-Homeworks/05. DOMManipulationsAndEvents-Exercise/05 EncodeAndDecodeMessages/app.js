function encodeAndDecodeMessages() {
    let [encodeButtomElement, decodeButtonElement] = document.getElementsByTagName('button');

    encodeButtomElement.addEventListener('click', (e) => {
        let textareaElement = e.target.parentNode.querySelector('textarea');

        let newMessage = getNewMessage(textareaElement.value.split(''), 1);

        let receivedTextareaElement = e.target.parentNode.parentNode.querySelector('textarea[disabled]');
        receivedTextareaElement.value = newMessage.join('');

        textareaElement.value = '';
    })

    decodeButtonElement.addEventListener('click', (e) => {
        let textareaElement = e.target.parentNode.querySelector('textarea');

        let newMessage = getNewMessage(textareaElement.value.split(''), -1);

        textareaElement.value = newMessage.join('');
    });

    function getNewMessage(message, number) {
        let newMessage = [];

        for (let symbol of message) {
            let newSymbol = String.fromCharCode(symbol.charCodeAt() + number);
            newMessage.push(newSymbol);
        }

        return newMessage;
    }
}