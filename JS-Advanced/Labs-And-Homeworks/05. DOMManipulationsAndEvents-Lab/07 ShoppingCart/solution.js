function solve() {
   let buttonAddElements = document.querySelectorAll('button.add-product');
   let textareaElement = document.querySelector('textarea');
   let productTitles = [];
   let totalPrice = 0;

   for (let button of buttonAddElements) {
      button.addEventListener('click', (e) => {
         let productElement = e.target.parentElement.parentElement;
         let productTitleElement = productElement.querySelector('div.product-title');
         let productPriceElement = productElement.querySelector('div.product-line-price');

         if (!productTitles.includes(productTitleElement.textContent)) {
            productTitles.push(productTitleElement.textContent);
         }
         totalPrice += Number(productPriceElement.textContent);

         textareaElement.textContent += `Added ${productTitleElement.textContent} for ${productPriceElement.textContent} to the cart.\n`
      })
   }

   let checkoutElement = document.querySelector('button.checkout');

   checkoutElement.addEventListener('click', (e) => {
      textareaElement.textContent += `You bought ${productTitles.join(', ')} for ${totalPrice.toFixed(2)}.`

      e.target.disabled = true;
      for (let button of buttonAddElements) {
         button.disabled = true;
      }
   });
}