function attachEventsListeners() {
    let daysElement = document.getElementById('days');
    let hoursElement = document.getElementById('hours');
    let minutesElement = document.getElementById('minutes');
    let secondsElement = document.getElementById('seconds');

    let info = {
        days: 1,
        hours: 24,
        minutes: 1440,
        seconds: 86400
    }

    let buttonElements = document.querySelectorAll('input[type="button"]');

    for (let button of buttonElements) {
        button.addEventListener('click', (e) => {
            let inputElement = e.target.parentNode.querySelector('input[type="text"]');
            let value = Number(inputElement.value);

            let days = value / info[inputElement.id];

            daysElement.value = days;
            hoursElement.value = days * info['hours'];
            minutesElement.value = days * info['minutes'];
            secondsElement.value = days * info['seconds'];
        });
    }
    console.log(buttonElements);
}