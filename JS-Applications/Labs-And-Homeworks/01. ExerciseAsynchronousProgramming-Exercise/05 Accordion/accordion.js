(async function solution() {
    let mainElement = document.getElementById('main');

    let url = 'http://localhost:3030/jsonstore/advanced/articles/list';
    let urlDetails = 'http://localhost:3030/jsonstore/advanced/articles/details/';

    let response = await fetch(url);
    let data = await response.json();

    data.forEach(async d => {
        let responseD = await fetch(urlDetails + d._id);
        let dataD = await responseD.json();

        let divAcsordion = document.createElement('div');
        divAcsordion.classList.add('accordion');
        divAcsordion.innerHTML = `<div class="head">
            <span>${d.title}</span>
            <button class="button" id="${d._id}">More</button> 
                  </div>
                  <div class="extra">
                      <p>${dataD.content}</p>
                   </div>`;

        let buttonElement = divAcsordion.querySelector('button');
        buttonElement.addEventListener('click', (e) => {
            let extraElement = e.currentTarget.parentNode.parentNode.children[1];

            if (e.currentTarget.textContent == 'More') {
                e.currentTarget.textContent = 'Less';
                extraElement.classList.remove('extra')
            } else {
                e.currentTarget.textContent = 'More';
                extraElement.classList.add('extra');
            }
        });

        mainElement.appendChild(divAcsordion);
    });
})();