function attachGradientEvents() {
    let gradientElement = document.getElementById('gradient');
    let resultElement = document.getElementById('result');

    gradientElement.addEventListener('mousemove', (e) => {
        let percentage = Math.floor((e.offsetX / e.currentTarget.clientWidth) * 100);
        resultElement.textContent = percentage + '%';
    });

    gradientElement.addEventListener('mouseout', () => {
        resultElement.textContent = '';
    });
}