function printTime(steps, footPrint, speedKmH) {
    let distance = steps * footPrint;
    let speed = speedKmH * 1000 / 3600
    let rest = Math.floor(distance / 500) * 60;
    let time = (distance / speed) + rest

    let hours = Math.floor(time / 3600);
    let minutes = Math.floor(time / 60);
    let seconds = (time % 60).toFixed(0);

    console.log(`${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}`);
}