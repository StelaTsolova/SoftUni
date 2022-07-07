function attachEvents() {
    let submitButton = document.getElementById('submit');

    submitButton.addEventListener('click', information);

    async function information() {
        let forecastElement = document.getElementById('forecast');
        forecastElement.style.display = 'block';

        let currentElement = document.getElementById('current');
        removeElement(currentElement, '.forecasts');

        let upcomingElement = document.getElementById('upcoming');
        removeElement(upcomingElement, '.forecasts-info');

        let location = await getLocation();
        if (location == undefined) {
            currentElement.firstChild.textContent = 'Error';

            return;
        } else {
            currentElement.firstChild.textContent = '';
        }

        let forecastToday = await getForecastToday(location.code);

        let divForecasts = document.createElement('div');
        divForecasts.classList.add('forecasts');

        let spanConditionSymbol = document.createElement('span');
        spanConditionSymbol.classList.add('condition');
        spanConditionSymbol.classList.add('symbol');
        spanConditionSymbol.innerHTML = getWeatherSymbol(forecastToday.forecast.condition);
        divForecasts.appendChild(spanConditionSymbol);

        let spanCondition = document.createElement('span');
        spanCondition.classList.add('condition');
        spanCondition.innerHTML = `<span class = "forecast-data">${forecastToday.name}</span>
        <span class = "forecast-data">${forecastToday.forecast.low}${getWeatherSymbol('Degrees')}/${forecastToday.forecast.high}${getWeatherSymbol('Degrees')}</span>
        <span class = "forecast-data">${forecastToday.forecast.condition}</span>`;
        divForecasts.appendChild(spanCondition);

        currentElement.appendChild(divForecasts);


        let divForecastsInfo = document.createElement('div');
        divForecastsInfo.classList.add('forecasts-info');

        let forecastUpcoming = await getForecastUpcoming(location.code);
        for (let forecast of forecastUpcoming.forecast) {
            let spanCondition = document.createElement('span');
            spanCondition.classList.add('upcoming');
            spanCondition.innerHTML = `<span class = "symbol">${getWeatherSymbol(forecast.condition)}</span>
            <span class = "forecast-data">${forecast.low}${getWeatherSymbol('Degrees')}/${forecast.high}${getWeatherSymbol('Degrees')}</span>
            <span class = "forecast-data">${forecast.condition}</span>`;

            divForecastsInfo.appendChild(spanCondition);
        };

        upcomingElement.append(divForecastsInfo);
    }

    function removeElement(element, clazz) {
        if (element.querySelector(clazz) != null) {
            element.querySelector(clazz).remove();
        }
    }

    async function getLocation() {
        let locationName = document.getElementById('location').value;
        const urlLocations = 'http://localhost:3030/jsonstore/forecaster/locations';

        let response = await fetch(urlLocations);
        let data = await response.json();

        let town = data.filter(o => o.name == locationName);

        return town[0];
    }

    async function getForecastToday(code) {
        let response = await fetch(`http://localhost:3030/jsonstore/forecaster/today/${code}`);
        let data = await response.json();

        return data;
    }

    function getWeatherSymbol(condition) {
        switch (condition) {
            case 'Sunny':
                return '&#x2600';
            case 'Partly sunny':
                return '&#x26C5';
            case 'Overcast':
                return '&#x2601';
            case 'Rain':
                return '&#x2614';
            case 'Degrees':
                return '&#176';
        }
    }

    async function getForecastUpcoming(code) {
        let response = await fetch(`http://localhost:3030/jsonstore/forecaster/upcoming/${code}`);
        let data = await response.json();

        return data;
    }
}

attachEvents();