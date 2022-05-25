function solve() {
  let textElement = document.getElementById('text');
  let conventionElement = document.getElementById('naming-convention');
  let textArr = textElement.value.split(' ');

  let haveError = false;
  switch (conventionElement.value) {
    case 'Camel Case':
      textArr[0] = textArr[0].toLowerCase();
      break;
    case 'Pascal Case':
      textArr[0] = textArr[0].toLowerCase();
      textArr[0] = textArr[0].replace(textArr[0][0], textArr[0][0].toUpperCase())
      break;
    default:
      haveError = true;
      break;
  }

  let resultElement = document.getElementById('result');
  if (!haveError) {
    for (let i = 1; i < textArr.length; i++) {
      textArr[i] = textArr[i].toLowerCase()
      textArr[i] = textArr[i].replace(textArr[i][0], textArr[i][0].toUpperCase())
    }

    resultElement.textContent = textArr.join('');

  } else {
    resultElement.textContent = 'Error!'
  }
}