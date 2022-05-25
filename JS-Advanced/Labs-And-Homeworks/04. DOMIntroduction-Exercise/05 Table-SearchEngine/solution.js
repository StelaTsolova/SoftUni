function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      let rowsElements = document.querySelectorAll('body table tbody tr');
      let searchElement = document.getElementById('searchField');

      for (let row of rowsElements) {

         if (row.textContent.includes(searchElement.value)) {
            row.classList.add('select');
         } else {
            row.classList.remove('select');
         }
      }
   }
}