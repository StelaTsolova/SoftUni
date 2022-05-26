function create(words) {
   let contentElement = document.getElementById('content');

   for (let word of words) {
      let divElement = document.createElement('div');
      let pElement = document.createElement('p');

      pElement.textContent = word;
      pElement.style.display = 'none';

      divElement.addEventListener('click', (e) => {
         e.target.children[0].style.display = 'block';
      });

      divElement.appendChild(pElement);
      contentElement.appendChild(divElement);
   }
}