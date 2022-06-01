function solve() {
    let [taskElement, dateElement] = document.getElementsByTagName('input');
    let descriptionElement = document.querySelector('textarea');
    let openSelectionSecondDivElement = document.querySelector('.wrapper section:nth-child(2) div:nth-child(2)');

    let addButton = document.getElementById('add');
    addButton.addEventListener('click', (e) => {
        e.preventDefault();
        if (taskElement.value != '' && dateElement.value != '' && descriptionElement.value != '') {

            openSelectionSecondDivElement.innerHTML +=
                `<article>
              <h3>${taskElement.value}</h3>
              <p>Description: ${descriptionElement.value}</p>
              <p>Due Date: ${dateElement.value}</p>
              <div class="flex">
                 <button class="green">Start</button>
                 <button class="red">Delete</button>
              </div>
          </article>`

            taskElement.value = '';
            descriptionElement.value = '';
            dateElement.value = '';
        }

        let startButtons = openSelectionSecondDivElement.querySelectorAll('.green');
        for (let button of startButtons) {
            button.addEventListener('click', (e) => {
                let inProgresSelectionSecondDivElement = document.querySelector('.wrapper section:nth-child(3) div:nth-child(2)');
                let articleElement = e.currentTarget.parentNode.parentNode;
                articleElement.querySelector('.green').remove();

                let finishButton = document.createElement('button');
                finishButton.classList.add('orange');
                finishButton.textContent = 'Finish';
                finishButton.addEventListener('click', (e) => {
                    let completeSelectionSecondDivElement = document.querySelector('.wrapper section:nth-child(4) div:nth-child(2)');
                    let articleElement = e.currentTarget.parentNode.parentNode;
                    articleElement.querySelector('.flex').remove();

                    completeSelectionSecondDivElement.appendChild(articleElement);
                });
                articleElement.querySelector('.flex').appendChild(finishButton);

                inProgresSelectionSecondDivElement.appendChild(articleElement);
            });
        }

        let deleteButtons = document.querySelectorAll('.red');
        for (let button of deleteButtons) {
            button.addEventListener('click', (e) => {
                e.currentTarget.parentNode.parentNode.remove();
            });
        }
    });
}