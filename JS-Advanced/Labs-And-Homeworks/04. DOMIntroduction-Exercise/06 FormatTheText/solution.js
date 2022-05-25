function solve() {
  let inputElement = document.getElementById('input');
  let inputArr = inputElement.value.split('.').filter(x => x !== '');

  let outputElement = document.getElementById('output');
  while (inputArr.length > 0) {
    let paragraphText = inputArr.splice(0, 3);

    let para = document.createElement('p');
    para.textContent = (paragraphText.join('. ') + '.');

    outputElement.appendChild(para);
  }
}