function solve() {
    const infoElement = document.getElementById('info');
    const departButton = document.getElementById('depart');
    const arriveButton = document.getElementById('arrive');

    let url = 'http://localhost:3030/jsonstore/bus/schedule/';

    let currentStop = {
        next: 'depot'
    }

    async function depart() {
        departButton.disabled = true;

        let response = await fetch(url + currentStop.next);
        let data = await response.json();
        currentStop = data;

        infoElement.textContent = `Next stop ${currentStop.name}`;

        arriveButton.disabled = false;
    }

    function arrive() {
        arriveButton.disabled = true;

        infoElement.textContent = `Arriving at ${currentStop.name}`;

        departButton.disabled = false;
    }

    return {
        depart,
        arrive
    };
}

let result = solve();