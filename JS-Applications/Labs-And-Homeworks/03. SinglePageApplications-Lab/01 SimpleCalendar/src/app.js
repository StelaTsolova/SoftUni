const years = document.getElementById('years');

let months = Array.from(document.querySelectorAll('.monthCalendar'));
months.forEach(m => m.remove());
months = months.reduce((a, v) => ({ ...a, [v.id]: v }), {});

let days = Array.from(document.querySelectorAll('.daysCalendar'));
days.forEach(d => d.remove());
days = days.reduce((a, v) => ({ ...a, [v.id]: v }), {});

const bodyElement = document.querySelector('body');
document.querySelector('tbody').addEventListener('click', detectClick);

const monthNumbers = {
    Jan: '1',
    Feb: '2',
    Mar: '3',
    Apr: '4',
    May: '5',
    Jun: '6',
    Jul: '7',
    Aug: '8',
    Sept: '9',
    Oct: '10',
    Nov: '11',
    Dec: '12'
}

let year;
let monthElement;

function detectClick(event) {
    const className = event.target.className;

    if (event.target.tagName == 'CAPTION') {
        returnPage(event);
    } else if (className == 'date' || className == 'day') {
        let text = getTextContent(event.target);

        if (text.length == 4 && Number(text)) {
            showMonth(text);
        } else if (text in monthNumbers) {
            showDays(text);
        }
    }
}

function showMonth(text) {
    year = text;

    monthElement = months[`year-${year}`];
    monthElement.addEventListener('click', detectClick);

    bodyElement.replaceChildren(monthElement);
}

function showDays(text) {
    let month = text;

    const day = days[`month-${year}-${monthNumbers[month]}`];
    day.addEventListener('click', detectClick);

    bodyElement.replaceChildren(day);
}

function getTextContent(element) {
    if (element.className == 'date') {
        return element.textContent;
    }
    else if (element.className == 'day') {
        return element.querySelector('div').textContent;
    }
}

function returnPage(event) {
    if (Number(event.target.textContent)) {
        bodyElement.replaceChildren(years);
    } else {
        bodyElement.replaceChildren(monthElement);
    }
}