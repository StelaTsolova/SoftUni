function addItem() {
    let itemsEelment = document.getElementById('items');
    let newItemTextEelement = document.getElementById('newItemText');

    let newLi = document.createElement('li');
    newLi.textContent = newItemTextEelement.value;

    let newA = document.createElement('a');
    newA.href = '#';
    newA.textContent = '[Delete]';
    newA.addEventListener('click', (e) => {
        e.currentTarget.parentNode.remove();
    });

    newLi.appendChild(newA);
    itemsEelment.appendChild(newLi);
    newItemTextEelement.value = '';
}