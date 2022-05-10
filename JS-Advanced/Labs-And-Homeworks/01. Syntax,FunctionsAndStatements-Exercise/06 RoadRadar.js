function printInfoForSpeed(speed, area) {
    let getSatus = function (difference) {
        if (difference <= 20) {
            return 'speeding';
        } else if (difference <= 40) {
            return 'excessive speeding';
        } else {
            return 'reckless driving';
        }
    }

    let printResult = function (limit) {
        if (speed <= limit) {
            console.log(`Driving ${speed} km/h in a ${limit} zone`);
        } else {
            let difference = speed - limit;
            let status = getSatus(difference);
            console.log(`The speed is ${difference} km/h faster than the allowed speed of ${limit} - ${status}`);
        }
    }

    switch (area) {
        case 'motorway':
            printResult(130);
            break;
        case 'interstate':
            printResult(90);
            break;
        case 'city':
            printResult(50)
            break;
        case 'residential':
            printResult(20);
            break;
    }
}