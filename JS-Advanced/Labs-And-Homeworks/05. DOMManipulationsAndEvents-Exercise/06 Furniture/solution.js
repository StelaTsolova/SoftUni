function solve() {
  let inputElement = document.querySelector('textarea');
  let [generateButton, buyButton] = document.querySelectorAll('button');

  generateButton.addEventListener('click', (e) => {
    let informationElement = e.target.parentNode.querySelector('textarea');
    let information = JSON.parse(informationElement.value)[0];

    let trElement = document.createElement('tr');

    addTdElementInTrElement('img', trElement, information.img);
    addTdElementInTrElement('p', trElement, information.name);
    addTdElementInTrElement('p', trElement, information.price);
    addTdElementInTrElement('p', trElement, information.decFactor);
    addTdElementInTrElement('input', trElement);

    let tableElement = document.querySelector('tbody');
    tableElement.appendChild(trElement);
  });

  function addTdElementInTrElement(typeChild, trElement, info) {
    let tdElement = document.createElement('td');
    let element = document.createElement(typeChild);

    switch (typeChild) {
      case 'img':
        element.src = info;
        break;
      case 'p':
        element.textContent = info;
        break;
      case 'input':
        element.type = 'checkbox';
        break;
    }

    tdElement.appendChild(element);
    trElement.appendChild(tdElement);
  }

  buyButton.addEventListener('click', (e) => {
    let inputElements = document.querySelectorAll('input:checked');

    let furnitures = [];
    let totalPrice = 0;
    let totalDecFactor = 0;
    for (let input of inputElements) {
      if (input.checked) {
        let [furniture, price, decFactor] = input.parentNode.parentNode.querySelectorAll('td p')
        furnitures.push(furniture.textContent);
        totalPrice += Number(price.textContent);
        totalDecFactor += Number(decFactor.textContent);
        console.log(furniture)
      }
    }

    let resultElement = document.querySelector('textarea[disabled]');
    resultElement.textContent = `Bought furniture: ${furnitures.join(', ')}\nTotal price: ${totalPrice.toFixed(2)}\nAverage decoration factor: ${totalDecFactor / furnitures.length}`
  })
}