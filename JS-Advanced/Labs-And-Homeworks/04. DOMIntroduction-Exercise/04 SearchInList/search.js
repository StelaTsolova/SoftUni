function search() {
   let townsElements = document.querySelectorAll('#towns li');
   let searchElement = document.getElementById('searchText');

   let matches = 0;
   for (let town of townsElements) {

      if (town.textContent.includes(searchElement.value)) {
         town.style.fontWeight = 'bold';
         town.style.textDecoration = 'underline';
         matches++;
      } else {
         town.style.fontWeight = 'normal';
         town.style.textDecoration = 'none';
      }
   }

   let resultElement = document.getElementById('result');
   resultElement.textContent = `${matches} matches found`;
   matches = 0;
}
