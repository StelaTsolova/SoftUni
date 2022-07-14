async function getInfo() {
    const stopNameElement = document.getElementById('stopName');
    const busesElement = document.getElementById('buses');
    const stopId = document.getElementById('stopId').value;

    const url = 'http://localhost:3030/jsonstore/bus/businfo/' + stopId;

    busesElement.replaceChildren();

    let response = await fetch(url);
    if (response.status != 200) {
        stopNameElement.textContent = 'Error';

        return;
    }

    let data = await response.json();

    stopNameElement.textContent = data.name;

    Object.entries(data.buses).forEach(b => {
        let liElement = document.createElement('li');
        liElement.textContent = `Bus ${b[0]} arrives in ${b[1]} minutes`;

        busesElement.appendChild(liElement);
    })
}