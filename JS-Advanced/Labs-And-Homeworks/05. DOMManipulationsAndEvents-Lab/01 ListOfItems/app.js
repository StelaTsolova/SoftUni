function addItem() {
    let newItemTextEelement = document.getElementById('newItemText');

    let newLi = document.createElement('li');
    newLi.textContent = newItemTextEelement.value;

    let itemsElement = document.getElementById('items');
    itemsElement.appendChild(newLi);
}