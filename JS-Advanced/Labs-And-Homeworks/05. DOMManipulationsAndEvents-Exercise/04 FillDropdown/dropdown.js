function addItem() {
    let newItemTextElemenmt = document.getElementById('newItemText');
    let newItemValueElement = document.getElementById('newItemValue');

    let optionElement = document.createElement('option');
    optionElement.text = newItemTextElemenmt.value;
    optionElement.value = newItemValueElement.value;

    let menuElement = document.getElementById('menu');
    menuElement.appendChild(optionElement);

    newItemTextElemenmt.value = '';
    newItemValueElement.value = '';
}